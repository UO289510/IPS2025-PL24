package giis.demo.ui;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaTutor extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNombreTutor;
	private JLabel lblApellidosTutor;
	private JLabel lblDNITutor;
	private JLabel lblContactoTutor;
	private JTextField txNombreTutor;
	private JTextField txApellidosTutor;
	private JTextField txDNITutor;
	private JTextField txContactoTutor;
	private JButton btnGuardarTutor;
	private JButton btnCancelarTutor;

	public VentanaTutor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTutor.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Datos tutor legal");
		setBounds(100, 100, 323, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblNombreTutor());
		contentPane.add(getLblApellidosTutor());
		contentPane.add(getLblDNITutor());
		contentPane.add(getLblContactoTutor());
		contentPane.add(getTxNombreTutor());
		contentPane.add(getTxApellidosTutor());
		contentPane.add(getTxDNITutor());
		contentPane.add(getTextField_2());
		contentPane.add(getBtnGuardarTutor());
		contentPane.add(getBtnCancelarTutor());
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	private JLabel getLblNombreTutor() {
		if (lblNombreTutor == null) {
			lblNombreTutor = new JLabel("Nombre tutor:");
			lblNombreTutor.setLabelFor(getTxNombreTutor());
			lblNombreTutor.setDisplayedMnemonic('n');
			lblNombreTutor.setBounds(10, 22, 92, 13);
		}
		return lblNombreTutor;
	}
	private JLabel getLblApellidosTutor() {
		if (lblApellidosTutor == null) {
			lblApellidosTutor = new JLabel("Apellidos tutor:");
			lblApellidosTutor.setLabelFor(getTxApellidosTutor());
			lblApellidosTutor.setDisplayedMnemonic('a');
			lblApellidosTutor.setBounds(10, 52, 92, 8);
		}
		return lblApellidosTutor;
	}
	private JLabel getLblDNITutor() {
		if (lblDNITutor == null) {
			lblDNITutor = new JLabel("DNI tutor:");
			lblDNITutor.setLabelFor(getTxDNITutor());
			lblDNITutor.setDisplayedMnemonic('d');
			lblDNITutor.setBounds(10, 80, 92, 12);
		}
		return lblDNITutor;
	}
	private JLabel getLblContactoTutor() {
		if (lblContactoTutor == null) {
			lblContactoTutor = new JLabel("Contacto tutor:");
			lblContactoTutor.setLabelFor(getTextField_2());
			lblContactoTutor.setDisplayedMnemonic('o');
			lblContactoTutor.setBounds(10, 110, 92, 12);
		}
		return lblContactoTutor;
	}
	private JTextField getTxNombreTutor() {
		if (txNombreTutor == null) {
			txNombreTutor = new JTextField();
			txNombreTutor.setBounds(112, 19, 96, 18);
			txNombreTutor.setColumns(10);
		}
		return txNombreTutor;
	}
	private JTextField getTxApellidosTutor() {
		if (txApellidosTutor == null) {
			txApellidosTutor = new JTextField();
			txApellidosTutor.setBounds(112, 47, 168, 18);
			txApellidosTutor.setColumns(10);
		}
		return txApellidosTutor;
	}
	private JTextField getTxDNITutor() {
		if (txDNITutor == null) {
			txDNITutor = new JTextField();
			txDNITutor.setBounds(112, 77, 96, 18);
			txDNITutor.setColumns(10);
		}
		return txDNITutor;
	}
	private JTextField getTextField_2() {
		if (txContactoTutor == null) {
			txContactoTutor = new JTextField();
			txContactoTutor.setBounds(112, 107, 96, 18);
			txContactoTutor.setColumns(10);
		}
		return txContactoTutor;
	}
	private JButton getBtnGuardarTutor() {
		if (btnGuardarTutor == null) {
			btnGuardarTutor = new JButton("Guardar");
			btnGuardarTutor.setBounds(127, 158, 84, 20);
		}
		return btnGuardarTutor;
	}
	private JButton getBtnCancelarTutor() {
		if (btnCancelarTutor == null) {
			btnCancelarTutor = new JButton("Cancelar");
			btnCancelarTutor.setBounds(221, 158, 84, 20);
		}
		return btnCancelarTutor;
	}
}
