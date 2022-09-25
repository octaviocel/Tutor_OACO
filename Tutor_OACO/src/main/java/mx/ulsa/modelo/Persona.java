package mx.ulsa.modelo;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apePaterno")
	private String apePaterno;
	
	@Column(name="apeMaterno")
	private String apeMaterno;
	
	@Column(name="edad")
	private Integer edad;
	
	@Column(name="telefono")
	private String telefono;
	
	@Column(name="rfc")
	private String rfc;
	
	@Column(name="fechaNac")
	private Date fechaNac;

	@Column(name="domicilio")
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
	public Persona(String nombre, String apePaterno, String apeMaterno, Integer edad, String telefono,
			String rfc, Date fechaNac, String domicilio) {
		super();
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
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}
