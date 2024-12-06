// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - Reverse GLL iterator class

import java.util.Iterator;

public class ReverseGLLIterator<T> implements Iterator<T>
{
	private GenericList<T>.Node<T> current;
	private GenericList<T>.Node<T> head;
	
	// Constructor
	public ReverseGLLIterator(GenericList<T>.Node<T> head) 
	{
        this.current = head;
        this.head = head;
        
        if (current != null)
        {
        	// get to last Node of Queue
        	while (current.next != null) 
        	{
        		current = current.next;
        	}
        }
    }
	
	// Helper method that finds the previous node given the current node
	private GenericList<T>.Node<T> previousNodeHelper(GenericList<T>.Node<T> head, GenericList<T>.Node<T> curr)
	{
		// no previous node exists
		if (head == curr)
		{
			return null;
		}
		
		// find previous node
		GenericList<T>.Node<T> temp = head;
		while (temp != null && temp.next != curr)
		{
			temp = temp.next;
		}
		/// Return the previous node
		return temp; 
	}
	
	// checks to see if there is more nodes
	@Override
	public boolean hasNext() {
		return current != null;
	}

	// iterates backwards and returns data as it goes
	@Override
	public T next() {
		if (current == null) 
		{
	        return null;  
	    }
		
		T val = current.data;
		
		// move to prev node
		current = previousNodeHelper(head, current);
		return val;
	}
}
