

import java.util.Scanner;

public class Inversorpalabras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palabra = "";
		String palabrainvertida = "";
		int longitudpalabra = 0;
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escriba la palabra o frase: ");
		palabra = entrada.nextLine();

		longitudpalabra = palabra.length();
		StringBuilder concat = new StringBuilder();

		while (longitudpalabra != 0) {
			// palabrainvertida += palabra.substring(longitudpalabra-1,longitudpalabra);
			concat.append(palabra.substring(longitudpalabra - 1, longitudpalabra));
			longitudpalabra--;
		}
		palabrainvertida = concat.toString();
		System.out.println("La Palabra Invertida es: " + palabrainvertida);
		entrada.close();
	}

}
