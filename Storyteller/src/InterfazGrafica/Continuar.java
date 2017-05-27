package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Continuar extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Continuar frame = new Continuar(null);
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
	public Continuar(InterfazDef interfaz) {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 688, 280);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			SpringLayout sl_contentPane = new SpringLayout();
			contentPane.setLayout(sl_contentPane);
			
			JLabel lbldeseaGuardarEl = new JLabel("\u00BFDesea continuar?");
			sl_contentPane.putConstraint(SpringLayout.NORTH, lbldeseaGuardarEl, 24, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, lbldeseaGuardarEl, 49, SpringLayout.WEST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, lbldeseaGuardarEl, 111, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, lbldeseaGuardarEl, 479, SpringLayout.WEST, contentPane);
			lbldeseaGuardarEl.setFont(new Font("Monotype Corsiva", Font.PLAIN, 32));
			contentPane.add(lbldeseaGuardarEl);
			
			JButton btnSi = new JButton("Si");
			btnSi.setFont(new Font("Monotype Corsiva", Font.PLAIN, 17));
			sl_contentPane.putConstraint(SpringLayout.NORTH, btnSi, 166, SpringLayout.NORTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.WEST, btnSi, -129, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnSi, -32, SpringLayout.SOUTH, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnSi, -62, SpringLayout.EAST, contentPane);
			contentPane.add(btnSi);
			
			JButton btnNo = new JButton("No");
			btnNo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnNo.setFont(new Font("Monotype Corsiva", Font.PLAIN, 16));
			sl_contentPane.putConstraint(SpringLayout.WEST, btnNo, -313, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.EAST, btnNo, -241, SpringLayout.EAST, contentPane);
			sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNo, -32, SpringLayout.SOUTH, contentPane);
			contentPane.add(btnNo);
		}


}
