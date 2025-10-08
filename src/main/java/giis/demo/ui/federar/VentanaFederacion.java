package giis.demo.ui.federar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaFederacion extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnDatosPersonales;
	private JLabel lblNombreSocio;
	private JLabel lblApellidosSocio;
	private JLabel lblFechaNacimientoSocio;
	private JLabel lblDNISocio;
	private JTextField txNombreSocio;
	private JTextField txApellidosSocio;
	private JTextField txFechaNacimientoSocio;
	private JTextField txDNISocio;
	private JPanel pnDeporte;
	private JLabel lblDeporte;
	private JComboBox cbDeportes;
	private JLabel lbLicenciaValida;
	private JCheckBox chckbxAceptoCesionDatos;
	private JPanel panel;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JPanel pnDeportesFederados;
	private JTable table;
	private JLabel lblDeportesFederados;
	private JLabel lblMenorDeEdad;
	
	public VentanaFederacion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaFederacion.class.getResource("/img/EII.jpeg")));
		setTitle("Club Deportivo EII: Licencia para federación en un deporte");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 356, 455);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPnDeportesFederados());
		setLocationRelativeTo(null);
	}
	
	private JPanel getPnDatosPersonales() {
		if (pnDatosPersonales == null) {
			pnDatosPersonales = new JPanel();
			pnDatosPersonales.setBounds(18, 20, 321, 135);
			pnDatosPersonales.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnDatosPersonales.setLayout(null);
			pnDatosPersonales.add(getLblNombreSocio());
			pnDatosPersonales.add(getLblApellidosSocio());
			pnDatosPersonales.add(getLblFechaNacimientoSocio());
			pnDatosPersonales.add(getLblDNISocio());
			pnDatosPersonales.add(getTxNombreSocio());
			pnDatosPersonales.add(getTxApellidosSocio());
			pnDatosPersonales.add(getTxFechaNacimientoSocio());
			pnDatosPersonales.add(getTxDNISocio());
			pnDatosPersonales.add(getLblMenorDeEdad());
		}
		return pnDatosPersonales;
	}
	private JLabel getLblNombreSocio() {
		if (lblNombreSocio == null) {
			lblNombreSocio = new JLabel("Nombre:");
			lblNombreSocio.setDisplayedMnemonic('n');
			lblNombreSocio.setLabelFor(getTxNombreSocio());
			lblNombreSocio.setBounds(10, 28, 69, 13);
		}
		return lblNombreSocio;
	}
	private JLabel getLblApellidosSocio() {
		if (lblApellidosSocio == null) {
			lblApellidosSocio = new JLabel("Apellidos:");
			lblApellidosSocio.setLabelFor(lblApellidosSocio);
			lblApellidosSocio.setDisplayedMnemonic('a');
			lblApellidosSocio.setBounds(10, 54, 69, 12);
		}
		return lblApellidosSocio;
	}
	private JLabel getLblFechaNacimientoSocio() {
		if (lblFechaNacimientoSocio == null) {
			lblFechaNacimientoSocio = new JLabel("Fecha de nacimiento:");
			lblFechaNacimientoSocio.setLabelFor(getTxFechaNacimientoSocio());
			lblFechaNacimientoSocio.setDisplayedMnemonic('f');
			lblFechaNacimientoSocio.setBounds(10, 80, 114, 13);
		}
		return lblFechaNacimientoSocio;
	}
	private JLabel getLblDNISocio() {
		if (lblDNISocio == null) {
			lblDNISocio = new JLabel("DNI:");
			lblDNISocio.setLabelFor(getTxDNISocio());
			lblDNISocio.setDisplayedMnemonic('d');
			lblDNISocio.setBounds(10, 106, 44, 12);
		}
		return lblDNISocio;
	}
	private JTextField getTxNombreSocio() {
		if (txNombreSocio == null) {
			txNombreSocio = new JTextField();
			txNombreSocio.setBounds(82, 25, 96, 18);
			txNombreSocio.setColumns(10);
		}
		return txNombreSocio;
	}
	private JTextField getTxApellidosSocio() {
		if (txApellidosSocio == null) {
			txApellidosSocio = new JTextField();
			txApellidosSocio.setBounds(82, 51, 188, 18);
			txApellidosSocio.setColumns(10);
		}
		return txApellidosSocio;
	}
	private JTextField getTxFechaNacimientoSocio() {
		if (txFechaNacimientoSocio == null) {
			txFechaNacimientoSocio = new JTextField();
			txFechaNacimientoSocio.setBounds(134, 77, 96, 18);
			txFechaNacimientoSocio.setColumns(10);
		}
		return txFechaNacimientoSocio;
	}
	private JTextField getTxDNISocio() {
		if (txDNISocio == null) {
			txDNISocio = new JTextField();
			txDNISocio.setBounds(57, 103, 96, 18);
			txDNISocio.setColumns(10);
		}
		return txDNISocio;
	}
	private JPanel getPnDeporte() {
		if (pnDeporte == null) {
			pnDeporte = new JPanel();
			pnDeporte.setBounds(18, 169, 321, 66);
			pnDeporte.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnDeporte.setLayout(null);
			pnDeporte.add(getLblDeporte());
			pnDeporte.add(getCbDeportes());
			pnDeporte.add(getLbLicenciaValida());
		}
		return pnDeporte;
	}
	private JLabel getLblDeporte() {
		if (lblDeporte == null) {
			lblDeporte = new JLabel("Selección de deporte:");
			lblDeporte.setBounds(10, 14, 123, 12);
		}
		return lblDeporte;
	}
	private JComboBox getCbDeportes() {
		if (cbDeportes == null) {
			cbDeportes = new JComboBox();
			cbDeportes.setBounds(143, 10, 96, 20);
		}
		return cbDeportes;
	}
	private JLabel getLbLicenciaValida() {
		if (lbLicenciaValida == null) {
			lbLicenciaValida = new JLabel("Licencia válida hasta: ");
			lbLicenciaValida.setBounds(10, 41, 229, 12);
		}
		return lbLicenciaValida;
	}
	private JCheckBox getChckbxAceptoCesionDatos() {
		if (chckbxAceptoCesionDatos == null) {
			chckbxAceptoCesionDatos = new JCheckBox("Acepto la cesión de mis datos al club");
			chckbxAceptoCesionDatos.setBounds(18, 251, 281, 20);
		}
		return chckbxAceptoCesionDatos;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel.setBounds(20, 22, 349, 324);
			panel.setLayout(null);
			panel.add(getPnDatosPersonales());
			panel.add(getPnDeporte());
			panel.add(getChckbxAceptoCesionDatos());
			panel.add(getBtnGuardar());
			panel.add(getBtnCancelar());
		}
		return panel;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.setMnemonic('g');
			btnGuardar.setBounds(164, 294, 84, 20);
		}
		return btnGuardar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('c');
			btnCancelar.setBounds(255, 294, 84, 20);
		}
		return btnCancelar;
	}
	private JPanel getPnDeportesFederados() {
		if (pnDeportesFederados == null) {
			pnDeportesFederados = new JPanel();
			pnDeportesFederados.setBorder(new LineBorder(new Color(0, 0, 0)));
			pnDeportesFederados.setBounds(20, 356, 349, 155);
			pnDeportesFederados.setLayout(null);
			pnDeportesFederados.add(getTable());
			pnDeportesFederados.add(getLblDeportesFederados());
		}
		return pnDeportesFederados;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(10, 32, 329, 113);
		}
		return table;
	}
	private JLabel getLblDeportesFederados() {
		if (lblDeportesFederados == null) {
			lblDeportesFederados = new JLabel("Deportes en los que estoy federado:");
			lblDeportesFederados.setBounds(10, 10, 311, 12);
		}
		return lblDeportesFederados;
	}
	private JLabel getLblMenorDeEdad() {
		if (lblMenorDeEdad == null) {
			lblMenorDeEdad = new JLabel("");
			lblMenorDeEdad.setForeground(Color.RED);
			lblMenorDeEdad.setBounds(240, 80, 53, 12);
		}
		return lblMenorDeEdad;
	}
}
