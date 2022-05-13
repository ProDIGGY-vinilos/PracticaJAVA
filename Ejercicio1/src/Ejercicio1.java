
public class Ejercicio1 {
	

	public static void main(String[] args) 
	{
		
		//Ejercicio 1
		// Mostrar por consola los 10 primeros números enteros y los 10 primeros números impares
		
		System.out.println("Primeros 10 numeros enteros");
		 for(int i=0; i<10; i++) 
		{
		System.out.print(i+1 +", ");			
		}
		System.out.println("");
		System.out.println("Primeros 10 numeros impares");
		 for(int i=1; i<20; i=i+2) 
		{
			System.out.print(i +", ");
		}
	}

}
