/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.*;

import java.util.LinkedList;
import Model.*;
import java.util.Collections;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class ManageEastAsiaCountries {
    LinkedList<EastAsiaCountries> myList;

    public ManageEastAsiaCountries() {
        myList = new LinkedList<EastAsiaCountries>();
    }
    
    public void addCountry(String xCountryCode, String xCountryName, float xTotal, String xCountryTerrain) {
        myList.add(new EastAsiaCountries(xCountryCode, xCountryName, xTotal, xCountryTerrain));
    }
    
    
    public boolean canAdd() {
        return myList.size() <= 11;
    }
    
    public boolean isDuplicate(String xCode) {
        return findCountryID(xCode) >= 0;
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
    
    public void displayCountry() {
        
        System.out.format("%-20s%-20s%-20s%-20s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
        for(int i = 0; i < myList.size(); ++i) {
            myList.get(i).display();
        }
        
    }
    
    public void displaySortByCountryName() {
        LinkedList<EastAsiaCountries> temp = new LinkedList<EastAsiaCountries>(myList);
        Collections.sort(temp);
        for(int i = 0; i < temp.size(); ++i) {
            temp.get(i).display();
        }
    }
    
    public void searchCountry(String xName) {
       
        System.out.format("%-20s%-20s%-20s%-20s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");    
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getCountryName().toLowerCase().contains(xName.toLowerCase())) {
                myList.get(i).display();
            }
        }
        
    }
    
    
    
}
