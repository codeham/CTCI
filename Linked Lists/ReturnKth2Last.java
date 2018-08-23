/**2.2 Given a Linked List and a number n, write a function that returns the
 value at the n’th node from end of the Linked List.**/
public class ReturnKth2Last {

	class Node{
		Node next = null;
		String element = "";

		Node(String element){
			this.element = element;
		}
	}

  public static void main (String[] args) {
  	/** Sample Input:  1 -> 2 -> 3 , k = 1
		    Sample Output: 3

        Sample Input:  1 -> 2 -> 5 -> 9, k = 3
        Sample Output: 2
  	**/
  	Node head = new Node("A");
  	head.next = new Node("B");
  	head.next.next = new Node("C");
  	head.next.next.next = new Node("D");

  	String result = K2Last(head, 3);
    // expected output: "B"

  	// // print test
    System.out.println(result);
  }

  public static String K2Last(Node head, int k){

    // find the size of the list
    Node curr = head;
    int size = 0;

    while(curr != null){
      size++;
      curr = curr.next;
    }

    // reset the pointer to the head
    curr = head;

    int limit = size - k;

    if(limit == size){
      // return the head
      return head.element;
    }

    for(int i = 0; i < limit; i++){
      // shift the pointer up until before the limit index
      curr = curr.next;
    }
    return curr.element;
  }

}