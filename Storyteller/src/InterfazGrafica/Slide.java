package InterfazGrafica;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import Arboles.Nodo;
import Logica.Controlador;

public class Slide extends javax.swing.JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1362174125576713002L;
	private Screen Pantalla;
	private DisplayMode DM;
	private Image Imagen;
	private Controlador p;
	
	public Slide(Controlador controlador) throws IOException, JSONException{
	    DM = new DisplayMode(1280,1500,32,DisplayMode.REFRESH_RATE_UNKNOWN);
	    Pantalla = new Screen();
	    Imagen = null;
	    p= controlador;

	}
	  
	
	public void Run () throws IOException, JSONException{
		CrearKeyListener();
		CrearKeyListenerl();
		this.getContentPane().setBackground(Color.BLACK);
	    setForeground(Color.WHITE);
	    try{
	    	Pantalla.setFullScreen(DM, this);
	    }
	    catch(Exception ex)
	    {
	    }
	    
	 }
	 public void paint (Graphics g)
	    {
		 super.paint(g);
		 if(Imagen != null){
			
	        g.setColor (Color.blue);
	        g.drawString("Primer linea",10,200);
	        g.drawImage(Imagen, 700, 200, 600, 600, null);
	        g.drawString("Segunda linea",10,300);
		 }
	    }
	  
	
	public void CargarImagen(Image pImagen, String pDescripcion, String pTitulo) throws IOException, InterruptedException{
		Imagen = pImagen;
		Thread.sleep(100);
		repaint();
	}
	
	public void CrearKeyListener(){
		KeyListener listener = new KeyListener(){
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
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
	
	public void CrearKeyListenerl(){
		MouseListener listener = new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				try {
					p.MostrarVentana();
				} catch (IOException | JSONException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		};
		addMouseListener(listener);
		setFocusable(true);
	}

}
