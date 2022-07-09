package ds.Array;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {

	private T[] arr;

	private int capacity = 0;

	private int len = 0;

	public DynamicArray(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Illegal capacity: " + capacity);
		this.capacity = capacity;
		this.arr = (T[]) new Object[capacity];
	}

	public int size() {
		return len;
	}

	public boolean isEmpty() {
		return size() == capacity;
	}

	public T get(int index) {
		if (index >= capacity)
			throw new ArrayIndexOutOfBoundsException("index is more than or equal to capacity");
		return arr[index];
	}

	public void clear() {
		arr = null;
		len = 0;
	}

	public void add(int index, T item) {
		if (index >= capacity || index < 0)
			throw new ArrayIndexOutOfBoundsException("index is more than or equal to capacity");
		arr[index] = item;
	}

	public void add(T item) {

		if (!isEmpty()) {// create new array of larger size and add copy old array to it
			T[] arr_new = newArray();
			for (int i = 0; i < len; i++) {
				arr_new[i] = this.arr[i];
			}
			arr = arr_new;

		}
		arr[len++] = item;

	}

	// Remove element at specific index
	public T removeAt(int rm_index) {
		if (rm_index >= capacity || rm_index < 0)
			throw new IndexOutOfBoundsException("index is more than or equal to capacity");
		T data = arr[rm_index];
		/*
		T[] arr_copy = (T[]) new Object[len - 1];
		for (int i = 0, j = 0; i < len; i++, j++) {
			if (i == index)
				j--; // skip over the index by fixing j temporarily
			else
				arr_copy[j] = arr[j];
		}
		arr = arr_copy;
		
		*/

		// shift all elements to left by one position starting from rm_index.
		for (int i = rm_index; i < len; i++) {
			arr[i] = arr[i + 1];
		}

		capacity = --len;

		return data;
	}

	public boolean remove(Object obj) {
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(obj)) {
				removeAt(i);
				return true;
			}
		}
		return false;
	}

	public int indexOf(Object obj) {
		for (int i = 0; i < len; i++) {
			if (arr[i].equals(obj))
				return i;

		}
		return -1;
	}

	public boolean contains(Object obj) {

		return indexOf(obj) != -1;
	}

	public T[] newArray() {
		this.capacity = capacity * 2;
		return (T[]) new Object[capacity];

	}

	public static void main(String args[]) {
		DynamicArray<Integer> d = new DynamicArray<>(3);
		System.out.println(d.capacity);
		for (int i = 0; i < 10; i++) {
			d.add(i + 1);
		}
		System.out.println(d.len);
		d.add(d.len++, 20);
		System.out.println(d.len);
		System.out.println(d.get(d.len - 1));
		System.out.println(d.contains(20));
		System.out.println(d.indexOf(20));
		System.out.println(d.capacity);
		// System.out.println(d.get(d.capacity));
		System.out.println(d.removeAt(0));
		d.clear();
		System.out.println(d.len);

	}
}
