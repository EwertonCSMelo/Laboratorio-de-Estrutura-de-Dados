
import java.io.*;
import java.util.*;

public class HuxleyCode {

	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		int tam1 = input.nextInt();
		int tam2 = input.nextInt();
		int fila = input.nextInt();

		int[] arr1 = new int[tam1];
		int[] arr2 = new int[tam2];
		int tam3 = arr1.length + arr2.length;
		int[] arrFinal = new int[tam1 + tam2];

		for (int i = 0; i < arr1.length; i++) {

			arr1[i] = input.nextInt();

		}

		for (int i = 0; i < arr2.length; i++) {

			arr2[i] = input.nextInt();

		}

		if (fila == 1) {
			mergeArr(arr2, tam2, arr1, tam1, arrFinal, tam3);

		} else if (fila == 2) {
			mergeArr(arr1, tam1, arr2, tam2, arrFinal, tam3);
		}

		printArr(arrFinal);
		
		input.close();

	}

	public static void mergeArr(int[] arr1, int tam1, int[] arr2, int tam2, int[] arrFinal, int tamFinal) {
		int j = 0;
		int i = 0;

		for (i = 0; i < tamFinal && j < tam1 && j < tam2; i += 2) {

			arrFinal[i] = arr1[j];
			arrFinal[i + 1] = arr2[j];
			j++;

		}
		i = 0;
		j = 0;

		if (tam1 < tam2) {

			for (i = tam1, j = tam1 * 2; j < tamFinal; j++, i++) {

				arrFinal[j] = arr2[i];

			}
		} else if (tam2 < tam1) {

			for (i = tam2, j = tam2 * 2; j < tamFinal; j++, i++) {

				arrFinal[j] = arr1[i];

			}
		}
	}

	public static void printArr(int[] arr) {

		for (int i = 0; i < arr.length; i++) {

			System.out.println(arr[i]);

		}

	}
}
