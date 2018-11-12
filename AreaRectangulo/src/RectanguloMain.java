import java.util.Scanner;

public class RectanguloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame el valor de la Base: ");
		int base = entrada.nextInt();
		System.out.println("Dame el valor de la altura: ");
		int altura = entrada.nextInt();
		
		Rectangulo mensajero = new Rectangulo(base,altura);
		mensajero.Imprimir();
		
		

	}

}
