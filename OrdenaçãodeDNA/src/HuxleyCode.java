import java.util.*;

public class HuxleyCode {

	public static int bubbleSort(String[] a) {
		// declarar as variáveis:
		int n = a.length;
		int j = 0;
		int i = 0;
		int numTrocas = 0;
		String aux;
		boolean houveTroca = true;
		
		// ordenar o vetor:
		while (houveTroca == true && j < n) {
			houveTroca = false;
			for (i = 0; i < a.length - 1; i++) {
				if (a[i].compareTo(a[i + 1]) > 0) {
					aux = a[i];
					a[i] = a[i + 1];
					a[i + 1] = aux;
					houveTroca = true;
					numTrocas++;					
				}
			}
			j++;
		}

		return numTrocas;
	}

	public static int[][] bubbleSort1(int[][] a) {
		// declarar as variáveis:
		int n = a.length;
		int j = 0;
		int i = 0;
		int aux0;
		int aux1;
		boolean houveTroca = true;

		// ordenar o vetor:
		while (houveTroca == true && j < n) {
			houveTroca = false;
			for (i = 0; i < a.length - 1; i++) {
				if (a[i][0] > a[i + 1][0]) {
					aux0 = a[i][0];
					aux1 = a[i][1];
					a[i][0] = a[i + 1][0];
					a[i][1] = a[i + 1][1];
					a[i + 1][0] = aux0;
					a[i + 1][1] = aux1;
					houveTroca = true;
				}
			}
			j++;
		}
		return a;
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String linha = null;		
		int c;
		int l;
		String total = input.nextLine();
		String[] quantity = total.split(" ");
		int m = Integer.parseInt(quantity[0]);
		

		while (m != 0) { // Leitura dos dados
			total = input.nextLine();
		    total = input.nextLine();
			quantity = total.split(" ");
			int j = Integer.parseInt(quantity[0]);
			int k = Integer.parseInt(quantity[1]);	 
			
			String[][] matrix = new String[k][j];
			String[][] matrixOrdenada = new String[k][j];
			String[] rowValues = new String[k];
			int[][] medidaDeDesordem = new int[k][2];

			for (l = 0; l < k; l++) {
				rowValues[l] = input.nextLine();
			}

			for (l = 0; l < k; l++) {
				String[] elementArray = rowValues[l].split("");
				for (c = 0; c < j; c++) {
					matrix[l][c] = elementArray[c];					
				}				
				medidaDeDesordem[l][0] = bubbleSort(elementArray);
				medidaDeDesordem[l][1] = l;
			}

			medidaDeDesordem = bubbleSort1(medidaDeDesordem);

			for (int i = 0; i < k; i++) {
				int md = medidaDeDesordem[i][1];				
				for (c = 0; c < j; c++) {					
					matrixOrdenada[i][c] = matrix[md][c];
				}
			}

			for (int linha1 = 0; linha1 < k; linha1++) {				
				for (int coluna = 0; coluna < j; coluna++) {
					System.out.printf("%s", matrixOrdenada[linha1][coluna]);
				}
				System.out.println();
			}
			
			System.out.println();
		} // Fim da leitura dos dados

		input.close();

	}
}
