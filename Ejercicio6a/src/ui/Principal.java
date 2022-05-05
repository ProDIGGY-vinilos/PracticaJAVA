package ui;
import java.io.Console;
import java.sql.*;
import java.util.Scanner;



public class Principal {

	public static void main(String[] args) {
		
		int opc;
		do {					
		opc = menu();
		
		switch (opc) {
		case 1: //LISTAR			
			
			break;
		case 2: //BUSCAR					
			
			break;
		case 3: //NUEVO
			
			break;
		case 4: //BORRAR
			
			break;
		case 5: //ACTUALIZAR
			
			break;
		case 6: //SALIR
			System.out.println("CERRANDO...");
			
			System.exit(0);

		default:
			System.out.println("Elija una opcion valida");			
			System.out.println("Volviendo al menu...");
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {		
				e.printStackTrace();
			}
			System.out.print("\033[H\033[2J");
	        System.out.flush();
			
			
			break;
		}
		} while (opc != 6);

	}

	private static int menu() {
		int opc;
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese la opcion que desee: ");
		System.out.println("1- Listar");
		System.out.println("2- Buscar");
		System.out.println("3- Nuevo");
		System.out.println("4- Borrar");
		System.out.println("5- Acualizar");
		opc = lector.nextInt();
		lector.close();
		return opc;
	}

}

