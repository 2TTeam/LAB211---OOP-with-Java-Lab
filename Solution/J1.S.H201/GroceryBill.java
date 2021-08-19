/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H201;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class GroceryBill {
    private Employee person;
    private double total = 0;
    private LinkedList<Item> list_id_item;
    
    public GroceryBill(Employee clerk) {
        this.person = clerk;
        list_id_item = new LinkedList<Item>();
    }
    
    public void add(Item i) {
        list_id_item.add(i);
        total += i.getPrice()  ;
    }
    
    public double getTotal() {
        return this.total;
    }
    
    public void printReceipt() {
        
        System.out.println("idItem" + "\t" + "price" + "\t" + "discount");
        
        for(int i = 0; i < list_id_item.size(); ++i) {
            System.out.println(list_id_item.get(i));
        }
    }

    public Employee getPerson() {
        return person;
    }

    public LinkedList<Item> getList_id_item() {
        return list_id_item;
    }
    
    
    
    
}
