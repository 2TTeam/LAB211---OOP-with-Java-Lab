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
        Menu();
    }
    
    public void Menu() {
        int choice;
        
        do {
            System.out.println("1. Enter the information for 11 countries in Southeast Asia.\n" +
                                "2. Display already information.\n" +
                                "3. Search the country according to the entered country's name.\n" +
                                "4. Display the information increasing with the country name.\n" +
                                "5. Exit.\n");
            
            
            choice = Utility.GetInt("Enter your choice: ",
                    1,
                    5);
            
            
            switch(choice) {
                case 1:
                    addCountry();
                break;
                case 2:
                    displayCountry();
                break;
                case 3:
                    searchCountry();
                break;
                case 4:
                    displaySortByCountryName();
                break;
            }
            
        }while(choice != 5);
    }
    
    public void addCountry() {
        if(myList.size() < 11) {
            
            String xCountryCode = Utility.GetString("Enter Country Code: ", false);
            
            if( findCountryID(xCountryCode) < 0 ) {
                String xCountryName = Utility.GetString("Enter Country Name: ", false);
                float xTotalArea = (float) Utility.GetDouble("Enter Total Area: ", 0.0001, Double.POSITIVE_INFINITY);
                String xCountryTerrain = Utility.GetString("Enter Country Terrain: ", false);
               
                myList.add(new EastAsiaCountries(xCountryCode, xCountryName, xTotalArea, xCountryTerrain));
                System.out.println("Add Successfully!");
            } else {
                System.out.println("This Code has exist!");
            }
            
            
        }else {
            System.out.println("Asian has only 11!");
        }
    }
    
    public int findCountryID(String xCountryCode) {
        
       for(int i = 0; i < myList.size(); ++i) {
           if( myList.get(i).getCountryCode().equalsIgnoreCase(xCountryCode)) {
               return i;
           }
       }
       
       return -1;
    }
    
    public void displayCountry() {
        
        System.out.format("%-20s%-20s%-20s%-20s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
        for(int i = 0; i < myList.size(); ++i) {
            myList.get(i).display();
        }
    }
    
    public void searchCountry() {
        
        
        String xName = Utility.GetString("Enter name: ", false);
        System.out.format("%-20s%-20s%-20s%-20s\n", "Country Code", "Country Name", "Total Area", "Country Terrain");
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getCountryName().toLowerCase().contains(xName.toLowerCase())) {
                myList.get(i).display();
            }
        }
    }
    
    public void displaySortByCountryName() {
        LinkedList<EastAsiaCountries> temp = new LinkedList<EastAsiaCountries>(myList);
        
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
    
    public static void main(String[] args) {
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        
     
    }
    
}
