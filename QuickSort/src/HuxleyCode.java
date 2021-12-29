import java.util.*;

public class HuxleyCode {

	public static void quickSort(int[] v, int a, int b) {		
		if (a < b) {			
			int q = particiona(v, a, b);
			quickSort(v, a, q - 1);
			quickSort(v, q + 1, b);
		}		
	}
	
	public static int particiona(int [] v, int p, int r) {
		int x = v[r];
		int i = p - 1;
		int aux;
		
		for ( int j = p; j < r; j++) {			
			if (v[j] <= x) {
				i++;
				aux = v[i];
				v[i] = v[j];
				v[j] = aux;
			}
		}
		
		aux = v[i + 1];		
		v[i+1] = v[r];
		v[r] = aux;
		
		return i + 1;
	}

	public static void Ordena(String args[]) {
		Scanner input = new Scanner(System.in);
		String total = input.nextLine();
		String[] quantity = total.split(" ");
		int numLinhas = Integer.parseInt(quantity[0]);

		String rowValues = null;

		while (numLinhas > 0) { // Leitura dos dados
			rowValues = input.nextLine();
			String[] elementArray = rowValues.split(" ");

			int[] rowQuantity = new int[elementArray.length];

			for (int i = 0; i < elementArray.length; i++) {
				rowQuantity[i] = Integer.parseInt(elementArray[i]);
			}

			quickSort(rowQuantity, 0, rowQuantity.length - 1);

			for (int i = 0; i < rowQuantity.length; i++) {
				System.out.printf("%d ", rowQuantity[i]);
			}

			System.out.println();

			numLinhas--;

		} // Fim da leitura dos dados

		input.close();

	}

}
