package giis.demo.tkrun.verIncidencias;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import giis.demo.ui.verIncidencias.VentanaVerConsultas;
import giis.demo.ui.verIncidencias.VentanaVerIncidencias;

public class VerIncidencias_Controller {

	/*
	 * 
	 * HACER EL FILTRO FUNCIONAL
	 * 
	 * CHECKEAR SI EL QUE ENTRA ES DIRECTIVO, SINO NO DEJAR ENTRAR
	 * 
	 */

	private VerIncidencias_Model model;
	private VentanaVerIncidencias view;

	private List<IncidenciaDTO> incidencias;
	private List<IncidenciaDTO> incidenciasFiltradas;

	private boolean filtrando = false;

	public VerIncidencias_Controller(VerIncidencias_Model verIncidencias_Model,
			VentanaVerIncidencias ventanaVerIncidencias) {
		this.model = verIncidencias_Model;
		this.view = ventanaVerIncidencias;

		this.incidencias = model.getListaIncidencias();
		this.incidenciasFiltradas = incidencias;

		this.initView();
	}

	public VentanaVerIncidencias getVentanaVerIncidencias() {
		return view;
	}

	public void initView() {
		this.showListaIncidencias();
	}

	private void showListaIncidencias() {
		List<IncidenciaDTO> incidencias = model.getListaIncidencias();

		DefaultTableModel tmodel = new DefaultTableModel(new Object[][] {},
				new String[] { "id", "tipo", "localizacion", "fecha_registro", "fecha_observacion" }) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Rellenar los datos
		for (IncidenciaDTO i : incidencias) {
			tmodel.addRow(new Object[] { i.getId(), i.getTipo(), i.getLocalizacion(), i.getFecha_registro(),
					i.getFecha_observacion() });
		}

		view.getTablaIncidencias().setModel(tmodel);
	}

	public void initController() {
		view.getTablaIncidencias().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionModel seleccion = view.getTablaIncidencias().getSelectionModel();

		seleccion.addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int filaSeleccionada = view.getTablaIncidencias().getSelectedRow();
				if (filaSeleccionada != -1) {
					mostrarDetalle(filaSeleccionada);
				}
			}
		});
	}

	private void mostrarDetalle(int fila) {
		String id = String.valueOf(incidencias.get(fila).getId());
		String tipo = incidencias.get(fila).getTipo();
		String localizacion = incidencias.get(fila).getLocalizacion();
		String descripcion = incidencias.get(fila).getDescripcion();
		String fechaRegistro = incidencias.get(fila).getFecha_registro();
		String fechaObservacion = incidencias.get(fila).getFecha_observacion();
		String usuarioDNI = incidencias.get(fila).getUsuario_DNI();

		// Ejemplo: mostrar en campos JTextField
		view.getTextFieldId().setText(id);
		view.getTextFieldTipo().setText(tipo);
		view.getTextFieldLocalizacion().setText(localizacion);
		view.getTextAreaDescripcion().setText(descripcion);
		view.getTextFieldRegistro().setText(fechaRegistro);
		view.getTextFieldObservacion().setText(fechaObservacion);
		view.getTextFieldUser().setText(usuarioDNI);

		generarHistoriaConsulta(id);
	}

	private void generarHistoriaConsulta(String id) {
		String idIncidencia = id;
		String dni = "POR_HACER";
		String nombre = "POR_HACER";
		String apellidos = "POR_HACER";
		LocalDateTime horaActual = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

		model.insertConsultaIncidencia(idIncidencia, dni, nombre, apellidos,
				horaActual.format(DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm")));
	}

	public void cargarConsultasIncidencias(VentanaVerConsultas ventanaConsultas) {
		List<ConsultaIncidenciaDTO> consultas = model.getListaConsultas();
		DefaultListModel<String> modelo = new DefaultListModel<>();
		ventanaConsultas.getListConsultas().setModel(modelo);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");

		consultas.sort(Comparator.comparing(c -> LocalDateTime.parse(c.getFecha_consulta().toString(), formatter)));

		for (int i = consultas.size() - 1; i >= 0; i--) {
			modelo.addElement(consultas.get(i).toString());
		}
	}

}
