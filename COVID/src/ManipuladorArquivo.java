import java.io.*;

public class ManipuladorArquivo {

	public static int leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		String[] elementArray = null;
		int numLinhas = 0;

		// Criando arquivo com a saida organizada para ser usada no processo ordenação
		// String path_out =
		// "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\covid19Pb_used.csv";
		String path_out = "C:\\LEDA\\caso_full_used.csv";

		File file = new File(path_out);

		if (file.isFile()) { // Deletando arquivo antigo
			file.delete();
		}

		int i = 0;
		while (linha != null) {
			linha = buffRead.readLine();
			try {
				elementArray = linha.split(",");
			} catch (NullPointerException nexc) {
				System.out.println("Fim da leitura do arquivo " + path);
			}

			if (i > 1) {
				escritor(path_out, elementArray);
				numLinhas++;
			}
			i++;
		}
		buffRead.close();
		return numLinhas - 1;
	}

	public static int leitorFull(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		String[] elementArray = null;
		int numLinhas = 0;

		// Criando arquivo com a saida organizada para ser usada no processo ordenação
		String path_out = "C:\\Users\\Sonny\\Documents\\Sonny\\Computação2021.1\\Fábio\\Projeto.covid\\caso_full_used.csv";

		File file = new File(path_out);

		if (file.isFile()) { // Deletando arquivo antigo
			file.delete();
		}

		int i = 0;
		while (linha != null) {
			linha = buffRead.readLine();
			try {
				elementArray = linha.split(",");
			} catch (NullPointerException nexc) {
				System.out.println("Fim da leitura do arquivo " + path);
			}

			if (i > 1) {
				escritorFull(path_out, elementArray);
				numLinhas++;
			}
			i++;
		}
		buffRead.close();
		return numLinhas - 1;
	}

	public static int contadorDeLinhas(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
		String linha = "";
		int numLinhas = 0;

		while (linha != null) {
			linha = buffRead.readLine();

			numLinhas++;
		}

		buffRead.close();
		return numLinhas - 1;
	}

	public static void escritorFull(String path_out, String[] linha) throws IOException {
		char quebra_de_linha = (char) 13;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path_out, true));
		if (!isNumber(linha[0]) && linha[0] != null && !linha[0].isEmpty() && linha[9] != null && !linha[9].isEmpty()
				&& linha[13] != null && !linha[13].isEmpty()) {
			// System.out.println(linha[0] + " " + linha[9] + " " + linha[13]);
			buffWrite.append(linha[0] + "," + linha[9] + "," + linha[13] + quebra_de_linha);
		}
		buffWrite.close();
	}

	public static void escritor(String path_out, String[] linha) throws IOException {
		char quebra_de_linha = (char) 13;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path_out, true));
		if (linha[4]. equals("Importados/Indefinidos") == false && linha[4] != null && !linha[4].isEmpty() && linha[7] != null && !linha[7].isEmpty()
				&& linha[10] != null && !linha[10].isEmpty()) {
			buffWrite.append(linha[4] + "," + linha[7] + "," + linha[10] + quebra_de_linha);
		}
		buffWrite.close();
	}

	public static void criadorDeArquivos(String pathOut, String cidade, int v1, int v2) throws IOException {
		char quebra_de_linha = (char) 13;
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(pathOut, true));
		buffWrite.append(cidade + "," + Integer.toString(v1) + "," + Integer.toString(v2) + quebra_de_linha);
		buffWrite.close();
	}

	public static boolean isNumber(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}