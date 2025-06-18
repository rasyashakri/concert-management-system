public class LinkedList <E> {

	Node<E> head;
	private Node<E> current, tail;
	private int size = 0;

	public LinkedList()
	{
		head = tail = current = null;
	}

	//addFirst()
	public void addFirst(E data) {

		Node<E> newNode = new Node<E> (data);
		newNode.next = this.head;
		this.head = newNode;

		if (this.tail == null) {
		    this.tail = this.head;
		}
		size++;
	  }

	//addLast()
     public void addLast(E data) {

         Node<E> newNode = new Node<E> (data);

         if (this.tail == null) {
             this.head = this.tail = newNode;
         }
         else {
             this.tail.next = newNode;
             this.tail = this.tail.next;
         }
         current = head;
	     size++;
	 }

	//getHead()
	public E getHead() {
		if (this.head == null) {
			return null;
		}
		else {
			this.current = this.head;
			return this.current.data;
		}
	}


	//getTail()
	public E getTail() {
        if (this.isEmpty()) {
            return null;
        }
        else {
            return tail.data;
        }
    }

	//getNext()
	public E getNext()
    {
        if (current == tail) {
            return null;
        }
        else {
            current = current.next;
            return current.data;
        }
    }


    // getDetails()
    public void getDetails() {
        if (head == null)
        {
            System.out.println("List is empty.");
            return;
        }

        Node <E> temp = head;
        while (temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // isEmpty()
    public boolean isEmpty() {
        return head == null;
    }

	 //removeFirst()
   	 public E removeFirst() {

		if (this.head == null) {
			return null;
		}
		else {
			this.current = this.head;
			this.head = this.head.next;

			if (this.head == null) {
				this.tail = null;
			}
			size--; // Decrement the size of the list
            return current.data; // Return the data of the removed node
		}
	}

    // removeLast()
    public E removeLast() {
        if (this.isEmpty())
            return null;

        if (this.head == this.tail) {
            E data = this.head.data;
            this.head = this.tail = null;
            return data;
        }

        Node<E> current = this.head;
        while (current.next != this.tail) {
            current = current.next;
        }

        E data = this.tail.data;
        this.tail = current;
        this.tail.next = null;
        size--;
        return data;
    }

    //getSize()
	public int getSize()
	{
	    return size;
    }
}
