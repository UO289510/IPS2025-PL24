package giis.demo.ui.verIncidencias;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import giis.demo.ui.federar.VentanaTutor;
import net.miginfocom.swing.MigLayout;

public class VentanaVerIncidencias extends JDialog {

	String[] columnas = { "ID", "Tipo", "Localización", "Descripción", "Fecha Registro" };
	DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelSuperior;
	private JPanel panelInferior;
	private JLabel lblBuscar;
	private JTextField txtFieldBuscador;
	private JButton btnBuscar;
	private JButton btnFiltrar;
	private JButton btnVolver;
	private JButton btnHistorial;
	private JPanel panelMedio;
	private JScrollPane scrollIncidencias;
	private JTable tablaIncidencias;
	private JPanel panelDetalle;
	private JLabel lblID;
	private JLabel lblTipo;
	private JLabel lblLocalizacion;
	private JLabel lblFechaRegistro;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblDescripcion;
	private JTextField textFieldId;
	private JTextField textFieldTipo;
	private JTextField textFieldLocalizacion;
	private JTextField textFieldRegistro;
	private JTextField textFieldObservacion;
	private JTextField textFieldUser;
	private JTextArea textAreaDescripcion;

	/**
	 * Create the dialog.
	 */
	public VentanaVerIncidencias() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaTutor.class.getResource("/img/EII.jpeg")));
		setTitle("Club deportivo EII: Datos tutor legal");
		setSize(700, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelSuperior());
		contentPane.add(getPanelInferior());
		contentPane.add(getPanelMedio());
		contentPane.add(getPanelDetalle());
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

	private JPanel getPanelMedio() {
		if (panelMedio == null) {
			panelMedio = new JPanel();
			panelMedio.setBounds(0, 37, 686, 194);
			panelMedio.setLayout(new BorderLayout(0, 0));
			panelMedio.add(getScrollIncidencias(), BorderLayout.CENTER);
		}
		return panelMedio;
	}

	private JScrollPane getScrollIncidencias() {
		if (scrollIncidencias == null) {
			scrollIncidencias = new JScrollPane();
			scrollIncidencias.setViewportView(getTablaIncidencias());
		}
		return scrollIncidencias;
	}

	public JTable getTablaIncidencias() {
		if (tablaIncidencias == null) {
			tablaIncidencias = new JTable();
			tablaIncidencias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return tablaIncidencias;
	}

	private JPanel getPanelDetalle() {
		if (panelDetalle == null) {
			panelDetalle = new JPanel();
			panelDetalle.setBounds(10, 241, 666, 175);
			panelDetalle.setLayout(
					new MigLayout("", "[146.00px][283.00px][316.00px][297.00px]", "[18px][18px][18px][89.00px,grow]"));
			panelDetalle.add(getLblID(), "cell 0 0,alignx right,aligny center");
			panelDetalle.add(getLblTipo(), "cell 2 0,alignx right,aligny center");
			panelDetalle.add(getTextFieldTipo(), "cell 3 0,growx,aligny center");
			panelDetalle.add(getLblLocalizacion(), "cell 0 1,alignx right,aligny center");
			panelDetalle.add(getLblNewLabel_1(), "cell 2 1,alignx right,aligny center");
			panelDetalle.add(getTextFieldUser(), "cell 3 1,growx,aligny center");
			panelDetalle.add(getLblFechaRegistro(), "cell 0 2,alignx right,aligny center");
			panelDetalle.add(getTextFieldId(), "cell 1 0,growx,aligny center");
			panelDetalle.add(getTextFieldLocalizacion(), "cell 1 1,growx,aligny center");
			panelDetalle.add(getTextFieldRegistro(), "cell 1 2,growx,aligny center");
			panelDetalle.add(getLblNewLabel(), "cell 2 2,alignx right,aligny center");
			panelDetalle.add(getTextFieldObservacion(), "cell 3 2,growx,aligny center");
			panelDetalle.add(getLblDescripcion(), "cell 0 3,alignx right,aligny top");
			panelDetalle.add(getTextAreaDescripcion(), "cell 1 3 3 1,grow");
		}
		return panelDetalle;
	}

	private JLabel getLblID() {
		if (lblID == null) {
			lblID = new JLabel("ID:");
			lblID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblID;
	}

	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblTipo;
	}

	private JLabel getLblLocalizacion() {
		if (lblLocalizacion == null) {
			lblLocalizacion = new JLabel("Localización: ");
			lblLocalizacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblLocalizacion;
	}

	private JLabel getLblFechaRegistro() {
		if (lblFechaRegistro == null) {
			lblFechaRegistro = new JLabel("Fecha de registro: ");
			lblFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblFechaRegistro;
	}

	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Fecha de la observación:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Usuario que reporto incidencia:");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblNewLabel_1;
	}

	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Descripción: ");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblDescripcion;
	}

	public JTextField getTextFieldId() {
		if (textFieldId == null) {
			textFieldId = new JTextField();
			textFieldId.setEnabled(false);
			textFieldId.setEditable(false);
			textFieldId.setColumns(10);
		}
		return textFieldId;
	}

	public JTextField getTextFieldTipo() {
		if (textFieldTipo == null) {
			textFieldTipo = new JTextField();
			textFieldTipo.setEnabled(false);
			textFieldTipo.setEditable(false);
			textFieldTipo.setColumns(10);
		}
		return textFieldTipo;
	}

	public JTextField getTextFieldLocalizacion() {
		if (textFieldLocalizacion == null) {
			textFieldLocalizacion = new JTextField();
			textFieldLocalizacion.setEnabled(false);
			textFieldLocalizacion.setEditable(false);
			textFieldLocalizacion.setColumns(10);
		}
		return textFieldLocalizacion;
	}

	public JTextField getTextFieldRegistro() {
		if (textFieldRegistro == null) {
			textFieldRegistro = new JTextField();
			textFieldRegistro.setEnabled(false);
			textFieldRegistro.setEditable(false);
			textFieldRegistro.setColumns(10);
		}
		return textFieldRegistro;
	}

	public JTextField getTextFieldObservacion() {
		if (textFieldObservacion == null) {
			textFieldObservacion = new JTextField();
			textFieldObservacion.setEnabled(false);
			textFieldObservacion.setEditable(false);
			textFieldObservacion.setColumns(10);
		}
		return textFieldObservacion;
	}

	public JTextField getTextFieldUser() {
		if (textFieldUser == null) {
			textFieldUser = new JTextField();
			textFieldUser.setEnabled(false);
			textFieldUser.setEditable(false);
			textFieldUser.setColumns(10);
		}
		return textFieldUser;
	}

	public JTextArea getTextAreaDescripcion() {
		if (textAreaDescripcion == null) {
			textAreaDescripcion = new JTextArea();
			textAreaDescripcion.setBackground(new Color(240, 240, 240));
			textAreaDescripcion.setEnabled(false);
			textAreaDescripcion.setEditable(false);
		}
		return textAreaDescripcion;
	}
}
