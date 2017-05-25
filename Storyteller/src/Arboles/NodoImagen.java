package Arboles;

public class NodoImagen<T> {
	private T Valor;
	
	public NodoImagen()
	{
		Valor = null;
	}
	
	
	public NodoImagen(T pValue)
	{
		Valor = pValue;
	}
	
	
	public T getValor()
	{
		return Valor;
	}
	
	
	public void setValor(T pValue)
	{
		Valor = pValue;
	}
}