package mx.ulsa.modelo;

public class Rol {

	private Integer id;
	
	private String nombres;
	private String descripcion;
	
	public 	Rol() {
		
	}
	
	public Rol(Integer id, String nombres, String descripcion) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.descripcion = descripcion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
