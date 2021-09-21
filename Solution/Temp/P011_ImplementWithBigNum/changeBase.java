/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package J1.S.P0011;

import java.math.BigInteger;
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
    
    
    public static int ValueOfChar(char c) {
        for(int i = 0; i < Mydigits.length; ++i) {
            if( (c+"").equalsIgnoreCase(Mydigits[i]+"")  ) {
                return i;
            }
        }
        return -1;
    } 

    
//    mydigits[0] = '0'
//    mydigit[10] = 'a'
//    mydigit[11] = 'b'
    
    
    
    
    public static BigInteger AllToDec(String s, int radix) {
        // fab123 -> 3 * 16^0 + 2 * 16^1 + 1 * 16^2 + b * 16^3 + a * 16^4 + f* 16^5
        BigInteger res = new BigInteger("0");
        BigInteger base =  new BigInteger("1");
        
        for(int i = s.length() - 1; i >= 0; --i) {
            
//            res += ( ValueOfChar(s.charAt(i)) ) * base;  
            BigInteger VoC = BigInteger.valueOf( ValueOfChar(s.charAt(i)) );
            res = res.add(base.multiply(VoC));
//            base *= radix;
            base = base.multiply(BigInteger.valueOf(radix));
        }

        return res;
    }
    
    public static String DecToAll(BigInteger DecValue,int radix) {
        //chuyen gia tri DecValue tu he 10 ve he radix
        //16 abcdf12345
        //DecToALl(700997, 16) = "AB245" 
//        700997 / 16 = 43812 du 5   -> 5 -> mydigits[5]  = '5'
//        43812  / 16 = 2738  du 4   -> 4 -> mydigits[4]  = '4'
//        2738   / 16 = 171   du 2   -> 2 -> mydigits[2]  = '2'
//        171    / 16 = 10    du 11  -> B -> mydigits[11] = 'B'
//        10     / 16 = 0     du 10  -> A -> mydigits[10] = 'A'
        
        String res = "";
        BigInteger rad = BigInteger.valueOf(radix);
        
        do {
//          lst = { divide, Remainder }
            BigInteger lst[] = DecValue.divideAndRemainder(rad);
            
//            for(int i = 0; i < lst.length; ++i) {
//                System.out.println(Integer.parseInt(lst[i].toString()));
//            }
            
            char t = Mydigits[Integer.parseInt(lst[1].toString())];

            res = t + res;
            
            if(lst[0].equals(new BigInteger("0"))) {
                return res;
            }
            DecValue = DecValue.divide(rad);
            
        }while(true);

    }
    
    
    
            
}
