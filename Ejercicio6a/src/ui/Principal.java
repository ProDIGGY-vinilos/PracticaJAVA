package ui;
import java.util.LinkedList;
import java.util.Scanner;

import entidades.ProductLogic;



public class Principal {

	public static void main(String[] args) {
		
		int opc; // problema looop dowhile con scanner
		
		do {					
			opc = menu();					
			switch (opc) {
			case 1: //LISTAR
				listar();				
				break;
			case 2: //BUSCAR
				buscar();	
				
				break;
			case 3: //NUEVO
				nuevo();
				
				break;
			case 4: //BORRAR
				borrar();	
				
				break;
			case 5: //ACTUALIZAR
				actualizar();
				
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

	private static void actualizar() {
		Boolean editar;
		do {
		int _id;
		Scanner lector = new Scanner(System.in);
		System.out.print("Ingrese el id del producto a actualizar: "); _id = Integer.parseInt(lector.nextLine());
		ProductLogic editP = new ProductLogic();
		editP = ProductLogic.getOneLogic(_id);
		System.out.println("Este es el producto que desea actualizar? "+ editP.getName()+" "+editP.getDescription());
		System.out.print("SI(1)/NO(0)"); editar = Boolean.parseBoolean(lector.nextLine());
		System.out.println();
		if (editar) {
			System.out.println("A continuacion ingrese los datos nuevos del producto: ");
			System.out.print("Ingrese nombre nuevo: (nombre anterior: "+editP.getName()+"): "); editP.setName(lector.nextLine());
			System.out.print("Ingrese descripcion nueva: (descripcion anterior: "+editP.getDescription()+"): ");editP.setDescription(lector.nextLine());
			System.out.print("Ingrese precio nuevo: (precio anterior: "+editP.getPrice()+"): "); editP.setPrice(Double.parseDouble(lector.nextLine()));
			System.out.print("Ingrese stock nuevo: (stock anterior: "+editP.getStock()+"): "); editP.setStock(Integer.parseInt(lector.nextLine()));
			System.out.print("Ingrese si incluye envio: (estado anterior: "+editP.isShippingIncluded()+"): "); editP.setShippingIncluded(Boolean.parseBoolean(lector.nextLine()));
			System.out.println();
			System.out.println("Producto actualizado");				
		} 		
		lector.close();
		}while(editar == false);
	}

	private static void borrar() {
		Boolean borrar;
		do {
		int _id;
		Scanner lector = new Scanner(System.in);
		System.out.print("Ingrese el id del producto a eliminar: "); _id = Integer.parseInt(lector.nextLine());
		ProductLogic delP = new ProductLogic();
		delP = ProductLogic.getOneLogic(_id);
		System.out.println("Este es el producto que desea eliminar? "+ delP.getName()+" "+delP.getDescription());
		System.out.print("SI(1)/NO(0)"); borrar = Boolean.parseBoolean(lector.nextLine());
		System.out.println();
		if (borrar) {
			ProductLogic.removeLogic(delP);
			System.out.println("Producto eliminado");				
		} 
		lector.close();
		}while(borrar == false);
	}

	private static void nuevo() {
		ProductLogic newp = new ProductLogic();
		Scanner lector = new Scanner(System.in);
		System.out.println("A continuacion ingrese los datos del producto nuevo: ");
		System.out.print("Ingrese nombre del producto: "); newp.setName(lector.nextLine());
		System.out.print("Ingrese una breve descripcion: "); newp.setDescription(lector.nextLine());
		System.out.print("Ingrese precio: "); newp.setPrice(Double.parseDouble(lector.nextLine()));
		System.out.print("Ingrese stock: "); newp.setStock(Integer.parseInt(lector.nextLine()));
		System.out.print("Ingrese si tiene envio incluido si(1)/no(0): "); newp.setShippingIncluded(Boolean.parseBoolean(lector.nextLine()));
		lector.close();
		ProductLogic.addNewLogic(newp);
	}

	private static void listar() {
		LinkedList<ProductLogic> p = new LinkedList<ProductLogic>();
		p = entidades.ProductLogic.getAllLogic();
		int i = 1;
		for (ProductLogic productLogic : p) {
			System.out.println(i+"ID: "+productLogic.getId()+" Nombre: "+productLogic.getName()+" Precio: "+productLogic.getPrice());
			i++;
		}
	}

	private static void buscar() {
		System.out.println("Ingrese Id a buscar: ");
		Scanner lector = new Scanner(System.in);
		int _id = Integer.parseInt(lector.nextLine());
		lector.close();
		ProductLogic p1 = new ProductLogic();
		p1 = entidades.ProductLogic.getOneLogic(_id);				
		System.out.println("ID: "+p1.getId()+" Nombre: "+p1.getName()+" Precio: "+p1.getPrice());
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
		System.out.println("6- Salir");
		opc = Integer.parseInt(lector.nextLine());
		lector.close();
		return opc;
	}

}

