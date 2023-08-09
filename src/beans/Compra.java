package beans;

public class Compra {

	private String nombre;
	private String precio;
	private String cantidad;

	public Compra(String nombre, String precio2, String cantidad2) {
		this.nombre = nombre;
		this.precio = precio2;
		this.cantidad = cantidad2;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Nombre=" + nombre + ", Precio=" + precio + ", Cantidad=" + cantidad;
	}

}
