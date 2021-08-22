/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H208;

import java.util.*;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
 
    public static int ListToInt(List<Integer> l){
        int res = 0;
        for(int i = 0; i < l.size(); ++i) {
            res = res*10 + l.get(i);
        }
        return res;
        
    }
    
    
    public static int swapDigitPairs(int n) {
        List<Integer> list_digit = new ArrayList<Integer>();
        int count = 0;
        int temp = n;
        while(temp > 0 ) {
            count++;
            list_digit.add(temp%10);
            temp/=10;
        }
        
//        Dao lai Mang cac digit
        for(int i = 0; i < list_digit.size() / 2 ; ++i) {
            int c = list_digit.get(i);
            list_digit.set(i, list_digit.get(list_digit.size() - i - 1));
            list_digit.set(list_digit.size() - i - 1, c);
        }
        
        
        if(count % 2 == 0) {           
            for(int i = 0; i < list_digit.size() - 1; i += 2) {
                int c = list_digit.get(i);
                list_digit.set(i, list_digit.get(i+1));
                list_digit.set(i + 1, c);
                
            }
            return ListToInt(list_digit);
            
        }else {
            for(int i = 1; i < list_digit.size() - 1; i += 2) {
                int c = list_digit.get(i);
                list_digit.set(i, list_digit.get(i+1));
                list_digit.set(i + 1, c);
                
            }
            return ListToInt(list_digit);
        } 
    }
            
            
    public static void main(String[] args) {
        int n = Utility.GetInt("Enter Integer: ", 1, Integer.MAX_VALUE);
        System.out.println(swapDigitPairs(n));
    }
}
