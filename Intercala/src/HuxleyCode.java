import java.io.*;
import java.util.*;

public class HuxleyCode {
  	public static int[] intercala(int[] a, int[] b) {
  	    int n1 = a.length;
  	    int n2 = b.length;
		int[] left = new int[n1];
		int[] right = new int[n2];
		int[] z = new int[n1 + n2];

		for (int i = 0; i < n1; i++) {
			left[i] = a[i];
		}

		for (int j = 0; j < n2; j++) {
			right[j] = b[j];
		}

		int i, j, k;
		i = 0;
		j = 0;
		k = 0;
       
		while (i < n1 && j < n2) {
			if (left[i] <= right[j]) {
				z[k] = left[i];
				i++;
				k++;
			} else {
				z[k] = right[j];
				j++;
			    k++;
			}
		}
		
		if((n2 % n1) != 0){
		    for (j = j; j < n2; j++){
		       z[k] = right[j]; 
		       k++;
		    }
		}
		
		return z;
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		String rowValues = null;
		int numLinhas = 2;
		int[] vetor1 = null;
		int[] vetor2 = null;

		while (numLinhas > 0) {
			rowValues = input.nextLine();

			String[] elementArray = rowValues.split(" ");
			
			if (numLinhas == 2) {
				vetor1 = new int[elementArray.length];

				for (int i = 0; i < vetor1.length; i++) {
					vetor1[i] = Integer.parseInt(elementArray[i]);
				}
			}
			
			if (numLinhas == 1) {
			    vetor2 = new int[elementArray.length];

				for (int i = 0; i < vetor2.length; i++) {
					vetor2[i] = Integer.parseInt(elementArray[i]);
				}
			}

			numLinhas--;

			if (numLinhas == 0) {

				boolean ordenado1 = true;
				int i = 0;
				while (ordenado1 == true && i < vetor1.length - 1) {
					ordenado1 = false;
					if (vetor1[i] < vetor1[i + 1]) {
						ordenado1 = true;
					}
					i++;
				}

				 
	            boolean ordenado2 = true;
	            i = 0;
	           
				while (ordenado2 == true && i < vetor2.length - 1) {
					ordenado2 = false;
					if (vetor2[i] < vetor2[i + 1]) {
						ordenado2 = true;
					}
					i++;
				}

                
                int tamTotal = vetor1.length + vetor2.length;
				int[] z = new int[tamTotal];

				if(ordenado1 == true && ordenado2 == true){
                    z = intercala(vetor1, vetor2);
                    for (i = 0; i < tamTotal; i++){
                        System.out.printf("%d ", z[i]);
                    }
                    
				}

				if(ordenado1 == false || ordenado2 == false){
				   	System.out.println(-1);
				}

			}

		}

		input.close();

	}

}