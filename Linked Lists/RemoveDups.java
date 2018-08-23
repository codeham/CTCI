
public class RemoveDups {

	class Node{
		Node next = null;
		int element = 0;

		Node(int element){
			this.element = element;
		}
	}

  public static void main (String[] args) {
  	/** Sample Input  1 -> 2 -> 2 -> 6 -> 4 -> 4 -> 2 
		Sample Output 1 -> 2 -> 6 -> 4
  	**/
  	Node head = new Node(1);
  	// head.next = new Node(2);
  	// head.next.next = new Node(2);
  	// head.next.next.next = new Node(6);
  	// head.next.next.next.next = new Node(4);
  	// head.next.next.next.next.next = new Node(4);
  	// head.next.next.next.next.next.next = new Node(2);

  	// Node result = RemoveDups(head);

  	// // print test
  	// while(result != null){
  	// 	System.out.print(head.element + " ");
  	// 	result = result.next;
  	// }
  }

  public static Node RemoveDups(Node head){
  	HashSet<Integer> set = new HashSet<>();
  	Node curr = head;
  	Node prev = null;

  	while(curr != null){
  		if(!set.contains(curr.element)){
  			// add to list
  			set.add(curr.element);
  			/** shift pointers **/
  			prev = curr;
  			curr = curr.next;
  		}else{
  			/** connect prev pointer , delete element, assign current pointer **/
  			prev.next = curr.next;
  			curr.next = null;
  			curr = prev.next;
  		}
  	}
  	return head;
  }

}