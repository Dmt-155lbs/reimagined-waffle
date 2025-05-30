package TDA;

import java.util.ArrayList;
import java.util.Comparator;

public class TreeMap<K,V> extends AbstractSortedMap<K,V> {

  public static class BalanceableBinaryTree<K,V> extends LinkedBinaryTree<Entry<K,V>> {
    //-------------- nested BSTNode class --------------
    // this extends the inherited LinkedBinaryTree.Node class
    protected static class BSTNode<E> extends Node<E> {
      int aux=0;
      BSTNode(E e, Node<E> parent, Node<E> leftChild, Node<E> rightChild) {
        super(e, parent, leftChild, rightChild);
      }
      public int getAux() { return aux; }
      public void setAux(int value) { aux = value; }
    } //--------- end of nested BSTNode class ---------

    // positional-based methods related to aux field
    public int getAux(Position<Entry<K,V>> p) {
      return ((BSTNode<Entry<K,V>>) p).getAux();
    }

    public void setAux(Position<Entry<K,V>> p, int value) {
      ((BSTNode<Entry<K,V>>) p).setAux(value);
    }

    // Override node factory function to produce a BSTNode (rather than a Node)
    @Override
    protected
    Node<Entry<K,V>> createNode(Entry<K,V> e, Node<Entry<K,V>> parent,
                            Node<Entry<K,V>> left, Node<Entry<K,V>> right) {
      return new BSTNode<>(e, parent, left, right);
    }

    /** Relinks a parent node with its oriented child node. */
    private void relink(Node<Entry<K,V>> parent, Node<Entry<K,V>> child,
                        boolean makeLeftChild) {
      child.setParent(parent);
      if (makeLeftChild)
        parent.setLeft(child);
      else
        parent.setRight(child);
    }

    public void rotate(Position<Entry<K,V>> p) {
      Node<Entry<K,V>> x = validate(p);
      Node<Entry<K,V>> y = x.getParent();        // we assume this exists
      Node<Entry<K,V>> z = y.getParent();        // grandparent (possibly null)
      if (z == null) {
        root = x;                                // x becomes root of the tree
        x.setParent(null);
      } else
        relink(z, x, y == z.getLeft());          // x becomes direct child of z
      // now rotate x and y, including transfer of middle subtree
      if (x == y.getLeft()) {
        relink(y, x.getRight(), true);           // x's right child becomes y's left
        relink(x, y, false);                     // y becomes x's right child
      } else {
        relink(y, x.getLeft(), false);           // x's left child becomes y's right
        relink(x, y, true);                      // y becomes left child of x
      }
    }

    public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) {
      Position<Entry<K,V>> y = parent(x);
      Position<Entry<K,V>> z = parent(y);
      if ((x == right(y)) == (y == right(z))) {   // matching alignments
        rotate(y);                                // single rotation (of y)
        return y;                                 // y is new subtree root
      } else {                                    // opposite alignments
        rotate(x);                                // double rotation (of x)
        rotate(x);
        return x;                                 // x is new subtree root
      }
    }
  } //----------- end of nested BalanceableBinaryTree class -----------

  /** Representation of the underlying tree structure. */
  public BalanceableBinaryTree<K,V> tree = new BalanceableBinaryTree<>();

  /** Constructs an empty map using the natural ordering of keys. */
  public TreeMap() {
    super();                  // the AbstractSortedMap constructor
    tree.addRoot(null);       // create a sentinel leaf as root
  }

  public TreeMap(Comparator<K> comp) {
    super(comp);              // the AbstractSortedMap constructor
    tree.addRoot(null);       // create a sentinel leaf as root
  }

  @Override
  public int size() {
    return (tree.size() - 1) / 2;        // only internal nodes have entries
  }

  /** Utility used when inserting a new entry at a leaf of the tree */
  private void expandExternal(Position<Entry<K,V>> p, Entry<K,V> entry) {
    tree.set(p, entry);            // store new entry at p
    tree.addLeft(p, null);         // add new sentinel leaves as children
    tree.addRight(p, null);
  }


  // Some notational shorthands for brevity (yet not efficiency)
  public Position<Entry<K,V>> root() { return tree.root(); }
  public Position<Entry<K,V>> parent(Position<Entry<K,V>> p) { return tree.parent(p); }
  public Position<Entry<K,V>> left(Position<Entry<K,V>> p) { return tree.left(p); }
  public Position<Entry<K,V>> right(Position<Entry<K,V>> p) { return tree.right(p); }
  public Position<Entry<K,V>> sibling(Position<Entry<K,V>> p) { return tree.sibling(p); }
  public boolean isRoot(Position<Entry<K,V>> p) { return tree.isRoot(p); }
  public boolean isExternal(Position<Entry<K,V>> p) { return tree.isExternal(p); }
  public boolean isInternal(Position<Entry<K,V>> p) { return tree.isInternal(p); }
  public void set(Position<Entry<K,V>> p, Entry<K,V> e) { tree.set(p, e); }
  public Entry<K,V> remove(Position<Entry<K,V>> p) { return tree.remove(p); }
  public void rotate(Position<Entry<K,V>> p) { tree.rotate(p); }
  public Position<Entry<K,V>> restructure(Position<Entry<K,V>> x) { return tree.restructure(x); }

  public Position<Entry<K,V>> treeSearch(Position<Entry<K,V>> p, K key) {
    if (isExternal(p))
      return p;                          // key not found; return the final leaf
    int comp = compare(key, p.getElement());
    if (comp == 0)
      return p;                          // key found; return its position
    else if (comp < 0)
      return treeSearch(left(p), key);   // search left subtree
    else
      return treeSearch(right(p), key);  // search right subtree
  }

  public Position<Entry<K,V>> treeMin(Position<Entry<K,V>> p) {
    Position<Entry<K,V>> walk = p;
    while (isInternal(walk))
      walk = left(walk);
    return parent(walk);              // we want the parent of the leaf
  }

  public Position<Entry<K,V>> treeMax(Position<Entry<K,V>> p) {
    Position<Entry<K,V>> walk = p;
    while (isInternal(walk))
      walk = right(walk);
    return parent(walk);              // we want the parent of the leaf
  }

  @Override
  public V get(K key) throws IllegalArgumentException {
    checkKey(key);                          // may throw IllegalArgumentException
    Position<Entry<K,V>> p = treeSearch(root(), key);
    rebalanceAccess(p);                     // hook for balanced tree subclasses
    if (isExternal(p)) return null;         // unsuccessful search
    return p.getElement().getValue();       // match found
  }

  @Override
  public V put(K key, V value) throws IllegalArgumentException {
    checkKey(key);                          // may throw IllegalArgumentException
    Entry<K,V> newEntry = new MapEntry<>(key, value);
    Position<Entry<K,V>> p = treeSearch(root(), key);
    if (isExternal(p)) {                    // key is new
      expandExternal(p, newEntry);
      rebalanceInsert(p);                   // hook for balanced tree subclasses
      return null;
    } else {                                // replacing existing key
      V old = p.getElement().getValue();
      set(p, newEntry);
      rebalanceAccess(p);                   // hook for balanced tree subclasses
      return old;
    }
  }

  @Override
  public V remove(K key) throws IllegalArgumentException {
    checkKey(key);                          // may throw IllegalArgumentException
    Position<Entry<K,V>> p = treeSearch(root(), key);
    if (isExternal(p)) {                    // key not found
      rebalanceAccess(p);                   // hook for balanced tree subclasses
      return null;
    } else {
      V old = p.getElement().getValue();
      if (isInternal(left(p)) && isInternal(right(p))) { // both children are internal
        Position<Entry<K,V>> replacement = treeMax(left(p));
        set(p, replacement.getElement());
        p = replacement;
      } // now p has at most one child that is an internal node
      Position<Entry<K,V>> leaf = (isExternal(left(p)) ? left(p) : right(p));
      Position<Entry<K,V>> sib = sibling(leaf);
      remove(leaf);
      remove(p);                            // sib is promoted in p's place
      rebalanceDelete(sib);                 // hook for balanced tree subclasses
      return old;
    }
  }

  @Override
  public Entry<K,V> firstEntry() {
    if (isEmpty()) return null;
    return treeMin(root()).getElement();
  }

  @Override
  public Entry<K,V> lastEntry() {
    if (isEmpty()) return null;
    return treeMax(root()).getElement();
  }

  @Override
  public Entry<K,V> ceilingEntry(K key) throws IllegalArgumentException {
    checkKey(key);                              // may throw IllegalArgumentException
    Position<Entry<K,V>> p = treeSearch(root(), key);
    if (isInternal(p)) return p.getElement();   // exact match
    while (!isRoot(p)) {
      if (p == left(parent(p)))
        return parent(p).getElement();          // parent has next greater key
      else
        p = parent(p);
    }
    return null;                                // no such ceiling exists
  }

  @Override
  public Entry<K,V> floorEntry(K key) throws IllegalArgumentException {
    checkKey(key);                              // may throw IllegalArgumentException
    Position<Entry<K,V>> p = treeSearch(root(), key);
    if (isInternal(p)) return p.getElement();   // exact match
    while (!isRoot(p)) {
      if (p == right(parent(p)))
        return parent(p).getElement();          // parent has next lesser key
      else
        p = parent(p);
    }
    return null;                                // no such floor exists
  }

  @Override
  public Entry<K,V> lowerEntry(K key) throws IllegalArgumentException {
    checkKey(key);                              // may throw IllegalArgumentException
    Position<Entry<K,V>> p = treeSearch(root(), key);
    if (isInternal(p) && isInternal(left(p)))
      return treeMax(left(p)).getElement();     // this is the predecessor to p
    // otherwise, we had failed search, or match with no left child
    while (!isRoot(p)) {
      if (p == right(parent(p)))
        return parent(p).getElement();          // parent has next lesser key
      else
        p = parent(p);
    }
    return null;                                // no such lesser key exists
  }

  @Override
  public Entry<K,V> higherEntry(K key) throws IllegalArgumentException {
    checkKey(key);                               // may throw IllegalArgumentException
    Position<Entry<K,V>> p = treeSearch(root(), key);
    if (isInternal(p) && isInternal(right(p)))
      return treeMin(right(p)).getElement();     // this is the successor to p
    // otherwise, we had failed search, or match with no right child
    while (!isRoot(p)) {
      if (p == left(parent(p)))
        return parent(p).getElement();           // parent has next lesser key
      else
        p = parent(p);
    }
    return null;                                 // no such greater key exists
  }

  @Override
  public Iterable<Entry<K,V>> entrySet() {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
    for (Position<Entry<K,V>> p : tree.inorder())
      if (isInternal(p)) buffer.add(p.getElement());
    return buffer;
  }

  @Override
  public Iterable<Entry<K,V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
    checkKey(fromKey);                                // may throw IllegalArgumentException
    checkKey(toKey);                                  // may throw IllegalArgumentException
    ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
    if (compare(fromKey, toKey) < 0)                  // ensure that fromKey < toKey
      subMapRecurse(fromKey, toKey, root(), buffer);
    return buffer;
  }

  // utility to fill subMap buffer recursively (while maintaining order)
  private void subMapRecurse(K fromKey, K toKey, Position<Entry<K,V>> p,
                              ArrayList<Entry<K,V>> buffer) {
    if (isInternal(p))
      if (compare(p.getElement(), fromKey) < 0)
        // p's key is less than fromKey, so any relevant entries are to the right
        subMapRecurse(fromKey, toKey, right(p), buffer);
      else {
        subMapRecurse(fromKey, toKey, left(p), buffer); // first consider left subtree
        if (compare(p.getElement(), toKey) < 0) {       // p is within range
          buffer.add(p.getElement());                      // so add it to buffer, and consider
          subMapRecurse(fromKey, toKey, right(p), buffer); // right subtree as well
        }
      }
  }
  
  
  protected void rebalanceInsert(Position<Entry<K, V>> p ){ }
  
  protected void rebalanceDelete(Position<Entry<K, V>> p){ }

  protected void rebalanceAccess(Position<Entry<K,V>> p) { }
  
  
}