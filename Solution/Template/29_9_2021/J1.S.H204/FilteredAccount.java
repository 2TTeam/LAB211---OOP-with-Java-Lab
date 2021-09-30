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
public class FilteredAccount extends Account{
    private int TotalTransaction;
    private int countFiltered;
    
    public FilteredAccount(Client c) {
        super(c);
        this.TotalTransaction = 0;
        this.countFiltered = 0;
    }

    public FilteredAccount(Client c, int Total) {
        super(c, Total);
        this.TotalTransaction = 0;
        this.countFiltered = 0;
    }
    
    

    @Override
    public boolean process(Transaction t) {
        this.TotalTransaction +=1;
        
        if(t.value() == 0) {
            this.countFiltered += 1;
            return true;
        } else {
            return super.process(t);
        }
    }
    
    
    public double percentFiltered() {
        return 1.0*countFiltered/TotalTransaction*100;
    }
        

    
    
    
}

