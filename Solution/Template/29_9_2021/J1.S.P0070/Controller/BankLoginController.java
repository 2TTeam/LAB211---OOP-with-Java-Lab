/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.*;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BankLoginController {
    private ResourceBundle lang;
    private Locale lc;
    private ArrayList<Character> root_characters_for_captcha;
    
    public BankLoginController() {  
        
        root_characters_for_captcha = new ArrayList<Character>();
        
        for(int i = 'a'; i <= 'z'; ++i) {
            root_characters_for_captcha.add( (char) i);
        }
        
        for(int i = 'A'; i <= 'Z'; ++i) {
            root_characters_for_captcha.add( (char) i);
        }
        
        for(int i = '0'; i <= '9'; ++i) {
            root_characters_for_captcha.add( (char) i);
        }

    }
    
    public void getLocale(String language, String country) {
        this.lc = new Locale( language , country );
        this.lang = ResourceBundle.getBundle("Language.properties", lc);
    }
    
    public String getMsg(String key) {
        return this.lang.getString(key);
    }

    public boolean isValidPassword(String xPassword) {
        String patt1 = "[0-9a-zA-Z]+";
        String patt2 = "[a-z]+";
        String patt3 = "[A-Z]+";
        String patt4 = "[0-9]+";
        
        return Utility.isMatchPattern(patt1, xPassword) &&
               Utility.isMatchPattern(patt2, xPassword) &&
               Utility.isMatchPattern(patt3, xPassword) &&
               Utility.isMatchPattern(patt4, xPassword) &&
               xPassword.length() >=8 &&
               xPassword.length() <=31;
    }
    
    
    
    public String getPassword(String msg, String wrongMsg) {
        Scanner sc = new Scanner(System.in);
        String xPassword;
        do{
            System.out.println(msg);
            
            xPassword = sc.nextLine();
            
            if(isValidPassword(xPassword) == true) {
                    return xPassword;
            } else {
                System.out.println(wrongMsg);
            }
            
        }while(true);
        
    }
    
    public boolean TypeCaptcha(String msg, int captchaSize, String wrongMsg) {
        Scanner sc = new Scanner(System.in);
        String captcha;
        String input;
        int tried = 0;
        
        
        do{
            captcha = randomCaptcha(captchaSize);
            
            input = Utility.GetString(msg + captcha, false);
            
            if(input.equals(captcha) ) {
                return true;  
            } else {
                System.out.println(wrongMsg);
                tried++;
            }
            
            if(tried == 5) {
                return false;
            }  
            
        }while(true);
    }
    
    public String randomCaptcha(int size) {
        ArrayList<Character> temp = new ArrayList<>(root_characters_for_captcha);
        
        String res = "";
        Random rd = new Random();
        int pos;
        
        for(int i = 0; i < size; ++i) {
            pos = rd.nextInt( temp.size() );
            res += temp.get(pos);
            temp.remove(pos);
        }
        
        return res;
    }
    
    
//    public static void main(String[] args) {
//        BankLoginController m = new BankLoginController();
//        System.out.println(m.randomCaptcha(6));
//        System.out.println(m.isValidPassword("000ABC00"));
//    }
    
}
