// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - GenericQueue class

public class GenericQueue<T> extends GenericList<T> {
	private Node<T> tail;  
	
	// getters/setters
	public Node<T> getTail() {
		return this.tail;
	}
	
	public void setTail(Node<T> tail) {
		this.tail = tail;
	}
	
	// Constructor 
	public GenericQueue(T value) {
        Node<T> newNode = new Node<>(value);
        setHead(newNode);
        this.tail = newNode;
        setLength(1);
	}
	
	// Constructor with code
	public GenericQueue(T value, int code) {
		Node<T> newNode = new Node<>(value, code);
        setHead(newNode);
        this.tail = newNode;
        setLength(1);
    }
	
	// Add node to the end of the queue
	@Override
	public void add(T data) {
		Node<T> node = new Node<T>(data);
		//set head and tail if node don't exist
		if (getHead() == null) 
		{
			setHead(node);
			tail = node;
			setLength(getLength() + 1);
		} 
		//add at the tail
		else {
			tail.next = node;
			tail = node;
			setLength(getLength() + 1);
		}
	}
	
	// Add node with data and code to end of queue
	public void add(T value, int code) 
	{
	    Node<T> node = new Node<>(value, code);
	  //set head and tail if node don't exist
	    if (getHead() == null) 
		{
			
			setHead(node);
			tail = node;
			setLength(getLength() + 1);
		} 
	    //add to tail
		else {
			tail.next = node;
			tail = node;
			setLength(getLength() + 1);
		}
	}
	
	// Delete node - FIFO 
	@Override
	public T delete() {
		if (getHead() == null) 
		{
			return null;
		}
		// move head to next node
		T data = getHead().data;
		setHead(getHead().next);  
		
		// if queue empty, return null
		if (getHead() == null) {
			tail = null;  
		}
		setLength(getLength() - 1);
		return data;  
	}
	
	// Wrapper method for add()
	public void enqueue(T data) {
		add(data);
	}
	
	// Wrapper method for delete()
	public T dequeue() {
		return delete();
	}
}
