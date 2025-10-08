package giis.demo.ui.federar;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class VentanaRecibos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnFiltros;
	private JLabel lblFechaDesde;
	private JTextField txFechaDesde;
	private JLabel lblFechaHasta;
	private JTextField txFechaHasta;
	private JLabel lblEstado;
	private JComboBox cbEstado;
	private JLabel lblCantidad;
	private JTextField txCantidadDesde;
	private JLabel lblA;
	private JTextField txCantidadHasta;
	private JLabel lblEuros;
	private JTextArea txDejarVacio;
	private JButton btnAplicarFiltro;
	private JButton btnCancelar;
	private JPanel pnDetallesRecibo;
	private JTable table;
	private JButton btnVerDetallesRecibo;

	public VentanaRecibos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRecibos.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Mis recibos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 356, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPnFiltros());
		contentPane.add(getPnDetallesRecibo());

	}
	private JPanel getPnFiltros() {
		if (pnFiltros == null) {
			pnFiltros = new JPanel();
			pnFiltros.setBorder(new TitledBorder(null, "Filtros", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnFiltros.setBounds(10, 22, 323, 231);
			pnFiltros.setLayout(null);
			pnFiltros.add(getLblFechaDesde());
			pnFiltros.add(getTxFechaDesde());
			pnFiltros.add(getLblFechaHasta());
			pnFiltros.add(getTxFechaHasta());
			pnFiltros.add(getLblEstado());
			pnFiltros.add(getCbEstado());
			pnFiltros.add(getLblCantidad());
			pnFiltros.add(getTxCantidadDesde());
			pnFiltros.add(getLblA());
			pnFiltros.add(getTxCantidadHasta());
			pnFiltros.add(getLblEuros());
			pnFiltros.add(getTxDejarVacio());
			pnFiltros.add(getBtnAplicarFiltro());
			pnFiltros.add(getBtnCancelar());
		}
		return pnFiltros;
	}
	private JLabel getLblFechaDesde() {
		if (lblFechaDesde == null) {
			lblFechaDesde = new JLabel("Fecha desde:");
			lblFechaDesde.setLabelFor(getTxFechaDesde());
			lblFechaDesde.setDisplayedMnemonic('d');
			lblFechaDesde.setBounds(10, 28, 96, 12);
		}
		return lblFechaDesde;
	}
	private JTextField getTxFechaDesde() {
		if (txFechaDesde == null) {
			txFechaDesde = new JTextField();
			txFechaDesde.setBounds(10, 50, 96, 18);
			txFechaDesde.setColumns(10);
		}
		return txFechaDesde;
	}
	private JLabel getLblFechaHasta() {
		if (lblFechaHasta == null) {
			lblFechaHasta = new JLabel("Fecha hasta:");
			lblFechaHasta.setLabelFor(getTxFechaHasta());
			lblFechaHasta.setDisplayedMnemonic('h');
			lblFechaHasta.setBounds(158, 28, 96, 12);
		}
		return lblFechaHasta;
	}
	private JTextField getTxFechaHasta() {
		if (txFechaHasta == null) {
			txFechaHasta = new JTextField();
			txFechaHasta.setBounds(158, 50, 96, 18);
			txFechaHasta.setColumns(10);
		}
		return txFechaHasta;
	}
	private JLabel getLblEstado() {
		if (lblEstado == null) {
			lblEstado = new JLabel("Estado:");
			lblEstado.setLabelFor(getCbEstado());
			lblEstado.setDisplayedMnemonic('e');
			lblEstado.setBounds(10, 95, 96, 12);
		}
		return lblEstado;
	}
	private JComboBox getCbEstado() {
		if (cbEstado == null) {
			cbEstado = new JComboBox();
			cbEstado.setBounds(10, 116, 96, 20);
		}
		return cbEstado;
	}
	private JLabel getLblCantidad() {
		if (lblCantidad == null) {
			lblCantidad = new JLabel("Cantidad:");
			lblCantidad.setLabelFor(getTxCantidadDesde());
			lblCantidad.setDisplayedMnemonic('c');
			lblCantidad.setBounds(158, 95, 96, 12);
		}
		return lblCantidad;
	}
	private JTextField getTxCantidadDesde() {
		if (txCantidadDesde == null) {
			txCantidadDesde = new JTextField();
			txCantidadDesde.setBounds(158, 117, 31, 18);
			txCantidadDesde.setColumns(10);
		}
		return txCantidadDesde;
	}
	private JLabel getLblA() {
		if (lblA == null) {
			lblA = new JLabel("a");
			lblA.setBounds(195, 120, 15, 12);
		}
		return lblA;
	}
	private JTextField getTxCantidadHasta() {
		if (txCantidadHasta == null) {
			txCantidadHasta = new JTextField();
			txCantidadHasta.setColumns(10);
			txCantidadHasta.setBounds(205, 117, 31, 18);
		}
		return txCantidadHasta;
	}
	private JLabel getLblEuros() {
		if (lblEuros == null) {
			lblEuros = new JLabel("€");
			lblEuros.setBounds(245, 118, 21, 16);
		}
		return lblEuros;
	}
	private JTextArea getTxDejarVacio() {
		if (txDejarVacio == null) {
			txDejarVacio = new JTextArea();
			txDejarVacio.setForeground(Color.BLUE);
			txDejarVacio.setFont(new Font("Tahoma", Font.PLAIN, 10));
			txDejarVacio.setText("Dejar el segundo campo vacío si solo se desea exacto");
			txDejarVacio.setWrapStyleWord(true);
			txDejarVacio.setLineWrap(true);
			txDejarVacio.setBounds(158, 145, 155, 29);
		}
		return txDejarVacio;
	}
	private JButton getBtnAplicarFiltro() {
		if (btnAplicarFiltro == null) {
			btnAplicarFiltro = new JButton("Aplicar filtro");
			btnAplicarFiltro.setMnemonic('a');
			btnAplicarFiltro.setBounds(114, 195, 96, 20);
		}
		return btnAplicarFiltro;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setMnemonic('c');
			btnCancelar.setBounds(217, 195, 96, 20);
		}
		return btnCancelar;
	}
	private JPanel getPnDetallesRecibo() {
		if (pnDetallesRecibo == null) {
			pnDetallesRecibo = new JPanel();
			pnDetallesRecibo.setBounds(10, 270, 322, 138);
			pnDetallesRecibo.setLayout(null);
			pnDetallesRecibo.add(getTable());
			pnDetallesRecibo.add(getBtnVerDetallesRecibo());
		}
		return pnDetallesRecibo;
	}
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBounds(10, 10, 302, 88);
		}
		return table;
	}
	private JButton getBtnVerDetallesRecibo() {
		if (btnVerDetallesRecibo == null) {
			btnVerDetallesRecibo = new JButton("Ver detalles recibo");
			btnVerDetallesRecibo.setBounds(193, 108, 119, 20);
		}
		return btnVerDetallesRecibo;
	}
}
