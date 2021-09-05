/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H201;

import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class GroceryBill {
    private Employee xPerson;
    private ArrayList<Item> xList;
    private double total;
    
    public GroceryBill() {
         xList = new ArrayList<Item>();
         
    }

    public GroceryBill(Employee cleak) {
        this.xPerson = cleak;
        this.xList = new ArrayList<Item>();
        this.total = 0;
    }

    public void add(Item i) {
        xList.add(i);
        this.total += i.getPrice();
    }

    public double getTotal() {
        return total;
    }
    
    public void printReceipt() {
        System.out.format("%-20s%-20s\n","ItemID", "Price");
        for(Item i : this.xList) {
            System.out.format("%-20s%-20f\n",i.getItemID(),i.getPrice());
        }
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ArrayList<Item> getxList() {
        return xList;
    }
    
    
    
    
    
}
