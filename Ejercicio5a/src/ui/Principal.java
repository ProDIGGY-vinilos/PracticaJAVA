package ui;
import java.util.Scanner;
import Entidades.*;

public class Principal {

	public static void main(String[] args) {
		
		Empleado[] emp = new Empleado[20];
		String  _nom, _ap, _email, key, op;
		int _dni , _totalVentas, i = 0 ;
		double _sueldoBase, _horasExtra, _horasMes;
		float _porcenComision;
		
		System.out.println("Desea ingresar un empleado? s/n");
		Scanner lector = new Scanner(System.in);
		op = lector.nextLine();		
		
		while ((op.equalsIgnoreCase("s")) && (i <= 20)) {
			System.out.print("Ingrese nombre: "); 		_nom = lector.nextLine();
			System.out.print("Ingrese apellido: "); 	_ap = lector.nextLine();
			System.out.print("Ingrese dni: "); 			_dni = Integer.parseInt(lector.nextLine());
			System.out.print("Ingrese email: ");    	_email = lector.nextLine();
			System.out.print("Ingrese sueldo base: ");  _sueldoBase = Double.parseDouble(lector.nextLine());
			System.out.println("Es Administrativo (a) o Vendedor(v)? ");
			
			key = lector.nextLine().toLowerCase();
			switch (key) {
			case "v": {			
				System.out.print("Ingrese total de ventas: "); _totalVentas = Integer.parseInt(lector.nextLine());	
				System.out.print("Ingrese porcentaje de comision: "); _porcenComision = Float.parseFloat(lector.nextLine());
				Vendedor ven = new Vendedor(_totalVentas, _porcenComision, _nom, _ap, _email, _dni, _sueldoBase);
				emp[i] = ven;
				i++;	
				break;
			}
			
			case "a": {
				System.out.print("Ingrese horas extra: "); _horasExtra = Double.parseDouble(lector.nextLine());	
				System.out.print("Ingrese horas del mes: "); _horasMes = Double.parseDouble(lector.nextLine());
				Administrativo adm = new Administrativo(_horasExtra, _horasMes, _nom, _ap, _email, _dni, _sueldoBase);
				emp[i] = adm;
				i++;	
				break;
			}
			default:
				System.out.println("Ingrese una opcion valida, reintentando...");
				break;
			}
			key ="";
			
			System.out.println("Desea ingresar un nuevo empleado? s/n");
			op = lector.nextLine();		
			
		}
			
		lector.close();
		
		System.out.println("El sueldo de cada empleado es de: ");
		
		for (int j = 0; j < i; j++) {
			System.out.println("empleado: "+emp[j].getNombre()+" tiene un sueldo de: $"+emp[j].getSueldo());
			
		}
	}

}
