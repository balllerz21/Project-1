// Name: Maria Guallpa
// CS 342, Fall 2024
// Project 1 - HM Tests class


import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HMTest 
{
	static MyHashMap<String> myMap;
	static MyHashMap<Integer> myMap2;
	static MyHashMap<String> myMapIter;
	
	// preps myHashMap objects for tests
    @BeforeEach
    public void setUp() 
    {
        myMap = new MyHashMap<>("initialKey", "initialValue");
        myMap2 = new MyHashMap<>("initialKey", 0);
        myMapIter = new MyHashMap<>("initialKey", "initialValue");
        myMapIter.put("key1", "value1");
        myMapIter.put("key2", "value2");
        myMapIter.put("key3", "value3");
    }
    
    // Constructor Tests
    @Test 
    public void ConstructorTest()
    {
        assertEquals("initialValue", myMap.get("initialKey"));
        assertEquals(1, myMap.size());  
        assertEquals(Integer.valueOf(0), myMap2.get("initialKey"));
        assertEquals(1, myMap2.size()); 
    }
    
 // Test for put() to make sure key-value pairs are added correctly
    @Test
    public void PutTest() 
    {
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");
        assertEquals("value1", myMap.get("key1"));  
        assertEquals("value2", myMap.get("key2")); 
        
        myMap2.put("Cozmo", 2);
        myMap2.put("COzzzzmo", 3);
        assertEquals(2, myMap2.get("Cozmo"));    
        assertEquals(3, myMap2.get("COzzzzmo"));
    }
    
  // Test for handling of adding the same key, ensuring value gets updated
    @Test
    public void PutSameKeyTest() {
        myMap.put("key1", "value1");
        myMap.put("key1", "updatedValue");

        assertEquals("updatedValue", myMap.get("key1"));  
        assertEquals(2, myMap.size());  
    }
    
 // Test for get() to get correct values for given keys
    @Test 
    public void GetTest()
    {
    	myMap.put("key12", "value100");
        myMap.put("key27", "value200");
        assertEquals("value100", myMap.get("key12"));  
        assertEquals("value200", myMap.get("key27")); 
        
        myMap2.put("cccccccc", 2);
        myMap2.put("COzzzzmo090", 3);
        assertEquals(2, myMap2.get("cccccccc"));    
        assertEquals(3, myMap2.get("COzzzzmo090"));
    }
    
 // Test for contains() to check if a key exists in the map
    @Test
    public void ContainsTest() {
        myMap.put("key1", "value1");

        assertTrue(myMap.contains("key1"));  
        assertFalse(myMap.contains("keysss222200000")); 
    }
    
 // Test for replace() to make sure values are replaced correctly for existing keys
    @Test
    public void ReplaceTest() {
        myMap.put("key1", "value1");
        assertEquals("value1", myMap.replace("key1", "newValue1"));  
        assertEquals("newValue1", myMap.get("key1"));  
        
        myMap2.put("cozmo", 100);
        assertEquals(100, myMap2.replace("cozmo", 200));  
        assertEquals(200, myMap2.get("cozmo"));  
    }
    
 // Test for size() to make sure correct count of key-value pairs
    @Test
    public void SizeTest() {
       
        myMap.put("key1", "value1");
        myMap.put("key2", "value2");

        assertEquals(3, myMap.size());  
    }
    
 // Test for isEmpty() to check if map is empty
    @Test
    public void IsEmptyTest() 
    {
        assertFalse(myMap.isEmpty());  
        assertFalse(myMap2.isEmpty());
    }
    
    // iterator() - HMIterator class
    @Test
    public void iteratorTest() 
    {
        String[] expected = {"value1", "value3", "value2", "initialValue"};

        int index = 0;
        for (String value : myMapIter) {
            assertEquals(expected[index], value, "Wrong value");
            index++;
        }
        assertEquals(expected.length, index, "wromg size");
    }
    
    // hasNext() - make sures this implemenation of hasNext() works for hashmaps
    @Test
    public void HasNextTest() 
    {
        Iterator<String> iter = myMapIter.iterator();
        assertTrue(iter.hasNext(), "not true");
        iter.next();  
        assertTrue(iter.hasNext(), "not true");
        iter.next();  
        assertTrue(iter.hasNext(),"not true");
        iter.next();  
        assertTrue(iter.hasNext(), "not true");
        iter.next();  
        assertFalse(iter.hasNext(), "not true");
    }
    
    // next() - make sures this implemenation of next() works for hashmaps
    @Test
    public void NextTest() 
    {
    	Iterator<String> iter = myMapIter.iterator();
        assertEquals("value1", iter.next(), "wrong value");  
        assertEquals("value3", iter.next(), "wrong value");        
        assertEquals("value2", iter.next(), "wrong value");        
        assertEquals("initialValue", iter.next(), "wrong value");        
        assertNull(iter.next(),"not null");
    }
 
}
