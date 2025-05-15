package EI5;

public class EI5 {

	public static void main(String[] args) {
		
		Estudiante e1=new Estudiante("Daniel", 329519);
		Estudiante e2=new Estudiante("Josue", 324578);
		Estudiante e3=new Estudiante("Jaord", 331547);
		Estudiante e4=new Estudiante("Felipe", 33605);
		Estudiante e6=new Estudiante("Sofimora", 324518);
		
		ControladorEstudiante Estudiante=new ControladorEstudiante();
		
		Estudiante.addEstudianteChainMap(e1);
		Estudiante.addEstudianteChainMap(e2);
		Estudiante.addEstudianteChainMap(e3);
		Estudiante.addEstudianteChainMap(e4);
		
		Estudiante.addEstudianteChainMap(e6);
		
		Estudiante.addEstudianteProbeMap(e1);
		Estudiante.addEstudianteProbeMap(e2);		
		Estudiante.addEstudianteProbeMap(e3);
		Estudiante.addEstudianteProbeMap(e4);
		
		Estudiante.addEstudianteProbeMap(e6);
		
		Estudiante.addEstudianteDoubleMap(e1);
		Estudiante.addEstudianteDoubleMap(e2);
		Estudiante.addEstudianteDoubleMap(e3);
		Estudiante.addEstudianteDoubleMap(e4);
		
		Estudiante.addEstudianteDoubleMap(e6);
		
		//System.out.println("\n");
		
		System.out.println("Hash Values del ChainHashMap con sus respectivos entries");
		System.out.println(Estudiante.HashValuesChainMap());
		
		System.out.println("Hash Values del ProbeHashMap con sus respectivos entries");
		System.out.println(Estudiante.HashValuesProbeMap());
		
		System.out.println("Hash Values del DoubleHashMap con sus respectivos entries");
		System.out.println(Estudiante.HashValuesDoubleMap());
		
		
		System.out.println("\nEliminación del estudiante con código 324518 del DoubleHashMap");
		System.out.println(Estudiante.remover(324518, 'D'));
		System.out.println("Tamaño del DoubleHashMap");
		System.out.println(Estudiante.tamanioMapa('D'));
		
		
		System.out.println("Tamaño del ChainHashMap");
		System.out.println(Estudiante.tamanioMapa('C')+"\n");
		
		System.out.println("Tamaño del ChainHashMap");
		System.out.println(Estudiante.tamanioMapa('C')+"\n");
		
		System.out.println("Tamaño del ProbeHashMap");
		System.out.println(Estudiante.tamanioMapa('P'));
		
		
		

		
		System.out.println("\nEstudiante con código 329519 en ChainHashMap");
		System.out.println(Estudiante.getEstudiante(329519, 'C'));
		System.out.println("\nEstudiante con código 324518 en ProbeHashMap");
		System.out.println(Estudiante.getEstudiante(324518, 'P'));
		System.out.println("\nEstudiante con código 33605 en DoubleHashMap");
		System.out.println(Estudiante.getEstudiante(33605, 'D'));

		System.out.println("\nKeySet para el PROBEHashMap");
		Iterable<Integer>keys=Estudiante.keys('P');
		for (Integer i:keys) {
			System.out.println("Key:"+i);
		}
		
		System.out.println("\nValues para el CHAINHashMap");
		Iterable<Estudiante>values=Estudiante.valores('C');
		for (Estudiante p:values) {
			System.out.println("Valor: "+p);
		}	
	}


}
