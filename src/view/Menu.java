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
                    controller.Controlador.crearProducto();
                    break;
                case 2:
                	controller.Controlador.mostrarProductos();
                    break;
                case 3:
                	controller.Controlador.actualizarProducto();
                    break;
                case 4:
                	controller.Controlador.eliminarProducto();
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


    }
