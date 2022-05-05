import java.util.Scanner;

public class Ejercicio4 {
	
	public static void main(String[] args) {
		
		//Ejercicio 4
		// Leer un entero y luego una lista de 20 enteros. Guardar los mayores al número inicial y mostrarlos al final. Usar arrays, no otras colecciones.
		
		int[] nums = new int[20];
		int nro;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un numero cualquiera: ");
		nro = Integer.parseInt(scanner.nextLine());
		System.out.println("A continuacion ingrese 20 numeros");
		int j = 0;
		 for (int i = 0; i < nums.length; i++)
		{
			int h = Integer.parseInt(scanner.nextLine());
			if ( h >= nro ) {
				nums[j] = h;
				j++;
			}
		}
		 
		 
		 System.out.println("Estos son los numeros ingresados mayores al inicial : '"+nro+"'");
		 for (int i = 0; i < j; i++) {
			 System.out.print(nums[i]+"; ");
		}
		 System.out.println("/");
		 
		 scanner.close();
		
		
	}
}
