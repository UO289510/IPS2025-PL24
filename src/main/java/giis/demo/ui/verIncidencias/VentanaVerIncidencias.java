package giis.demo.ui.verIncidencias;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import giis.demo.ui.VentanaTutor;

public class VentanaVerIncidencias extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSuperior;
	private JScrollPane scrllBusquedas;
	private JPanel panelInferior;
	private JLabel lblBuscar;
	private JTextField txtFieldBuscador;
	private JButton btnBuscar;
	private JButton btnFiltrar;
	private JTable table;

	String[] columnas = { "ID", "Tipo", "Localización", "Descripción", "Fecha Registro" };
	DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
	private JButton btnVolver;
	private JButton btnHistorial;

	/**
	 * Create the dialog.
	 */
	public VentanaVerIncidencias() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTutor.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Datos tutor legal");
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelSuperior());
		contentPane.add(getScrllBusquedas());
		contentPane.add(getPanelInferior());
	}

	private JPanel getPanelSuperior() {
		if (panelSuperior == null) {
			panelSuperior = new JPanel();
			panelSuperior.setBounds(0, 0, 686, 37);
			FlowLayout fl_panelSuperior = new FlowLayout(FlowLayout.CENTER, 10, 8);
			panelSuperior.setLayout(fl_panelSuperior);
			panelSuperior.add(getLblBuscar());
			panelSuperior.add(getTxtFieldBuscador());
			panelSuperior.add(getBtnBuscar());
			panelSuperior.add(getBtnFiltrar());
		}
		return panelSuperior;
	}

	private JScrollPane getScrllBusquedas() {
		if (scrllBusquedas == null) {
			scrllBusquedas = new JScrollPane();
			scrllBusquedas.setBounds(0, 37, 686, 391);
			scrllBusquedas.setViewportView(getTable());
		}
		return scrllBusquedas;
	}

	private JPanel getPanelInferior() {
		if (panelInferior == null) {
			panelInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelInferior.getLayout();
			flowLayout.setVgap(8);
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelInferior.setBounds(0, 426, 686, 37);
			panelInferior.add(getBtnHistorial());
			panelInferior.add(getBtnVolver());
		}
		return panelInferior;
	}

	private JLabel getLblBuscar() {
		if (lblBuscar == null) {
			lblBuscar = new JLabel("Buscar por ID");
			lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblBuscar;
	}

	private JTextField getTxtFieldBuscador() {
		if (txtFieldBuscador == null) {
			txtFieldBuscador = new JTextField();
			txtFieldBuscador.setFont(new Font("Tahoma", Font.PLAIN, 12));
			txtFieldBuscador.setColumns(40);
		}
		return txtFieldBuscador;
	}

	private JButton getBtnBuscar() {
		if (btnBuscar == null) {
			btnBuscar = new JButton("Buscar");
		}
		return btnBuscar;
	}

	private JButton getBtnFiltrar() {
		if (btnFiltrar == null) {
			btnFiltrar = new JButton("Filtrar");
			btnFiltrar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new VentanaFiltrarIncidencias().setVisible(true);
				}
			});
		}
		return btnFiltrar;
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable(modelo);
		}
		return table;
	}

	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
		}
		return btnVolver;
	}

	private JButton getBtnHistorial() {
		if (btnHistorial == null) {
			btnHistorial = new JButton("Ver Historial de Busqueda");
		}
		return btnHistorial;
	}
}
