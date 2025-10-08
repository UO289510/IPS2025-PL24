package giis.demo.tkrun.verIncidencias;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;

import giis.demo.ui.verIncidencias.VentanaVerIncidencias;
import giis.demo.util.SwingUtil;

public class VerIncidencias_Controller {

	/*
	 * MIRAR CADA CUANTO MIRO LA TABLA, NECESITO TODOS LOS VALORES PARA METERLOS EN
	 * EL DETALLADO
	 * 
	 * VER COMO GUARDAR LAS CONSULTAS, SI EN TXT O EN TABLA EN DB
	 * 
	 * HACER LA APERTURA DEL HISTORIAL DE CONSULTAS
	 * 
	 * HACER EL FILTRO FUNCIONAL
	 * 
	 * CHECKEAR SI EL QUE ENTRA ES DIRECTIVO, SINO NO DEJAR ENTRAR
	 */

	private VerIncidencias_Model model;
	private VentanaVerIncidencias view;

	public VerIncidencias_Controller(VerIncidencias_Model verIncidencias_Model,
			VentanaVerIncidencias ventanaVerIncidencias) {
		this.model = verIncidencias_Model;
		this.view = ventanaVerIncidencias;

		this.initView();
	}

	public void initView() {
		this.getListaIncidencias();

		view.setVisible(true);
	}

	private void getListaIncidencias() {
		List<IncidenciaDTO> incidencias = model.getListaIncidencias();
		TableModel tmodel = SwingUtil.getTableModelFromPojos(incidencias,
				new String[] { "id", "tipo", "localizacion", "fecha_registro", "fecha_observacion" });
		view.getTablaIncidencias().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaIncidencias());
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
		String id = view.getTablaIncidencias().getValueAt(fila, 0).toString();
		String tipo = view.getTablaIncidencias().getValueAt(fila, 1).toString();
		String localizacion = view.getTablaIncidencias().getValueAt(fila, 2).toString();
		String descripcion = view.getTablaIncidencias().getValueAt(fila, 3).toString();
		String fechaRegistro = view.getTablaIncidencias().getValueAt(fila, 4).toString();
		String fechaObservacion = view.getTablaIncidencias().getValueAt(fila, 5).toString();
		String usuarioDNI = view.getTablaIncidencias().getValueAt(fila, 6).toString();

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
		String apellido = "POR_HACER";
		LocalTime horaActual = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);

		// mirar donde guardarlo
	}

}
