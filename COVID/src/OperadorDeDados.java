import java.io.*;

public class OperadorDeDados {

	public static void dataSort(String path, int numLinhas) throws IOException {

		String[] cidade = new String[numLinhas];
		double auxiliar;
		int[] numCasos = new int[numLinhas];
		int[] numObitos = new int[numLinhas];
		System.out.println("Número de cidades: " + numLinhas);

		// BufferedReader buffRead = new BufferedReader(new InputStreamReader(new
		// FileInputStream(path), "UTF-8"));
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		String linha = "";
		String[] elementArray;

		int i = 0;
		System.out.println("Por favor aguarde...");
		while (i <= numLinhas - 1) {
			linha = buffRead.readLine();
			try {
				elementArray = linha.split(",");

				cidade[i] = elementArray[0];
				auxiliar = Double.parseDouble(elementArray[1]);
				numCasos[i] = (int) auxiliar;
				numObitos[i] = Integer.parseInt(elementArray[2]);
				// System.out.printf("%s %d %d \n", cidade[i], numCasos[i], numObitos[i]);
			} catch (NullPointerException nexc) {
				System.out.println("Dados Armazenados!");
			}

			i++;
		}

		buffRead.close();

		String[] vCidade = new String[numLinhas];
		int[] vNumCasos = new int[numLinhas];
		int[] vNumObitos = new int[numLinhas];

		// Aplicando o método de ordenação QuickSort para o número de casos
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;

		long tempoInicial = System.nanoTime();
		QuickSort.quickSort(vCidade, numCasos, numObitos, 0, numCasos.length - 1);
		long tempoFinal = System.nanoTime();
		System.out.printf("Quick Sort Casos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto
		String path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\qSort_ordena_casos.csv";
		System.out.println("Número de casos ordenados pelo método insertSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		

		// Aplicando o método de ordenação QuickSort para o número de óbitos
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;

		tempoInicial = System.nanoTime();
		QuickSort.quickSort(vCidade, vNumObitos, vNumCasos, 0, numObitos.length - 1);
		tempoFinal = System.nanoTime();
		System.out.printf("Quick Sort Obitos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto
		
		path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\qSort_ordena_obitos.csv";
		System.out.println("Número de casos ordenados pelo método insertSort...");
		
		for (i = numLinhas - 1; i >= 0; i--) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		

		// Aplicando o método de ordenação QuickSort para as localidades
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		QuickSort.quickSortStr(vCidade, vNumCasos, vNumObitos, 0, numCasos.length - 1);
		tempoFinal = System.nanoTime();
		System.out.printf("QuickSort Cidades: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto
	    path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\qSort_ordena_cidades.csv";
		System.out.println("Número de casos ordenados pelo método QuickSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		
		// Aplicando o método CountingSort em Numeros de Casos
		vCidade = cidade;												
		vNumCasos = numCasos;
		vNumObitos = numObitos;

		tempoInicial = System.nanoTime();
		CountingSort.sort(vCidade, vNumCasos, vNumObitos);
		tempoFinal = System.nanoTime();
		System.out.printf("Counting Sort Casos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto
	    path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\cSort_ordena_casos.csv";
	    
		System.out.println("Número de casos ordenados pelo método CountingSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		
		
		// Aplicando o método CountingSort em Numeros de Óbitos
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		CountingSort.countSort(vCidade, vNumObitos, vNumCasos, numObitos.length);
		tempoFinal = System.nanoTime();
		System.out.printf("CountingSort Óbitos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto
		
	    path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\cSort_ordena_obitos.csv";	    
		System.out.println("Número de casos ordenados pelo método CountingSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		
		
		// Reiniciando vetores...	

		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;		
		
		// Aplicando o método CountingSort em Nome das Cidades
		tempoInicial = System.nanoTime();
		CountingSort.sort(vCidade, vNumCasos, vNumObitos);
		tempoFinal = System.nanoTime();
		System.out.printf("CountingSort Cidades %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto
		
	    path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\cSort_ordena_cidades.csv";	    
		System.out.println("Número de casos ordenados pelo método CountingSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}

		// Aplicando o método InsertionSort em número de casos
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		System.out.println("Número de casos ordenados pelo método insertSort...");
		tempoInicial = System.nanoTime();		
		InsertionSort.insertSort(vCidade, vNumCasos, vNumObitos);
		tempoFinal = System.nanoTime();
		System.out.printf("Insertion Sort Casos%.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto		
		
	    path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\iSort_ordena_casos.csv";	    
		System.out.println("Número de casos ordenados pelo método InsertionSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		// Aplicando o método InsertionSort em número de óbitos
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		InsertionSort.insertSort(vCidade, vNumObitos, vNumCasos);
		tempoFinal = System.nanoTime();
		System.out.printf("Insertion Sort Óbitos: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto	

		path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\iSort_ordena_obitos.csv";	    
		System.out.println("Número de casos ordenados pelo método InsertionSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}

		// Aplicando o método InsertionSort em Cidades
		vCidade = cidade;
		vNumCasos = numCasos;
		vNumObitos = numObitos;
		tempoInicial = System.nanoTime();
		InsertionSort.insertSortStr(vCidade, vNumCasos, vNumObitos);
		tempoFinal = System.nanoTime();
		System.out.printf("Insert Sort Cidades: %.3f ms%n", (tempoFinal - tempoInicial) / 1000000d); // Calculando o tempo gasto			
		
		path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\iSort_ordena_cidades.csv";	    
		System.out.println("Número de casos ordenados pelo método InsertionSort...");
		for (i = 0; i < numLinhas; i++) {
			ManipuladorArquivo.criadorDeArquivos(path_out, cidade[i], vNumCasos[i], vNumObitos[i]);
		}
		
		QuickMediana3.QuickCasos(path, numLinhas);

	}

}
