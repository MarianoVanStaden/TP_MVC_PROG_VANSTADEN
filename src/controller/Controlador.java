package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import model.Producto;


public class Controlador {
	
	private static ArrayList<Producto> productos = new ArrayList<>();
	private static ArrayList<String> categorias = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	
    public static void crearProducto() {
    	try {
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
        catch (Exception e) {
        	System.out.println("Ha ingresado un tipo de dato incorrecto, reinicie el programa");
        }
    }

    public static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n**Lista de todos los productos**");
        for (Producto producto : productos) {
            System.out.println("Id: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio()+ ", Categoría: " + producto.getCategoria());
        }
    }
    

    public static void mostrarProductosPorCategoria() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n**Lista de productos por categoría**");

        Map<String, List<Producto>> productosPorCategoria = new HashMap<>();
        for (Producto producto : productos) {
            String categoria = producto.getCategoria();
            List<Producto> listaProductosCategoria = productosPorCategoria.getOrDefault(categoria, new ArrayList<>());
            listaProductosCategoria.add(producto);
            productosPorCategoria.put(categoria, listaProductosCategoria);
        }

        for (Map.Entry<String, List<Producto>> entry : productosPorCategoria.entrySet()) {
            String categoria = entry.getKey();
            List<Producto> productosCategoria = entry.getValue();

            System.out.println("\nProductos de categoría " + categoria + ":");
            for (Producto producto : productosCategoria) {
                System.out.println("Id: " + producto.getId() + ", Nombre: " + producto.getNombre() + ", Precio: " + producto.getPrecio());
            }
        }
    }



    public static void actualizarProducto() {
    	try {
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
        catch (Exception e) {
        	System.out.println("Ha ingresado un tipo de dato incorrecto, reinicie el programa");
        }
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
    	try {
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
        catch (Exception e) {
        	System.out.println("Ha ingresado un tipo de dato incorrecto, reinicie el programa");
        }

    }

	public static void cargarLotePrueba() {
        Producto primero = new Producto("001", "pala", 200, "Herramientas");
        Producto segundo = new Producto("002", "motor", 3000, "Maquinas");
        Producto tercero = new Producto("003", "pico", 100, "Herramientas");
        Producto cuarto = new Producto("004", "rotopercutor", 1500, "Maquinas");
        Producto quinto = new Producto("005", "Perforadora eléctrica", 500, "Maquinas");
        Producto sexto = new Producto("006", "Disco de corte", 50, "Repuestos");
        productos.add(primero);
        productos.add(segundo);
        productos.add(tercero);
        productos.add(cuarto);
        productos.add(quinto);
        productos.add(sexto);
        System.out.println("Lote de pruebas cargado correctamente");
        System.out.println();
		
	}
}
