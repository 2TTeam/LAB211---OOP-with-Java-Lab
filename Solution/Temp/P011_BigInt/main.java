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
public class main {
    public static void main(String[] args) {
      
        int inBase = Integer.parseInt(
                    Utility.getStringByRegex("Enter Base of Input: ", changeBase.BASE_ACCEPT)
                    );
        
        String inputString = "";
        switch (inBase) {
            case 2:
                inputString = Utility.getStringByRegex("Enter Bin: ", changeBase.BIN_PATTERN);
            break;
            case 10:
                inputString = Utility.getStringByRegex("Enter Dec: ", changeBase.DEC_PATTERN);
            break;
            case 16:
                inputString = Utility.getStringByRegex("Enter Hex: ", changeBase.HEX_PATTERN);
            break;
            }
        
        BigInteger decValue = changeBase.AllToDec(inputString, inBase);
        
//        System.out.println(decValue);
        
        int outBase = Integer.parseInt(
                    Utility.getStringByRegex("Enter Base of Output: ", changeBase.BASE_ACCEPT)
                    );
        
        String outputString = changeBase.DecToAll(decValue, outBase);
            
        System.out.println("Output: " + outputString);
            
        
        
    }
}
