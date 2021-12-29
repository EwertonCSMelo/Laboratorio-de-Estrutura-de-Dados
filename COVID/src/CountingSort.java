class CountingSort {
	public static void countSort(String[] v0, int[] v1, int[] v2, int size) {
		String[] v0Output = new String[size + 1];
		int[] v1Output = new int[size + 1];
		int[] v2Output = new int[size + 1];

		// Encontrando o maior elemento do vetor
		int max = v1[0];
		for (int i = 1; i < size; i++) {
			if (v1[i] > max)
				max = v1[i];
		}
		int[] count = new int[max + 1];

		// Inicializa a contagem com zero dos vetores
		for (int i = 0; i < max; ++i) {
			count[i] = 0;
		}

		// Armazena a contagem de cada elemento
		for (int i = 0; i < size; i++) {
			count[v1[i]]++;
		}

		// Armazena a contagem acumulativa de cada vetor
		for (int i = 1; i <= max; i++) {
			count[i] += count[i - 1];
		}
		
		//Encontra o indice de cada elemento do vetor original no vetor count
		// Coloca os elementos na saída do vetor
		for (int i = size - 1; i >= 0; i--) {
			v0Output[count[v1[i]] - 1] = v0[i];
			v1Output[count[v1[i]] - 1] = v1[i];
			v2Output[count[v1[i]] - 1] = v2[i];

			count[v1[i]]--;
		}

		// Copia os elementos organizado no vetor original
		for (int i = 0; i < size; i++) {
			v0[i] = v0Output[i];
			v1[i] = v1Output[i];
			v2[i] = v2Output[i];
		}
	}

    // Encontra o comprimento mais longo na string[] a.
	public static int findLongestLength(String[] a) {
		int longest = 0;
		for (int i = 0; i < a.length; ++i) {
			if (a[i].length() > longest) {
				longest = a[i].length();
			}
		}
		return longest;
	}

	// se d >= 0 && d < a[i].length(), retorna a[i].charAt(d);
	// else , return 0, que significa o menor valor para ordenar.
	public static int findCharAtInString(int i, int d, String[] a) {
		if (d < 0 || d >= a[i].length()) {
			return 0;
		}
		return a[i].charAt(d);
	}

	// Rearranja o vetor de variáveis String
	public static void sort(String[] v0, int[] v1, int[] v2) {
		int n = v0.length;
		int R = 256; // extended ASCII alphabet size.
		String[] auxV0 = new String[n];
		int[] auxV1 = new int[n];
		int[] auxV2 = new int[n];

		int w = findLongestLength(v0); // w é o comprimento do String mais longo em a.
		for (int d = w - 1; d >= 0; d--) {
			// sort pelo indice key contando sobre o n-ésimo character

			// calcula a frequencia de contagem
			int[] count = new int[R + 1];
			for (int i = 0; i < n; ++i) {
				int c = findCharAtInString(i, d, v0);
				count[c + 1]++;
			}

			// calcula o acumulado
			for (int r = 0; r < R; ++r) {
				count[r + 1] += count[r];
			}

			// move os dados
			for (int i = 0; i < n; ++i) {
				int c = findCharAtInString(i, d, v0);
				int index = count[c];
				auxV0[index] = v0[i];
				auxV1[index] = v1[i];
				auxV2[index] = v2[i];
				count[c]++;
			}

			// cópia de volta
			for (int i = 0; i < n; ++i) {
				v0[i] = auxV0[i];
				v1[i] = auxV1[i];
				v2[i] = auxV2[i];
			}
		}

	}
}
