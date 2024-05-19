package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Producto;

public class Menu {

    private static ArrayList<Producto> productos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    actualizarProducto();
                    break;
                case 4:
                    eliminarProducto();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
    

    private static void mostrarMenu() {
        System.out.println("\n**Sistema de gestión de productos**");
        System.out.println("1. Crear producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Actualizar producto");
        System.out.println("4. Eliminar producto");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void crearProducto() {
        System.out.print("Ingrese el ID del producto: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        productos.add(new Producto(id, nombre, precio));
        System.out.println("Producto creado correctamente.");
    }

    private static void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        System.out.println("\n**Lista de productos**");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    private static void actualizarProducto() {
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
        scanner.nextLine(); // Consumir el salto de línea

        productoEncontrado.setNombre(nuevoNombre);
        productoEncontrado.setPrecio(nuevoPrecio);
        System.out.println("Producto actualizado correctamente.");
    	}

    private static Producto buscarProducto(String nombreABuscar) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombreABuscar)) {
                return producto;
            }
        }
        return null;
    }

    private static void eliminarProducto() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

    }
    }
