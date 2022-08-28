package mx.ulsa.modelo;

import java.sql.Date;

public class Usuario {

	private Integer id;
	
	private String correo;
	
	private String password;
	
	private Boolean status;
	
	private Date fechaResgitro;
	
	private Date fechaVigencia;
	
	
	public Usuario() {}

	

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
	
	
}
