
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {

		//Ejercicio 2
		// Leer 10 palabras y mostrarlas en orden inverso al que fueron ingresadas.
		
		String[] palabras = new String[10];
		System.out.println("A continuacion ingrese 10 palabras: ");
		Scanner lector = new Scanner(System.in);
		
		
		for (int i = 0; i < palabras.length; i++) {
			palabras[i] = lector.nextLine();
		}
		
		lector.close();
		System.out.print("Palabras: ");
		for (int i = palabras.length-1; i >= 0; i--) {
			System.out.print(palabras[i]+"; ");			
		}
		System.out.println(" 'Fin' ");
	}

}
