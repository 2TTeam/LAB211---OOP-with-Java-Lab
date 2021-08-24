/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0071;

import java.util.Comparator;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class CompareByID_Desc implements Comparator<Task>{

    @Override
    public int compare(Task o1, Task o2) {
        return  -(o1.getID() - o2.getID()) ;
    }

   
            
    
}
