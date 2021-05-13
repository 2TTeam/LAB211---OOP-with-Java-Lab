/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.Array;
import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BaseConvert {
    
    public static final String MyBase_PATTERN = "^(2|10|16)$";
    public static final String BIN_PATTERN="[01]+";
    public static final String DEC_PATTERN="[0-9]+";
    public static final String HEX_PATTERN="[0-9a-fA-F]+";
    public final static char[] Mydigits = 
     { '0', '1', '2', '3', '4', '5', '6', '7', '8', 
       '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    
    public static String getTrueFormatInput(String xBase){
        do{
            if(xBase.equalsIgnoreCase("2"))
                return Utility.GetStringByRegex("Enter Bin: ", BIN_PATTERN);
            if(xBase.equalsIgnoreCase("10"))
                return Utility.GetStringByRegex("Enter Dec: ", DEC_PATTERN);
            if(xBase.equalsIgnoreCase("16"))
                return Utility.GetStringByRegex("Enter Hex: ", HEX_PATTERN);
        }while(true);
    }
    
//    input tu inBase -> he 10 -> outBase
    public static int AlltoDec(String xInput,String xInbase){ 
        int ValueInDec=0; 
        
        int j=1;
        int b=0;
        if(xInbase.equalsIgnoreCase("2"))  b=2;
        if(xInbase.equalsIgnoreCase("10")) b=10;
        if(xInbase.equalsIgnoreCase("16")) b=16;
        
        
        for(int i=xInput.length()-1;i>=0;i--){
            ValueInDec+= MyCharacterToDigit(xInput.charAt(i))*j;
            j*=b;
        }
        return ValueInDec;
    }
    
    public static String DecToAll(int xValueInDec,String xOutbase){
        int a = xValueInDec;
        int b = 0 ;
        if(xOutbase.equalsIgnoreCase("2"))  b=2;
        if(xOutbase.equalsIgnoreCase("10")) b=10;
        if(xOutbase.equalsIgnoreCase("16")) b=16;
        
        String result="";
        
        while(a>0){
            char temp = Mydigits[a%b]; 
            result = temp + result;
            a/=b;
        }
        return result;
    }
    
    private static int MyCharacterToDigit(char c){
        for(int i=0;i<Mydigits.length;i++){
            if( (c+"").compareToIgnoreCase(Mydigits[i]+"") == 0){
                return i;
            }
        }
        return -1;
    }
    
    public static String BaseConvertion(String inBase,String inPut,String outBase){
        return DecToAll( 
                AlltoDec(inPut, inBase)
                , outBase);
    }
    
    
    
}
