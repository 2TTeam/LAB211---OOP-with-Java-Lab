
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class H202_H203 {
    
    public static void printReverse(String s) {
        
        for(int i = s.length() - 1; i >= 0; --i) {
            System.out.print(s.charAt(i));
        }
    }
    
    public static void printReverse2(String s) {
        String[] words = s.split("[\\s]+");
        
        
//        for(String w : words) {
//            System.out.println(w);
//        }
//        
        String first = words[words.length - 1];
//      there = t + here
//            = T + here
 
        first = first.substring(0,1).toUpperCase() + first.substring(1);
        
        for(int i = words.length - 1; i>=0 ; --i) {
            
            if( i == words.length - 1) {
                System.out.print(first);
            } else {
            System.out.print(words[i]);
            }
            System.out.print(" ");
            
        }
    }
    
//    hello there!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String input = sc.nextLine();
        
        printReverse2(input);
        
    }
}
