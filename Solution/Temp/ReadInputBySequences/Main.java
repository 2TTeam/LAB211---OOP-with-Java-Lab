/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    
    public static int StringToInt(String s) {
        int a = 0;
        int base = 1;
        for(int i = s.length() - 1; i >= 0; --i) {
            a += ( s.charAt(i) - '0' ) * base;
            base*=10;
        } 
        return a;
    }
    
    public static void main(String[] args) {
//        '1' - '0' = 1
//         "312" -> 12
//        a += 2 * 1;
//        a += 1 * 10;
//        a += 3 * 100;
        

        
//        String s = "   12,   3,   5,   6 ,  8, 11";  //sc.nextLine();
        String s = Utitlity.getString("Enter array: ", true);
        ArrayList<Integer> myList  = new ArrayList<Integer>();
        
        String temp = "";
        for(int i = 0; i < s.length(); ++i) {
            while( i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'   ) { 
                temp += s.charAt(i);
                ++i;
//                System.out.println(i);;
            }
            
            if(temp.length() > 0) {
                myList.add( StringToInt(temp) );
            }
            temp = "";
        } 
        
        for(int i = 0; i < myList.size(); ++i) {
            System.out.println(myList.get(i));
        }
        
    }
}


//nhap tu ban phim -> Buffer reader -> doc vao bien 

//'12, 2, 3, 4, 5'