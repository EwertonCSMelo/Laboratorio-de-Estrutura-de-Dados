import java.io.*;
import java.util.*;

public class HuxleyCode {
    String digits = "0123456789ABCDEF";
    int decimal;
    int size;
    
    private Object element[];
    private int Top;

    public void ArrayStack(int initialCapacity) {
        if (initialCapacity < 1) {
            throw new IllegalArgumentException("initialCapacity must be>=1");
        }
        element = new Object[initialCapacity];
        Top = -1;
    }

    /**
     * @return true iff stack is empty
     */
    public boolean isEmpty() {
        return (Top == -1);
    }

    /**
     * remove top element of stack and return it
     *
     * @throws EmptyStackException when the stack is empty
     */
    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        Object topElement = element[Top];
        element[Top--] = null;
        return topElement;
    }

    /**
     * @return top element of stack
     * @throws EmptyStackException when the stack is empty
     */
    public Object peek() {
        return element[Top];
    }

    /**
     * add theElement to the top of the stack
     *
     * @param theElement
     */
    public void push(Object theElement) {
        if (Top == element.length - 1) {
            element = Arrays.copyOf(element,  2 * element.length);
        }
        element[++Top] = theElement;
    }


    public HuxleyCode(int n) {
    	ArrayStack(n);
        Scanner input = new Scanner(System.in);
        decimal = input.nextInt();
        size = 0;
    }

    /**
     * push the value to stack
     */
    public void setHex2Stack() {
        if (decimal == 0) {
            push(0);
        }
        while (decimal > 0) {
            int digit = decimal % 16;
            push(digits.charAt(digit));
            decimal = decimal / 16;
            size++;
        }
    }

    /**
     * @return hexadecimal string value
     */
    public String getHex() {
        String h = "";
        while (!isEmpty()) {
            h = h + pop();
        }
        return h;
    }

    public static void main(String args[]) {
        HuxleyCode d = new HuxleyCode(16);
        d.setHex2Stack();
        System.out.println(d.getHex());
    }

}


