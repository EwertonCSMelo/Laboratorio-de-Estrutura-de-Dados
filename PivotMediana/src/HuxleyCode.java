import java.util.Scanner;

public class HuxleyCode {	

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String rowValues = null;
		int[] vetor = null;
		int[] vetor2 = null;		
		int temp = 0;
		double inf = Double.POSITIVE_INFINITY;
        int r = 0;
		rowValues = input.nextLine();

		String[] elementArray = rowValues.split(" ");

		vetor = new int[elementArray.length];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = Integer.parseInt(elementArray[i]);
		}

		int maior = -1 * (int) inf;
		int menor = (int) inf;
		int ind_menor = 0;
		int ind_maior = 0;
		int m = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] < menor) {
				menor = vetor[i];
				ind_menor = i;
			}

			if (vetor[i] > maior) {
				maior = vetor[i];
				ind_maior = i;
			}

		}

		vetor2 = new int[vetor.length];
		
		m = (vetor[ind_menor] + vetor[ind_maior]) / 2;

		menor = (int) inf;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] != m) {
				int dif = Math.abs(vetor[i] - m);
				if (dif < menor) {
					menor = dif;
					temp = vetor[i];
					r = i;
				}
			}
		}

		System.out.println(vetor[r]);

		int j = 0;

		for (int i = 0; i < vetor.length; i++) {
			if (vetor[i] < temp) {
				vetor2[j] = vetor[i];
				j++;
			}
		}
		
		
			vetor2[j] = temp;
			j++;
		

		while (j < vetor.length - 1) {
			for (int i = 0; i < vetor.length; i++) {
				if (vetor[i] > temp && vetor[i] != vetor2[i]) {
					vetor2[j] = vetor[i];
					j++;
				}
			}
		}
		
		for (int i = 0; i < vetor.length; i++) {
			System.out.printf("%d ", vetor2[i]);
		}

		input.close();

	}

}
