/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H205;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BankingAccount {
    private Startup s;
    private Debit d;
    private Credit c;
    private int balance;
    
    
    public BankingAccount(Startup s) {
        this.s = s;
    }
    
    public void debit(Debit d) {
        this.d = d;
    }
    
    public void credit(Credit c) {
        this.c = c;
    }
    
    public int getBalance() {
        if(d == null && c == null) {
            return 0;
        } else if( d == null && c != null) {
            return c.getValue();
        } else if( d != null && c == null) {
            return d.getValue();
        } else {
            return c.getValue() + d.getValue();
        }
    }
    
    public Debit getDebit() {
        return this.d;
    }
    
    public Credit getCredit() {
        return this.c;
    }
    
    
    
}
