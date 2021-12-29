import java.io.*;
import java.util.*;

public class HuxleyCode {
    
    public static int[] insertSortCrescente(int n, int array[]) {
		int numTrocas = 0;

		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] > key)) {
				array[i + 1] = array[i];
				i--;
				numTrocas++;
			}
			array[i + 1] = key;
		}

		return array;
	}
	
	public static int[] insertSortDecrescente(int n, int array[]) {
		int numTrocas = 0;

		for (int j = 1; j < n; j++) {
			int key = array[j];
			int i = j - 1;
			while ((i > -1) && (array[i] < key)) {
				array[i + 1] = array[i];
				i--;
				numTrocas++;
			}
			array[i + 1] = key;
		}

		return array;
	}
    
    
  public static void main(String args[]) {
      Scanner input = new Scanner(System.in);

		int i;
		int n =3;
		boolean ok = true;
		int[] array = new int[n];
		
		for (i = 0; i < n; i++ ) {
			 array[i]= input.nextInt();
			 if(array[i] < 0){
	                System.out.println("Ordenacao cancelada.");
	                ok = false;
	            } 
		}
		
		if(array[0] % 2 != 0 && ok == true){
		    array = insertSortCrescente(n, array);
		}
		else if(array[0] % 2 == 0 && ok == true){
            array = insertSortDecrescente(n, array);
		}

		if (ok == true){
		   for ( i = 0; i < n; i++ ) {
              System.out.println(array[i]);
           }
		}
  }
}