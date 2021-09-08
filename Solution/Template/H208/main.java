/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H208;
import Template.Utility;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static int swapDigitPairs(int n) {
        int res = 0;
        int b = 1;
        // 482596
//        res = 0
//        6 , 9 
//        res += 6*10 +9 = 69;
//        b=100;        
//        5 , 2
//        res += 5*b*10 + 2*b;
//        69 + 5200 = 5269
        
        //842 b =100;
        //8
        while(n / 10 > 0) {
            int first = n % 10;
            
            n/=10;
            
//            System.out.println(n);
            
            if(n > 0) {
                int second = n % 10;
                n /= 10;
//                System.out.println(n);
                res += first * b * 10 + second * b;
                b*=100;
            }  
        }
        
//        1234567
        if(n > 0) {
            res += n * b;
        }
        
        return res;
        
    }
     
    public static String swapDigitPairs2(int n) {
        String res = "";
        
        //102345
        //54
        // 32+54
        while(n / 10 > 0) {
            int first = n % 10;
            String temp = "";
            
            n/=10;
            temp += (char) (first + '0' );
            
            if(n > 0) {
                int second = n % 10;
                n /= 10;
                temp += (char) (second + '0' );

                res = temp + res;
            }  
        }
        
        if(n > 0) {
            res = (char) (n + '0' ) + res;
        }
        
        return res;
        
    }
//    cach de lam
    public static int swapDigitPairs3(int n) {
        String res = "";
        
        //102345
        //54
        // 32+54
        while(n / 10 > 0) {
            int first = n % 10;
            String temp = "";
            
            n/=10;
            temp += (char) (first + '0' );
            
            if(n > 0) {
                int second = n % 10;
                n /= 10;
                temp += (char) (second + '0' );

                res = temp + res;
            }  
        }
        
        if(n > 0) {
            res = (char) (n + '0' ) + res;
        }
        
        return Integer.parseInt(res);
        
    }
    
    public static void main(String[] args) {
        int n = Utility.GetInt("Enter int: ", 0, Integer.MAX_VALUE);
        System.out.println(swapDigitPairs3(n));
    }
}
