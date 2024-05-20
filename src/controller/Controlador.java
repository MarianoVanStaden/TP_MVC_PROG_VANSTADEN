package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.Producto;




public class Controlador {
	
	private static ArrayList<Producto> productos = new ArrayList<>();
	private static ArrayList<String> categorias = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	
    public static void crearProducto() {
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        
        System.out.print("Ingrese la categoría del producto: ");
        String categoria = scanner.nextLine();
        scanner.nextLine(); 

        productos.add(new Producto(id, nombre, precio, categoria));
        categorias.add(categoria);
        
        
        System.out.println("Producto creado correctamente.");
    }

    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n**Lista de todos los productos**");
        for (Producto producto : productos) {
            System.out.println("Id: " + producto.getId() + " Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio()+ " Categoría: " + producto.getCategoria());
        }
    }
    
    public static void mostrarProductosPorCategoria() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n**Lista de productos por categoría**");
        ArrayList<String> listaCategorias = new ArrayList<>();
        for(int k = 0; k<productos.size(); k++) {
        	listaCategorias.add(listaCategorias.contains(productos.get(k).getCategoria()) ? null : productos.get(k).getCategoria()); //Operador ternario es igual que en JS
        	System.out.println("El tamaño de listaCategorias es: " + listaCategorias.size());
        }
        
        for (int i = 0; i<listaCategorias.size(); i++) {
        	System.out.println("Productos de categoría " + productos.get(i).getCategoria() + ":");
        for (Producto producto : productos) {
        	if (productos.get(i).getCategoria().equals(producto.getCategoria()))
            System.out.println("Id: " + producto.getId() + " Nombre: " + producto.getNombre() + " Precio: " + producto.getPrecio());
        }
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
        
        System.out.print("Ingrese la nueva categoría del producto: ");
        String nuevaCategoria = scanner.nextLine();
        scanner.nextLine(); 

        productoEncontrado.setNombre(nuevoNombre);
        productoEncontrado.setPrecio(nuevoPrecio);
        productoEncontrado.setCategoria(nuevaCategoria);
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

	public static void cargarLotePrueba() {
        Producto primero = new Producto("001", "pala", 200, "herramientas");
        Producto segundo = new Producto("002", "motor", 3000, "maquinas");
        Producto tercero = new Producto("003", "pico", 100, "herramientas");
        Producto cuarto = new Producto("004", "rotopercutor", 1500, "maquinas");
        Producto quinto = new Producto("005", "Perforadora eléctrica", 500, "maquinas");
        productos.add(primero);
        productos.add(segundo);
        productos.add(tercero);
        productos.add(cuarto);
        productos.add(quinto);
		
	}
}
