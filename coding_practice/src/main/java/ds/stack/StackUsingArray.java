package ds.stack;

public class StackUsingArray {

	private int[] array;
	private int top;
	private int capacity;

	StackUsingArray(int capacity) {

		this.array = new int[capacity];
		this.top = -1; // initially stack is empty
		this.capacity = capacity;
	}

	public void push(int element) {
		if (isFull()) {
			throw new RuntimeException("Stack is full");
		}
		array[++top] = element;
	}

	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return array[top--];
	}

	public int peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return array[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == capacity - 1;
	}
}
