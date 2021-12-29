package AreadoCirculo;

import java.util.*;

public class AreaDoCirculo {
	
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			int raio;
			double areaDoCirculo;
			
			System.out.print("Digite o valor do raio: ");
			raio = input.nextInt();
			
			areaDoCirculo = Math.PI*raio*raio;
			
			System.out.printf("A área do circulo é: %f", areaDoCirculo);
		}

	}

}
