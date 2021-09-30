/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        
        BankLoginController m = new BankLoginController();
        int choice;
        
        do {
            System.out.println("1. Vietnamese\n"+
                               "2. English\n"+
                               "3. Exit\n");
            choice = Utility.GetInt(
                    "Enter your choice: ", 1, 3);
            
            switch(choice) {
                case 1:
                    m.getLocale("vi", "VN");
                    break;
                case 2:
                    m.getLocale("en", "UK");
                    break;
                case 3:
                    return;
            }       
            
            String xAccount = Utility.GetStringByRegex(
                    m.getMsg("account"), Utility.ACCOUNT_PATTERN, m.getMsg("accountError"));
//            m.setAccount(xAccount);
            
            
            String xPassword = m.getPassword(m.getMsg("password"), m.getMsg("passwordError"));
            
//            m.setPassword(xPassword);
            
            
            boolean xTypecaptcha = m.TypeCaptcha(
                    m.getMsg("captcha")
                    , 6, m.getMsg("captchaInputError"));
            
            if(xTypecaptcha == true) {
                System.out.println("Login succesfully!");
            } else{
                System.err.println("Fail to login!");
                System.err.println("You have tried 5 times!");
            }
             
        }while(true);
        
        
        
    }
}
