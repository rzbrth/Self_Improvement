package ds.queue;

import java.util.Stack;


/*
 * Keep 2 stacks, let's call them newStack and oldStack.

Enqueue:

Push the new element onto newStack
Dequeue:

If oldStack is empty, refill it by popping each element from newStack and pushing it onto oldStack

Pop and return the top element from oldStack

Using this method, each element will be in each stack exactly once
- meaning each element will be pushed twice and popped twice, giving amortized constant time operations.
https://stackoverflow.com/questions/69192/how-to-implement-a-queue-using-two-stacks
 */
public class QueueUsingTwoStacks<T> {

	Stack<T> newStack = new Stack<>();
	Stack<T> oldStack = new Stack<>();
	
	
	public boolean isEmpty() {
		return newStack.isEmpty();
	}
	public void enqueue(T item) {
		
		newStack.push(item);
	}
	
	public T dequeue() { // Get oldest item and remove it
		
		if(oldStack.isEmpty()) {
			while(!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
		return oldStack.pop();
	}
	
	public T peek() {//Get oldest item without removing
		
		if(isEmpty()) {
			throw new RuntimeException("Queue is empty");
		}
		if(oldStack.isEmpty()) {
			while(!newStack.isEmpty()) {
				oldStack.push(newStack.pop());
			}
		}
		return oldStack.peek();
	}
	
	 public static void main(String[] args) {
		 QueueUsingTwoStacks<Integer> queue = new QueueUsingTwoStacks<>();

		 System.out.println("I Empty: " + queue.isEmpty());
	        // enqueue integers 1..3
	        for(int i = 1; i <= 3; i++)
	            queue.enqueue(i);
	        
	        // execute peek operations 
	            System.out.println("Peeked: " + queue.peek());

	        // execute 2 dequeue operations 
	        for(int i = 0; i < 2; i++)
	            System.out.println("Dequeued: " + queue.dequeue());

	        // enqueue integers 4..5
	        for(int i = 4; i <= 5; i++)
	            queue.enqueue(i);

			 System.out.println("I Empty: " + queue.isEmpty());

	        // dequeue the rest
	        while(!queue.isEmpty())
	            System.out.println("Dequeued: " + queue.dequeue());
	    }
}
