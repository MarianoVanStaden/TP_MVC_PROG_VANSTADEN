package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Producto;




public class Controlador {
	
	public static ArrayList<Producto> productos = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

    public static void crearProducto() {
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 

        productos.add(new Producto(id, nombre, precio));
        System.out.println("Producto creado correctamente.");
    }

    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n**Lista de productos**");
        for (Producto producto : productos) {
            System.out.println("Id: " + producto.getId() + " Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio());
        }
    }

    public static void actualizarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.print("Ingrese el nombre del producto a actualizar: ");
        String nombreABuscar = scanner.nextLine();

        Producto productoEncontrado = buscarProducto(nombreABuscar);
        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.print("Ingrese el nuevo nombre del producto: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio del producto: ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine(); 

        productoEncontrado.setNombre(nuevoNombre);
        productoEncontrado.setPrecio(nuevoPrecio);
        System.out.println("Producto actualizado correctamente.");
    	}

    public static Producto buscarProducto(String nombreABuscar) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreABuscar)) {
                return producto;
            }
        }
        return null;
    }

    public static void eliminarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }
        System.out.print("Ingrese el nombre del producto a eliminar: ");
        String nombreABuscar = scanner.nextLine();

        Producto productoEncontrado = buscarProducto(nombreABuscar);
        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado.");
            return;
        }
        for (int i= 0; i<productos.size(); i++) {
        	if (productos.get(i).getNombre().equals(nombreABuscar)) {
        		productos.remove(i);
        		break;
        	}
        }
        System.out.println("Producto " + nombreABuscar + " eliminado");

    }
}
