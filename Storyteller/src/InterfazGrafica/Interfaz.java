package InterfazGrafica;
import java.awt.Canvas;
import Arboles.Arbol;

public class Interfaz extends Canvas{
	/**
	 * 
	 */
	private static final long serialVersionUID = -306458454844959241L;
	private Arbol<Object> Lista;
    
	public Interfaz ()
	{

	}

	
	public Arbol<Object> getLista() {
		return Lista;
	}

	
	public void setLista(Arbol<Object> lista) {
		Lista = lista;
	}
}
