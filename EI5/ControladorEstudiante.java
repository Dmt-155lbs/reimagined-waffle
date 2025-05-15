package EI5;

import TDA.ChainHashMap;
import TDA.DoubleHashMap;
import TDA.Entry;
import TDA.ProbeHashMap;

public class ControladorEstudiante {
	
	private ChainHashMap<Integer, Estudiante> chainMap;
	private ProbeHashMap<Integer, Estudiante> probeMap;
	private DoubleHashMap<Integer, Estudiante> doubleMap;
	
	public ControladorEstudiante() {
		chainMap=new ChainHashMap<>(7, 23);
		probeMap=new ProbeHashMap<>(7,23);
		doubleMap=new DoubleHashMap<>(11,29,23);
		
	}
	
	public void addEstudianteChainMap(Estudiante p) {
		chainMap.put(p.getCodigo(), p);
	}
	
	public void addEstudianteProbeMap(Estudiante p) {
		probeMap.put(p.getCodigo(), p);
		
	}
	
	public void addEstudianteDoubleMap(Estudiante p) {
		doubleMap.put(p.getCodigo(), p);
	}
	
	public Estudiante remover(int k, char c) {
		if (c=='C')
			
			return chainMap.remove(k);
		else if (c=='P')
			
			return probeMap.remove(k);
		else
			
			return doubleMap.remove(k);
	}
	
	
	public Estudiante getEstudiante(int k, char c) {
		if (c=='C')
			
			return chainMap.get(k);
		
		else if (c=='P')
			
			return probeMap.get(k);
		
		else
			return doubleMap.get(k);
		
	}
	
	
	public int tamanioMapa(char c) {
		if (c=='C')
			
			return chainMap.size();
		
		else if (c=='P')
			
			
			return probeMap.size();
		
		else
			return doubleMap.size();
		
	}
	
	
	public String HashValuesChainMap() {
		String c="";
		
		
		for (Entry<Integer, Estudiante>e:chainMap.entrySet()) {
			c+= "Hash Value:"+chainMap.hashValue(e.getKey())+"→ ";
			c+= e.getValue();
			c+= "\n";
			
		}
		return c;
	}
	
	public String HashValuesProbeMap() {
		String p="";
		
		
		for (Entry<Integer, Estudiante>e:probeMap.entrySet()) {
			p+= "Hash Value:"+probeMap.findSlot(probeMap.hashValue(e.getKey()),e.getKey())+"→ ";
			p+= e.getValue();
			p+= "\n";
			
		}
		return p;
	}

	public String HashValuesDoubleMap() {
		String d="";
		
		
		for (Entry<Integer, Estudiante>e:doubleMap.entrySet()) {
			d+= "Hash Value:"+doubleMap.findSlot(doubleMap.hashValue(e.getKey()),e.getKey())+"→ ";
			d+= e.getValue();
			d+= "\n";
			
		}
		return d;
	}
	
	public Iterable<Integer> keys(char c){
		if (c=='C')
			
			return chainMap.keySet();
		
		else if (c=='P')
			
			return probeMap.keySet();
		
		else
			return doubleMap.keySet();
	}
	
	public Iterable<Estudiante> valores(char c){
		if (c=='C')
			
			return chainMap.values();
		
		else if (c=='P')
			
			return probeMap.values();
		
		else
			return doubleMap.values();
		
	}

}
