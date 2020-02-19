/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package question3;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author shubham
 */
public class TreeSet {
      public static void main(String[] args)
        {
            java.util.TreeSet<Integer> HS=new java.util.TreeSet<Integer>();
            Integer number;
            Integer ch;
             Scanner input = new Scanner(System.in);
            do{
            
            System.out.println("1. Add Element");
            System.out.println("2. Display Element");
            System.out.println("3. Remove Element");            
            System.out.println("4. Update Element");
            System.out.println("0. Exit");
            System.out.println("Enter Your Choice-");
            ch=input.nextInt();
            
            switch(ch){
                
                case 1:
                     System.out.println("Enter Size Of TreeSet-");
                    Integer i=input.nextInt();

                    for (int j = 0; j < i; j++) {
                        System.out.println("Enter Number That You Want to Add in TreeSet-");
                        number=input.nextInt();
                        HS.add(number);
                    }
                    break;
                case 2:
                     
                    System.out.println("Show");

                   Iterator<Integer> data = HS.iterator(); 
                    while (data.hasNext()) 
                        System.out.println(data.next()); 
                    break;
                    
                case 3:
                    System.out.println("Enter Elemrnt That You Want To Rmove");
                    Integer r=input.nextInt();
                   
                    HS.remove(r);
                    System.out.println("Delete Successfully");
                    break;
                case 4:
                    System.out.println("Enter Elemrnt That You Want To Update");
                    Integer u=input.nextInt();
                    HS.remove(u);
                    System.out.println("Enter Elemrnt That You Want To Add");

                    Integer newelement=input.nextInt();
                    HS.add(newelement);
                    System.out.println("Element Successfully Update");
                    
                    break;
                case 0:
                    System.out.println("BBye");
                    break;
                    default:
                        System.err.println("Sorry Please Choice Other Option");
                        break;
            }

        }while (ch!=0); 
        }
    
}
