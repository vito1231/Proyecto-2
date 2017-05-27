package Arboles;

public class NodoImagen<T> {
	private T Valor;
	private Estado EstadoImagen;
	private String Descripcion;
	
	public Estado getEstadoImagen() {
		return EstadoImagen;
	}


	public void setEstadoImagen(Estado estadoImagen) {
		EstadoImagen = estadoImagen;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


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
