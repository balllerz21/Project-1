// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - Hashmap class

import java.util.Iterator;
import java.util.ArrayList;

public class MyHashMap<T> implements Iterable<T> {
	private ArrayList<GenericQueue<T>> map;  
	private int size;  

	// Constructor
	public MyHashMap(String key, T value) {
		map = new ArrayList<>(10);  
		for (int i = 0; i < 10; i++) {
			map.add(null);  
		}
		size = 0;
		put(key, value);  
	}
	
	// Adding pair
	public void put(String key, T value) {
		int hashCode = key.hashCode();
		int index = hashCode & 9;  
		
		GenericQueue<T> q = map.get(index);
		// Insert new queue if no queue exists
		if (q == null) {
			GenericQueue<T> newQ = new GenericQueue<>(value, hashCode);
			map.set(index, newQ);  
			size++;  
		} 
		else {
			//updating pair
			GenericList<T>.Node<T> curr = q.getHead();
			while (curr != null) {
				if (curr.code == hashCode) {
					curr.data = value; 
					return;
				}
				curr = curr.next;
			}
			// Add new key-value pair - if it dont exist
			q.add(value, hashCode);  
			size++;  
		}
	}

	// Check if a key exists
	public boolean contains(String key) {
		int hashCode = key.hashCode();
		int index = hashCode & 9;
		GenericQueue<T> q = map.get(index);
		if (q == null) return false;
		GenericList<T>.Node<T> curr = q.getHead();
		while (curr != null) {
			if (curr.code == hashCode) return true;
			curr = curr.next;
		}
		return false;
	}

	// Get the value for a given key
	public T get(String key) {
		int hashCode = key.hashCode();
		int index = hashCode & 9;
		GenericQueue<T> q = map.get(index);
		if (q == null) return null;
		GenericList<T>.Node<T> curr = q.getHead();
		while (curr != null) {
			// Return value if key is found
			if (curr.code == hashCode) return curr.data;  
			curr = curr.next;
		}
		return null;
	}
	
	// Return total number of pairs
	public int size() {
		return size;
	}
	
	// Check if map is empty - will always be false due to implementation
	public boolean isEmpty() {
		return size == 0;
	}

	// Replace the value for an existing key
	public T replace(String key, T value) {
		int hashCode = key.hashCode();
		int index = hashCode & 9;
		GenericQueue<T> q = map.get(index);
		if (q == null) {
			return null;
			}
		//loops to find if value can be replaced
		GenericList<T>.Node<T> curr = q.getHead();
		while (curr != null) {
			if (curr.code == hashCode) {
				T oldValue = curr.data;  
				curr.data = value;  
				return oldValue;
			}
			curr = curr.next;
		}
		return null;
	}
	
	// Return an iterator
	@Override
	public Iterator<T> iterator() {
		return new HMIterator<>(map);  
	}

}
