/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0101.Controller;

import java.util.*;
import J1.S.P0101.Model.*;
/**
 *
 * @author Ryuunosuke Akasaka
 */


public class EmployeeManagementController {
    ArrayList<Employee> myList;

    public EmployeeManagementController() {
        myList = new ArrayList<Employee>();
    }

    public EmployeeManagementController(ArrayList<Employee> myList) {
        this.myList = myList;
    }
    
    public void add(String id, String firstName, String lastName,
                    String phone, String email, String address, Date DOB, int sex, double salary, String Egency) {
        myList.add(new Employee(id, firstName, lastName, phone, email, address, DOB,sex, salary, Egency));
    }
    
    public void update(String xId, String xFirstName, String xLastName,
                    String xPhone, String xEmail, String xAddress, Date xDOB, int xSex, double xSalary, String xEgency) {
                    
        
        int pos = findID(xId);
        myList.set(pos, new Employee(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, pos, xSalary, xEgency));
    
    }
    
    public void remove(String xId) {
        int pos = findID(xId);
        
        myList.remove(pos);
    }
    
    public void searchName(String xName) {
        
        for(int i = 0; i < myList.size(); ++i) {
            String Fullname = myList.get(i).getFirstName() + myList.get(i).getLastName();
            if(Fullname.toLowerCase().contains(xName.toLowerCase())) {
                System.out.println( myList.get(i) );
            }
        }   
    }
    
    public ArrayList<Employee> searchName2(String xName) {
        
        ArrayList<Employee> tempList = new ArrayList<Employee>();
        
        for(int i = 0; i < myList.size(); ++i) {
            String Fullname = myList.get(i).getFirstName() + myList.get(i).getLastName();
            if(Fullname.toLowerCase().contains(xName.toLowerCase())) {
                tempList.add(myList.get(i));
            }
        } 
        
        return tempList;
    }
    
    public void sortMyList() {
        // sort -> sort myList
        // display sort -> in ra cai list duoc sort chu ko sort myList
        Collections.sort(myList); 
    }
    
    
    public void display() {
        for(int i = 0; i < myList.size(); ++i) {
            System.out.println(myList.get(i));
        }
    } 
    
    public void printHeader() {
        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", 
                "ID",
                "First Name",
                "Last Name",
                "Phone",
                "Email",
                "Address",
                "DOB",
                "Sex",
                "Salary",
                "Egency"
                );
    }
    
    public int findID(String xId) {
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getId().equalsIgnoreCase(xId)) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isDuplicated(String xID) {
        return findID(xID) >= 0;
    }
}
