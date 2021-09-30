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
        this.minBalance = Integer.MAX_VALUE;
        this.maxBaLance = Integer.MIN_VALUE;
    }

    @Override
    public void debit(Debit d) {
        int updateValue = super.getBalance() + d.getValue();
        minBalance = Math.min(minBalance, updateValue);
        maxBaLance = Math.max(maxBaLance, updateValue);
        super.setBalance(updateValue);
    }

    @Override
    public void credit(Credit c) {
        int updateValue = super.getBalance() + c.getValue();
        minBalance = Math.min(minBalance, updateValue);
        maxBaLance = Math.max(maxBaLance, updateValue);
        super.setBalance(updateValue);
    }
    
    public int getMin() {
        return this.minBalance;
    }

    
    public int getMax() {
        return this.maxBaLance;
    }
    
}
