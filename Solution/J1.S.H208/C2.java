/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H208;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class C2 {
    public static int swapDigitPairs(int n) {
        int res = 0;
        int k = 1;
//        1234567 
                
//        54 76
                
        while(n > 0) {
            int c = n%10;
            n/=10;
            if(n != 0) {
                res += c*k*10 + (n%10)*k;
                n/=10;
                k*=100;
            }else {
                res += c*k;
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int n = Utility.GetInt("Enter Int: ", 1, Integer.MAX_VALUE);
        System.out.println(swapDigitPairs(n));
        
    }
}
