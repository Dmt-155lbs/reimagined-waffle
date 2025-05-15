package EI3;

import TDA.DoublyLinkedList;

public class WebBrowserHistory {
	
	private DoublyLinkedList<String> history;
    private DoublyLinkedList.Node<String> current;

    public WebBrowserHistory() {
        history = new DoublyLinkedList<>();
        current = null;
    }

    public void visitPage(String url) {
        if (current != null) {
            while (history.last() != current.getElement()) {
                history.removeLast();  // Limpiar historial adelante
            }
        }
        history.addLast(url);
        current = history.getTrailer().getPrev();  // Actualizar la página actual
    }

    public String back() {
        if (current != null && current.getPrev() != history.getHeader()) {
            current = current.getPrev();
            return current.getElement();
        }
        return null;  // No hay más páginas atrás
    }

    public String forward() {
        if (current != null && current.getNext() != history.getTrailer()) {
            current = current.getNext();
            return current.getElement();
        }
        return null;  // No hay más páginas adelante
    }

    public String getCurrentPage() {
        if (current != null) {
            return current.getElement();  // Devolver la página actual (URL)
        } else {
            return null;  // No hay página actual
        }
    }

}
