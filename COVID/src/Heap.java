import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Heap {
	
public static void HeapCasos(String path, int numLinhas) throws IOException {

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
		String path_out3 = "C:\\LEDA\\HSort_ordena_casos_medio.csv";
		HeapCasos(numCasos,numObitos,cidade);
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	tempoInicial = System.nanoTime();
	  	HeapCasos(numCasos,numObitos,cidade);
		tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Heap Sort Para ordenar Caso: ");
	  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);	
		String path_out = "C:\\LEDA\\HSort_ordena_casos_melhor.csv";
	  	for(int k = 0; k<numCasos.length; k++){
	  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
	  	}
	  	
	  	
	  	String path_out2 = "C:\\LEDA\\HSort_ordena_casos_pior.csv";
	  	int [] auxCasosPior = new int [numCasos.length];
	  	int [] auxObitosPior = new int [numCasos.length];
	  	String[] auxCidadePior = new String [numCasos.length];
	  	int n=0;
	  	for(int k = numCasos.length-1; k>=0; k--){
	  		auxCasosPior[n]=numCasos[k];
	  		auxObitosPior[n]=numObitos[k];
	  		auxCidadePior[n]=cidade[k];	  			
	  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[n], auxCasosPior[n], auxObitosPior[n]);
	  		n++;
	  	}
	  	tempoInicial= System.nanoTime();
	  	HeapCasos(auxCasosPior,auxObitosPior,auxCidadePior);
		tempoFinal = System.nanoTime();
	  	System.out.println(" O tempo Gasto Para o Heap Sort Para ordenar Caso: ");
	  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	

		}

private static void HeapCasos(int[] numCasos, int[] numObitos, String[] cidade) {
			int n= numCasos.length;
	        
	        for(int i = n / 2 - 1; i >= 0; i--){
	            aplicarHeap(numCasos,numObitos,cidade, n, i);
	        }
		 
	        for(int j = n-1; j > 0; j--){
	            int auxC = numCasos[0];
	            int auxO = numObitos[0];
	            String auxCidade= cidade[0];
	            numCasos[0] = numCasos[j];
	            numObitos[0]=numObitos[j];
	            cidade[0] =cidade[j];
	            numCasos[j] = auxC;
	            numObitos[j]= auxO;
	            cidade[j]=auxCidade;
	            aplicarHeap(numCasos,numObitos,cidade, j, 0);
	        }}

private static void aplicarHeap(int[] numCasos,int []numObitos, String[] cidade, int n, int i){
    int raiz = i;
    int esquerda = 2*i + 1;
    int direita = 2*i + 2;
    
    if (esquerda < n && numCasos[esquerda] > numCasos[raiz]){
        raiz = esquerda;
    }
    if (direita < n && numCasos[direita] > numCasos[raiz]){
        raiz = direita;
    }
    
    if (raiz != i){
        int auxC = numCasos[i];
        int auxO= numObitos[i];
        String auxCidade= cidade[i];
        numCasos[i] = numCasos[raiz];
        numObitos[i] = numObitos[raiz];
        cidade[i]= cidade[raiz];
        numObitos[raiz] = auxO;
        numCasos[raiz] = auxC;
        cidade[raiz] =auxCidade;
        aplicarHeap(numCasos,numObitos,cidade, n, raiz);
    }
}
	
public static void HeapObitos(String path, int numLinhas) throws IOException {

	String[] cidade = new String [numLinhas];
	int[] numCasos = new int[numLinhas];
	int[] numObitos =new int[numLinhas];
	double tempoInicial;
	double tempoFinal;

	double auxiliar;
	
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
	String path_out3 = "C:\\LEDA\\HSort_ordena_obitos_medio.csv";
	HeapObitos(numCasos,numObitos,cidade);
  	for(int k = 0; k<numObitos.length; k++){
  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
  	}
  	tempoInicial =System.nanoTime();
  	HeapObitos(numCasos,numObitos,cidade);
	tempoFinal = System.nanoTime();
  	System.out.println(" O tempo Gasto Para o Heap Sort Para ordenar Obitos: ");
  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);	
	String path_out = "C:\\LEDA\\HSort_ordena_obitos_melhor.csv";
  	for(int k = 0; k<numObitos.length; k++){
  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
  	}
  	
 
  	String path_out2 = "C:\\LEDA\\HSort_ordena_obitos_pior.csv";
  	int [] auxCasosPior = new int [numCasos.length];
  	int [] auxObitosPior = new int [numCasos.length];
  	String[] auxCidadePior = new String [numCasos.length];
  	int n=0;
  	for(int k = numCasos.length-1; k>0; k--){	 
  		auxCasosPior[n]=numCasos[k];
  		auxObitosPior[n]=numObitos[k];
  		auxCidadePior[n]=cidade[k];	  			
  		ManipuladorArquivo.criadorDeArquivos(path_out2, auxCidadePior[k], auxCasosPior[k], auxObitosPior[k]);
  		n++;
  	}
  	tempoInicial = System.nanoTime();
  	HeapObitos(auxCasosPior,auxObitosPior,auxCidadePior);
	tempoFinal = System.nanoTime();
  	System.out.println(" O tempo Gasto Para o Heap Sort Para ordenar Obitos: ");
  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	
	}

private static void HeapObitos(int[] numCasos, int[] numObitos, String[] cidade) {
		int n= numObitos.length;
        
        for(int i = n / 2 - 1; i >= 0; i--){
            aplicarHeapObitos(numCasos,numObitos,cidade, n, i);
        }
	 
        for(int j = n-1; j > 0; j--){
            int auxC = numCasos[0];
            int auxO = numObitos[0];
            String auxCidade= cidade[0];
            numCasos[0] = numCasos[j];
            numObitos[0]=numObitos[j];
            cidade[0] =cidade[j];
            numCasos[j] = auxC;
            numObitos[j]= auxO;
            cidade[j]=auxCidade;
            aplicarHeapObitos(numCasos,numObitos,cidade, j, 0);
        }}

private static void aplicarHeapObitos(int[] numCasos,int []numObitos, String[] cidade, int n, int i){
int raiz = i;
int esquerda = 2*i + 1;
int direita = 2*i + 2;

if (esquerda < n && numObitos[esquerda] > numObitos[raiz]){
    raiz = esquerda;
}
if (direita < n && numObitos[direita] > numObitos[raiz]){
    raiz = direita;
}

if (raiz != i){
    int auxC = numCasos[i];
    int auxO= numObitos[i];
    String auxCidade= cidade[i];
    numCasos[i] = numCasos[raiz];
    numObitos[i] = numObitos[raiz];
    cidade[i]= cidade[raiz];
    numObitos[raiz] = auxO;
    numCasos[raiz] = auxC;
    cidade[raiz] =auxCidade;
    aplicarHeapObitos(numCasos,numObitos,cidade, n, raiz);
}
}

public static void HeapNomes(String path, int numLinhas) throws IOException {

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
	
	String path_out3 = "C:\\LEDA\\HSort_ordena_nomes_medio.csv";
	HeapNomes(numCasos,numObitos,cidade);
  	for(int k = 0; k<cidade.length; k++){
  		ManipuladorArquivo.criadorDeArquivos(path_out3, cidade[k], numCasos[k], numObitos[k]);
  	}
  	tempoInicial= System.nanoTime();
  	HeapNomes(numCasos,numObitos,cidade);
	tempoFinal = System.nanoTime();
  	System.out.println(" O tempo Gasto Para o Heap Sort Para ordenar Nomes: ");
  	System.out.println(" Melhor Caso:"+(tempoFinal-tempoInicial)/1000000);	
	String path_out = "C:\\LEDA\\HSort_ordena_nomes_melhor.csv";
  	for(int k = 0; k<cidade.length; k++){
  		ManipuladorArquivo.criadorDeArquivos(path_out, cidade[k], numCasos[k], numObitos[k]);
  	}
  	
 
  	String path_out2 = "C:\\LEDA\\HSort_ordena_nomes_pior.csv";
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
  	tempoInicial= System.nanoTime();
  	HeapNomes(auxCasosPior,auxObitosPior,auxCidadePior);
	tempoFinal = System.nanoTime();
  	System.out.println(" O tempo Gasto Para o Heap Sort Para ordenar Nomes: ");
  	System.out.println(" Pior Caso:"+(tempoFinal-tempoInicial)/1000000);	
	}

private static void HeapNomes(int[] numCasos, int[] numObitos, String[] cidade) {
		int n= numObitos.length;
        
        for(int i = n / 2 - 1; i >= 0; i--){
            aplicarHeapNomes(numCasos,numObitos,cidade, n, i);
        }
	 
        for(int j = n-1; j > 0; j--){
            int auxC = numCasos[0];
            int auxO = numObitos[0];
            String auxCidade= cidade[0];
            numCasos[0] = numCasos[j];
            numObitos[0]=numObitos[j];
            cidade[0] =cidade[j];
            numCasos[j] = auxC;
            numObitos[j]= auxO;
            cidade[j]=auxCidade;
            aplicarHeapNomes(numCasos,numObitos,cidade, j, 0);
        }}

private static void aplicarHeapNomes(int[] numCasos,int []numObitos, String[] cidade, int n, int i){
int raiz = i;
int esquerda = 2*i + 1;
int direita = 2*i + 2;

if (esquerda < n && cidade[esquerda].compareTo(cidade[raiz])>0){
    raiz = esquerda;
}
if (direita < n && cidade[direita].compareTo(cidade[raiz])>0){
    raiz = direita;
}

if (raiz != i){
    int auxC = numCasos[i];
    int auxO= numObitos[i];
    String auxCidade= cidade[i];
    numCasos[i] = numCasos[raiz];
    numObitos[i] = numObitos[raiz];
    cidade[i]= cidade[raiz];
    numObitos[raiz] = auxO;
    numCasos[raiz] = auxC;
    cidade[raiz] =auxCidade;
    aplicarHeapNomes(numCasos,numObitos,cidade, n, raiz);
}
}

}



