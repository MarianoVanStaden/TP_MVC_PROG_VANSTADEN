package model;

public class Producto {
private String id;
private String nombre;
private double precio;

public Producto(String id2, String nombre, double precio) {
	super();
	this.id = id2;
	this.nombre = nombre;
	this.precio = precio;
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public double getPrecio() {
	return precio;
}
public void setPrecio(double precio) {
	this.precio = precio;
}

}