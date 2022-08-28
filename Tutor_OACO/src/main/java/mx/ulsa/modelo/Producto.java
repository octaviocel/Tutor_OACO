package mx.ulsa.modelo;

public class Producto {

	private Integer id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private String imagen;
	private Integer numExistentes;
	private String codigoBarra;
	private Integer iva;

	public Producto() {

	}

	public Producto(Integer id, String nombre, String descripcion, Double precio, String imagen, Integer numExistentes,
			String codigoBarra, Integer iva) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.imagen = imagen;
		this.numExistentes = numExistentes;
		this.codigoBarra = codigoBarra;
		this.iva = iva;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Integer getNumExistentes() {
		return numExistentes;
	}

	public void setNumExistentes(Integer numExistentes) {
		this.numExistentes = numExistentes;
	}

	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Integer getIva() {
		return iva;
	}

	public void setIva(Integer iva) {
		this.iva = iva;
	}

}
