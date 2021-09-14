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
public class View {
    ManageEastAsiaCountries m;

    public View(ManageEastAsiaCountries m) {
        this.m = m;
    }
    
    public void addCountry() {
        if(m.getMyList().size() < 11) {
            
            String xCountryCode = Utility.GetString("Enter Country Code: ", false);
            
            if( m.findCountryID(xCountryCode) < 0 ) {
                String xCountryName = Utility.GetString("Enter Country Name: ", false);
                float xTotalArea = (float) Utility.GetDouble("Enter Total Area: ", 0.0001, Double.POSITIVE_INFINITY);
                String xCountryTerrain = Utility.GetString("Enter Country Terrain: ", false);
               
                m.getMyList().add(new EastAsiaCountries(xCountryCode, xCountryName, xTotalArea, xCountryTerrain));
                System.out.println("Add Successfully!");
            } else {
                System.out.println("This Code has exist!");
            }
            
            
        }else {
            System.out.println("Asian has only 11!");
        }
    }
    
    public void displayCountry() {
        
        System.out.format("%-20s%-20s%-20s%-20s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
        for(int i = 0; i < m.getMyList().size(); ++i) {
            m.getMyList().get(i).display();
        }
    }
    
    public void searchCountry() {
        
        
        String xName = Utility.GetString("Enter name: ", false);
        System.out.format("%-20s%-20s%-20s%-20s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
        for(int i = 0; i < m.getMyList().size(); ++i) {
            if(m.getMyList().get(i).getCountryName().toLowerCase().contains(xName.toLowerCase())) {
                m.getMyList().get(i).display();
            }
        }
    }
    
    public void displaySortByCountryName() {
        LinkedList<EastAsiaCountries> temp = new LinkedList<EastAsiaCountries>(m.getMyList());
        
//        for(int i = 0; i < temp.size() - 1; ++i) {
//            for(int j = 0; j < temp.size() - 1 - i; ++j) {
//                if(temp.get(j).getCountryName().compareToIgnoreCase(temp.get(j + 1).getCountryName()) > 0 ) {
//                    Collections.swap(temp, j, j + 1);
//                } 
//            }
//        }
     

        Collections.sort(temp);
        for(int i = 0; i < temp.size(); ++i) {
            temp.get(i).display();
        }
          
    
    }
}
