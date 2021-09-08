/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H207;
import Template.Utility;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    
    public static int secondHalfLetters2(String s) {
        String s2 = s.toLowerCase();
        
        int minChar = 9999;
        int maxChar = 0;
        
        boolean hasAlphabet = false;
        
        for(int i = 0; i < s2.length(); ++i) {
            if(Character.isAlphabetic(s2.charAt(i))) {
                minChar = Math.min(minChar, s2.charAt(i));
                maxChar = Math.max(maxChar, s2.charAt(i));
                hasAlphabet = true;
            }
        }

        
        if(hasAlphabet == false) {
            return 0;
        }
        
        int middleChar = (minChar + maxChar) / 2;
        
        int count = 0;
        
        for(int i = 0; i< s.length(); ++i) {
            if( Character.isAlphabetic(s2.charAt(i)) && s2.charAt(i) > middleChar) {
                System.out.println( (char) s2.charAt(i));
                ++count;
            }
        }
        
        return count;
        
    }
    
    public static int secondHalfLetters(String s) {
        String s2 = s.toLowerCase();
        char middleChar = ('a' + 'z') / 2;
        
        int count = 0;
        
        for(int i = 0; i< s.length(); ++i) {
            if( Character.isAlphabetic(s2.charAt(i)) && s2.charAt(i) > middleChar) {
                System.out.println(s2.charAt(i));
                ++count;
            }
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(secondHalfLetters2( Utility.GetString("Enter String: ", false)) );
    }
}
