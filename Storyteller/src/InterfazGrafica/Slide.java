package InterfazGrafica;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Logica.JSON_ARRAY;

public class Slide extends javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1362174125576713002L;
	private Image Imagen;
	private Screen Pantalla;
	private DisplayMode DM;
	private String Titulo;
	private String Descripcion;
	private File Archivo;
	private ArrayList<String> h;
	
	public Slide(File pArchivo) throws IOException, JSONException{
	    DM = new DisplayMode(1280,1500,32,DisplayMode.REFRESH_RATE_UNKNOWN);
	    Pantalla = new Screen();
	    Archivo = pArchivo;
	}
	  
	
	public void run () throws IOException, JSONException{
		CrearKeyListener();
		this.getContentPane().setBackground(Color.BLACK);
	    setForeground(Color.WHITE);
	    try{
	    	System.out.println(this.getHeight());
	    	Pantalla.setFullScreen(DM, this);
	    }
	    catch(Exception ex)
	    {
	    }
	    
	 }
	  
	  

	
	public void CargarImagen(ArrayList<String> h, String pDescripcion, String pTitulo) throws IOException, InterruptedException{
		for(String Url : h){
				//Analisis.Analizar(Url);
				System.out.println(Url);
				URL url = new URL(Url);
				Imagen = ImageIO.read(url);
				Descripcion = pDescripcion;
				Titulo = pTitulo;
				this.getGraphics().drawImage(Imagen,700	, 200, 600, 600, null); 
				Thread.sleep(150);
		}
	}
	
	public void CrearKeyListener(){
		KeyListener listener = new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println("dsa");
				Pantalla.restoreScreen();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		addKeyListener(listener);
		setFocusable(true);
	}


	

}
