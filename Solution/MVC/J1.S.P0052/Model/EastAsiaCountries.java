/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class EastAsiaCountries extends Country implements Comparable<EastAsiaCountries>{
    private String countryTerrain;

    public EastAsiaCountries() {
    }

    public EastAsiaCountries(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20f%-20s",
                super.getCountryCode(),
                super.getCountryName(),
                super.totalArea,
                this.countryTerrain);
    }

    
    
    @Override
    public void display() {
        System.out.println(this.toString() );
    }

    @Override
    public int compareTo(EastAsiaCountries o) {
        return this.getCountryName().compareToIgnoreCase(o.getCountryName());
    }
    
    
}
