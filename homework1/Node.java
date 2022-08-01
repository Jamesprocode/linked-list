package homework1;

public class Node <T> { // tell your program that 
	//I am using generic types
	
	T value;
	Node<T> next;
	Node<T> prev;
	
	public Node (T value) {
		this.value = value;
	}

}
