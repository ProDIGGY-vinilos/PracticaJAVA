import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		//Ejercicio 3
		// Leer 10 palabras, luego leer una nueva palabra e indicar si la misma ya había sido ingresada en las 10 primeras.
		
		String[] palabras = new String[10];
		String palabra = new String();				
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese 10 palabras");
		for (int i = 0; i < palabras.length; i++) 
		{
			palabras[i] = lector.nextLine();						
		}		
		System.out.println("Ingrese una palabra para buscar");
		palabra = lector.nextLine();
		lector.close();
		int cont = 0;
		for (String pal : palabras) 
		{
			if (palabra.equalsIgnoreCase(pal)) 
			{
				cont++;
			}			
		}
		System.out.println("La palabra '"+palabra+"' se encontro en el arreglo 'palabras': "+cont+" veces");
		
		
				
	}

}
