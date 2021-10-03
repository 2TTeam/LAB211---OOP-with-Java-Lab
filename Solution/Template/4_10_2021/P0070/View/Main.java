/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0070.View;

import P0070.Controller.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        
        BankController m = new BankController();
        String xAccount;
        String xPassword;
        int tried;
        String xCaptcha;
        
        System.out.println("Login function of Ebank system includes:\n" +
                           "1. Vietnamese\n" +
                           "2. English\n" +
                           "3. Exit\n");
        
        int choice = Utility.GetInt("Enter your choice: ", 1, 3);
        
        switch ( choice ) {
            case 1:
                m.setLocale("vi", "VN");
                break;
            case 2:
                m.setLocale("en", "UK");
                break;
            case 3:
                return;
        }
        
        
        
        xAccount = Utility.GetStringByRegex(
                m.getMsg("account"), "[0-9]{10}", m.getMsg("accountError"));
        
//        tried = 0;
        
        do {
            xPassword = Utility.GetString(
                    m.getMsg("password"), true);
            if(m.isValidPassword(xPassword) == true) {
                break;
            } else {
                System.out.println(m.getMsg("passwordError"));
            }
        }while(true);
        
        
        
        tried = 0;
        do {
            if(tried >= 5) {
                System.out.println("Fail to login!");
                return;
            } else {
                String randcaptcha = m.randomCaptcha(6);
                System.out.println(m.getMsg("captcha") +
                        randcaptcha);
                
                if( Utility.GetString(m.getMsg("captchaInput"), true).equals(randcaptcha)) {
                    System.out.println("Login successfully");
                    return;
                } else {
                    System.out.println(m.getMsg("captchaInputError"));
                    tried++;
                }
            }
            
        }while(true);
        
    }
}
