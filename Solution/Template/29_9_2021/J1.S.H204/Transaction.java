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
public class Transaction {
    private int value;

    public Transaction(int value) {
        this.value = value;
    }    
    
    public int value() {
        return this.value;
    }
}
