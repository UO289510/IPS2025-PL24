package giis.demo.tkrun.verIncidencias;

import java.util.List;

import giis.demo.util.Database;

public class VerIncidencias_Model {

	private Database db = new Database();

	public static final String SQL_LISTA_INCIDENCIAS = "SELECT * FROM Incidencia";
	public static final String SQL_LISTA_CONSULTAS = "SELECT * FROM ConsultaIncidencia";
	public static final String SQL_INSERT_CONSULTA = "INSERT INTO ConsultaIncidencia(id_incidencia,id_directivo,nombre_directivo,apellido_directivo,fecha_consulta) VALUES (?,?,?,?,?)";

	public List<IncidenciaDTO> getListaIncidencias() {
		return db.executeQueryPojo(IncidenciaDTO.class, SQL_LISTA_INCIDENCIAS);
	}

	public List<ConsultaIncidenciaDTO> getListaConsultas() {
		return db.executeQueryPojo(ConsultaIncidenciaDTO.class, SQL_LISTA_CONSULTAS);
	}

	public void insertConsultaIncidencia(String idIncidencia, String dni, String nombre, String apellidos,
			String horaActual) {
		db.executeUpdate(SQL_INSERT_CONSULTA, idIncidencia, dni, nombre, apellidos, horaActual);
	}

}
