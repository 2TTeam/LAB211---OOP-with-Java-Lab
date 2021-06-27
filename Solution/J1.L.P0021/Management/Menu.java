/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;
import Validation.Utility;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Menu {
    private String[] hints;
    private int n = 0; //currentSizeOfhint

    public Menu(int maxSize) {
        if(maxSize<1) maxSize = 10;
        hints = new String[maxSize];
    }
    public Menu(String[] hints) {
        this.hints = hints;
    }
    
    void add(String xHint){
        if(n<hints.length){
            hints[n++] = Utility.GetString("Enter hint: ", false);
        }else{
            System.out.println("Size of Menu is Max!");
        }
    }
    void printListhints(){
        int i=0;
        for (String hint : hints) {
            System.out.println(i +". "+hint);
            ++i;
        }
    }
    
    public int getChoice(){
        return Utility.GetInt("Enter your choice", 0, n-1);
    }
    
    
    
}
