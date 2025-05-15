package EI3;

public class EI3 {

	public static void main(String[] args) {
		WebBrowserHistory browserHistory = new WebBrowserHistory();
		
		browserHistory.visitPage("https://pagina1.com");
        browserHistory.visitPage("https://pagina2.com");
        browserHistory.visitPage("https://pagina3.com");
        
        System.out.println("Página actual: " + browserHistory.getCurrentPage());  // https://pagina3.com
        
        System.out.println("Ir atrás: " + browserHistory.back());  // https://pagina2.com
        System.out.println("Página actual: " + browserHistory.getCurrentPage());  // https://pagina2.com
        
        System.out.println("Ir atrás: " + browserHistory.back());  // https://pagina1.com
        System.out.println("Página actual: " + browserHistory.getCurrentPage());  // https://pagina1.com
        
        System.out.println("Ir adelante: " + browserHistory.forward());  // https://pagina2.com
        System.out.println("Página actual: " + browserHistory.getCurrentPage());  // https://pagina2.com
        
        browserHistory.visitPage("https://pagina4.com");
        System.out.println("Página actual después de visitar una nueva página: " + browserHistory.getCurrentPage());  // https://pagina4.com
        System.out.println("Intentar ir adelante: " + browserHistory.forward());  // null, ya no hay páginas adelante

	}

}
