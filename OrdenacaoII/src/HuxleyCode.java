import java.util.*;

public class HuxleyCode {

	public static void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			intercala(a, p, q, r);
		}
	}

	public static void intercala(int[] a, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] left = new int[n1];
		int[] right = new int[n2];

		for (int i = 0; i < n1; i++) {
			left[i] = a[p + i];

		}

		for (int j = 0; j < n2; j++) {
			right[j] = a[q + 1 + j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = p;

		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			a[k] = left[i];
			i++;
			k++;
		}

		while (j < n2) {
			a[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String total = input.nextLine();
		String[] quantity = total.split(" ");
		int numLinhas = Integer.parseInt(quantity[0]);

		String rowValues = null;

		while (numLinhas > 0) { // Leitura dos dados
			rowValues = input.nextLine();
			String[] elementArray = rowValues.split(" ");

			int[] rowQuantity = new int[elementArray.length];

			for (int i = 0; i < elementArray.length; i++) {
				rowQuantity[i] = Integer.parseInt(elementArray[i]);
			}

			mergeSort(rowQuantity, 0, rowQuantity.length - 1);

			for (int i = 0; i < rowQuantity.length; i++) {
				System.out.printf("%d ", rowQuantity[i]);
			}

			System.out.println();

			numLinhas--;

		} // Fim da leitura dos dados

		input.close();

	}

}
