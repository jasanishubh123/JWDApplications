/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 *
 * @author shubham
 */
public class PriorityQ {
      public static void main(String args[]) 
    { 
        
        PriorityQueue<String> pQueue = new PriorityQueue<String>(); 
  
        // Adding items to the pQueue using add() 
        pQueue.add("MSCIT"); 
        pQueue.add("MCA"); 
        pQueue.add("BCA"); 
        pQueue.add("BSCIT"); 
  
        // Printing the most priority element 
        System.out.println("Head value using peek function:"
                           + pQueue.peek()); 
  
        // Printing all elements 
        System.out.println("The queue elements:"); 
        Iterator itr = pQueue.iterator(); 
        while (itr.hasNext()) 
            System.out.println(itr.next()); 
  
       
        pQueue.poll(); 
        System.out.println("After removing an element"
                           + "with poll function:"); 
        Iterator<String> itr2 = pQueue.iterator(); 
        while (itr2.hasNext()) 
            System.out.println(itr2.next()); 
  
        // Removing Java using remove() 
        pQueue.remove("BCA"); 
        System.out.println("after removing Java with"
                           + " remove function:"); 
        Iterator<String> itr3 = pQueue.iterator(); 
        while (itr3.hasNext()) 
            System.out.println(itr3.next()); 
  
      
        boolean b = pQueue.contains("MSCIT"); 
        System.out.println("Priority queue contains MSCIT "
                           + "or not?: " + b); 
  
        
        Object[] arr = pQueue.toArray(); 
        System.out.println("Value in array: "); 
        for (int i = 0; i < arr.length; i++) 
            System.out.println("Value: " + arr[i].toString()); 
    } 
    
}
