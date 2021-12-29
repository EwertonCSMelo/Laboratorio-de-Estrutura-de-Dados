import java.io.IOException;

public class Covid {

	public static void main(String args[]) throws IOException {
		// Dados de entrada
		//String path_in = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\covid19Pb.csv";
		String path_in = "C:\\LEDA\\caso_full.csv";
		//String path_dados = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\covid19Pb_used.csv";
		//String path_dados = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\caso_full_used.csv";
		String pathDadosFull = "C:\\LEDA\\caso_full_used.csv";
		

		
		//ManipuladorArquivo.leitor(path_in);			
		
		int numLinhas = ManipuladorArquivo.contadorDeLinhas(pathDadosFull);
		System.out.println("----------------------------------------------------------------------------------------------");
		Select.SelectCasos(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		Select.SelectObitos(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		Select.SelectNome(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
	
		
		Merge.MergeCasos(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		Merge.MergeObitos(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		Merge.MergeNomes(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");

		
		Heap.HeapCasos(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		Heap.HeapObitos(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		Heap.HeapNomes(pathDadosFull, numLinhas);
		System.out.println("----------------------------------------------------------------------------------------------");
		
		System.out.println("Melhor numero de caso: ");
		// melhor caso Numero de Casos 
		pathDadosFull = "C:\\LEDA\\Sort_ordena_casos_melhor.csv";
		OperadorDeDados.dataSort(pathDadosFull, numLinhas);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Pior numero de caso: ");
		// pior caso Numero de Casos 
		pathDadosFull = "C:\\LEDA\\caso_full_piorCidade.csv";
		OperadorDeDados.dataSort(pathDadosFull, numLinhas);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();		
		System.out.println("Melhor numero de óbitos: ");
		// melhor caso Numero de Óbitos 
		pathDadosFull = "C:\\LEDA\\Sort_ordena_Obitos_melhor.csv";
		OperadorDeDados.dataSort(pathDadosFull, numLinhas);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Pior numero de obito: ");
		 //pior caso Numero de Óbitos
		pathDadosFull = "C:\\LEDA\\caso_full_piorObitos.csv";
		OperadorDeDados.dataSort(pathDadosFull, numLinhas);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Melhor numero de Cidades: ");
		// melhor caso Numero de Cidades
		pathDadosFull = "C:\\LEDA\\caso_full_melhornumcidade.csv";
		OperadorDeDados.dataSort(pathDadosFull, numLinhas);
		
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println();

		System.out.println("Pior numero de cidades: ");
		// pior caso Numero de Cidades
		pathDadosFull = "C:\\LEDA\\caso_full_piorCidade.csv";
		OperadorDeDados.dataSort(pathDadosFull, numLinhas);
		
	}

}
