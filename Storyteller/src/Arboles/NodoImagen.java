package Arboles;

public class NodoImagen<T> {
	private T Valor;
	private Estado EstadoImagen;
	
	public NodoImagen()
	{
		Valor = null;
		EstadoImagen = Estado.SinProcesar;
	}
	
	
	public NodoImagen(T pValue)
	{
		Valor = pValue;
		EstadoImagen = Estado.SinProcesar;
	}
	
	
	public T getValor()
	{
		return Valor;
	}
	
	
	public void setValor(T pValue)
	{
		Valor = pValue;
	}


	public Estado getEstado() {
		return EstadoImagen;
	}


	public void setEstado(Estado estado) {
		EstadoImagen = estado;
	}
}
