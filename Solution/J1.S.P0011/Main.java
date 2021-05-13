/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Template;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        String inBase = Utility.GetStringByRegex("Enter input base:", BaseConvert.MyBase_PATTERN); 
        String input  = BaseConvert.getTrueFormatInput(inBase);
        String outBase= Utility.GetStringByRegex("Enter output base:", BaseConvert.MyBase_PATTERN);
        System.out.println("Output: "+BaseConvert.BaseConvertion(inBase, input, outBase));     
        
    }
}