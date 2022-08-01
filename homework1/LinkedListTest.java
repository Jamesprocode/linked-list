package homework1;

public class LinkedListTest  {
	
	public static void main(String[] args) {
	Node<String> n1 = new Node<>("Node 1");
	LinkedList<String> strlist = new LinkedList<>();
	LinkedList<String> comstr = new LinkedList<>();
	
	LinkedList<Integer> list = new LinkedList<>();
	LinkedList<Integer> comList = new LinkedList<>();
	LinkedList<Integer> empty = new LinkedList<>();
	
//  test int list add	
	list.add(0);
	list.add(1);
	list.add(2);
	list.add(4);
	comList.add(0);
	comList.add(1);
	comList.add(2);
	comList.add(4);
	
	//equals
	System.out.println("test list and comList equal: " + list.equals(comList)); //true

	//add
	System.out.println("test list original: " + list);
	
	//contains
	System.out.println("test list contains(return int -1): " + list.contains(3)); // -1
	
	// 2 add
	list.add(3, 3);
	
	//contains
	System.out.println("test list contains after add(return int 3)" + list.contains(3));
	
	//2 add
	System.out.println("test list add(item, pos): " + list);
	
	//get
	System.out.println("test list get(return 0): " + list.get(0));
	
	//remove
	System.out.println("test list remove(pos return 2): " + list.remove(2));
	System.out.println("test list after remove: " + list);	
	//2remove
	System.out.println("test list after remove(T return 3): " + list.remove(3));
	System.out.println("test list after remove(T)" + list);
	
	//replace
	list.replace(5, 0);
	System.out.println("test list after replace: " + list);
//	empty.replace(0, 0);
	
	//equals
	System.out.println("test list and comList equal: " + list.equals(comList)); //false
	System.out.println("test list and empty equal: " + list.equals(empty));//false
	
	//reverse
	System.out.println("test list reversed: " + list.reverse());
	
	//combine
	System.out.println("test list and comList combine: " + list.combine(comList));
//	System.out.println(list);
	System.out.println("test list and empty combine: " + list.combine(empty));
	
	//reverse
	System.out.println("test list reversed: " + list.reverse());
	System.out.println(empty.reverse());

	
 // test string list
	strlist.add("a");
	strlist.add("b");
	strlist.add("c");
	strlist.add("d");
	strlist.add("e");
	comstr.add("a");
	comstr.add("b");
	comstr.add("c");
	comstr.add("d");
	System.out.println("test strlist original: " + strlist);
	
	//equals
	System.out.println("test strlist equals: " + strlist.equals(comstr));//true
	
	//reverse
	System.out.println("test strlist reverse: " + strlist.reverse());
	
	//remove
	System.out.println("test strlist remove: " + strlist.remove("a"));
	System.out.println("test strlist after remove: " + strlist);
	
	//2 remove
	System.out.println("test strlist 2 remove: " + strlist.remove(2)); // remove d
	System.out.println("test strlist 2 after remove: " + strlist);
	
	//combine
	System.out.println("test strlist combine comstr: " + strlist.combine(comstr));
	System.out.println("test strlist: " + strlist);
	//get
	System.out.println("test strlist get: " + strlist.get(0));
	
	//reverse
	System.out.println("test strlist reversed: " + strlist.reverse());
	System.out.println(empty.reverse());
	
	//shuffle
	System.out.println("test strlist shuffle: " + strlist.shuffles());
	}
}	
