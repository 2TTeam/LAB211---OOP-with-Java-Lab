/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052.Controller;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
        
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Utility { 
    public static final String PHONE_PATTERN="^[\\d]{10,13}$";
    public static final String EMAIL_PATTERN="^[a-zA-Z]\\w+@\\w+(\\.\\w+){1,2}$";
    public static final String[] COURSES_LIST={"C/C++","Java",".Net"};
    
    public static int getInt(String msg, int min,int max){
        int i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                
                i=Integer.parseInt(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public static double getDouble(String msg, double min,double max){
        double i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                i=Double.parseDouble(sc.nextLine());
                if(i>=min && i<=max) return i;
                else System.out.println("Out of range");
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public static String getString(String msg,boolean isEmpty){
        
        String s;
        Scanner sc = new Scanner(System.in);
        do { 
            System.out.println(msg);
            s = sc.nextLine();
            if(isEmpty == true) return s;
            else{
                if(s.equals("")){
                    System.err.println("String must have atleast 1 character");
                } else return s;
            }
            
        } while (true);
    }
    
    public static String getYN(String msg){
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                s=sc.next("[ynYN]");
                break;
            } catch (Exception e) {
                System.out.println(e);
                sc.nextLine();
            }
        }while(true);
        return (""+s.charAt(0)).toLowerCase();
    }
    
    public static String getStringByRegex(String msg,String Patt){
        String s;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            try {
                s = sc.nextLine();
                if(Pattern.matches(Patt,s)==true)
                    return s;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);   
    }
    

    public static Date getDate(String msg, String inFormat){
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat(inFormat); 

        SDF.setLenient(false);

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            String sDate = sc.nextLine();
            
            
            try {
                date = SDF.parse(sDate);
                return date;
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
        
    }
    
    public static String getDate(String msg, String inFormat, String outFormat,String[] anotherInputList) {
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat(inFormat); 
        SimpleDateFormat SDF2 = new SimpleDateFormat(outFormat);
        
        SDF.setLenient(false);

        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            String sDate = sc.nextLine();
            for(int i = 0; i < anotherInputList.length; ++i) {
                if(anotherInputList[i].equals(sDate)) {
                    return sDate;
                }
            }
            
            try {
                date = SDF.parse(sDate);
                return SDF2.format(date);
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
    }
    
    public static String getEmail(String msg) {
        String s;
        Scanner sc = new Scanner(System.in);
        do { 
            s = sc.nextLine();
            
            if(Pattern.matches("^[a-z][a-zA-Z0-9]+@[a-z]+(\\.[a-z]+){1,3}$", s)) {
                return s;
            }else {
                System.out.println("Wrong format");
            }
                     
            
        } while (true);
    }
     
    public static String getInArray(String[] acceptedList,String msg){
        String inputString="";
        Scanner sc = new Scanner(System.in);
        
        do{
            inputString = Utility.getString(msg, false);
            for(int i=0;i<acceptedList.length;++i){
                if(inputString.equalsIgnoreCase(acceptedList[i])){
                    return inputString;
                }
            }
            System.out.print("The accpeted List: ");
            for(int i=0;i<acceptedList.length;++i){
                    System.out.print(acceptedList[i]+" ");
            }
            System.out.println("");
        }while(true);
    }
    
}