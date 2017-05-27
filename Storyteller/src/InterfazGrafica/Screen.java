package InterfazGrafica;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import javax.swing.JFrame;

public class Screen {
	private GraphicsDevice GD;
	
	public Screen()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GD = env.getDefaultScreenDevice();
	}
	
	
	public void setFullScreen(DisplayMode DM, JFrame Ventana)
	{
		Ventana.setUndecorated(true);
		Ventana.setResizable(false);
		GD.setFullScreenWindow(Ventana);
		if(DM != null && GD.isDisplayChangeSupported())
		{
			try{
				GD.setDisplayMode(DM);
			}catch(Exception ex){}
		}
	}
	
	
	public Window getFullScreenWindow()
	{
		return GD.getFullScreenWindow();
	}
	
	
	public void restoreScreen()
	{
		Window Ventana = GD.getFullScreenWindow();
		if(Ventana!=null)
		{
			Ventana.dispose();
		}
		GD.setFullScreenWindow(null);
	}
}
