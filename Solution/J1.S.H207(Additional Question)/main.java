/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H205;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static int secondHalfLetters(String s) {
        
        
        
        String s2 = s.toLowerCase();
        int MinValue = Integer.MAX_VALUE;
        int MaxValue = Integer.MIN_VALUE;
        
        boolean hasAlphabet = false;
            
        for(int i = 0 ; i < s.length(); ++i) {
//            s.charAt(i) >= 'a' && s.charAt(i) <='z'
            if( Character.isAlphabetic(s.charAt(i)) ) {
                hasAlphabet = true;
                MinValue = Integer.min(MinValue, s.charAt(i));
                MaxValue = Integer.max(MaxValue, s.charAt(i));       
            }
        }

        
        if(hasAlphabet == false) {
            return 0;
        } else {
            int Middle = (MaxValue + MinValue)/2;
//            System.out.println((char) Middle);
            int count = 0;
            for(int i = 0; i < s.length(); ++i) {
                if(s.charAt(i) > Middle) ++count;
            }
            return count;
        }
    }
    
    public static void main(String[] args) {
        String s = Utility.GetString("Enter String: ", false);
        System.out.println(secondHalfLetters(s));
//          String s = Utility.GetStringByRegex("Enter String: ", "[a-zA-Z]+");
    }
}
