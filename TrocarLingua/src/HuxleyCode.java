import java.util.*;

public class HuxleyCode {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int i;
		int j = 0;
		int n;
		int valorInicial = 0;
		int tamCiclo =0;

		while (input.hasNext()) {
			
			i = input.nextInt();
			j = input.nextInt();

			if (i < 1 || i > 1000 || j < 1 || j > 1000) {
				break;
			}
			valorInicial = i;
			if (valorInicial > j) {
				n = j;
				j = valorInicial;
				valorInicial = n;
			}

			for (i = valorInicial; i < j; i++) {
				n = i;
				int maior = 0;
				tamCiclo = 0;

				while (n != 1) {
					if (n % 2 == 0) {
						n = n / 2;
					}

					else if (n % 2 != 0) {
						n = n * 3 + 1;
					}

					tamCiclo = tamCiclo + 1;
				}
				tamCiclo = tamCiclo + 1;

				if (maior < tamCiclo) {
					maior = tamCiclo;
				}
				
			}

		}

		System.out.printf("%d %d %d\n", valorInicial, j, tamCiclo);
	}
}