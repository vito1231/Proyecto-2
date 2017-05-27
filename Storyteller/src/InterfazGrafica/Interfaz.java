package InterfazGrafica;


import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Logica.JSON_ARRAY;

public class Interfaz extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5434314643296392986L;
	private JButton BotonArbol;
	private Slide Archivo;
	private JSON_ARRAY NU;
	
	public Interfaz() throws JSONException, IOException, ParseException, InterruptedException{
		setSize(1900, 1050);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Arbol();
	}
	
	
	public void Arbol(){
		BotonArbol = new JButton("Nuevo");
		BotonArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	try {
					BotonArbolActionPerformed(evt);
				} catch (IOException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });

		BotonArbol.setBounds(10, 10, 80, 40);
		BotonArbol.setBackground(new Color(100,100,100));
		this.add(BotonArbol); 
	}
	
	private void BotonArbolActionPerformed(java.awt.event.ActionEvent evt) throws IOException, JSONException, ParseException, InterruptedException {                                         
        // TODO add your handling code here:
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".json", "json");
		fileChooser.setFileFilter(filter);
		if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  Archivo = new Slide(file);
		  NU = new JSON_ARRAY(file.getAbsolutePath(),Archivo);
		  Archivo.run();
		  Archivo.setVisible(true);
		  Archivo.CargarImagen(NU.ObtenerURLs(), "pDescripcion"," pTitulo");
		}
    }                         
	
	public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new Interfaz().setVisible(true);
				} catch (JSONException | IOException | ParseException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
}