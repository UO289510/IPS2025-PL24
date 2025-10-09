package giis.demo.tkrun.verIncidencias;

public class ConsultaIncidenciaDTO {

	private int id;
	private int id_incidencia;
	private int id_directivo;
	private String nombre_directivo;
	private String apellido_directivo;
	private String fecha_consulta;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public int getId_directivo() {
		return id_directivo;
	}

	public void setId_directivo(int id_directivo) {
		this.id_directivo = id_directivo;
	}

	public String getNombre_directivo() {
		return nombre_directivo;
	}

	public void setNombre_directivo(String nombre_directivo) {
		this.nombre_directivo = nombre_directivo;
	}

	public String getApellido_directivo() {
		return apellido_directivo;
	}

	public void setApellido_directivo(String apellido_directivo) {
		this.apellido_directivo = apellido_directivo;
	}

	public String getFecha_consulta() {
		return fecha_consulta;
	}

	public void setFecha_consulta(String fecha_consulta) {
		this.fecha_consulta = fecha_consulta;
	}

	@Override
	public String toString() {
		return getFecha_consulta().toString() + ": " + getNombre_directivo() + " " + getApellido_directivo() + " ("
				+ getId_directivo() + ") reviso la incidencia con id: " + getId_incidencia();
	}

}
