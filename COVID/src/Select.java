import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Select {
	
public static void SelectCasos(String path, int numLinhas) throws IOException {
	
		String[] cidade = new String [numLinhas];
		int[] numCasos = new int[numLinhas];
		int[] numObitos =new int[numLinhas];
		double auxiliar;
		double tempoInicial;
		double tempoFinal;
		
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		String[] elementArray;  
		
		int i = 0;
		
		while (linha != null) {
			linha = buffRead.readLine();
			try {
				elementArray = linha.split(",");

				cidade[i] = elementArray[0];
				auxiliar = Double.parseDouble(elementArray[1]);
				//auxiliar = Double.parseDouble(elementArray[1]);
				numCasos[i] = (int) auxiliar;
				numObitos[i] = Integer.parseInt(elementArray[2]);
				// System.out.printf("%s %d %d \n", cidade[i], numCasos[i], numObitos[i]);
			} catch (NullPointerException nexc) {
				System.out.println("Dados Armazenados!");
			}

			i++;
		}
		
		String path_out3 = "C:\\LEDA\\SSort_ordena_casos_medio.csv";
		
		SelectionCasos(numCasos,numObitos,cidade);
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	tempoInicial = System.nanoTime();
	  	SelectionCasos(numCasos,numObitos,cidade);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Selection Sort Para ordenar Casos: ");
	  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);
		String path_out = "C:\\LEDA\\SSort_ordena_casos_melhor.csv";
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
	  	}
	   	
	  	String path_out2 = "C:\\LEDA\\SSort_ordena_casos_pior.csv";
	  	int [] auxCasosPior = new int [numCasos.length];
	  	int [] auxObitosPior = new int [numCasos.length];
	  	String[] auxCidadePior = new String [numCasos.length];
	  	int n=0;
	  	for(int k = numCasos.length-1; k>=0; k--){	 
	  		auxCasosPior[n]=numCasos[k];
	  		auxObitosPior[n]=numObitos[k];
	  		auxCidadePior[n]=cidade[k];	  			
	  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
	  		n++;
	  	}
	  	tempoInicial = System.nanoTime();
	  	SelectionCasos(auxCasosPior,auxObitosPior,auxCidadePior);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Selection Sort Para ordenar Casos: ");
	  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);
	  	
		}

private static void SelectionCasos(int[] numCasos,int []numObitos, String[] cidade){
			
		  	for (int j = 0; j < numCasos.length; j++) {
			int j_menor = j;
				for (int k = j + 1; k < numCasos.length; k++){
					if (numCasos[k] < numCasos[j_menor])
						j_menor = k;
					}
				
				int keyC = numCasos[j];
				int keyO = numObitos[j];
				String keyCidade = cidade[j];
				
				numCasos[j]=numCasos[j_menor];
				numObitos[j]=numObitos[j_menor];
				cidade[j]= cidade[j_menor];
				
				numCasos[j_menor]=keyC;
				numObitos[j_menor]=keyO;
				cidade[j_menor]=keyCidade;
		                     
				
		  	}
		  	

		}

public static void SelectObitos(String path, int numLinhas) throws IOException {
		
		String[] cidade = new String [numLinhas];
		int[] numCasos = new int[numLinhas];
		int[] numObitos =new int[numLinhas];
		double auxiliar;
		double tempoInicial;
		double tempoFinal;
		
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		String[] elementArray;  
		
		int i = 0;
		
		while (linha != null) {
			linha = buffRead.readLine();
			try {
				elementArray = linha.split(",");

				cidade[i] = elementArray[0];
				auxiliar = Double.parseDouble(elementArray[1]);
				//auxiliar = Double.parseDouble(elementArray[1]);
				numCasos[i] = (int) auxiliar;
				numObitos[i] = Integer.parseInt(elementArray[2]);
				// System.out.printf("%s %d %d \n", cidade[i], numCasos[i], numObitos[i]);
			} catch (NullPointerException nexc) {
				System.out.println("Dados Armazenados!");
			}

			i++;
		}
		
		SelectionObitos(numCasos,numObitos,cidade);
		
		String path_out3 = "C:\\LEDA\\SSort_ordena_Obitos_medio.csv";
		SelectionObitos(numCasos,numObitos,cidade);
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	tempoInicial = System.nanoTime();
	  	SelectionObitos(numCasos,numObitos,cidade);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Selection Sort Para ordenar Obitos: ");
	  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);
		String path_out = "C:\\LEDA\\SSort_ordena_Obitos_melhor.csv";
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
	  	}
	   	
	  	String path_out2 = "C:\\LEDA\\SSort_ordena_Obitos_pior.csv";
	  	int [] auxCasosPior = new int [numCasos.length];
	  	int [] auxObitosPior = new int [numCasos.length];
	  	String[] auxCidadePior = new String [numCasos.length];
	  	int n=0;
	  	for(int k = numCasos.length-1; k>=0; k--){	 
	  		auxCasosPior[n]=numCasos[k];
	  		auxObitosPior[n]=numObitos[k];
	  		auxCidadePior[n]=cidade[k];	  			
	  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
	  		n++;
	  	}
	  	tempoInicial = System.nanoTime();
	  	SelectionObitos(auxCasosPior,auxObitosPior,auxCidadePior);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Selection Sort Para ordenar Obitos: ");
	  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);
	  	
		}

private static void SelectionObitos(int[] numCasos,int []numObitos, String[] cidade){
	
  	for (int j = 0; j < numObitos.length; j++) {
	int j_menor = j;
		for (int k = j + 1; k < numObitos.length; k++){
			if (numObitos[k] < numObitos[j_menor])
				j_menor = k;
			}
		
		int keyC = numCasos[j];
		int keyO = numObitos[j];
		String keyCidade = cidade[j];
		
		numCasos[j]=numCasos[j_menor];
		numObitos[j]=numObitos[j_menor];
		cidade[j]= cidade[j_menor];
		
		numCasos[j_menor]=keyC;
		numObitos[j_menor]=keyO;
		cidade[j_menor]=keyCidade;
                     
		
  	}
  	

}


public static void SelectNome(String path, int numLinhas) throws IOException {
		
		String[] cidade = new String [numLinhas];
		int[] numCasos = new int[numLinhas];
		int[] numObitos =new int[numLinhas];
		double auxiliar;
		double tempoInicial;
		double tempoFinal;
		
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		String[] elementArray;  
		
		int i = 0;
		
		while (linha != null) {
			linha = buffRead.readLine();
			try {
				elementArray = linha.split(",");

				cidade[i] = elementArray[0];
				auxiliar = Double.parseDouble(elementArray[1]);
				//auxiliar = Double.parseDouble(elementArray[1]);
				numCasos[i] = (int) auxiliar;
				numObitos[i] = Integer.parseInt(elementArray[2]);
				// System.out.printf("%s %d %d \n", cidade[i], numCasos[i], numObitos[i]);
			} catch (NullPointerException nexc) {
				System.out.println("Dados Armazenados!");
			}

			i++;
		}
		
	  	SelectionNomes(numCasos,numObitos,cidade);
	  	
		String path_out3 = "C:\\LEDA\\SSort_ordena_Nomes_medio.csv";
		SelectionNomes(numCasos,numObitos,cidade);
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	tempoInicial=System.nanoTime();
	  	SelectionNomes(numCasos,numObitos,cidade);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Selection Sort Para ordenar Nomes: ");
	  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);
		String path_out = "C:\\LEDA\\SSort_ordena_nomes_melhor.csv";
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
	  	}
	   	
	  	String path_out2 = "C:\\LEDA\\SSort_ordena_nomes_pior.csv";
	  	int [] auxCasosPior = new int [numCasos.length];
	  	int [] auxObitosPior = new int [numCasos.length];
	  	String[] auxCidadePior = new String [numCasos.length];
	  	int n=0;
	  	for(int k = numCasos.length-1; k>=0; k--){	 
	  		auxCasosPior[n]=numCasos[k];
	  		auxObitosPior[n]=numObitos[k];
	  		auxCidadePior[n]=cidade[k];	  			
	  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
	  		n++;
	  	}
	  	tempoInicial=System.nanoTime();
	  	SelectionNomes(auxCasosPior,auxObitosPior,auxCidadePior);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Selection Sort Para ordenar Nomes: ");
	  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	  	
		
}

private static void SelectionNomes(int[] numCasos,int []numObitos, String[] cidade){
	
	for (int j = 0; j < cidade.length; j++) {
		int j_menor = j;
			for (int k = j + 1; k < numObitos.length; k++){
				if (cidade[k].compareTo(cidade[j_menor])<0)
					j_menor = k;
				}
			
			int keyC = numCasos[j];
			int keyO = numObitos[j];
			String keyCidade = cidade[j];
			
			numCasos[j]=numCasos[j_menor];
			numObitos[j]=numObitos[j_menor];
			cidade[j]= cidade[j_menor];
			
			numCasos[j_menor]=keyC;
			numObitos[j_menor]=keyO;
			cidade[j_menor]=keyCidade;
	                     
			
	  	}
  	

}
}

