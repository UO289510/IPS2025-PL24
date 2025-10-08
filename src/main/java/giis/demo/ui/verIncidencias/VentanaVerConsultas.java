package giis.demo.ui.verIncidencias;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import giis.demo.ui.federar.VentanaTutor;

public class VentanaVerConsultas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	String[] columnas = { "ID", "Tipo", "Localización", "Descripción", "Fecha Registro" };
	DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	private JPanel panel;
	private JList list;
	private JLabel lblConsultas;

	/**
	 * Create the dialog.
	 */
	public VentanaVerConsultas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTutor.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Datos tutor legal");
		setBounds(100, 100, 355, 236);
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
			panel.setBounds(10, 36, 321, 153);
			panel.add(getList());
		}
		return panel;
	}

	private JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}

	private JLabel getLblConsultas() {
		if (lblConsultas == null) {
			lblConsultas = new JLabel("Historial de Consultas:");
			lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblConsultas.setBounds(10, 10, 321, 16);
		}
		return lblConsultas;
	}
}
