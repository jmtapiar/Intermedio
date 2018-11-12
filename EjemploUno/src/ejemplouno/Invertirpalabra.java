package ejemplouno;



public class Invertirpalabra {
	
	
	public String invertirPalabra(String frase) {
		String palabra = "";
		String palabrainvertida = "";
		int longitudpalabra = 0;
		palabra=frase;
		longitudpalabra = palabra.length();
		StringBuilder concat = new StringBuilder();

		while (longitudpalabra != 0) {
			// 
			concat.append(palabra.substring(longitudpalabra - 1, longitudpalabra));
			longitudpalabra--;
		}
		palabrainvertida = concat.toString();
		
		return palabrainvertida;
	}
	
	
}
