import java.io.*;
import java.util.*;
import java.io.IOException;
import java.util.Scanner;

public class HuxleyCode {
	// function to sort the given matrix
	static void sortMat(int mat[][], int n) {
		// temporary matrix of size n^2
		int temp[] = new int[n * n];
		int k = 0;

		// copy the elements of matrix
		// one by one into temp[]
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				temp[k++] = mat[i][j];

		// sort temp[]
		Arrays.sort(temp);

		// copy the elements of temp[]
		// one by one in mat[][]
		k = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				mat[i][j] = temp[k++];
	}

	// function to print the given matrix
	static void printMat(int mat[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(mat[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int M;
		int N;

		M = input.nextInt();
		N = input.nextInt();

		int[][] matriz = new int[M][N];

		for (int i = 1; i <= M; i++) {
			for (int j = 1; j <= N; j++) {
				matriz[i][j] = input.nextInt();

			}
		}
		sortMat(matriz, N);
		printMat(matriz, N);
		

	}

}
