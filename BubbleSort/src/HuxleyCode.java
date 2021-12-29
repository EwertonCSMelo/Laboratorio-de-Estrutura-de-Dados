import java.util.Scanner;

public class HuxleyCode {

	public static void main(String[] args) {
		// declarar as variáveis:
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int j = 0;
		int[] a = new int[m];
		int i = 0;
		int aux = 0;
		boolean houveTroca = true;

		for (i = 0; i < m; i++) {
			a[i] = input.nextInt();
		}

		// ordenar o vetor:
		while (houveTroca == true && j < n) {
			System.out.print("[");
			houveTroca = false;
			for (i = 0; i < a.length-1; i++) {
				if (a[i] > a[i + 1]) {
					aux = a[i];
					a[i] = a[i + 1];
					a[i + 1] = aux;
					houveTroca = true;
				}
			}	
			
			for (i = 0; i < a.length-1; i++) {
			System.out.printf("%d, ", a[i]);
			}
			System.out.printf("%d]\n", a[i]);
			j++;
		}
		
	}
}
