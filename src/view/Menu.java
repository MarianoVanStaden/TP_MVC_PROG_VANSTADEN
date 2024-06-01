package view;

import java.util.Scanner;

public class Menu {
	public static void menuInicial() {
    try {


        int opcion;
        try (Scanner scanner = new Scanner(System.in)) {
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
			        	break;
			        case 0:
			            System.out.println("Saliendo del sistema...");
			            break;
			        default:
			            System.out.println("Opción no válida.");
			            System.out.println("Intente nuevamente.");
			    }
			} while (opcion != 0);
		}
    }
    catch (Exception e) {
    	System.out.println("Ha ingresado un tipo de dato incorrecto, reinicie el programa");
    }
	}
    

    private static void mostrarMenu() {
    	System.out.println();
        System.out.println("\033[1m" + "Sistema de gestión de productos" + "\033[1m");
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
