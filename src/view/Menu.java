package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Producto;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;


        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    controller.Controlador.crearProducto();
                    break;
                case 2:
                	controller.Controlador.mostrarProductos();
                    break;
                case 3:
                	controller.Controlador.mostrarProductosPorCategoria();
                    break;
                case 4:
                	controller.Controlador.actualizarProducto();
                    break;
                case 5:
                	controller.Controlador.eliminarProducto();
                    break;
                case 9:
                	controller.Controlador.cargarLotePrueba();
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
        System.out.println("2. Mostrar todos los productos");
        System.out.println("3. Mostrar los productos por categoría");
        System.out.println("4. Actualizar producto");
        System.out.println("5. Eliminar producto");
        System.out.println("9. Cargar lote de prueba");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }


    }
