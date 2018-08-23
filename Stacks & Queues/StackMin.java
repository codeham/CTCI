/** Stack Min: How would you design a stack which, in addition to push and pop,
has a function min which returns the minumum element ?
Push, pop and min should all operate in O(1) time.

Stack - LIFO(stack of pancakes)
Push(N) - Pushes N to the top of the stack
Pop()   - Returns element at the top, and removes from stack
Min()   - Return min. element in the stack

**/

public class StackMin extends Stack<StackNode>{
	public static class StackNode{
		int data;
		int currMin;

		StackNode(int data){
			this.data = data;
		}
	}

	// attributes for StackMin implementation
	int min;
	StackNode topStack;

	StackMin(){
		min = 0;
	}
	/** Push(StackNode n)
	**/
	public static void push(int n){
		// edge case , stack is full
		if(isFull()){
			// throw exception
		}

		// edge case, first Node being pushed onto the stack
		if(size == 0){
			min = n.data;
		}

		// checking if element is smaller or equal to min
		if(n.data <= min){
			min = n.data;
		}

		// pushing
		StackNode sn = new StackNode(n);
		sn.currMin = min;
		sn.next = topStack;
		topStack = sn;
	}
	/** pop() **/
	public static int pop(){
		if(isEmpty()){
			//throw exception, empty stack
		}

		int item = topStack.data;
		
		// edge case: one Node left in the Stack, reset min back to 0
		if(size == 1){
			min = 0;
		}

		// determine our new min (if applicable)
		if(item == min){
			// assign prev min to min
			min = topStack.currMin;
		}

		topStack = topStack.next;

		return item;
	}

	public static int getMin(){
		return min;
	}
}