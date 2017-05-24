import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class prueba extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
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
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 649);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNewAlbum = new JMenuItem("New Album");
		mntmNewAlbum.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		mnFile.add(mntmNewAlbum);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblStoryteller = new JLabel("StoryTeller");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblStoryteller, 22, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblStoryteller, 29, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lblStoryteller, 89, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblStoryteller, 402, SpringLayout.WEST, contentPane);
		lblStoryteller.setFont(new Font("Segoe Script", Font.PLAIN, 46));
		contentPane.add(lblStoryteller);
		
		JList list = new JList();
		list.setFont(new Font("Arial", Font.PLAIN, 40));
		sl_contentPane.putConstraint(SpringLayout.NORTH, list, 75, SpringLayout.SOUTH, lblStoryteller);
		sl_contentPane.putConstraint(SpringLayout.WEST, list, 96, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, list, -104, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, list, 340, SpringLayout.WEST, contentPane);
		DefaultListModel model = new DefaultListModel();
		
		
		
		model.addElement("Prueba");
		model.addElement("Prueba 2");
		list.setModel(model);
		
		contentPane.add(list);
		
		
		
		
		
	}
}
