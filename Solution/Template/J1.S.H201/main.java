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
public class main {
    public static void main(String[] args) {
        
        Employee e = new Employee("HE001");
        
        Item t1 = new Item("001", 100, 0.2);
        Item t2 = new Item("002", 200, 0.1);
        Item t3 = new Item("003", 300, 0);
        
        DiscountBill b1 = new DiscountBill(false, e);
        b1.add(t1);
        b1.add(t2);
        b1.add(t3);
        
        System.out.println("discount amount: " + b1.getDiscountAmount());
        System.out.println("discount count:"+b1.getDiscountCount());
        System.out.println("discount Percent"+b1.getDiscountPercent() * 100);
        System.out.println("Total" + b1.getTotal());
        
        b1.printReceipt();
        
        
        DiscountBill b2 = new DiscountBill(true, e);
        b2.add(t1);
        b2.add(t2);
        b2.add(t3);
        
        System.out.println(b2.getDiscountAmount());
        System.out.println(b2.getDiscountCount());
        System.out.println(b2.getDiscountPercent() * 100);
        System.out.println(b2.getTotal() );
        
        b2.printReceipt();
        
    }
}
