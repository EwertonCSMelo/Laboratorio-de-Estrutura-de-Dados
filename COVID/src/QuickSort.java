public class QuickSort {

	public static void quickSort(String[] v0, int[] v1, int[] v2, int a, int b) {
	
		if (a < b) {
			int q = particiona(v0, v1, v2, a, b);
			quickSort(v0, v1, v2, a, q - 1);
			quickSort(v0, v1, v2, q + 1, b);
		}
	}

	public static int particiona(String[] v0, int[] v1, int[] v2, int p, int r) {
		int i = p - 1;
		int x = v1[r];
		int aux;
		String auxStr;

		for (int j = p; j < r; j++) {
			if (v1[j] <= x) { 
				i++;

				auxStr = v0[i];
				v0[i] = v0[j];
				v0[j] = auxStr;

				aux = v1[i];
				v1[i] = v1[j];
				v1[j] = aux;

				aux = v2[i];
				v2[i] = v2[j];
				v2[j] = aux;

			}

		}
		
		auxStr = v0[i + 1];
		v0[i + 1] = v0[r];
		v0[r] = auxStr;

		aux = v1[i + 1];
		v1[i + 1] = v1[r];
		v1[r] = aux;

		aux = v2[i + 1];
		v2[i + 1] = v2[r];
		v2[r] = aux;

		return i + 1;

	}

	public static void quickSortStr(String[] v0, int[] v1, int[] v2, int a, int b) {

		if (a < b) {
			int q = particionaStr(v0, v1, v2, a, b);
			quickSortStr(v0, v1, v2, a, q - 1);
			quickSortStr(v0, v1, v2, q + 1, b);
		}
	}

	public static int particionaStr(String[] v0, int[] v1, int[] v2, int p, int r) {
		int i = p - 1;
		String x = v0[r];

		int aux;
		String auxStr;

		for (int j = p; j < r; j++) {

			if (v0[j].compareToIgnoreCase(x) < 0) { 
				i++;

				auxStr = v0[i];
				v0[i] = v0[j];
				v0[j] = auxStr;

				aux = v1[i];
				v1[i] = v1[j];
				v1[j] = aux;

				aux = v2[i];
				v2[i] = v2[j];
				v2[j] = aux;

			}

		}

		auxStr = v0[i + 1];
		v0[i + 1] = v0[r];
		v0[r] = auxStr;

		aux = v1[i + 1];
		v1[i + 1] = v1[r];
		v1[r] = aux;

		aux = v2[i + 1];
		v2[i + 1] = v2[r];
		v2[r] = aux;

		return i + 1;
	}

}
