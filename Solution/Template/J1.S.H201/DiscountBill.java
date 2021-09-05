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
public class DiscountBill extends GroceryBill{
    private boolean prefered;

    public DiscountBill() {
    }

    public DiscountBill(boolean prefered, Employee cleak) {
        super(cleak);
        this.prefered = prefered;
    }

    @Override
    public double getTotal() {
        if(prefered == false ) {
            return super.getTotal();
        } else {
            return super.getTotal() - this.getDiscountAmount();
        }
        
    }


    @Override
    public void printReceipt() {
        if(prefered == false ) {
            super.printReceipt();
        } else {
            System.out.format("%-20s%-20s%-20s\n", "ItemID", "Price", "Discount");
            for(Item i : super.getxList()) {
                System.out.println(i);
            }
        }
    
    }
    
    public int getDiscountCount() {
        if(prefered == false) {
            return 0;
        } else {
            int count = 0;
            for(Item i : super.getxList()) {
                if(i.getDiscount() > 0) {
                    ++count;
                }
            }
            return count;
        }
    }
    
    public double getDiscountAmount() {
        if(prefered == false) {
            return 0;
        } else {
            double res = 0;
            for(Item i : super.getxList()) {
                res += i.getDiscount() * i.getPrice();
            }
            return res;
        }
    }
    
    public double getDiscountPercent() {
        if(prefered == false ) {
            return 0;
        } else {
            return getDiscountAmount() / super.getTotal();
        }
    }
    
    
        
    
}
