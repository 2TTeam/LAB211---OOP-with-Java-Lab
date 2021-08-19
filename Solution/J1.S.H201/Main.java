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
public class Main {
    public static void main(String[] args) {
        
        Employee clerk = new Employee("Hai", "HE1");
        GroceryBill Gbill = new GroceryBill(clerk);
        
        Gbill.add(new Item("1", 10, 0.2));
        Gbill.add(new Item("2", 20, 0));
         
        
        
        System.out.println("total Bill: " + Gbill.getTotal());
        Gbill.printReceipt();
       
    }
    
    
}
