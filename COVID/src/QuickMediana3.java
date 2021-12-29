import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickMediana3 {

	public static void QuickCasos(String path, int numLinhas) throws IOException {

		String[] cidade = new String[numLinhas];
		int[] numCasos = new int[numLinhas];
		int[] numObitos = new int[numLinhas];
		String[] vCidade = new String[numLinhas];
		int[] vNumCasos = new int[numLinhas];
		int[] vNumObitos = new int[numLinhas];
		long tempoInicial;
		long tempoFinal;

		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String linha = "";
		String[] elementArray;
		String pathOut = "";
		int i = 0;

		while (linha != null) {
			linha = buffRead.readLine();
			try {
				if (i < numLinhas) {
					elementArray = linha.split(",");
					cidade[i] = elementArray[0];
					numCasos[i] = Integer.parseInt(elementArray[1]);
					numObitos[i] = Integer.parseInt(elementArray[2]);
				}
			} catch (NullPointerException nexc) {
				System.out.println("Dados Armazenados!");
			}
			i++;
		}
		buffRead.close();

		// Aplicando ClickSort Mediana de 3 em casos de COVID
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		quickSort(cidade, vNumCasos, numObitos, 0, numCasos.length - 1);
		tempoFinal = System.nanoTime();
		System.out.printf("Insert Quicksort Mediana3 Casos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); 
		
		String path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\m3Sort_ordena_casos.csv";	    
		System.out.println("Número de casos ordenados pelo método Mediana3Sort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}


		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		quickSort(vCidade, vNumObitos, vNumCasos, 0, numObitos.length - 1);
		tempoFinal = System.nanoTime();
		System.out.printf("Insert Quicksort Mediana3 Obitos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando
																													// o
																													// tempo
																													// gasto
		pathOut = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\m3Sort_ordena_obitos.csv";
		File file = new File(pathOut);
		if (file.isFile()) { // Deletando arquivo antigo
			file.delete();
		}

		for (int k = 0; k < numCasos.length; k++) {
			ManipuladorArquivo.criadorDeArquivos(pathOut, cidade[k], numCasos[k], numObitos[k]);
		}

		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		quickSortStr(vCidade, vNumObitos, vNumCasos, 0, numObitos.length - 1);
		tempoFinal = System.nanoTime();
		System.out.printf("Insert Quicksort Mediana3 Cidades: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); 
		
		
		pathOut = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\m3Sort_ordena_cidades.csv";
		file = new File(pathOut);

		if (file.isFile()) { // Deletando arquivo antigo
			file.delete();
		}

		for (int k = 0; k < numCasos.length; k++) {
			ManipuladorArquivo.criadorDeArquivos(pathOut, vCidade[k], vNumCasos[k], vNumObitos[k]);
		}

	}

	public static void quickSort(String[] v0, int[] v1, int[] v2, int a, int b) {

		if (a < b) {
			int q = particiona(v0, v1, v2, a, b);
			quickSort(v0, v1, v2, a, q - 1);
			quickSort(v0, v1, v2, q + 1, b);
		}
	}

	public static int particiona(String[] v0, int[] v1, int[] v2, int p, int r) {
		// procura a mediana entre inicio, meio e fim
		int meio = (p + r) / 2;
		int a = v1[p];
		int b = v1[meio];
		int c = v1[r];
		int medianaIndice; // índice da mediana
		// A sequência de if...else a seguir verifica qual é a mediana
		if (a < b) {
			if (b < c) {
				// a < b && b < c
				medianaIndice = meio;
			} else {
				if (a < c) {
					// a < c && c <= b
					medianaIndice = r;
				} else {
					// c <= a && a < b
					medianaIndice = p;
				}
			}
		} else {
			if (c < b) {
				// c < b && b <= a
				medianaIndice = meio;
			} else {
				if (c < a) {
					// b <= c && c < a
					medianaIndice = p;
				} else {
					// b <= a && a <= c
					medianaIndice = r;
				}
			}
		}
		// coloca o elemento da mediana no fim para poder usar o Quicksort de Cormen
		// procura a mediana entre inicio, meio e fim
		swapStr(v0, medianaIndice, p);
		swap(v1, medianaIndice, p);
		swap(v2, medianaIndice, p);

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

	// método auxiliar para realizar as trocas de elementos

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	// Troca Strings
	private static void swapStr(String[] A, int i, int j) {
		String temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static void quickSortStr(String[] v0, int[] v1, int[] v2, int a, int b) {

		if (a < b) {
			int q = particionaStr(v0, v1, v2, a, b);
			quickSortStr(v0, v1, v2, a, q - 1);
			quickSortStr(v0, v1, v2, q + 1, b);
		}
	}

	public static int particionaStr(String[] v0, int[] v1, int[] v2, int p, int r) {
		// procura a mediana entre inicio, meio e fim
		int meio = (p + r) / 2;
		String a = v0[p];
		String b = v0[meio];
		String c = v0[r];
		int medianaIndice; // índice da mediana
		// A sequência de if...else a seguir verifica qual é a mediana
		if (a.compareToIgnoreCase(b) < 0) {
			if (b.compareToIgnoreCase(c) < 0) {
				// a < b && b < c
				medianaIndice = meio;
			} else {
				if (a.compareToIgnoreCase(c) < 0) {
					// a < c && c <= b
					medianaIndice = r;
				} else {
					// c <= a && a < b
					medianaIndice = p;
				}
			}
		} else {
			if (c.compareToIgnoreCase(b) < 0) {
				// c < b && b <= a
				medianaIndice = meio;
			} else {
				if (c.compareToIgnoreCase(a) < 0) {
					// b <= c && c < a
					medianaIndice = p;
				} else {
					// b <= a && a <= c
					medianaIndice = r;
				}
			}
		}
		// coloca o elemento da mediana no fim para poder usar o Quicksort de Cormen
		// procura a mediana entre inicio, meio e fim
		swapStr(v0, medianaIndice, p);
		swap(v1, medianaIndice, p);
		swap(v2, medianaIndice, p);
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