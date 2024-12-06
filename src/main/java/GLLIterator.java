// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - GLL iterator class

import java.util.Iterator;

public class GLLIterator<T> implements Iterator<T> 
{
	GenericList<T>.Node<T> current;  

	// Constructor 
	public GLLIterator(GenericList<T>.Node<T> head) {
        this.current = head;
    }

	// Check if there is another node to iterate
	@Override
    public boolean hasNext() {
        return current != null;  
    }

	// iterates to next node and returns data as it goes
	@Override
	public T next() {
		if (current == null) {
	        return null;  
	    }
		T value = current.data; 
		current = current.next;  
		return value;
	}
}

