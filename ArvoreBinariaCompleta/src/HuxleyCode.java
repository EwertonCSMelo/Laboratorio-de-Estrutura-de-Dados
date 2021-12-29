
/* Java program to cona binary tree from
the given String */
import java.util.*;


class HuxleyCode {

	static int min = Integer.MIN_VALUE;
	
	/*
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 */
	public static class Node {
	    int data;
	    Node left, right;
	    
	    Node(int data) {
	        this.data = data;
	    }
	}


	// static variable to point to the
	// starting index of the string.
	static int start = 1;

	// Construct Tree Function which accepts
	// a string and return root of the tree;
	static Node constructTree(String s) {

		// Check for null or empty string
		// and return null;
		if (s.length() == 0 || s == null) {
			return null;
		}

		if (start >= s.length())
			return null;

		// Boolean variable to check
		// for negative numbers
		boolean neg = false;

		// Condition to check for negative number
		if (s.charAt(start) == '-') {
			neg = true;
			start++;
		}

		// This loop basically construct the
		// number from the continuous digits
		int num = 0;
		while (start < s.length() && Character.isDigit(s.charAt(start))) {
			int digit = Character.getNumericValue(s.charAt(start));
			num = num * 10 + digit;
			start++;
		}

		// If string contains - minus sign
		// then append - to the number;
		if (neg)
			num = -num;

		// Create the node object i.e. root of
		// the tree with data = num;
		Node node = new Node(num);

		if (start >= s.length()) {
			return node;
		}

		// Check for open bracket and add the
		// data to the left subtree recursively
		if (start < s.length() && s.charAt(start) == '(') {
			start++;
			node.left = constructTree(s);
		}

		if (start < s.length() && s.charAt(start) == ')') {
			start++;
			return node;
		}

		// Check for open bracket and add the data
		// to the right subtree recursively
		if (start < s.length() && s.charAt(start) == '(') {
			start++;
			node.right = constructTree(s);
		}

		if (start < s.length() && s.charAt(start) == ')') {
			start++;
			return node;
		}
		return node;
	}

	// Print tree function
	public static void printTree(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + " ");
		printTree(node.left);
		printTree(node.right);
	}

	static /*
			 * Function to get the count of full Nodes in a binary tree
			 */
	public int getfullCount(Node root) {
		// If tree is empty
		if (root == null)
			return 0;

		// Initialize empty queue.
		Queue<Node> queue = new LinkedList<Node>();

		// Do level order traversal starting from root
		queue.add(root);

		int count = 0; // Initialize count of full nodes
		while (!queue.isEmpty()) {

			Node temp = queue.poll();
			if (temp.left != null && temp.right != null)
				count++;

			// Enqueue left child
			if (temp.left != null) {
				queue.add(temp.left);
			}

			// Enqueue right child
			if (temp.right != null) {
				queue.add(temp.right);
			}
		}
		return count;
	}
	
	static Vector<Integer> list = new Vector<>();
	
	 
	// Function to storage the nodes	
	public static void stoRoot(Node node) {
		if(node == null) {
			list.add(min);
			return; 	
		}
			
	    list.add(node.data);
	
	    stoRoot(node.left);	
	    stoRoot(node.right);
	}
	
	  public static int ileft(int index) {
	        return 2 * index + 1;
	    }

	    public static int iright(int index) {
	        return 2 * (index + 1);
	    }

	    public static int parent(int index) {
	        return (index-1)/2;
	    }
	
	// Function to storage the nodes	
		public static void printNode(int [] array) {
			int i = 0;
			
			while(ileft(i) < array.length || iright(i) < array.length) {
				
			System.out.println(array.length + " "+ ileft(i) + " " + array[ileft(i)] + " " + array[iright(i)]);
			if (array[ileft(i)] != min && array[iright(i)] == min)System.out.print(array[parent(ileft(i))] + " ");
			if (array[ileft(i)] == min && array[iright(i)] != min)System.out.print(array[parent(iright(i)) ]+ " "); 
			i++;
			}	
		
		}
	
	

	/*
	 * Given a binary tree, return true if the tree is complete else false
	 */
	static boolean isCompleteBT(Node root) {
		// Base Case: An empty tree is complete Binary Tree
		if (root == null)
			return true;

		// Create an empty queue
		Queue<Node> queue = new LinkedList<>();

		// Create a flag variable which will be set true
		// when a non full node is seen
		boolean flag = false;

		// Do level order traversal using queue.
		queue.add(root);
		while (!queue.isEmpty()) {
			Node temp_node = queue.remove();

			/* Check if left child is present */
			if (temp_node.left != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty left child, then the given tree is not
				// a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Left Child
				queue.add(temp_node.left);
			}
			// If this a non-full node, set the flag as true
			else
				flag = true;

			/* Check if right child is present */
			if (temp_node.right != null) {
				// If we have seen a non full node, and we see a node
				// with non-empty right child, then the given tree is not
				// a complete Binary Tree
				if (flag == true)
					return false;

				// Enqueue Right Child
				queue.add(temp_node.right);

			}
			// If this a non-full node, set the flag as true
			else
				flag = true;
		}
		// If we reach here, then the tree is complete Binary Tree
		return true;
	}

	
	   // Function to print all nodes of a given binary tree in a specific
    // order from top to bottom
    public static void printNodes(Node root)
    {
        // return if the tree is empty
        if (root == null) {
            return;
        }      
 
        // create two empty queues and enqueue root's left and
        // right child, respectively
        Queue<Node> first = new ArrayDeque<>();
        first.add(root.left);
 
        Queue<Node> second = new ArrayDeque<>();
        second.add(root.right);
 
        // loop till queue is empty
        while (!first.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int n = first.size();
 
            // process every node of the current level
            while (n-- > 0)
            {
                // dequeue front node from the first queue and print it
                Node x = first.poll();
                
                // enqueue left and right child of `x` to the first queue
                if (x.left != null && root.right == null) {                    
                    System.out.print(x.left.data + " ");
                }
 
                if (x.left == null && x.right !=null) {
                    first.add(x.right);
                }
 
                // dequeue front node from the second queue and print it
                Node y = second.poll();
 
              
 
                // enqueue right and left child of `y` to the second queue
                if (y.left == null && y.right != null) {
                    second.add(y.right);
                    System.out.print(y.data + " ");
                }
 
                if (y.left != null && y.right == null) {
                    second.add(y.left);
                }
            }
        }
    }
	
	
	
	// Driver Code
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// Input
		String s = "(33(9(0(1()())())(2(3()())(4()())))(11(5()(6()()))(8(7()())())))";
	    //String s = "(7(11(9()())(2()()))(13(0()())(1()())))";

		// Call the function cunstruct tree
		// to create the tree pass the string;
		Node root = constructTree(s);

		// Function to print preorder of the tree
		printTree(root);

		// int number_nodes = TotalNodes(root);
		System.out.println();
		if (isCompleteBT(root)) {
			System.out.println("completa");
		    System.out.println("total de nos: " + getfullCount(root));
		}
		else {
			System.out.println("nao completa");
			// Function calling
			 stoRoot(root);
			 int [] array = new int [list.size()];
			 int i = 0;
			 for(int value : list)
		        {
		          array[i] = value; 
		          i++;
		        }
	
			 System.out.println(list.size() + " " + array.length);
			 printNode(array);
		   
	 
		}

		System.out.println();		

	}
}

