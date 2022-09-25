package mx.ulsa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre_rol")
	private String nombres;
	
	@Column(name="descripcion")
	private String descripcion;
	
	public 	Rol() {
		
	}
	
	public Rol(Integer id, String nombres, String descripcion) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.descripcion = descripcion;
	}
	
	public Rol( String nombres, String descripcion) {
		super();
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

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombres=" + nombres + ", descripcion=" + descripcion + "]";
	}
		
}
