/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H206;

import java.util.LinkedList;
import Template.Utility;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void printSquare(int min, int max) {
        LinkedList<Integer> myList = new LinkedList<Integer>();
        for(int i = min; i <= max; ++i) {
            myList.add(i);
        }
        
        for(int i = 0; i < max - min + 1; ++i) {
            for(int j = 0; j < myList.size(); ++j) {
                System.out.print(myList.get(j));
            }
            
            int temp = myList.get(0);
            myList.remove(0);
            myList.add(temp);
            
            System.out.println("");
        }
    
    }
    
    
    public static void main(String[] args) {
        int Min = Utility.GetInt("Enter min: ", 0, Integer.MAX_VALUE);
        int Max = Utility.GetInt("Enter Max: ", Min, Integer.MAX_VALUE);
        
        printSquare(Min, Max);
        
    }
}
