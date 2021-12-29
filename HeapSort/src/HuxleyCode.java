import java.io.*;
import java.util.*;

public class HuxleyCode {

	// Programa principal
	public static void main(String[] args) {
		try (Scanner input = new Scanner(System.in)) {
			String rowValues = null;

			rowValues = input.nextLine();
			String[] elementArray = rowValues.split(" ");

			int[] rowQuantity = new int[elementArray.length];

			for (int i = 0; i < elementArray.length; i++) {
				rowQuantity[i] = Integer.parseInt(elementArray[i]);
			}

			sort(rowQuantity);
			System.out.print("Resultado Final:");
			printArray(rowQuantity, 0);
		}
	}

	public static void sort(int arr[]) {
		int n = arr.length;
		// int reduz = 0;
		System.out.print("Estado inicial:");
		printArray(arr, 0);
		System.out.println();

		// Constrói o heap (rearranja o vetor)
		// Constrói o heap (rearranja o vetor)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
			System.out.printf("Estado Atual:");
			printArray(arr, 0);
			System.out.println();
		}
	}
	// Para heapify uma subarvore com no i que é
	// um indice no arr[]. n é o tamanho do heap

	static void heapify(int arr[], int n, int i) {
		int parent = i; // Inicializa parent como raiz
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// Se o filho esquerdo e maior que a raiz
		if (l < n && arr[l] > arr[parent])
			parent = l;

		// Se o filho da direita e maior que o pai
		if (r < n && arr[r] > arr[parent])
			parent = r;

		// Se o pai não e raiz
		if (parent != i) {
			int swap = arr[i];
			arr[i] = arr[parent];
			arr[parent] = swap;
			// Recursivamente hapify a sub-arvore afetada
			heapify(arr, n, parent);
		}
	}

	/* Uma funcao utilitaria para exibir o vetor de tamanho n */
	static void printArray(int arr[], int reduz) {
		int n = arr.length - reduz;
		// System.out.println("reduz: " + reduz);
		for (int i = 0; i < n; ++i) {
			if (i != n - 1) {
				System.out.printf(" %d |", arr[i]);
			} else {
				System.out.printf(" %d", arr[i]);
			}
		}
	}

}
