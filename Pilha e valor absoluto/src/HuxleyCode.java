import java.io.*;
import java.util.*;

public class HuxleyCode {
	// Initial size of
    // the Array
    static int Max = 5;
     
    // Array for the stack
    // implementation
    static int[] arr = new int[Max];
     
    // Stores the minimum
    // Element of the stack
    static int minEle = 0;
    static int maxEle = Integer.MIN_VALUE;
     
    // Stores the top element
    // of the stack
    static int Top = 0;
       
    // Method to check whether
    // stack is empty or not
    static boolean isEmpty()
    {
        if (Top <= 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
	HuxleyCode() {
		Top = -1;
	}
    // Method to push elements
    // to the Special Stack
    void push(int x)
    {
        // If stack is empty
        if (Top >= -1) {
     
            // Assign x to minEle
            minEle = x;
            
            // Increment top by 1
            Top++;
     
            // Assign x to arr[top]
            arr[Top] = x;
     
          
        }
        // If array is full
        else if (Top == Max) {
     
            // Update the Max size
            Max = 2 * Max;
     
            int[] temp = new int[Max];
     
            // Traverse the array arr[]
            for (int i = 0; i < Top; i++) {
                temp[i] = arr[i];
            }
     
            // If x is less than minEle
            if (x < minEle) {
     
                // Push 2*x-minEle
                temp[Top] = 2 * x - minEle;
     
                // Assign x to minEle
                minEle = x;
     
                Top++;
            }
            // Else
            else {
     
                // Push x to stack
                temp[Top] = x;
                Top++;
            }
            // Assign address of the
            // temp to arr
            arr = temp;
        }
        else {
            // If x is less
            // than minEle
            if (x < minEle) {
     
                // Push 2*x-minEle
                arr[Top] = 2 * x - minEle;
                Top++;
     
                // Update minEle
                minEle = x;
            }
            else {
                // Push x to the
                // stack
                arr[Top] = x;
                Top++;
            }
        }
    }
    // Method to pop the elements
    // from the stack.
    int pop()
    {
        // If stack is empty
        if (isEmpty()) {
       //     System.out.print("Underflow");
            return 0;
        }
        // Stores the top element
        // of the stack
        int t = arr[Top - 1];
     
        // If t is less than
        // the minEle
        if (t < minEle) {
            // Pop the minEle
            //System.out.println("Popped element : " + minEle);
     
            // Update minEle
            minEle = 2 * minEle - t;
        }

        Top--;
        return arr[Top + 1];
    }
     
    // Method to find the topmost
    // element of the stack
    static int peek()
    {
        // If stack is empty
        if (isEmpty()) {
            //System.out.println("Underflow");
            return -1;
        }
     
        // Stores the top element
        // of the stack
        int t = arr[Top - 1];
     
        // If t is less than
        // the minEle
        if (t < minEle) {
            return minEle;
        }
        // Else
        else {
            return t;
        }
    }


	static int getMax() {
		int aux = peek();
	    if (aux > maxEle) maxEle = aux;  
		return maxEle;
	}

	 // Method to find the Minimum
    // element of the Special stack
    static int getMin()
    {
        // If stack is empty
        if (isEmpty()) {
            //System.out.println("Underflow");
            return -1;
        }
        // Else
        else {
            return minEle;
        }
    }
    
    int abs()
    {  
       maxEle = getMax();
       minEle = getMin();            
       return (int)Math.abs(maxEle - minEle);
    }
    
    

	/* Driver program to test twStacks class */
	public static void main(String[] args) {
		int numero = 0;
		String comando = "";
		Scanner input = new Scanner(System.in);
		String rowValues = null;
		HuxleyCode ts = new HuxleyCode();

		while (input.hasNext()) {
			rowValues = input.nextLine();
			String[] elementArray = rowValues.split(" ");
			comando = elementArray[0];
			
			
			if (elementArray.length > 1) {
				numero = Integer.parseInt(elementArray[1]);
			}
			
			if (comando.equalsIgnoreCase("push") == true) {
				ts.push(numero);
			}

			if (comando.equalsIgnoreCase("pop") == true) {
				int desempilhado = ts.pop();
				System.out.print(desempilhado);
			}

			if (comando.equalsIgnoreCase("abs") == true) {				
				System.out.println(ts.abs());
			}

		}
		input.close();
	}

}
