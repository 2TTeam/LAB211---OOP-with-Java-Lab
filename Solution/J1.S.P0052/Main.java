/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052;

/**
 *
 * @author Ryuunosuke Akasaka
 */
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ManageEastAsiaCountries mn = new ManageEastAsiaCountries();
        ArrayList<EastAsiaCountries> listAsiaCountry  = new ArrayList<>();
        int i;
        do {
            System.out.println("1. Enter the information for 11 countries in Southeast Asia.");
            System.out.println("2. Display already information.");
            System.out.println("3. Search the country according to the entered country's name.");
            System.out.println("4. Display the information increasing with the country name.");
            System.out.println("5. Exit.");
            i = Utility.GetInt("Please choice one option: " , 1 , 5);
            switch (i){
                case 1:
                    mn.addCountry(listAsiaCountry);
                    break;
                case 2:
                    mn.displayInformation(listAsiaCountry);
                    break;
                case 3:
                    mn.searchInformation(listAsiaCountry);
                    break;
                case 4:
                    mn.displaySortedInformation(listAsiaCountry);
                    break;
                case 5:
                    break;
            }
        }while (i != 5);
    }
}
