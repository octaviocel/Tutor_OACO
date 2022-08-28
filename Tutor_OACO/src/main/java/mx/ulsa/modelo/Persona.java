package mx.ulsa.modelo;

import java.sql.Date;

public class Persona {
	private Integer id;

	private String nombre;
	
	private String apePaterno;
	
	private String apeMaterno;
	
	private Integer edad;
	
	private String telefono;
	
	private String rfc;
	
	private Date fechaNac;
	
	private String domicilio;
	
	public Persona() {
		
	}

	public Persona(Integer id, String nombre, String apePaterno, String apeMaterno, Integer edad, String telefono,
			String rfc, Date fechaNac, String domicilio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apePaterno = apePaterno;
		this.apeMaterno = apeMaterno;
		this.edad = edad;
		this.telefono = telefono;
		this.rfc = rfc;
		this.fechaNac = fechaNac;
		this.domicilio = domicilio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApePaterno() {
		return apePaterno;
	}

	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}

	public String getApeMaterno() {
		return apeMaterno;
	}

	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	
	
}
