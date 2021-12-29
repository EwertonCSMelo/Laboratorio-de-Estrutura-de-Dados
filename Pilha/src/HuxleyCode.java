import java.io.*;
import java.util.*;

public class HuxleyCode {
	static final int MAX = 1000;
	static int top;
	static int a[] = new int[MAX]; // Maximum size of Stack

	boolean isEmpty() {
		return (top < 0);
	}

	HuxleyCode() {
		top = -1;
	}

	// Method to push an element
	// x to stack2
	void push(int x) {

		// There is at least one empty
		// space for new element
		if (top >= -1) {
			top++;
			a[top] = x;
		} else {
			System.out.print("Stack Overflow" + " By element :" + x + "\n");
			return;
		}
	}

	int pop() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top--];
			return x;
		}
	}

	int peek() {
		if (top < 0) {
			System.out.println("Stack Underflow");
			return 0;
		} else {
			int x = a[top];
			return x;
		}
	}

	void print() {
		for (int i = top; i > -1; i--) {
			if (i > 0) {
				System.out.print(a[i] + " ");
			} else {
				System.out.print(a[i] + "\n");
			}
		}
	}

	/* Driver program to test twStacks class */
	public static void main(String[] args) {
		int numero = 0;
		String comando = "";
		Scanner input = new Scanner(System.in);
		String rowValues = null;
		HuxleyCode ts = new HuxleyCode();

		while (!comando.equalsIgnoreCase("Finalizar")) {
			rowValues = input.nextLine();
			String[] elementArray = rowValues.split(" ");
			comando = elementArray[0];
			if (elementArray.length > 1) {
				numero = Integer.parseInt(elementArray[1]);
			}		

			if (comando.equalsIgnoreCase("Empilhar") == true) {				
				ts.push(numero);
			}

			if (comando.equalsIgnoreCase("Desempilhar") == true) {				
				ts.pop();
			}

			if (comando.equalsIgnoreCase("Imprimir") == true) {
				ts.print();
			}

		}
		input.close();
	}

}
