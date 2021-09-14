/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052;

import Template.Utility;
import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        
        ManageEastAsiaCountries m = new ManageEastAsiaCountries();
        View v = new View(m);
        int choice;
        
        do {
            System.out.println("1. Enter the information for 11 countries in Southeast Asia.\n" +
                                "2. Display already information.\n" +
                                "3. Search the country according to the entered country's name.\n" +
                                "4. Display the information increasing with the country name.\n" +
                                "5. Exit.\n");
            
            
            choice = J1.S.P0052.Utility.GetInt("Enter your choice: ",
                    1,
                    5);
                       
            switch(choice) {
                case 1:
                    v.addCountry();
                break;
                case 2:
                    v.displayCountry();
                break;
                case 3:
                    v.searchCountry();
                break;
                case 4:
                    v.displaySortByCountryName();
                break;
            }
            
        }while(choice != 5);
    
    
    }
    
}
