package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuardarAlbum extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuardarAlbum frame = new GuardarAlbum();
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
	public GuardarAlbum(/*InterfazDef interfaz*/) {
		Continuar conti=new Continuar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 280);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lbldeseaGuardarEl = new JLabel("\u00BFDesea guardar el album?");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lbldeseaGuardarEl, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lbldeseaGuardarEl, 33, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, lbldeseaGuardarEl, 97, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lbldeseaGuardarEl, 463, SpringLayout.WEST, contentPane);
		lbldeseaGuardarEl.setFont(new Font("Monotype Corsiva", Font.PLAIN, 32));
		contentPane.add(lbldeseaGuardarEl);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		sl_contentPane.putConstraint(SpringLayout.NORTH, textField, 11, SpringLayout.SOUTH, lbldeseaGuardarEl);
		sl_contentPane.putConstraint(SpringLayout.WEST, textField, -359, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, textField, 46, SpringLayout.SOUTH, lbldeseaGuardarEl);
		sl_contentPane.putConstraint(SpringLayout.EAST, textField, -91, SpringLayout.EAST, contentPane);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombreDelAlbum = new JLabel("Nombre del album:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNombreDelAlbum, 5, SpringLayout.NORTH, textField);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNombreDelAlbum, -163, SpringLayout.WEST, textField);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNombreDelAlbum, -6, SpringLayout.WEST, textField);
		lblNombreDelAlbum.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		contentPane.add(lblNombreDelAlbum);
		
		
		JButton btnSi = new JButton("Si");
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String key=textField.getText();
				//interfaz.getTable().add(key, );
				 setVisible(false);
				 conti.setVisible(true);
				 
			}
		});
		btnSi.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnSi, 166, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnSi, -129, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSi, -32, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnSi, -62, SpringLayout.EAST, contentPane);
		contentPane.add(btnSi);
		
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				conti.setVisible(true);
			}
		});
		btnNo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNo, -313, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNo, -241, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNo, -32, SpringLayout.SOUTH, contentPane);
		contentPane.add(btnNo);
	}
}
