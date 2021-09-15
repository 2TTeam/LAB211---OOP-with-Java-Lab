/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.*;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        
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
                    if(m.canAdd() == true) {
                        String xCountryCode = Utility.GetString("Enter Country Code: ", false);
                        
                        if( !m.isDuplicate(xCountryCode) ) {
                            String xCountryName = Utility.GetString("Enter Country Name: ", false);
                            float xTotalArea = (float) Utility.GetDouble("Enter Total Area: ", 0.0001, Double.POSITIVE_INFINITY);
                            String xCountryTerrain = Utility.GetString("Enter Country Terrain: ", false); 
                            m.addCountry(xCountryCode, xCountryName, xTotalArea, xCountryTerrain);
                        }
                    } 
                break;
                case 2:
                    m.displayCountry();
                break;
                case 3:
                    String xName = Utility.GetString("Enter name: ", false);
                    m.searchCountry(xName);
                break;
                case 4:
                    m.displaySortByCountryName();
                break;
            }
            
        }while(choice != 5);
    }
    
}
