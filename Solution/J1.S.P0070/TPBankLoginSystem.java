/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0070;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
/**
 *
 * @author SAKURA
 */
public class TPBankLoginSystem {
    private ResourceBundle lang;
    private Locale lc;
    private String accountNumber,password;

    public void Menu() {
        System.out.println("-------Login Program-------");
        
        if(ChangeLocale())
            return;
//      with locale ( language , country )
//      search for Bundle with name : basename_language_country
        lang=ResourceBundle.getBundle("j1.s.p0070.properties", lc);
        this.accountNumber= Utility.GetStrWRegEx( this.lang.getString("account") , "^[0-9]{10}$" , this.lang.getString("accountError"));
        this.password= Utility.GetStrWRegEx( this.lang.getString("password"), "^(?=.*?[0-9])(?=.*[a-zA-Z])[0-9a-zA-Z]{8,31}$" , this.lang.getString("passwordError"));
        
        String captcha=randCaptcha(6);
        System.out.println(this.lang.getString("captcha")+captcha);
        String captchaInput;
        do
        {
            captchaInput=Utility.GetStrWRegEx( this.lang.getString("captchaInput") , "^[0-9a-zA-Z]+$" , this.lang.getString("captchaInputError"));
            if(captcha.contains(captchaInput))
                break;
            System.out.println(this.lang.getString("captchaInputError"));
        }
        while(true);
                
    }
    ///add locale 
    private boolean ChangeLocale()
    {
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        int choice=Integer.parseInt(Utility.GetStrWRegEx("Please enter choice option: ", "^[1-3]{1}$","Please enter from 1 to 3!"));
        /// Locale ( language , country )
        if(choice==1)
        {
            this.lc=new Locale("vn","VN");
            return false;
        }
        if(choice==2)
        {
            this.lc=new Locale("en","UK");
            return false;
        }
        return true;
    }
    
    private final String character="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public String randCaptcha(int n)
    {
        Random rand=new Random();
        String res="";
        do
        {
            int randValue=rand.nextInt(62);
            //turn on for unique character captcha 
            //if(Character.toString(character.charAt(randValue)).matches("^[^"+res+" ]$"))
                res=res+ character.charAt(randValue);
        }
        while(res.length()<n);
        return res;
    }
}
