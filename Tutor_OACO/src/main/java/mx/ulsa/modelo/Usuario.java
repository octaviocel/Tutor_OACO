package mx.ulsa.modelo;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	private Persona persona;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
	private Rol rol;

	@Column(name = "correo")
	private String correo;

	@Column(name = "password")
	private String password;

	@Column(name = "status")
	private Boolean status;

	@Column(name = "fechaRegistro")
	private Date fechaResgitro;

	@Column(name = "fechaVigencia")
	private Date fechaVigencia;

	public Usuario() {
	}

	public Date getFechaResgitro() {
		return fechaResgitro;
	}

	public void setFechaResgitro(Date fechaResgitro) {
		this.fechaResgitro = fechaResgitro;
	}

	public Date getFechaVigencia() {
		return fechaVigencia;
	}

	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}

	public Usuario(Integer id, String correo, String password, Boolean status, Date fechaResgitro, Date fechaVigencia) {
		super();
		this.id = id;
		this.correo = correo;
		this.password = password;
		this.status = status;
		this.fechaResgitro = fechaResgitro;
		this.fechaVigencia = fechaVigencia;
	}

	public Usuario(String correo, String password, Boolean status, Date fechaResgitro, Date fechaVigencia) {
		super();
		this.correo = correo;
		this.password = password;
		this.status = status;
		this.fechaResgitro = fechaResgitro;
		this.fechaVigencia = fechaVigencia;
	}

	public Usuario(Integer id, String correo, String password, Boolean status, Date fechaResgitro, Date fechaVigencia,Persona persona, Rol rol) {
		super();
		this.id = id;
		this.correo = correo;
		this.password = password;
		this.status = status;
		this.fechaResgitro = fechaResgitro;
		this.fechaVigencia = fechaVigencia;
		this.persona =  persona;
		this.rol=rol;
	}
	
	public Usuario(String correo, String password, Boolean status, Date fechaResgitro, Date fechaVigencia,Persona persona, Rol rol) {
		super();
		this.correo = correo;
		this.password = password;
		this.status = status;
		this.fechaResgitro = fechaResgitro;
		this.fechaVigencia = fechaVigencia;
		this.persona =  persona;
		this.rol=rol;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public void setPersona(Persona persona) {
		this.persona=persona;
	}
	
	public Persona getPersona() {
		return persona;
	}
	
	public void setRol(Rol rol) {
		this.rol=rol;
	}
	
	public Rol getRol() {
		return rol;
	}

}
