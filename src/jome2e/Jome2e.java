
package jome2e;

import java.util.Scanner;


public class Jome2e {

  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String name;
              int byear;
              
              System.out.print("enter your name: ");
              name = sc.nextLine();
              System.out.print("enter your birth year: ");
              byear = sc.nextInt();
              
        System.out.println("hello " +name+" Youre age is "+ (2025 - byear));
        
    }
    
}
