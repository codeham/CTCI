/** 3.3 Stack of Plates 
 * imagine a (literal) stack of plates. If the stack gets too high, it might topple. 
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds
 * some threshold. Implement a data structure SetOfStacks that mimics this. 
 * SetOfStacks should be composed of several stacks, and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should
 * behave identically to a single stack (that is, pop() should return the same values as it
 * would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific
 * sub-stack.
 **/

public class SetOfStacks{
	public static class Node(){
		int data;
		Node next;

		Node(int data){
			this.data = data;
		}
	}
	// attributes
	private int maxSize;
	private int stackSize;
	Node top;
	Node prevTop;
	List<SetOfStacks> stacks = new ArrayList<>();

	SetOfStacks(int limit){
		this.maxSize = limit;
	}

	// push()
	public void push(int val){
		// case: maximum has been met for the stack
		if(stackSize == maxSize){
			// create new stack and keep track of previous stack pointer
			SetOfStacks newStack = new SetOfStacks(maxSize);
			newStack.prev = top;
			newStack.push(val);
			// add new stack to list
			tracks.add(newStack);
		}
		// default behavior, push to stack
		Node item - new Node(val);
		item.next = top;
		top = item;
	}

	public int pop(){
		// empty stack 
		if((size == 0) && (stacks.size != 0)){
			top = this.prev;

			list.remove(list.size-1);
		}
	}
}