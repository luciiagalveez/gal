package ufv.dis.pareja;

public class Producto {

	String nombre;
	String cat;
	int precio;
	String EAN;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCat() {
		return cat;
	}
	public void setCat(String cat) {
		this.cat = cat;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getEAN() {
		return EAN;
	}
	public void setEAN(String eAN) {
		EAN = eAN;
	}
	public Producto(String nombre, String cat, int precio, String eAN) {
		super();
		this.nombre = nombre;
		this.cat = cat;
		this.precio = precio;
		EAN = eAN;
	}
	
	
	
	
	
}
