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
public class MinMaxAccount extends BankingAccount{
    private int minBalance;
    private int maxBaLance;
    
    
    public MinMaxAccount(Startup s) {
        super(s);
    }

    @Override
    public void debit(Debit d) { 
        int BalaceBeforeUpdate = super.getBalance();
        super.debit(d);
        minBalance = Math.min( BalaceBeforeUpdate, super.getBalance() );
        maxBaLance = Math.min( BalaceBeforeUpdate, super.getBalance() );
    }

    @Override
    public void credit(Credit c) {
        int BalaceBeforeUpdate = super.getBalance();
        super.credit(c);
        minBalance = Math.min( BalaceBeforeUpdate, super.getBalance() );
        maxBaLance = Math.min( BalaceBeforeUpdate, super.getBalance() );
    }
    
    public int getMin() {
        return this.minBalance;
    }

    
    public int getMax() {
        return this.maxBaLance;
    }
    
}
