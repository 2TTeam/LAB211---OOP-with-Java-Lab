/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package P0070.Controller;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BankController {
    private Locale lc;
    private ResourceBundle lang;
    private ArrayList<Character> accepted_character_forCaptcha;
    
    
    public BankController() {
        
        buildListCharacterForCaptcha();
    }
    
    public void buildListCharacterForCaptcha() {
        accepted_character_forCaptcha = new ArrayList<>();
        for(int i = '0'; i <= '9'; ++i) {
            accepted_character_forCaptcha.add( (char) i);
        }
        
        for(int i = 'a'; i <= 'z'; ++i) {
            accepted_character_forCaptcha.add( (char) i);
        }
        
        for(int i = 'A'; i <= 'Z'; ++i) {
            accepted_character_forCaptcha.add( (char) i);
        }
    }
    
    public void setLocale(String language, String country) {
        this.lc = new Locale(language, country);
        this.lang = ResourceBundle.getBundle("P0070.Language.properties", lc);
    }
    
    public String getMsg(String key) {
        return this.lang.getString(key);
    }
    
    public boolean isValidPassword(String xPassword) {
//        a-zA-Z0-9
        String patt1 = "[a-z]+";
        String patt2 = "[A-Z]+";
        String patt3 = "[0-9]+";
        String patt4 = "[a-zA-Z0-9]{8,31}";
        String patt5 = ".{8-31}";
        return Utility.matchesPattern(patt1, xPassword) &&
               Utility.matchesPattern(patt2, xPassword) &&
               Utility.matchesPattern(patt3, xPassword) &&
               Utility.matchesPattern(patt4, xPassword);
    }
    
    public String getPassword(String msg,String errorMsg) {
        Scanner sc = new Scanner(System.in);
        String s;    
        
        do{
            System.out.println(msg);
            s = sc.nextLine();
            if(isValidPassword(s) == true) {
                return s;
            } else {
                System.out.println(errorMsg);
            }
        }while(true);
    }
    
    public String randomCaptcha(int sizeOfCaptcha) {
        ArrayList<Character> temp = new ArrayList<>(accepted_character_forCaptcha);
//        0,1,2,3,..,9,a,b,c,d,...,9,A,B,...,Z
        Random rand = new Random();
        String res = "";
        int pos;
        
        for(int i = 0; i < sizeOfCaptcha; ++i) {
            pos = rand.nextInt( temp.size() );
            res += temp.get(pos);
            temp.remove(pos);
        }
        
        return res;
    }
     
    public static void main(String[] args) {
        BankController t = new BankController();
        String m = t.randomCaptcha(6);
        System.out.println(m);
    }
}
