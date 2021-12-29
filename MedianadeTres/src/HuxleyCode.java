
import java.util.*;

public class HuxleyCode {

	public static void quicksortMedianaDeTres(int[] A) {
		quicksortMedianaDeTres(A, 0, A.length - 1);
	}

	private static void quicksortMedianaDeTres(int[] A, int inicio, int fim) {
		if (inicio < fim) {
			// realiza a parti��o
			int q = partition(A, inicio, fim);
			// ordena a parti��o esquerda
			quicksortMedianaDeTres(A, inicio, q - 1);
			// ordena a parti��o direita
			quicksortMedianaDeTres(A, q + 1, fim);
		}
	}

	// M�todo de parti��o
	private static int partition(int[] A, int inicio, int fim) {
		// procura a mediana entre inicio, meio e fim
		int meio = (inicio + fim) / 2;
		int a = A[inicio];
		int b = A[meio];
		int c = A[fim];
		int medianaIndice; // �ndice da mediana
		// A sequ�ncia de if...else a seguir verifica qual � a mediana
		if (a < b) {
			if (b < c) {
				// a < b && b < c
				medianaIndice = meio;
			} else {
				if (a < c) {
					// a < c && c <= b
					medianaIndice = fim;
				} else {
					// c <= a && a < b
					medianaIndice = inicio;
				}
			}
		} else {
			if (c < b) {
				// c < b && b <= a
				medianaIndice = meio;
			} else {
				if (c < a) {
					// b <= c && c < a
					medianaIndice = fim;
				} else {
					// b <= a && a <= c
					medianaIndice = inicio;
				}
			}
		}
		// coloca o elemento da mediana no fim para poder usar o Quicksort de Cormen
		swap(A, medianaIndice, fim);

		// *******************ALGORITMO DE PARTI��O DE CORMEN*********************
		// o pivo � o elemento final
		int pivo = A[fim];
		int i = inicio - 1;
		/*
		 * Este la�o ir� varrer os vetores da esquerda para direira procurando os
		 * elementos que s�o menores ou iguais ao piv�. Esses elementos s�o colocados na
		 * parti��o esquerda.
		 */
		for (int j = inicio; j <= fim - 1; j++) {
			if (A[j] <= pivo) {
				i = i + 1;
				swap(A, i, j);
			}
		}
		// coloca o piv� na posi��o de ordena��o
		swap(A, i + 1, fim);
		return i + 1; // retorna a posi��o do piv�
	}

	// m�todo auxiliar para realizar as trocas de elementos
	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}



	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String rowValues = null;
		int numLinhas = 2;
		int[] vetor = null;
		int[] vetor2 = null;
		int medianaIndice;
		int temp;

		rowValues = input.nextLine();

		String[] elementArray = rowValues.split(" ");

		vetor = new int[elementArray.length];

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = Integer.parseInt(elementArray[i]);
		}

		medianaIndice = partition(vetor, 0, vetor.length - 1);
		System.out.printf("%d \n", vetor[medianaIndice]);

		vetor2 = new int[vetor.length];

		temp = vetor[medianaIndice];
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