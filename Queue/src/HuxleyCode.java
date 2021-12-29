import java.io.*;
import java.util.*;

public class HuxleyCode {

	private int capacity;
	int queueArr[];
	int front;
	int rear;
	int currentSize = 0;

	public HuxleyCode(int sizeOfQueue) {
		this.capacity = sizeOfQueue;
		front = 0;
		rear = -1;
		queueArr = new int[this.capacity];
	}

	/**
	 * this method is used to add element in the queue
	 * 
	 * @param data
	 */
	public void enqueue(int data) {
		if (isFull()) {
			queueArr = Arrays.copyOf(queueArr, 2 * queueArr.length);
		} else {
			rear++;
			if (rear == capacity - 1) {
				rear = 0;
			}
			queueArr[rear] = data;
			currentSize++;
		}
	}

	/**
	 * This method removes an element from the front of the queue
	 */
	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty!! Can not dequeue element");
		} else {
			front++;
			if (front == capacity - 1) {
				// System.out.println(queueArr[front - 1] + " removed from the queue");
				front = 0;
			} else {
				// System.out.println(queueArr[front - 1] + " removed from the queue");
			}
			currentSize--;
		}
	}

	/**
	 * This method is use to check if element is full or not
	 * 
	 * @return boolean
	 */
	public boolean isFull() {
		if (currentSize == capacity) {
			return true;
		}
		return false;
	}

	/**
	 * This method is use to check if element is empty or not
	 * 
	 * @return
	 */
	public boolean isEmpty() {

		if (currentSize == 0) {
			return true;
		}
		return false;
	}
	
	// print queue elements
		 void display()
		{
			int i;
			if (front == rear) {
				System.out.printf("\nQueue is Empty\n");
				return;
			}

			// traverse front to rear and print elements
			for (i = front; i < rear; i++) {
				System.out.printf(" %d <-- ", queueArr[i]);
			}
			return;
		}

	public static void main(String a[]) {
		int id = 0;
		int idade = 0;
		int n = 0;
		int cont = 0;

		String comando = "";
		Scanner input = new Scanner(System.in);
		String rowValues = null;

		HuxleyCode idosos = new HuxleyCode(5);
		HuxleyCode idIdosos = new HuxleyCode(5);
		HuxleyCode naoIdosos = new HuxleyCode(5);
		HuxleyCode idNaoIdosos = new HuxleyCode(5);

		n = input.nextInt();

		while (!comando.equalsIgnoreCase("f")) {
			rowValues = input.nextLine();
			String[] elementArray = rowValues.split(" ");

			if (elementArray.length == 1) {
				comando = elementArray[0];
			}

			if (elementArray.length > 1) {
				id = Integer.parseInt(elementArray[0]);
				idade = Integer.parseInt(elementArray[1]);
			}

			if (comando.equalsIgnoreCase("a") == true && idade > 60) {
				idIdosos.enqueue(id);
				idosos.enqueue(idade);
			}

			if (comando.equalsIgnoreCase("a") == true && (idade <= 60)) {
				idNaoIdosos.enqueue(id);
				naoIdosos.enqueue(idade);				
			}

			if (comando.equalsIgnoreCase("r") == true) {
				if (idosos.isEmpty() == false && cont <= n || naoIdosos.isEmpty() == true) {
					idosos.dequeue();
					idosos.dequeue();
					cont++;
				} else {
					naoIdosos.dequeue();
					idNaoIdosos.dequeue();
				}
			}

			if (cont == n)
				cont = 0;

			if (comando.equalsIgnoreCase("i") == true) {
				System.out.println("fila de idosos:");
				for (int i = idosos.front; i < idosos.rear; i++) {
					if (idosos.isEmpty() == false) {
						System.out.print("ID: " + idIdosos.queueArr[i] + " ");
						System.out.print("IDADE: " + idosos.queueArr[i] + "\n");
					} else {
						System.out.print("fila vazia!\n");
					}

				}
				System.out.println("fila de nao-idosos:");
				for (int i = naoIdosos.front; i < naoIdosos.rear; i++) {
					if (naoIdosos.isEmpty() == false) {
						System.out.print("ID: " + idNaoIdosos.queueArr[i] + " ");
						System.out.print("IDADE: " + naoIdosos.queueArr[i] + "\n");
					} else {
						System.out.print("fila vazia!\n");
					}
				}
				System.out.println("----------");
				System.out.println();
			}

		}
		input.close();
	}

}