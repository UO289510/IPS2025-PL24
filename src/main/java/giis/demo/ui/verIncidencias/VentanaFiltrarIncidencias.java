package giis.demo.ui.verIncidencias;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import giis.demo.ui.VentanaTutor;

public class VentanaFiltrarIncidencias extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	String[] columnas = { "ID", "Tipo", "Localización", "Descripción", "Fecha Registro" };
	DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	private JLabel lblTipo;
	private JLabel lblLocalizacion;
	private JLabel lblFechaInicio;
	private JLabel lblFechaFinal;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTextField tfFechaInicio;
	private JTextField tfFechaFinal;
	private JPanel pnInferior;
	private JButton btnResetearFiltro;
	private JButton btnAceptar;

	/**
	 * Create the dialog.
	 */
	public VentanaFiltrarIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTutor.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Datos tutor legal");
		setBounds(100, 100, 355, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblTipo());
		contentPane.add(getLblLocalizacion());
		contentPane.add(getLblFechaInicio());
		contentPane.add(getLblFechaFinal());
		contentPane.add(getComboBox());
		contentPane.add(getComboBox_1());
		contentPane.add(getTfFechaInicio());
		contentPane.add(getTfFechaFinal());
		contentPane.add(getPnInferior());
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipo.setBounds(10, 10, 80, 20);
		}
		return lblTipo;
	}

	private JLabel getLblLocalizacion() {
		if (lblLocalizacion == null) {
			lblLocalizacion = new JLabel("Localización:");
			lblLocalizacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblLocalizacion.setBounds(10, 50, 80, 20);
		}
		return lblLocalizacion;
	}

	private JLabel getLblFechaInicio() {
		if (lblFechaInicio == null) {
			lblFechaInicio = new JLabel("Fecha inicio (dd/mm/yyyy):");
			lblFechaInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaInicio.setBounds(10, 90, 150, 20);
		}
		return lblFechaInicio;
	}

	private JLabel getLblFechaFinal() {
		if (lblFechaFinal == null) {
			lblFechaFinal = new JLabel("Fecha final (dd/mm/yyyy):");
			lblFechaFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblFechaFinal.setBounds(10, 130, 150, 20);
		}
		return lblFechaFinal;
	}

	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setBounds(49, 11, 282, 20);
		}
		return comboBox;
	}

	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(85, 51, 246, 20);
		}
		return comboBox_1;
	}

	private JTextField getTfFechaInicio() {
		if (tfFechaInicio == null) {
			tfFechaInicio = new JTextField();
			tfFechaInicio.setBounds(170, 92, 161, 18);
			tfFechaInicio.setColumns(10);
		}
		return tfFechaInicio;
	}

	private JTextField getTfFechaFinal() {
		if (tfFechaFinal == null) {
			tfFechaFinal = new JTextField();
			tfFechaFinal.setColumns(10);
			tfFechaFinal.setBounds(170, 132, 161, 18);
		}
		return tfFechaFinal;
	}

	private JPanel getPnInferior() {
		if (pnInferior == null) {
			pnInferior = new JPanel();
			pnInferior.setBounds(0, 160, 341, 29);
			pnInferior.add(getBtnResetearFiltro());
			pnInferior.add(getBtnAceptar());
		}
		return pnInferior;
	}

	private JButton getBtnResetearFiltro() {
		if (btnResetearFiltro == null) {
			btnResetearFiltro = new JButton("Por Defecto");
		}
		return btnResetearFiltro;
	}

	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
		}
		return btnAceptar;
	}
}
