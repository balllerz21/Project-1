// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - GQ Tests class

import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class GQTest 
{
	static GenericQueue<Integer> testQueue1;
	static GenericQueue<Double> testQueue2;
	static GenericQueue<String> testQueue3;
	static GenericQueue<Integer> testQueue4;
	static GenericQueue<Integer> list;
	
	//Preps the genericQueues for tests
	@BeforeEach
	public void setUp()
	{
		testQueue1 = new GenericQueue<>(5);
		testQueue2 = new GenericQueue<>(10.0);
		testQueue3 = new GenericQueue<>("hello");
		testQueue4 = new GenericQueue<>(1, 1000);
		
		list = new GenericQueue<>(1);
		list.add(2);
		list.add(3);
	}
	
	//constructor tests
	@Test
	public void ConstructorTest()
	{
		assertNotNull(testQueue1);
		assertEquals(5, testQueue1.getHead().data, "initialized wrong");
		assertEquals(testQueue1.getHead(), testQueue1.getTail(), "initialized wrong");
		assertEquals(1, testQueue1.getLength(), "wrong length");
		
		assertNotNull(testQueue2);
		assertEquals(10.0, testQueue2.getHead().data, "initialized wrong");
		assertEquals(testQueue2.getHead(), testQueue2.getTail(), "initialized wrong");
		assertEquals(1, testQueue2.getLength(), "wrong length");
		
		assertNotNull(testQueue3);
		assertEquals("hello", testQueue3.getHead().data, "initialized wrong");
		assertEquals(testQueue3.getHead(), testQueue3.getTail(), "initialized wrong");
		assertEquals(1, testQueue3.getLength(), "wrong length");
	}
	
	//add tests - FIFO Entry
	@Test 
	public void addTest()
	{
		testQueue1.add(10);
		assertEquals(5, testQueue1.getHead().data, "wrong head");
		assertEquals(10, testQueue1.getTail().data, "added wrong");
		assertEquals(2, testQueue1.getLength(), "wrong length");
		
		testQueue2.add(15.0);
		assertEquals(10.0, testQueue2.getHead().data, "wrong head");
		assertEquals(15.0, testQueue2.getTail().data, "added wrong");
		assertEquals(2, testQueue2.getLength(), "wrong length");
		
		testQueue3.add("wow");
		assertEquals("hello", testQueue3.getHead().data, "wrong head");
		assertEquals("wow", testQueue3.getTail().data, "added wrong");
		assertEquals(2, testQueue3.getLength(), "wrong length");
	}
	
	//add tests - FIFO entry (constructors with code)
	@Test 
	public void addTest2()
	{
		testQueue4.add(2, 1001);
		assertEquals(1, testQueue4.getHead().data, "wrong head");
		assertEquals(1000, testQueue4.getHead().code, "wrong code");
		assertEquals(2, testQueue4.getTail().data, "added wrong");
		assertEquals(1001, testQueue4.getTail().code, "added wrong");
		assertEquals(2, testQueue4.getLength());
		
		testQueue4.add(100, 1002);
		assertEquals(1, testQueue4.getHead().data, "wrong head");
		assertEquals(1000, testQueue4.getHead().code, "wrong code");
		assertEquals(100, testQueue4.getTail().data, "added wrong");
		assertEquals(1002, testQueue4.getTail().code, "added wrong");
		assertEquals(3, testQueue4.getLength());
		
		
	}
	// enqueue tests - multiple elements for integers
	@Test
	public void enqueueTest()
	{
		testQueue1.enqueue(10);
		assertEquals(5, testQueue1.getHead().data, "wrong head");
		assertEquals(10, testQueue1.getTail().data, "added wrong");
		assertEquals(2, testQueue1.getLength(), "wrong length");
		
		testQueue1.enqueue(15);
		assertEquals(5, testQueue1.getHead().data, "wrong head");
		assertEquals(15, testQueue1.getTail().data, "added wrong");
		assertEquals(3, testQueue1.getLength(), "wrong length");
		
		testQueue1.enqueue(20);
		assertEquals(5, testQueue1.getHead().data, "wrong head");
		assertEquals(20, testQueue1.getTail().data, "added wrong");
		assertEquals(4, testQueue1.getLength(), "wrong length");
		
	}
	// enqueue tests - multiple elements for doubles
	@Test
	public void enqueueTest2()
	{
		testQueue2.enqueue(12.0);
		assertEquals(10.0, testQueue2.getHead().data, "wrong head");
		assertEquals(12.0, testQueue2.getTail().data, "added wrong");
		assertEquals(2, testQueue2.getLength(), "wrong length");
		
		testQueue2.enqueue(15.0);
		assertEquals(10.0, testQueue2.getHead().data, "wrong head");
		assertEquals(15.0, testQueue2.getTail().data, "added wrong");
		assertEquals(3, testQueue2.getLength(), "wrong length");
		
		testQueue2.enqueue(20.0);
		assertEquals(10.0, testQueue2.getHead().data, "wrong head");
		assertEquals(20.0, testQueue2.getTail().data, "added wrong");
		assertEquals(4, testQueue2.getLength(), "wrong length");
	}
	
	// enqueue tests - multiple elements for strings
	@Test
	public void enqueueTest3()
	{
		testQueue3.enqueue("coool");
		assertEquals("hello", testQueue3.getHead().data, "wrong head");
		assertEquals("coool" ,testQueue3.getTail().data, "added wrong");
		assertEquals(2, testQueue3.getLength(), "wrong length");
		
		testQueue3.enqueue("lol");
		assertEquals("hello", testQueue3.getHead().data, "wrong head");
		assertEquals("lol" ,testQueue3.getTail().data, "added wrong");
		assertEquals(3, testQueue3.getLength(), "wrong length");
		
		testQueue3.enqueue("ciao");
		assertEquals("hello", testQueue3.getHead().data, "wrong head");
		assertEquals("ciao" ,testQueue3.getTail().data, "added wrong");
		assertEquals(4, testQueue3.getLength(), "wrong length");
	}
	
	// delete test - fifo deletion
	@Test
	public void deleteTest()
	{
		assertEquals(1, testQueue1.getLength());
		assertEquals(5, testQueue1.delete());
		assertEquals(0, testQueue1.getLength());
		
		assertNull(testQueue1.delete());
	}
	
	// dequeue tests for integers
	@Test 
	public void dequeueTest()
	{
		testQueue1.add(15);
		testQueue1.add(20);
		testQueue1.add(30);
		assertEquals(5, testQueue1.delete());
		assertEquals(15, testQueue1.delete());
		assertEquals(20, testQueue1.delete());
		assertEquals(1, testQueue1.getLength());
	}
	
	// dequeue tests for doubles
	@Test
	public void dequeueTest2()
	{
		testQueue2.add(15.5);
		testQueue2.add(20.0);
		testQueue2.add(30.0);
		assertEquals(10.0, testQueue2.delete());
		assertEquals(15.5, testQueue2.delete());
		assertEquals(20.0, testQueue2.delete());
		assertEquals(1, testQueue2.getLength());
	}
	
	// dequeue tests for strings
	@Test
	public void dequeueTest3()
	{
		testQueue3.add("wow");
		testQueue3.add("woof");
		testQueue3.add("cozmo");
		assertEquals("hello", testQueue3.delete());
		assertEquals("wow", testQueue3.delete());
		assertEquals("woof", testQueue3.delete());
		assertEquals(1, testQueue3.getLength());
	}
	
	
	// Generic List tests - used tests with Generic Queues
	
	// Tests the dumpList() to make sure it returns all elements in the queue
	@Test
	public void DumpListTest()
	{
		ArrayList<Integer> result = list.dumpList();
		assertEquals(3, result.size(), "The size of the list should be 3");
        assertEquals(1, result.get(0), "The first element should be 1");
        assertEquals(2, result.get(1), "The second element should be 2");
        assertEquals(3, result.get(2), "The third element should be 3");
	}
	
	// Tests the get() to make sure it retrieves the right elements from the queue
	@Test 
	public void GetTest()
	{
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(3, list.get(2));
		assertNull(list.get(5));
		assertNull(list.get(-1));
	}
	
	// Tests the set() to make sure it sets the correct element at the right index
	@Test
	public void SetTest()
	{
		assertEquals(1, list.set(0, 200));
		assertEquals(200, list.get(0));
		
		assertEquals(2, list.set(1, 5000));
		assertEquals(5000, list.get(1));
	}
	
	//test print() - if all prints in the right order
	@Test
	public void printTest()
	{
		list.print();
		// Should print: 
		// 1
		// 2
		// 3
		testQueue3.add("Rubini");
		testQueue3.add("Soldi");
		testQueue3.print();
		// Should print: 
		// Hello
		// Rubini
		// Soldi
	}
	
	
	
	// iterator Tests - GLLIterator Class
	@Test
	//hasNext() - Checks if there is another element in the map
	public void hasNextIteratorTest() 
	{
	    GenericQueue<Integer> queue = new GenericQueue<>(1);
	    queue.add(2);
	    queue.add(3);
	    Iterator<Integer> iterator = queue.iterator();

	    assertTrue(iterator.hasNext(), "hasNext() should returned wrong boolean");
	    iterator.next();  
	    assertTrue(iterator.hasNext(), "hasNext() should returned wrong boolean");
	    iterator.next(); 
	    assertTrue(iterator.hasNext(), "hasNext() should returned wrong boolean");
	    iterator.next(); 
	    assertFalse(iterator.hasNext(), "hasNext() should returned wrong boolean");
	}
	
	@Test
	// next() - tests if the elements are iterated correctly
	public void nextIteratorIteratorTest() 
	{
	    testQueue1.add(2);
	    testQueue1.add(3);
	    Iterator<Integer> iterator = testQueue1.iterator();
	    assertEquals(5, iterator.next(), "wrong element");
	    assertEquals(2, iterator.next(), "wrong element");
	    assertEquals(3, iterator.next(), "wrong element");
	    assertNull(iterator.next(), "wrong element");
	}
	
	// iterator() test - for each loop implementation
	@ParameterizedTest
    @ValueSource(ints = {1, 2, 3})  
    void iteratorTest(int expectedValue) {
        int index = 0;
        int[] expectedValues = {1, 2, 3};  
        for (Integer value : list) {
            assertEquals(expectedValues[index], value, "The value does not match the expected order");
            index++;
        }
        assertEquals(expectedValues.length, index, "Not all elements were iterated through in the for-each loop");
    }
	
	// descendingIterator() tests - ReverseGLLIterator class
	// hasNext() - Tests for the hasNext() method in the descending iterator
	@Test
	public void hasNextDescendingIteratorTest() {
		testQueue1.add(2);
		testQueue1.add(3);
	    Iterator<Integer> descendingIterator = testQueue1.descendingIterator();
	    assertTrue(descendingIterator.hasNext(), "hasNext() returned wrong boolean");
	    descendingIterator.next();  
	    assertTrue(descendingIterator.hasNext(), "hasNext() returned wrong boolean");
	    descendingIterator.next();  
	    assertTrue(descendingIterator.hasNext(), "hasNext() returned wrong boolean");
	    descendingIterator.next(); 
	    assertFalse(descendingIterator.hasNext(), "hasNext() returned wrong boolean");
	}
	
	// Tests the next() method for descending iterator
	@Test
	public void nextTestDescendingIterator() 
	{
		testQueue1.add(2);
		testQueue1.add(3);
	    Iterator<Integer> iterator = testQueue1.descendingIterator();

	    assertEquals(3, iterator.next(), "wrong element");
	    assertEquals(2, iterator.next(), "wrong element");
	    assertEquals(5, iterator.next(), "wrong element");
	    assertNull(iterator.next(), "next() should return null or behave accordingly after all elements are retrieved");
	}
	
	// descendingIterator() - Reverse GLLIterator class
	@Test
	void DescendingIteratorTest() {
        Iterator<Integer> descendingIterator = list.descendingIterator();
        int[] expectedValues = {3, 2, 1};  
        int index = 0;

        while (descendingIterator.hasNext() && index < expectedValues.length) {
            int actualValue = descendingIterator.next();
            assertEquals(expectedValues[index], actualValue, "Iterator value did not match the expected value");
            index++;
        }
        assertEquals(expectedValues.length, index, "The iterator did not return the correct number of elements");
    }
	
}