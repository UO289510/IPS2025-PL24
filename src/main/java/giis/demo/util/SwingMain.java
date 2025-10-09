package giis.demo.util;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import giis.demo.tkrun.verIncidencias.VerIncidencias_Controller;
import giis.demo.tkrun.verIncidencias.VerIncidencias_Model;
import giis.demo.ui.federar.VentanaFederacion;
import giis.demo.ui.federar.VentanaRecibos;
import giis.demo.ui.federar.VentanaTutor;
import giis.demo.ui.verIncidencias.VentanaVerConsultas;
import giis.demo.ui.verIncidencias.VentanaVerIncidencias;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las
 * pantallas de las aplicaciones de ejemplo y acciones de inicializacion de la
 * base de datos. No sigue MVC pues es solamente temporal para que durante el
 * desarrollo se tenga posibilidad de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // NOSONAR codigo autogenerado
			@Override
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); // NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		VentanaVerIncidencias ventanaVerIncidencias = new VentanaVerIncidencias();
		VentanaVerConsultas ventanaVerConsultas = new VentanaVerConsultas();
		VerIncidencias_Controller incidenciasController = new VerIncidencias_Controller(new VerIncidencias_Model(),
				ventanaVerIncidencias);
		incidenciasController.initController();

		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 400, 300);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		JButton btnEjecutarTkrun = new JButton("Ejecutar giis.demo.tkrun");

		btnEjecutarTkrun.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				// CarrerasController.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);

		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);

		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.addActionListener(new ActionListener() { // NOSONAR codigo autogenerado
			@Override
			public void actionPerformed(ActionEvent e) {
				Database db = new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		JButton btnVentanaFederacion = new JButton("Abrir Ventana Federación");
		btnVentanaFederacion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaFederacion().setVisible(true);
			}
		});
		frame.getContentPane().add(btnVentanaFederacion);

		JButton btnVentanaRecibos = new JButton("Abrir Ventana Recibos");
		btnVentanaRecibos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaRecibos().setVisible(true);
			}
		});
		frame.getContentPane().add(btnVentanaRecibos);

		JButton btnVentanaTutor = new JButton("Abrir Ventana Tutor");
		btnVentanaTutor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaTutor().setVisible(true);
			}
		});
		frame.getContentPane().add(btnVentanaTutor);

		JButton btnVentanaVerIncidencias = new JButton("Abrir Ventana Ver Incidencias");
		btnVentanaVerIncidencias.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				incidenciasController.getVentanaVerIncidencias().setVisible(true);
			}
		});
		frame.getContentPane().add(btnVentanaVerIncidencias);

		JButton btnConsultaIncidencia = new JButton("Ver Historial de consultas de las Incidencias");
		btnConsultaIncidencia.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaVerConsultas ventanaConsultas = new VentanaVerConsultas();
				ventanaConsultas.setVisible(true);
				incidenciasController.cargarConsultasIncidencias(ventanaConsultas);
			}
		});
		frame.getContentPane().add(btnConsultaIncidencia);
	}

	public JFrame getFrame() {
		return this.frame;
	}

}
