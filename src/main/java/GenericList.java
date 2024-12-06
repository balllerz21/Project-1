// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - GenericList class

import java.util.ArrayList;
import java.util.Iterator;

public abstract class GenericList<T> implements Iterable<T>
{
    // Node class 
    protected class Node<T> 
    {
        T data;  
        int code;  
        Node<T> next;  
        
        // Constructor (used for generic queue)
        public Node(T data) 
        {
            this.data = data;
            this.next = null;
        }

        // Constructor (used for hashmap)
        public Node(T data, int code)
        {
            this.data = data;
            this.next = null;
            this.code = code;
        }
    }
    
    // Private members
    private Node<T> head;
    private int length;
    
    // Getters and setters 
    public void setLength(int length)
    {
        this.length = length;
    }
    
    public int getLength()
    {
        return this.length;
    } 
    
    public void setHead(Node <T> head) 
    {
        this.head = head;
    }
    
    public Node<T> getHead()
    {
        return this.head;
    }   
    
    // Method to print all elements in the list
    public void print()
    {
        if (head == null) 
        {
            System.out.println("Empty List");
        } 
        else 
        {
            Node<T> curr = head;
            while(curr != null) 
            {
                System.out.println(curr.data);
                curr = curr.next;
            }
        }
    }

    // Abstract methods - implemented in GenericQueue
    public abstract void add(T data);
    public abstract T delete();
    
    // Puts all elements from the list into an ArrayList and returns it
    public ArrayList<T> dumpList()
    {
        ArrayList<T> list = new ArrayList<>();
        if (head == null) 
        {
            return list;  
        } 
        else 
        {
            Node<T> curr = head;
            while (curr != null) 
            {
                list.add(curr.data); 
                curr = curr.next;
            }
        }
        return list;
    }
    
    // Returns the data at a specific index
    public T get(int index)
    {
        int currIndex = 0;
        Node<T> curr = getHead();
        
        // out of bounds check
        if (index < 0 || index >= this.getLength())
        {
            return null;
        }
        
        // loops to find index 
        while(currIndex < index)
        {
            curr = curr.next;
            currIndex++;
        }       
        return curr.data;
    }

    // Replaces the data at a specified index and returns the old data
    public T set(int index, T element)
    {
        int currIndex = 0;
        Node<T> curr = getHead();
        
        // out of bounds checks
        if (index < 0 || index >= this.getLength())
        {
            return null;
        }
        
        //loops to see if index exists
        while(currIndex < index)
        {
            curr = curr.next;
            currIndex++;
        }       
        
        // The chnage code
        T oldElement = curr.data;  
        curr.data = element;  
        
        return oldElement;
    }

    // iterators
    public Iterator<T> iterator() 
    {
        return new GLLIterator<T>(getHead());
    }
    
    public Iterator<T> descendingIterator()
    {
        return new ReverseGLLIterator<T>(getHead());
    }
}
