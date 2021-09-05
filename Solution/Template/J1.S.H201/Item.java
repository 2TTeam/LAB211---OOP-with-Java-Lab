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
    private String ItemID;
    private double Price;
    private double Discount;

    public Item() {
    }

    public Item(String ItemID, double Price, double Discount) {
        this.ItemID = ItemID;
        this.Price = Price;
        this.Discount = Discount;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String ItemID) {
        this.ItemID = ItemID;
    }

    

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double Discount) {
        this.Discount = Discount;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20f%-20f", ItemID, Price, Discount);
    }
    
    
    
    
}
