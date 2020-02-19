/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

/**
 *
 * @author shubham
 */

import java.util.*;
import java.io.*;

public class LinkedList {

     
    
    public static void main(String args[]) {
     java.util.LinkedList<Integer> LL=new java.util.LinkedList<Integer>();
       Integer number;
       Integer ch;
        Scanner input = new Scanner(System.in);
        
                do{
            
            System.out.println("1. Add Element");
            System.out.println("2. Display Element");
            System.out.println("3. Remove Element");            
            System.out.println("4. Update Element");
            System.out.println("5. Add First");
            System.out.println("6. Remove First");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice-");
            ch=input.nextInt();
            
            switch(ch){
                
                case 1:
                     System.out.println("Enter Size Of LinkedList-");
                    Integer i=input.nextInt();

                    for (int j = 0; j < i; j++) {
                        System.out.println("Enter Number That You Want to Add in LinkedList-");
                        number=input.nextInt();
                        LL.add(number);
                    }
                    break;
                case 2:
                     
                    System.out.println("Show");

                    for (int j = 0; j < LL.size(); j++) {
                        System.out.println(LL.get(j)+"");
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter Elemrnt That You Want To Rmove");
                    Integer r=input.nextInt();
                   
                    LL.remove(r);
                    System.out.println("Delete Successfully");
                    break;
                case 4:
                    System.out.println("Enter Elemrnt That You Want To Update");
                    Integer u=input.nextInt();
                    Integer uindex= LL.indexOf(u);
                    System.out.println("Enter Elemrnt That You Want To Add");

                    Integer newelement=input.nextInt();
                    LL.set(uindex, newelement);
                    System.out.println("Element Successfully Update");
                    
                    break;
                case 0:
                    System.out.println("BBye");
                    break;
                case 5:
                    System.out.println("Enter Element");
                    Integer first=input.nextInt();
                    LL.addFirst(first);
                     System.out.println("Success Fully Store At First");
                    break;
                    
                case 6:
                    LL.removeFirst();
                    System.out.println("Element Remove From First");
                    break;
                    default:
                        System.err.println("Sorry Please Choice Other Option");
                        break;
            }

        }while (ch!=0); 

      
      
    }
    
}
