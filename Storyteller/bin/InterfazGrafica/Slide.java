package InterfazGrafica;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JFrame;


public class Slide extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image Imagen;
	private GraphicsDevice GD;
	private DisplayMode DM;
	private String Descripcion;
	private String Titulo;
	
	public Slide()
	{
		DM = new DisplayMode(1280,1500,32,DisplayMode.REFRESH_RATE_UNKNOWN);
		GD = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		Descripcion = "";
		Titulo = "";
		Imagen = null;
	}
	
	
	public void Run ()
	{
		KeyListener();
		this.getContentPane().setBackground(Color.BLACK);
	    try
	    {
	    	setFullScreen();
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}
	
	  
	public void paint(Graphics g)
	{
		if(Imagen != null){
			super.paint(g);
			g.setFont((new Font("Dialog", Font.PLAIN,64)));
			g.drawString(Titulo, getWidth()/2-75, 100);
		    g.drawImage(Imagen, getWidth()/4, getHeight()/8, this);
		    g.setFont((new Font("Dialog", Font.PLAIN,40)));
		    g.drawString(Descripcion, getWidth()/2-400, getHeight()-200);
		}
	}
	
	
	public void CargarImagen(Image pImagen, String pDescripcion, String pTitulo) throws IOException
	{
		Imagen = pImagen;
	    Descripcion = pDescripcion;
	    Titulo = pTitulo;
	    repaint() ;
	}
	
	
	public void setFullScreen()
	{
		setUndecorated(true);
		setResizable(false);
		GD.setFullScreenWindow(this);
		if(DM != null && GD.isDisplayChangeSupported())
		{
			try
			{
				GD.setDisplayMode(DM);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	 
	 
	public Window getFullScreenWindow()
	{
		return GD.getFullScreenWindow();
	}
	
	
	public void restoreScreen()
	{
		Window Ventana = GD.getFullScreenWindow();
		if(Ventana != null)
		{
			Ventana.dispose();
		}
		GD.setFullScreenWindow(null);	
	}
	
	
	public void KeyListener()
	{
		KeyListener Listener = new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				restoreScreen();
			}

			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
			}

			@Override
			public void keyTyped(KeyEvent e) 
			{
				// TODO Auto-generated method stub
			}
			
     };
     addKeyListener(Listener);
	 setFocusable(true);
	}
}
