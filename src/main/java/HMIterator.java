import java.util.ArrayList;
import java.util.Iterator;

public class HMIterator<T> implements Iterator<T> 
{
	//map of queues
    private ArrayList<GenericQueue<T>> map;  
    //tracker of indexes
    private int currentIndex;              
    //tracker of nodes
    private GenericList<T>.Node<T> currentNode; 

    // Constructor 
    public HMIterator(ArrayList<GenericQueue<T>> map) {
        this.map = map;
        this.currentIndex = 0;  
        this.currentNode = null;  

        
        moveNodeHelper(); 
    }

    // Move to the next existing node in the map
    private void moveNodeHelper() {
        while (currentIndex < map.size()) {
            GenericQueue<T> queue = map.get(currentIndex);  

            // Set the current node if a valid queue is found
            if (queue != null && queue.getHead() != null) {
                currentNode = queue.getHead();
                return;  
            }  
         // Move to the next bucket if empty
            currentIndex++;  
        }
     // No more nodes
        currentNode = null;  
    }

    // Checks if there is another element in the map
    @Override
    public boolean hasNext() {
        return currentNode != null;  
    }

    // iterates through map and returns data as it goes
    @Override
    public T next() {
    	// No more elements
        if (currentNode == null) 
        {
            return null;  
        }

        T val = currentNode.data;
        currentNode = currentNode.next;

        // checks if the queue has no more nodes. If it doesn't, finds next queue in map
        if (currentNode == null) 
        {
            currentIndex++;  
            moveNodeHelper();  
        }
        // return the current data
        return val;
    }
}
