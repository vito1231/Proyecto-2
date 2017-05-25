package Arboles;

public class Arbol<T> {
	private Nodo Raiz;
	
	public Arbol()
	{
		Raiz = null;
	}
	
	
	public boolean Vacio()
	{
		if(Raiz == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public void addNodeValue(T pValue)
	{
		Nodo<String> Nuevo = new Nodo<String>((String) pValue);
		if(!Vacio())
		{
			Insertar(Raiz, Nuevo);
		}
		else
		{
			Raiz = Nuevo;
		}
	}
	
	
	public void addNode(Nodo<String> pNodo)
	{
		if(!Vacio())
		{
			Insertar(Raiz, pNodo);
		}
		else
		{
			Raiz = pNodo;
		}
	}
	
	
	public Nodo<String> Insertar(Nodo<String> pNodo, Nodo<String> pNuevo){
		if(pNodo != null){
			if(pNodo.getValor().compareToIgnoreCase(pNuevo.getValor()) < 0)
			{
				Nodo<String> Aux = Insertar(pNodo.getNodeDer(), pNuevo);
				if(pNodo.getNodeDer() == null){
					pNodo.addChildDer(Aux);
				}
				if(Peso(pNodo.getNodeDer()) - Peso(pNodo.getNodeIzq()) == 2){
					if(pNodo.getValor().compareToIgnoreCase(pNuevo.getValor()) < 0){
						pNodo = RotarHijoDer(pNodo);
					}
					else{
						pNodo = RotarDobleHijoDer(pNodo);
					}
				}
			
			}
			else if(pNodo.getValor().compareToIgnoreCase(pNuevo.getValor()) > 0)
			{
				Nodo<String> Aux = Insertar(pNodo.getNodeIzq(), pNuevo);
				if(pNodo.getNodeIzq() == null){
					pNodo.addChildIzq(Aux);
				}
				if(Peso(pNodo.getNodeIzq()) - Peso(pNodo.getNodeDer()) == 2){
					if(pNodo.getValor().compareToIgnoreCase(pNuevo.getValor()) > 0){
						pNodo = RotarHijoIzq(pNodo);
					}
					else{
						pNodo = RotarDobleHijoIzq(pNodo);
					}
				}

			}
		}
		return pNuevo;
	}
	
	
	public Nodo<T> buscarNodo(T pValue)
	{
		return null;
	}
	
	
	public int Peso(Nodo<String> Nodo){
		return Nodo == null ? -1:Nodo.getPeso();
	}
	
	
	public Nodo<String> RotarHijoDer(Nodo<String> Nodo)
	{
		Nodo<String> Auxiliar = Nodo.getNodeDer();
		Nodo.addChildDer(Auxiliar.getNodeIzq());
		Auxiliar.addChildIzq(Nodo);
		Nodo.setPeso(Max(Peso(Nodo.getNodeIzq()), Peso(Nodo.getNodeDer())) + 1);
		Auxiliar.setPeso(Max(Peso(Auxiliar.getNodeDer()),Nodo.getPeso()) +1);
		return Auxiliar;
	}
	
	
	public Nodo<String> RotarHijoIzq(Nodo<String> Nodo)
	{
		Nodo<String> Auxiliar = Nodo.getNodeIzq();
		Nodo.addChildIzq(Auxiliar.getNodeDer());
		Auxiliar.addChildDer(Nodo);
		Nodo.setPeso(Max(Peso(Nodo.getNodeIzq()), Peso(Nodo.getNodeDer())) + 1);
		Auxiliar.setPeso(Max(Peso(Auxiliar.getNodeDer()),Nodo.getPeso()) +1);
		return Auxiliar;
	}
	
	
	public Nodo<String> RotarDobleHijoDer(Nodo<String> Nodo)
	{
		Nodo.addChildDer(RotarHijoIzq(Nodo.getNodeDer()));
		return RotarHijoDer(Nodo);
	}
	
	
	public Nodo<String> RotarDobleHijoIzq(Nodo<String> Nodo)
	{
		Nodo.addChildIzq(RotarHijoDer(Nodo.getNodeIzq()));
		return RotarHijoIzq(Nodo);
	}
	
	
	public int Max(int IzqPeso, int DerPeso)
	{
		return IzqPeso > DerPeso ? IzqPeso:DerPeso;
	}
	
	
	public void Recorrer()
	{
		EnOrden(Raiz);
	}
	
	
	public void EnOrden(Nodo<String> Nodo)
	{
		if(Nodo != null){
			EnOrden(Nodo.getNodeIzq());
			System.out.println(Nodo.getValor());
			EnOrden(Nodo.getNodeDer());
		}
	}
}
