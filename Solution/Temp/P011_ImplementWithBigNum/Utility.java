/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0011;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Utility {
    public static String EMAIL_PATTERN = "^[a-z][a-zA-Z0-9]+@[a-z]+(\\.[a-z]+){1,3}$";
    
    
    public static int getInt(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        
        do{
            System.out.println(msg);
            
            
            try {
                n = Integer.parseInt(sc.nextLine());
                if( n >= min && n <= max ) {
                    return n;
                } else {
                    System.out.println("Out of range");
                } 
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            
        }while(true);
    }
    
    public static double getDouble(String msg, double min, double max) {
        Scanner sc = new Scanner(System.in);
        double n;
        
        do{
            System.out.println(msg);
            try {
                n = Double.parseDouble(sc.nextLine());
                
                if( n >= min && n <= max ) {
                    return n;
                } else {
                    System.out.println("Out of range");
                } 
                
            } catch (Exception e) {
                
                System.out.println(e);
            }
            
            
            
        }while(true);
    }
    
    
    
    public static String getString(String msg,boolean isEmpty) {
        Scanner sc = new Scanner(System.in);
        
        String s;
        
        do {
            System.out.println(msg);
            s = sc.nextLine();
            
            if(isEmpty == true) {
                return s;
            }else {
                if(s.trim().equals("")) {
                    System.out.println("String must have atleast 1 character!");
                } else {
                    return s;
                }
            }
            
        }while(true);
    }
    
    public static Date getDate(String msg,String inSDF) {
        Scanner sc = new Scanner(System.in);
        
        SimpleDateFormat SDF = new SimpleDateFormat(inSDF);
        SDF.setLenient(false);
        
        Date d;
        
        do{
            System.out.println(msg);
            
            try {
                d = SDF.parse(sc.nextLine());
                return d;
            } catch (Exception e) {
                System.out.println(e);
            }
            
           
            
        }while(true); 
    }
    
    public static String getDateToString(String msg, String inSDF, String outSDF) {

        Scanner sc = new Scanner(System.in);
        
        SimpleDateFormat SDF = new SimpleDateFormat(inSDF);
        SDF.setLenient(false);
        SimpleDateFormat SDF2 = new SimpleDateFormat(outSDF);
        
        Date d;
        
        do{
            System.out.println(msg);
            
            try {
                d = SDF.parse(sc.nextLine());
                return SDF2.format(d);
            } catch (Exception e) {
                System.out.println(e);
            }
            
           
            
        }while(true); 
    }
    
    
    
    public static String getStringByRegex(String msg, String Patt) {
        String s;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println(msg);
            s = sc.nextLine();
            if(Pattern.matches(Patt, s)) {
                return s;
            }else {
                System.out.println("Wrong format");
            }
                     
            
        } while (true);
    }
    
   
}
