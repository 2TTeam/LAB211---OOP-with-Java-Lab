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
import java.util.Collections;

public class ManageEastAsiaCountries {
    public int SearchByID(ArrayList<EastAsiaCountries> asiaC, String code){
        for (int i = 0; i < asiaC.size(); i++) {
            if (asiaC.get(i).getCountryCode().equalsIgnoreCase(code)){
                    return i;
            }
        }
        return -1;
    }

    public void addCountry(ArrayList<EastAsiaCountries> asiaC){
        if (asiaC.size() == 11){
            System.out.println("Asia has only 11 countries");
        }
        else {          
            String code = Utility.GetString("Enter country code: ",false);

            if (SearchByID(asiaC, code) >= 0) {
                System.out.println("This country is exist");
                return;
            } 
            
            String name = Utility.GetString("Enter country name: ",false);
//            String name = Utility.GetStringByRegex("Enter country code: ","^([a-zA-Z]+ {0,1})*$");
            double area = Utility.GetDouble("Enter total area:  ",0,Double.POSITIVE_INFINITY);
            String terrain = Utility.GetString("Enter terrain of country: ",false);
            asiaC.add(new EastAsiaCountries(code, name, area, terrain));
        }
    }

    public void searchInformation(ArrayList<EastAsiaCountries> asiaC){
        boolean flag = false;
        String str = Utility.GetString("Enter the name you want to search for: ",false);
        
        
        for (EastAsiaCountries entry : asiaC) {
            if(entry.getCountryName().toLowerCase().contains(str.toLowerCase())) {
                if(flag==false) System.out.printf("%-20s%-20s%-20s%-20s\n","ID","Name","Area","Terrain");
                entry.display();         
                flag = true; 
            }
        }
        if(flag == false) System.out.println("No result!");
    }

    public void displayInformation(ArrayList<EastAsiaCountries> asiaC){
        System.out.printf("%-20s%-20s%-20s%-20s\n","ID","Name","Area","Terrain");
        for (EastAsiaCountries asiaCountries: asiaC) {
                asiaCountries.display();
        }
    }
    public void displaySortedInformation(ArrayList<EastAsiaCountries> asiaC){
        System.out.printf("%-20s%-20s%-20s%-20s\n","ID","Name","Area","Terrain");
        ArrayList<EastAsiaCountries> temp = new ArrayList<>(asiaC);
        Collections.sort(temp);
        for (EastAsiaCountries asiaCountries: temp) {
            asiaCountries.display();
        }
    }
}




