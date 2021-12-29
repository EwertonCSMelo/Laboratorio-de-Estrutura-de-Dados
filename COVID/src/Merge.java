import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge {
	
public static void MergeCasos(String path, int numLinhas) throws IOException {

		String[] cidade = new String [numLinhas];
		int[] numCasos = new int[numLinhas];
		int[] numObitos =new int[numLinhas];
		int [] auxCasos = new int [numLinhas];
		int [] auxObitos = new int [numLinhas];
		String [] auxCidade = new String [numLinhas];
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
		
		String path_out3 = "C:\\LEDA\\MSort_ordena_casos_medio.csv";
		MergeSortCasos(numCasos,numObitos,cidade,auxCasos,auxObitos,auxCidade,0,numObitos.length-1);
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	tempoInicial = System.nanoTime();
	  	MergeSortCasos(numCasos,numObitos,cidade,auxCasos,auxObitos,auxCidade,0,numObitos.length-1);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Merge Sort Para ordenar Caso: ");
	  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);	
		String path_out = "C:\\LEDA\\MSort_ordena_casos_melhor.csv";
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	
	  	
	  	String path_out2 = "C:\\LEDA\\MSort_ordena_casos_pior.csv";
	  	int [] auxCasosPior = new int [numCasos.length];
	  	int [] auxObitosPior = new int [numCasos.length];
	  	String[] auxCidadePior = new String [numCasos.length];
	  	int [] auxXCasosPior = new int [numCasos.length];
	  	int [] auxXObitosPior = new int [numCasos.length];
	  	String [] auxXCidadepior = new String [numCasos.length];
	  	int n=0;
	  	for(int k = numCasos.length-1; k>=0; k--){	 
	  		auxCasosPior[n]=numCasos[k];
	  		auxObitosPior[n]=numObitos[k];
	  		auxCidadePior[n]=cidade[k];	  	
	  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
	  		n++;
	  	}
	  	tempoInicial = System.nanoTime();
	  	MergeSortCasos(auxCasosPior,auxObitosPior,auxCidadePior,auxXCasosPior,auxXObitosPior,auxXCidadepior,0,cidade.length-1);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Merge Sort Para ordenar Caso: ");
	  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	
		}
public static void MergeSortCasos(int []numCasos,int[] numObitos,String[] cidade,int [] auxCasos,int [] auxObitos,String[] auxCidade, int ini, int fim) {
			if(ini<fim) {
				int meio= (ini+fim)/2;
				 MergeSortCasos(numCasos,numObitos,cidade,auxCasos,auxObitos,auxCidade,ini,meio);
				 MergeSortCasos(numCasos,numObitos,cidade,auxCasos,auxObitos,auxCidade,meio+1,fim);
				 intercarlarC(numCasos,numObitos,cidade,auxCasos,auxObitos,auxCidade,ini,meio,fim);
			}
	
	


}
private static void intercarlarC(int[] numCasos, int[] numObitos, String[] cidade, int[] auxCasos, int[] auxObitos,
			String[] auxCidade, int ini, int meio, int fim) {
			for(int k = ini;k<=fim;k++) {
				auxCasos[k]=numCasos[k];
				auxObitos[k]=numObitos[k];
				auxCidade[k]=cidade[k];
			}
			int i =ini;
			int j = meio+1;
			
			for(int k=ini; k<=fim;k++) {
				if(i>meio) {
					numCasos[k]=auxCasos[j];
					numObitos[k]=auxObitos[j];
					cidade[k]=auxCidade[j];
					j++;
				}else if(j>fim) {
					numCasos[k]=auxCasos[i];
					numObitos[k]=auxObitos[i];
					cidade[k]=auxCidade[i];
					i++;
				}else if(auxCasos[i]<auxCasos[j]) {
					numCasos[k]=auxCasos[i];
					numObitos[k]=auxObitos[i];
					cidade[k]=auxCidade[i];
					i++;
				}else {
					numCasos[k]=auxCasos[j];
					numObitos[k]=auxObitos[j];
					cidade[k]=auxCidade[j];
					j++;
				}
			}
		
	}
public static void MergeObitos(String path, int numLinhas) throws IOException {

		String[] cidade = new String [numLinhas];
		int[] numCasos = new int[numLinhas];
		int[] numObitos =new int[numLinhas];
		int [] auxCasos = new int [numLinhas];
		int [] auxObitos = new int [numLinhas];
		String [] auxCidade = new String [numLinhas];
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
		
		String path_out3 = "C:\\LEDA\\MSort_ordena_obitos_medio.csv";
		mergeSortObitos(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,0,numCasos.length-1);
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	tempoInicial = System.nanoTime();
	  	mergeSortObitos(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,0,numCasos.length-1);
	  	tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Merge Sort Para ordenar Obitos: ");
	  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);	
		String path_out = "C:\\LEDA\\MSort_ordena_obitos_melhor.csv";
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	
	  	
	  	String path_out2 = "C:\\LEDA\\MSort_ordena_Obitos_pior.csv";
	  	int [] auxCasosPior = new int [numCasos.length];
	  	int [] auxObitosPior = new int [numCasos.length];
	  	String[] auxCidadePior = new String [numCasos.length];
	  	int [] auxXCasosPior = new int [numCasos.length];
	  	int [] auxXObitosPior = new int [numCasos.length];
	  	String [] auxXCidadepior = new String [numCasos.length];
	  	int n=0;
	  	for(int k = numCasos.length-1; k>=0; k--){	 
	  		auxCasosPior[n]=numCasos[k];
	  		auxObitosPior[n]=numObitos[k];
	  		auxCidadePior[n]=cidade[k];	
	  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
	  		n++;
	  	}
	  	tempoInicial= System.nanoTime();
	  	mergeSortObitos(auxObitosPior,auxXObitosPior,auxCasosPior,auxCidadePior,auxXCasosPior,auxXCidadepior,0,cidade.length-1);
		tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Merge Sort Para ordenar Obitos: ");
	  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	
	  	
		}
private static void mergeSortObitos(int[] numObitos, int[] auxObitos,int[] numCasos,String[] cidade,int [] auxCasos,String [] auxCidade, int ini, int fim) {
		if(ini<fim) {
			int meio= (ini+fim)/2;
			mergeSortObitos(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,ini,meio);
			mergeSortObitos(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,meio+1,fim);
			intercarlaObitos(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,ini,meio,fim);
		
		}
	}
private static void intercarlaObitos(int[] numObitos, int[] auxObitos,int[] numCasos,String[] cidade,int [] auxCasos,String [] auxCidade, int ini, int meio, int fim) {

		for(int k=ini;k<=fim;k++) {
			auxObitos[k]=numObitos[k];
			auxCasos[k]=numCasos[k];
			auxCidade[k]=cidade[k];
		}
		
		int i=ini;
		int j=meio+1;
			for(int k=ini;k<=fim;k++) {
				if(i>meio) {
					numObitos[k]=auxObitos[j];
					numCasos[k]=auxCasos[j];
					cidade[k]=auxCidade[j];
					j++;
				}
				else if(j>fim) {
					numObitos[k]= auxObitos[i];
					numCasos[k]=auxCasos[i];
					cidade[k]=auxCidade[i];
					i++;
				}
				else if(auxObitos[i]<auxObitos[j]) {
					numObitos[k]=auxObitos[i];
					numCasos[k]=auxCasos[i];
					cidade[k]=auxCidade[i];
					i++;
				}
				else {
					numObitos[k]=auxObitos[j];
					numCasos[k]=auxCasos[j];
					cidade[k]=auxCidade[j];
					j++;
				}
			}
	}
public static void MergeNomes(String path, int numLinhas) throws IOException {

	String[] cidade = new String [numLinhas];
	int[] numCasos = new int[numLinhas];
	int[] numObitos =new int[numLinhas];
	int [] auxCasos = new int [numLinhas];
	int [] auxObitos = new int [numLinhas];
	String [] auxCidade = new String [numLinhas];
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

	String path_out3 = "C:\\LEDA\\MSort_ordena_nomes_medio.csv";
	mergeSortNomes(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,0,numCasos.length-1);
  	for(int k = 0; k<numCasos.length; k++){
  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
  	}
  	tempoInicial = System.nanoTime();
  	mergeSortNomes(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,0,numCasos.length-1);
	tempoFinal = System.nanoTime();
  	System.out.println(" O tempo Gasto Para o Merge Sort Para ordenar Nomes: ");
  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);	
	String path_out = "C:\\LEDA\\MSort_ordena_nomes_melhor.csv";
  	for(int k = 0; k<numCasos.length; k++){
  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
  	}
  	
  	
  	
  	String path_out2 = "C:\\LEDA\\MSort_ordena_nomes_pior.csv";
  	int [] auxCasosPior = new int [numCasos.length];
  	int [] auxObitosPior = new int [numCasos.length];
  	String[] auxCidadePior = new String [numCasos.length];
  	int [] auxXCasosPior = new int [numCasos.length];
  	int [] auxXObitosPior = new int [numCasos.length];
  	String [] auxXCidadepior = new String [numCasos.length];
  	int n=0;
  	for(int k = numCasos.length-1; k>=0; k--){	 
  		auxCasosPior[n]=numCasos[k];
  		auxObitosPior[n]=numObitos[k];
  		auxCidadePior[n]=cidade[k];	
  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
  		n++;
  	}
  	tempoInicial = System.nanoTime();
  	mergeSortNomes(auxObitosPior,auxXObitosPior,auxCasosPior,auxCidadePior,auxXCasosPior,auxXCidadepior,0,cidade.length-1);
	tempoFinal = System.nanoTime();
  	System.out.println(" O tempo Gasto Para o Merge Sort Para ordenar Nomes: ");
  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	
  	
	}
private static void mergeSortNomes(int[] numObitos, int[] auxObitos,int[] numCasos,String[] cidade,int [] auxCasos,String [] auxCidade, int ini, int fim) {
	if(ini<fim) {
		int meio= (ini+fim)/2;
		mergeSortNomes(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,ini,meio);
		mergeSortNomes(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,meio+1,fim);
		intercarlaNomes(numObitos,auxObitos,numCasos,cidade,auxCasos,auxCidade,ini,meio,fim);
	
	}
}
private static void intercarlaNomes(int[] numObitos, int[] auxObitos,int[] numCasos,String[] cidade,int [] auxCasos,String [] auxCidade, int ini, int meio, int fim) {

	for(int k=ini;k<=fim;k++) {
		auxObitos[k]=numObitos[k];
		auxCasos[k]=numCasos[k];
		auxCidade[k]=cidade[k];
	}
	
	int i=ini;
	int j=meio+1;
		for(int k=ini;k<=fim;k++) {
			if(i>meio) {
				numObitos[k]=auxObitos[j];
				numCasos[k]=auxCasos[j];
				cidade[k]=auxCidade[j];
				j++;
			}
			else if(j>fim) {
				numObitos[k]= auxObitos[i];
				numCasos[k]=auxCasos[i];
				cidade[k]=auxCidade[i];
				i++;
			}
			else if(auxCidade[i].compareTo(auxCidade[j])<0) {
				numObitos[k]=auxObitos[i];
				numCasos[k]=auxCasos[i];
				cidade[k]=auxCidade[i];
				i++;
			}
			else {
				numObitos[k]=auxObitos[j];
				numCasos[k]=auxCasos[j];
				cidade[k]=auxCidade[j];
				j++;
			}
		}
}
}
	
