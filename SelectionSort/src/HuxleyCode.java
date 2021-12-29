import java.util.*;

public class HuxleyCode {

	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int[] v = new int[m];
		int i = 0;
		int j = 0;
		int l = 0;
		int aux = 0;
		int menor = 0;
		
		
		for (i = 0; i < v.length; i++) {
			v[i] = input.nextInt();
		}
		
		
		
		for (i = 0; i < n; i++) {
			
			menor = i;
			for (j = i + 1; j < v.length; j++)
				if (v[j] < v[menor])
					menor = j;
			
			aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;	
			
			
			System.out.print("[");
			for (l = 0; l < m - 1; l++) {
				System.out.printf("%d, ", v[l]);
			}

			System.out.printf("%d]\n", v[l]);
		
		}	
		
		
	}
}
