package Logica;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Arboles.Arbol;
import Arboles.Nodo;
import Arboles.NodoImagen;
import InterfazGrafica.Interfaz;
import InterfazGrafica.Slide;

public class Controlador {
	private Analizador Analisis;
	private Arbol<Nodo<String>> Imagenes;
	private Slide Ventana;
	private Interfaz Principal;
	private ArrayList<Nodo<String>> Lista;
	
	public Controlador() throws IOException, JSONException, ParseException, InterruptedException{
		Principal = new Interfaz(this);
		Analisis = new Analizador();
		Imagenes = new Arbol<Nodo<String>>(this);
		Ventana = new Slide(this);
		Lista = new ArrayList<Nodo<String>>();
		
	}
	
	
	public void AnalizarImagenes(ArrayList<String> Urls) throws IOException, JSONException, InterruptedException{
		for(String Url : Urls){
			URL url = new URL(Url);
			Image Imagen = ImageIO.read(url);
			System.out.println(Url);
			Analisis.Analizar(Url);
			InsertarArbol(Analisis.Tags(),Imagen,"fe");
			Thread.sleep(150);
		}
	}
	
	
	public Interfaz getPrincipal() {
		return Principal;
	}


	public void setPrincipal(Interfaz principal) {
		Principal = principal;
	}


	private void InsertarArbol(ArrayList<String> Tags, Image Imagen, String Descripcion) {
		for(String Tag : Tags){
			Nodo<String> Nuevo = new Nodo<String>(Tag);
			NodoImagen<Image> Nueva = new NodoImagen<Image>();
			Nueva.setDescripcion(Descripcion);
			Imagenes.addNode(Nuevo,Nueva);
		}
		
	}
	
	
	
	public void DesplegarImagenes(Nodo<String> Nodo) throws IOException, InterruptedException{
		Ventana.CargarImagen(Nodo.getImagen().get(0).getValor(), Nodo.getImagen().get(0).getDescripcion(), Nodo.getValor());
		
	}


	public void MostrarVentana() throws IOException, JSONException, InterruptedException {
		Ventana.Run();
		Ventana.setVisible(true);
		Imagenes.Recorrer();
	}
	public Controlador getControl(){
		return this;
	}


	public ArrayList<Nodo<String>> getLista() {
		return Lista;
	}


	public void setLista(ArrayList<Nodo<String>> lista) {
		Lista = lista;
	}


	public Slide getVentana() {
		return Ventana;
	}


	public void setVentana(Slide ventana) {
		Ventana = ventana;
	}
	
}
