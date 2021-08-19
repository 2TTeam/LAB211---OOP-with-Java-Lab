/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H201;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Item {
    private String Iid;
    private double price;
    private double discount;

    public Item() {
    }

    public Item(String Iid, double price, double discount) {
        this.Iid = Iid;
        this.price = price;
        this.discount = discount;
    }

    public String getIid() {
        return Iid;
    }
        
    
    
    public double getPrice() {
        return price;
    }

    
    public double getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return Iid + "\t" + price + "\t" + discount; 
    }
    
    
    
    
}

