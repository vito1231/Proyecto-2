package Arboles;

public class Nodo<T> {
	private Nodo<T> HijoIzq;
	private Nodo<T> HijoDer;
	private T Valor;
	private int Peso;
	
	public Nodo()
	{
		HijoIzq = null;
		HijoDer = null;
		Valor = null;
		Peso = 0;
	}
	
	
	public Nodo(T pValue)
	{
		HijoIzq = null;
		HijoDer = null;
		Valor = pValue;
		Peso = 0;
	}
	
	
	public void addChildIzq(Nodo<T> pHijoIzq)
	{
		HijoIzq = pHijoIzq;
	}
	
	
	public void addChildDer(Nodo<T> pHijoDer)
	{
		HijoDer = pHijoDer;
	}
	
	
	public Nodo<T> getNodeIzq()
	{
		return HijoIzq;
	}

	
	public Nodo<T> getNodeDer()
	{
		return HijoDer;
	}
	
	
	public T getValor()
	{
		return Valor;
	}
	
	
	public void setValor(T pValue)
	{
		Valor = pValue;
	}


	public int getPeso() {
		return Peso;
	}


	public void setPeso(int peso) {
		Peso = peso;
	}
}
