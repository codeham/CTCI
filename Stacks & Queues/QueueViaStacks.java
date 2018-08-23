/** Queue via stacks: Implement a MyQueue class which implements a queue using two stacks

	Queue - queue is stack that prioritizes order (FIFO . ex. - checkout line)
	Enque - Elements being added from the back of the queue
	Deque - Elements being removed from the front of the queue

	3 Items [A] [B] [C]
	
	Enque(C)

	[C]

	Enque(A)

	[C]   <- [A]
	[C][A]

	Enque(B)
	[C][A][B]
	
	Deque()
	[A][B]


**/
import java.util.stack;

public class QueueViaStacks{
	/** Attributes
		2 Stacks
	**/
	private static class Node{
		Node next;
		int data;

		Node(int data){
			this.data = data;
		}
	}

	private Stack<Node> stack1;
	private Stack<Node> stack2;

	QueueViaStacks(){
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	/** Methods
		Enqueue(n) - adds element from the back of the queue
		Dequeue()  - removes element from the front of the queue
	**/
	public void add(int n){

		// case where stack 1 is empty and stack 2 isn't (optimal mode)
		// stack1 is empty , and stack 2 has data inside of it
		shiftStacks();
		Node x = new Node(n);
		stack1.push(x);
	}

	public Node remove(){

		/** if stack2 is empty, pop all data from stack1 onto stack2 and remove the top:O(n)
		 	if stack2 is populated, just simply keep removing from stack2, a continuous
			pattern of remove() calls yields an O(1) removal instead of O(n)
		**/
		shiftStacks();
		// return the item at the top of stack 2
		Node x = stack2.pop();
		return x;
	}

	public void shiftStacks(){
		/** helper method that shifts items to opposite stacks **/
		if(stack1.isEmpty()){
			// shift items to stack2
			while(stack1.size() != 0){
				Node temp = stack1.pop();
				stack2.push(temp);
			}
		}else{
			// shift items to stack1
			while(stack2.size() != 0){
				Node temp = stack2.pop();
				stack1.push(temp);
			}
		}
	}

	public int size(){
		/** returns size of stack(s) **/
		return stack1.size() + stack2.size();
	}

	public void peek(){
		/** ensure that stacks are well shifter **/
		// peek() the item at the top of the 2nd stack, this being the head of queue
		shiftStacks();
		return stack2.peek();
	}
}
