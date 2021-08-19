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
        
        Employee clerk1 = new Employee("A", "HE001");
        Employee clerk2 = new Employee("B", "HE002");
                
        Item i1 = new Item("001", 100, 0.2);
        Item i2 = new Item("002", 200, 0.1);
        
        DiscoutBill D1 = new DiscoutBill(clerk1, true);
        D1.add(i1);
        D1.add(i2);
        
        System.out.println("Total: "+D1.getTotal());
        D1.printReceipt();
        
        
        DiscoutBill D2 = new DiscoutBill(clerk2, false);
        D2.add(i1);
        D2.add(i2);
        
        System.out.println("Total: " + D2.getTotal());
        D2.printReceipt();
       
    }
    
    
}
