package InterfazGrafica;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle.Control;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import Arboles.Arbol;
import HashTable.Entry;
import HashTable.ParOrdenado;
import Logica.Controlador;
import Logica.JSON_ARRAY;
import Logica.Serializacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InterfazDef extends JFrame {

	private Slide Archivo;
	private JSON_ARRAY NU;
	private JPanel contentPane;
	private ParOrdenado table;
	private Controlador Control;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazDef frame = new InterfazDef(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazDef(Controlador pControl) {
		Control = pControl;
		DefaultListModel model = new DefaultListModel();
		
		try{
			table= Control.cargar();
			ArrayList<Entry> tabla = table.getTable();
			for(int i=0; i<tabla.size(); i++){
				model.addElement(tabla.get(i).getKey());
			}
			
		}
		catch(Exception e){
			table= new ParOrdenado();
			Control.salvar(table);
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 725);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewAlbum = new JMenuItem("New Album");
		mntmNewAlbum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					cargar();
				} catch (IOException | JSONException | ParseException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnFile.add(mntmNewAlbum);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblStoryteller = new JLabel("StoryTeller");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblStoryteller, 34, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblStoryteller, 38, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStoryteller, 131, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStoryteller, 508, SpringLayout.WEST, contentPane);
		lblStoryteller.setFont(new Font("Kunstler Script", Font.PLAIN, 88));
		contentPane.add(lblStoryteller);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_contentPane.putConstraint(SpringLayout.NORTH, scrollPane, 11, SpringLayout.SOUTH, lblStoryteller);
		sl_contentPane.putConstraint(SpringLayout.WEST, scrollPane, 85, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, scrollPane, 590, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, scrollPane, 803, SpringLayout.WEST, contentPane);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String valor=(String) list.getSelectedValue(); 
				Entry album= table.busqueda_binaria(valor);
				Serializacion objeto= new Serializacion ();
				Arbol arbol =(Arbol) objeto.deserializar(album.getValue());
				try {
					arbol.Recorrer();
				} catch (IOException | InterruptedException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		});
		list.setFont(new Font("Monotype Corsiva", Font.PLAIN, 23));
		list.setModel(model);
		scrollPane.setViewportView(list);
	}
	public void cargar() throws IOException, JSONException, ParseException, InterruptedException{
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".json", "json");
		fileChooser.setFileFilter(filter);
		if (fileChooser.showOpenDialog(fileChooser) == JFileChooser.APPROVE_OPTION) {
		  File file = fileChooser.getSelectedFile();
		  JSON_ARRAY ListaUrls = new JSON_ARRAY(file.getAbsolutePath());
		  Control.AnalizarImagenes(ListaUrls.ObtenerURLs());
		  Control.MostrarVentana();
		}
		
	}

	public Slide getArchivo() {
		return Archivo;
	}

	public void setArchivo(Slide archivo) {
		Archivo = archivo;
	}

	public ParOrdenado getTable() {
		return table;
	}

	public void setTable(ParOrdenado table) {
		this.table = table;
	}
	
}