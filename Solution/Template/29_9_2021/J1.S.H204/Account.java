/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H204;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Account {
    private Client c;
    private int Total;
    
    
    public Account(Client c) {
        this.c = c;
        this.Total = 0;
    }  

    public Account(Client c, int Total) {
        this.c = c;
        this.Total = Total;
    }
    
    
//    nap 500k t.value = 500 
//  t.value < 0 <=>  rut tien
//  t.value > 0 <=>  nap tien vao tai khoan  
    
    
    
    public boolean process(Transaction t) {
        if(this.Total + t.value() >= 0) {
            Total += t.value();
            return true;
        } else {
            return false;
        }
    }


    
}
