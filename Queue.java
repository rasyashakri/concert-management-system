public class Queue<E> extends LinkedList<E> {

	public Queue() {}

	public void enqueue (E e) {
		addLast(e);
	}

	public E dequeue() {
		return removeFirst();
	}

	public E getFront() {
		return getHead();
	}

	public int size() {
		return getSize();  // Returns the number of elements in the queue
    }
}


