/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0011;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class changeBase {
    
    public final static String BIN_PATTERN = "^[01]+$";
    public final static String DEC_PATTERN = "^[0-9]+$";
    public final static String HEX_PATTERN = "^[0-9a-fA-F]+$";
    public final static String BASE_ACCEPT = "^(2|10|16)$";
    
    public final static char[] Mydigits = 
     { '0', '1', '2', '3', '4', '5', '6', '7', '8', 
       '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    
//    mydigits[0] = '0'
//    mydigit[10] = 'a'
//    mydigit[11] = 'b'
    
    
    
    
    public static int AllToDec(String s, int radix) {
        // fab123 -> 3 * 16^0 + 2 * 16^1 
        int res = 0;
        int base = 1;
        
        for(int i = s.length() - 1; i >= 0; --i) {
            
            res += ( ValueOfChar(s.charAt(i)) ) * base;  
            base *= radix;
        }

        return res;
    }
    
    public static String DecToAll(int DecValue,int radix) {
        //chuyen gia tri DecValue tu he 10 ve he radix
        //16 abcdf12345
        //DecToALl(700997, 16) = "AB245" 
//        700997 / 16 = 43812 du 5   -> 5 -> mydigits[5]  = '5'
//        43812  / 16 = 2738  du 4   -> 4 -> mydigits[4]  = '4'
//        2738   / 16 = 171   du 2   -> 2 -> mydigits[2]  = '2'
//        171    / 16 = 10    du 11  -> B -> mydigits[11] = 'B'
//        10     / 16 = 0     du 10  -> A -> mydigits[10] = 'A'
        
        String output = "";
        while(DecValue / radix != 0) {
            char t = Mydigits[DecValue%radix];
            output = t + output;
            DecValue /= radix;
        }
        
           output = Mydigits[DecValue%radix] + output; 

        return output;
    }
    
    
    public static int ValueOfChar(char c) {
        for(int i = 0; i < Mydigits.length; ++i) {
            if( (c+"").equalsIgnoreCase(Mydigits[i]+"")  ) {
                return i;
            }
        }
        return -1;
    } 
            
}
