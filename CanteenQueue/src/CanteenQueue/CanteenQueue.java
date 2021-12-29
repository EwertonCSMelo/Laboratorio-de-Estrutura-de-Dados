package CanteenQueue;

import java.util.*;

public class CanteenQueue {

	public static int insertSort(int n, int array[]){
		int numTrocas = 0;
			
	      for (int j = 1; j < n; j++) {  
	            int key = array[j];  
	            int i = j-1;  
	            while ( (i > -1) && ( array [i] < key ) ) {  
	                array [i+1] = array [i];  
	                i--; 
	                numTrocas++;
	            }  
	            array[i+1] = key;  
	        } 
	      
	      return n-numTrocas;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		int numTrocas;
		System.out.print("Digite a quantidade total de alunos 1 - 1000: ");
		n= input.nextInt();
		int[] array = new int [n];
		for (int i = 0; i<n; i++ ) {
			System.out.print("Digite a nota do aluno: ");
			array[i]= input.nextInt(); 
		}
		
		numTrocas = insertSort(n, array);
		
		System.out.printf("Número de trocas: %d", numTrocas); 
				
	}

}
