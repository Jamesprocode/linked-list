package homework1;

import java.util.Random;

public class LinkedList <T> implements LinkedListInterface<T> {

	Node<T> head;
	Node<T> tail;
	

	@Override
	public int size() {
		Node<T> current = this.head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		} // when current becomes null, that means you are already outisde of list
		
		return count;	
	}
	
	
	@Override
	public String toString() {
		String list = "Head -> ";
		Node<T> current = this.head;
//		System.out.println(current.value);
//		System.out.println(current.next.value);
		while (current != null) {
			if (current.next == null) { 
				list = list + current.value + '\n' + "                          tail -> ";
			}
			else {
				list = list + current.value + " -> ";	
			}
			current = current.next;
		}
		Node<T> currentPrev = this.tail;
		while (currentPrev != null) {
			if (currentPrev.prev == null) {
				list = list + currentPrev.value;
			}
			else {
				list = list + currentPrev.value + " -> ";
			}
			currentPrev = currentPrev.prev;
		}	
//		System.out.println(list);
		return list;	
	}
	
	
	@Override
	public boolean isEmpty() {
		
		if (this.head == null) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	@Override
	public int add(T item) {
		Node<T> newNode = new Node<T>(item);
//		int count = 0;
		if (isEmpty()) {
			this.head = newNode;
			newNode.prev = null;
			this.tail = newNode;
		}
		else {
//			Node<T> current = this.head;
			// tail means .next is null
//			while (current.next != null) {
//				count++;
//				current = current.next;
//			} //when you are done with the loop, current is pointing
			// to the tail of the list
			Node<T> last = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
			newNode.prev = last;
			
		}
		return this.size();
	}
	
	
	@Override
	public void add(T item, int pos) { 
		if (pos < 0 || pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> newNode = new Node<T>(item);
		Node<T> current = this.head;
		// add to the front
		if (pos == 0) {	
			this.head = newNode;
			newNode.next = current;
			current.prev = newNode;
				
		}
		
		// add to the end
		else if (pos == this.size()) {
			Node<T> last = this.tail;
			this.tail.next = newNode;
			this.tail = newNode;
			newNode.prev = last;
					
		}
		else {

			for (int i  = 0 ;i < pos-1; i++) {
				current = current.next;
			}// stop right before the node at pos
		
			newNode.next = current.next;
			current.next.prev = newNode;
			current.next = newNode;
			newNode.prev = current;
			
		
		
		}
	}
	@Override
	public int contains(T item) {
		Node<T> current = this.head;
		int count = 0;
		while (current != null) {
			if (current.value == item) {
				return count;
			}
			current = current.next;
			count++;
		}

		return -1;
	}
	
	// int count
	// 
	@Override
	public T get(int pos) {
		//throw out of bounds for invalid pos
		if (pos < 0 || pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		//find node at pos
		T NodeAtPos = null;
		Node<T> current = this.head;
		for (int i  = 0 ;i < pos; i++) {
			current = current.next;
		}// stop right before the node at pos
		NodeAtPos = current.value;
		return NodeAtPos;
		
		
	}
	@Override
	public T remove(int pos) {
		//throw out of bounds for invalid pos
		if (pos < 0 || pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		T removed = this.get(pos);
		//if there is only one node in the list
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
			return removed;
		}

		//remove the head
		else if (pos == 0) {			
			this.head = this.head.next;
			this.head.prev = null;
			return removed;
		}
		//remove the tail
		else if (pos == this.size()-1) {
			this.tail = this.tail.prev;
			this.tail.next = null;
			return removed;
		}
		//remove in between
		else {
//			find the remove node in the list
			Node<T> current = this.head;
//			Node<T> removeNode = new Node<>(this.get(pos));
			//remove the node
			for (int i  = 0 ;i < pos; i++) {
				current = current.next;
			}
			current.next.prev = current.prev;
			current.prev.next = current.next;
//			removeNode.next.prev = removeNode.prev; 
//			removeNode.prev.next = removeNode.next; 
			
			return removed;
		}
	}

	@Override
	public int remove(T item) {
//		Node<T> current = this.head;
		Node<T> removeNode = new Node<>(item);
		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		}
		//remove the head
		if (removeNode == this.head) {			
			this.head = this.head.next;
			this.head.prev = null;
			return 0;
		}
		//remove the tail
		else if (removeNode == this.tail) {
			this.tail = this.tail.prev;
			this.tail.next = null;
			return this.size()-1;	
		}
		//does not contain
		else if (this.contains(item) == -1){
			return -1;
		}
		//remove in between
		else {
//			find the remove node in the list
			int pos = this.contains(item);
//			Node<T> removeNode = new Node<>(this.get(pos));
			//remove the node
			this.remove(pos);
//			for (int i  = 0 ;i < pos; i++) {
//				current = current.next;
//			}
//			current.next.prev = current.prev;
//			current.prev.next = current.next;
////			removeNode.next.prev = removeNode.prev; 
////			removeNode.prev.next = removeNode.next; 
//			
			return pos;
		}
	
	}
	@Override
	public void replace(T item, int pos) {
		if (pos < 0 || pos > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		this.remove(pos);
		this.add(item, pos);
	}
	@Override
	public boolean equals(LinkedList<T> list2) {
		Node<T> current = this.head;
		Node<T> current1 = list2.head;
		if (list2.isEmpty() || this.isEmpty()) {
			return false;
		}
		while(current != null && current1 != null) {
			if (current.value != current1.value) {
				return false;
			}
			current = current.next;
			current1 = current1.next;
		}
		return true;
	}
	@Override
	public LinkedList<T> combine(LinkedList<T> list2) {
//		Node<T> current = this.head;
//		Node<T> current1 = list2.head;
		LinkedList<T> combined = new LinkedList<T>();
		if (list2.isEmpty()) {
			combined.head = this.head;
			combined.tail = this.tail;
			return combined;
		}
		else if (this.isEmpty()) {
			return list2;
		}
		else {
		combined.head = this.head;
		this.tail.next = list2.head;
		list2.head.prev = this.tail;
		combined.tail = list2.tail;
		this.tail = combined.tail;
//		System.out.println(combined.tail.value);
		return combined;
		}
	}
	@Override
	public LinkedList<T> reverse() {
		if (isEmpty()) {
			return null;
		}
		LinkedList<T> reversed = new LinkedList<T>();
		reversed.head = null;
//		Node<T> reversedCurrent = reversed.head;
		Node<T> current = this.tail;
//		System.out.println(current.value);
		while (current != null) {
			
			reversed.add(current.value);
			current = current.prev;
			
//			reversedCurrent.next = current.prev;
//			reversedCurrent.next.prev = current;
//			current = current.prev;
//			reversedCurrent = reversedCurrent.next;
//			System.out.println(reversedCurrent.value);
		}
		return reversed;
	}
	
	public LinkedList<T> shuffles() {
		LinkedList<T> shuffle = new LinkedList<T>();
		int count = this.size();
		for (int i = 0; i < count; i++) {
//			System.out.println(current.next.value);
			Random random = new Random();
			int randomPos = random.nextInt(this.size());                                                            
//			System.out.println(randomPos);
			T addTolist = this.get(randomPos);
//			System.out.println(addTolist);
			shuffle.add(addTolist);
			this.remove(randomPos);
//			System.out.println(this);
//			System.out.println(current.next.value);

			
		}
//		shuffle.add(this.head.value);
		
		return shuffle;
	}

}
