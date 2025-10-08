package giis.demo.tkrun.verIncidencias;

public class IncidenciaDTO {

	private int id;
	private String tipo;
	private String localizacion;
	private String descripcion;
	private String fecha_registro;
	private String fecha_observacion;
	private String usuario_DNI;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuario_DNI() {
		return usuario_DNI;
	}

	public void setUsuario_DNI(String usuario_DNI) {
		this.usuario_DNI = usuario_DNI;
	}

	public String getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(String fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public String getFecha_observacion() {
		return fecha_observacion;
	}

	public void setFecha_observacion(String fecha_observacion) {
		this.fecha_observacion = fecha_observacion;
	}

}
