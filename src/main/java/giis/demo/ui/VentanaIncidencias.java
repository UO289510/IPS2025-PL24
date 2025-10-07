package giis.demo.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class VentanaIncidencias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIncidencias frame = new VentanaIncidencias();
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
	public VentanaIncidencias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel title = new JPanel();
		contentPane.add(title, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("INCIDENCIAS");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 35));
		title.add(lblTitle);
		
		JPanel content = new JPanel();
		contentPane.add(content, BorderLayout.CENTER);
		content.setLayout(null);
		
		JLabel lblTipoIncidencia = new JLabel("Seleccione el tipo de incidencia");
		lblTipoIncidencia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTipoIncidencia.setBounds(85, 59, 286, 37);
		content.add(lblTipoIncidencia);
		
		JComboBox cboxTipoIncidencias = new JComboBox();
		cboxTipoIncidencias.setModel(new DefaultComboBoxModel(new String[] {"Instalaciones", "Plataforma", "Asuntos económicos", "Otros"}));
		lblTipoIncidencia.setLabelFor(cboxTipoIncidencias);
		cboxTipoIncidencias.setBounds(381, 59, 296, 37);
		content.add(cboxTipoIncidencias);
		
		JLabel lblLocation = new JLabel("¿Donde ocurrió la incidencia?");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLocation.setBounds(85, 111, 286, 37);
		content.add(lblLocation);
		
		JTextField txtLocation = new JTextField();
		lblLocation.setLabelFor(txtLocation);
		txtLocation.setBounds(381, 111, 296, 37);
		content.add(txtLocation);
		
		JLabel lblDate = new JLabel("¿Cuando ocurrió la incidencia? (Opcional)");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(22, 168, 374, 37);
		content.add(lblDate);
		
		JDateChooser dcDate = new JDateChooser();
		lblDate.setLabelFor(dcDate);
		dcDate.setBounds(406, 168, 296, 37);
		content.add(dcDate);
		
		JLabel lblPorFavorDescriba = new JLabel("Por favor, describa brevemente el problema:");
		lblPorFavorDescriba.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPorFavorDescriba.setBounds(22, 233, 414, 37);
		content.add(lblPorFavorDescriba);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(22, 268, 708, 196);
		content.add(textArea);
		
		JPanel buttons = new JPanel();
		contentPane.add(buttons, BorderLayout.SOUTH);
		buttons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttons.add(btnCancelar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttons.add(btnEnviar);

	}
}
