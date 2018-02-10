// Integer Stack
import java.util.Scanner;
public class intStack {
	private Node first; // top of the stack
	private int size; // size of list
	public int sum;
	
	static class Node{ // constructor
		public int item;
		public Node next;
		public Node(int item, Node next) {
			this.item = item;
			this.next = next;
		}
	}

	public boolean isEmpty() { // checks if the list is empty
		return(first == null); 
	}
	
	public int size() { // returns size of the list
		return(size);
	}
	
	public int sum() { // returns sum of list
		return(sum);
	}

	public void push(int item) { // adds item to the stack
		Node oldFirst = first;
		first = new Node(item, first); // adds item to first 
		first.next = oldFirst; // connects first to oldFirst
		size++;
		sum += first.item;
	}
	
	public int pop() {
		int item = first.item; // save item to return
		sum -= item;
		first = first.next; // deletes first node
		size--; // decrease size of list
		return(item);
	}

	public String toString() { // purpose: output into a string
		StringBuilder result = new StringBuilder("[ ");
		for(Node x = first; x != null; x = x.next) { 
			result.append(x.item);
			if(x.next == null) {
				result.append(" ");
			}
			else {
				result.append(", ");
			}
		}
		result.append("]");
		return(result.toString());
	}

	public static intStack maker() {
		intStack result = new intStack();
		result.first = null; //list starts empty

		return result;
	}
	
	public static void main(String[] arg) {
		intStack iStack = intStack.maker(); // returned string
		@SuppressWarnings("resource")
		Scanner sizeInput = new Scanner(System.in);
		@SuppressWarnings("resource")
		Scanner numInput = new Scanner(System.in);
		
		System.out.print("How many numbers do you want to input?: ");
		int len = sizeInput.nextInt(), x = 0;
		if(len != 0) {
			for(int i = 0; i < len; i++) {
				System.out.print("Enter a number: ");
				x = numInput.nextInt();
				iStack.push(x);
			}
			System.out.println(iStack.pop() + " was just popped"); 
		}
		
		System.out.println("\nIs the list empty? " + iStack.isEmpty());
		System.out.println("List: "+ iStack);
		System.out.println("Size = " + iStack.size());
		System.out.println("Sum = " + iStack.sum());
	}
}
