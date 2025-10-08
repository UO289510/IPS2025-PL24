package giis.demo.tkrun.verIncidencias;

import java.util.List;

import giis.demo.util.Database;

public class VerIncidencias_Model {

	private Database db = new Database();

	public static final String SQL_LISTA_INCIDENCIAS = "SELECT * FROM Incidencia";

	public List<IncidenciaDTO> getListaIncidencias() {
		return db.executeQueryPojo(IncidenciaDTO.class, SQL_LISTA_INCIDENCIAS);
	}

}
