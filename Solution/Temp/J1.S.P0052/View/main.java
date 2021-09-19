/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052.View;
import J1.S.P0052.Controller.*;
import java.util.ArrayList;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        m.addCountry("01", "B", 10, "a");
        m.addCountry("02", "A", 10, "b");
        m.addCountry("03", "C", 12, "c");
        int choice;
        
        do {
            System.out.println("1. Enter the information for 11 countries in Southeast Asia.\n" +
                               "2. Display already information.\n" +
                               "3. Search the country according to the entered country's name.\n" +
                               "4. Display the information increasing with the country name.\n" +
                               "5. Exit.\n");
            choice = Utility.getInt("Enter your choice: ", 1, 5);
            
            switch(choice) {
                case 1:
                    if(m.canAdd() == true) {
                        String xCountryCode = Utility.getString("Enter country code: ", false);
                        if(m.isDuplicated(xCountryCode) == false) {
                            String xCountryName = Utility.getString("Enter country name: ", false);
                            double xTotalArea = Utility.getDouble("Enter total area: ", 0.001, Double.POSITIVE_INFINITY);
                            String xCountryTerrain = Utility.getString("Enter country Terrain: ", false);
                            
                            m.addCountry(xCountryCode, xCountryName, xTotalArea, xCountryTerrain);
                        } else {
                            System.out.println("This ID has existed");
                        }
                    }
                break;
                case 2:
                    m.displayCountry();
                break;
                case 3:
                    String xName = Utility.getString("Enter name: ", false);
                    m.searchName(xName);
                break;
                case 4:
                    m.displayCountrySortByNameAsc();
                break;
            }
            
            
        }while(choice != 5);
    
    }
    
}
