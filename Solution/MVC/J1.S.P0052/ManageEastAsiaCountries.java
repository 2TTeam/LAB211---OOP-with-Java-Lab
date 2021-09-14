/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class ManageEastAsiaCountries {
    private LinkedList<EastAsiaCountries> myList;

    public ManageEastAsiaCountries() {
        myList = new LinkedList<EastAsiaCountries>();

    }
    
    public int findCountryID(String xCountryCode) {
        
       for(int i = 0; i < myList.size(); ++i) {
           if( myList.get(i).getCountryCode().equalsIgnoreCase(xCountryCode)) {
               return i;
           }
       }
       
       return -1;
    }
    

    
    public LinkedList<EastAsiaCountries> getMyList() {
        return myList;
    }
    

    public void setMyList(LinkedList<EastAsiaCountries> myList) {
        this.myList = myList;
    }
    
    
    
   
    
}
