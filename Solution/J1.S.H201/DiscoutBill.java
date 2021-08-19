/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H201;

import java.util.LinkedList;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class DiscoutBill extends GroceryBill{
    private boolean preferred;

    public DiscoutBill(Employee clerk, boolean preferred) {
        super(clerk);
        this.preferred = preferred;
    }

    public int getDiscountCount() {
        int res = 0;
        LinkedList<Item> temp = new LinkedList<Item>(super.getList_id_item());
        for(int i = 0; i < temp.size() ; ++i) {
           if(temp.get(i).getDiscount() == 0 ) ++res;
        }
        return res;
    }

    
    
    
    
    public double getDiscountAmount() {
        double res = 0;
        LinkedList<Item> temp = new LinkedList<Item>(super.getList_id_item());
        for(int i = 0; i < temp.size() ; ++i) {
           res += temp.get(i).getDiscount()*temp.get(i).getPrice();
        }
        return res;
    }
    
    @Override
    public double getTotal() {
        if(this.preferred == true) {
            return super.getTotal() - getDiscountAmount();        
        } else {
            return super.getTotal();
        }
    }
    
    public double getDiscountPercent() {
        return this.getDiscountAmount()/super.getTotal();
    }
    
    
    
    
    
    
    
    
}

