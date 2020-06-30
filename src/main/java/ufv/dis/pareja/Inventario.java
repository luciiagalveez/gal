package ufv.dis.pareja;

import java.util.ArrayList;

import ufv.dis.pareja.Producto;

public class Inventario {

private ArrayList <Producto> productos;
	
	public Inventario() {
		
		productos = new ArrayList<Producto>();
		
	}
	
	public void addProducto(Producto p) {
		productos.add(p);
	}
	
	public int getListSize() { //metodo para saber el tamaño de la lista (test comprueba si se ha añadido)
		return productos.size();
	}
	
}
