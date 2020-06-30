package ufv.dis.pareja;

import java.util.ArrayList;

import ufv.dis.pareja.Producto;

public class Inventario {

private ArrayList <Producto> productos;
	
	public Inventario() {
		
		this.productos = new ArrayList<Producto>();
		
	}
	
	public void addProducto(Producto p) {
		this.productos.add(p);
	}
	
	public void removeProducto (Producto p) {
		this.productos.remove(p);
	}
	
	public boolean checkIfExists (Producto p) {
		return this.productos.contains(p); 
	}
	
	public int getListSize() { //metodo para saber el tamaño de la lista (test comprueba si se ha añadido)
		return productos.size();
	}
	
}
