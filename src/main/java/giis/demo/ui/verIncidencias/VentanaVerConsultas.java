package giis.demo.ui.verIncidencias;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import giis.demo.ui.federar.VentanaTutor;

public class VentanaVerConsultas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	String[] columnas = { "ID", "Tipo", "Localización", "Descripción", "Fecha Registro" };
	DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	private JPanel panel;
	private JList listConsultas;
	private JLabel lblConsultas;
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public VentanaVerConsultas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTutor.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Datos tutor legal");
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblConsultas());
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(10, 36, 566, 267);
			panel.setLayout(null);
			panel.add(getScrollPane());
		}
		return panel;
	}

	public JList<String> getListConsultas() {
		if (listConsultas == null) {
			listConsultas = new JList<String>();
		}
		return listConsultas;
	}

	private JLabel getLblConsultas() {
		if (lblConsultas == null) {
			lblConsultas = new JLabel("Historial de Consultas:");
			lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConsultas.setBounds(10, 10, 321, 16);
		}
		return lblConsultas;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 566, 267);
			scrollPane.setViewportView(getListConsultas());
		}
		return scrollPane;
	}
}
