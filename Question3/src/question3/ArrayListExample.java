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
public class ArrayListExample {
    
    
    
    
 
    public static void main(String[] args)
    {
        Integer ch;
        ArrayList<Integer> AL = new ArrayList<Integer>();
       Integer number;
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
                     System.out.println("Enter Size Of ArrayList-");
                    Integer i=input.nextInt();

                    for (int j = 0; j < i; j++) {
                        System.out.println("Enter Number That You Want to Add in ArrayList-");
                        number=input.nextInt();
                        AL.add(number);
                    }
                    break;
                case 2:
                     
                    System.out.println("Show");

                    for (int j = 0; j < AL.size(); j++) {
                        System.out.println(AL.get(j)+"");
                    }
                    break;
                    
                case 3:
                    System.out.println("Enter Elemrnt That You Want To Rmove");
                    Integer r=input.nextInt();
                   
                    AL.remove(r);
                    System.out.println("Delete Successfully");
                    break;
                case 4:
                    System.out.println("Enter Elemrnt That You Want To Update");
                    Integer u=input.nextInt();
                    Integer uindex= AL.indexOf(u);
                    System.out.println("Enter Elemrnt That You Want To Add");

                    Integer newelement=input.nextInt();
                    AL.set(uindex, newelement);
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

