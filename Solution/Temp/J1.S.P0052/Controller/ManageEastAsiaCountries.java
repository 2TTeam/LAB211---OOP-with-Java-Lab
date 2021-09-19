package J1.S.P0052.Controller;
import J1.S.P0052.Model.*;
import java.util.ArrayList;
import java.util.Collections;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class ManageEastAsiaCountries {
    private ArrayList<EastAsiaCountries> myList;

    public ManageEastAsiaCountries() {
        myList = new ArrayList<EastAsiaCountries>();
    }
    
    public void addCountry(String xCountryCode,String xCountryName,double xTotalArea,String xCountryTerrain) {
        myList.add(new EastAsiaCountries(xCountryTerrain, xCountryCode, xCountryName, xTotalArea));
    }
    
    public boolean canAdd() {
        return myList.size() < 11;
    }
    
    public boolean isDuplicated(String xCountryCode) {
        return findCountryCode(xCountryCode) >= 0;
    }
    
    public int findCountryCode(String xCountryCode) {
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getCountryCode().equalsIgnoreCase(xCountryCode)) {
                return i;
            }
        }   
        return -1;
    }
    
    public void displayCountry() {
        printHeader();
        for(int i = 0; i < myList.size(); ++i) {
            myList.get(i).display();
        }
    }
    
    public void searchName(String xName) {
        printHeader();
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getCountryName().toLowerCase().
                    contains(xName.toLowerCase())) {
                myList.get(i).display();
            }
        }
    }
    
    public void printHeader() {
            
        System.out.format("%-20s%-20s%-20s%-20s\n","Country Code", "Country Name","Total Area", "Country Terrain");
    
    }
    
    public void displayCountrySortByNameAsc() {
//        tao ra tempList co data giong voi myList, nhung thao tac tren tempList ko anh huong toi myList
        ArrayList<EastAsiaCountries> tempList = new ArrayList<EastAsiaCountries>(myList);
//        moi thao tac tren tempList2 se anh huong truc tiep den myList
//        ArrayList<EastAsiaCountries> tempList2 = myList;
        

//      Cach 1:
//        for(int i = 0; i < tempList.size() - 1; ++i) {
//            for(int j = 0; j < tempList.size() - 1 - i; ++j) {
//                if(tempList.get(j).getCountryName().compareToIgnoreCase(tempList.get(j+1).getCountryName()) > 0) {
//                    Collections.swap(tempList, j, j + 1);
//                }
//            }
//        } O(n^2)
        
//      Cach 2 comparable:     (//      Cach 3 comparator:)
        Collections.sort(tempList);
//        O(nlogn)

        
        printHeader();
        for(EastAsiaCountries entry : tempList) {
            entry.display();
        }
    }
}
