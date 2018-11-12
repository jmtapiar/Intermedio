package ejemplouno;

import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Prueba Ejecucion");
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba la palabra o frase: ");
		Invertirpalabra inv = new Invertirpalabra();
		inv.invertirPalabra(entrada.nextLine());
		System.out.println("La Palabra Invertida es: " + inv.invertirPalabra(entrada.nextLine()));
		entrada.close();
	}

}
