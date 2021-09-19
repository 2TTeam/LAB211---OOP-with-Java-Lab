/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0052.Model;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Country {
    protected String countryCode;
    protected String countryName;
    protected double totalArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20f", this.countryCode, this.countryName,this.totalArea);
    }
    
    public void display() {
        System.out.println(this.toString());
    }
    
    
    
}
