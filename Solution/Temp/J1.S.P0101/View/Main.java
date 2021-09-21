/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0101.View;

import J1.S.P0101.Controller.*;
import java.util.*;
import J1.S.P0101.Model.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) throws ParseException {
     
        EmployeeManagementController m = new EmployeeManagementController();
        
        SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
        
        
        m.add("01", "Nguyen Van", "A", "021312313", "@fpt", "x", SDF.parse("20-11-2021"), 1, 11234.25, "FPT");
        m.add("02", "Nguyen Quang", "B", "021312313", "@fpt", "x", SDF.parse("20-12-2021"), 3, 1000, "FPT");
        m.add("03", "Nguyen Va", "C", "021312313", "@fpt", "x", SDF.parse("19-11-2021"), 1, 11234.25, "FPT");
        m.add("04", "Nguyen thi", "Van", "021312313", "@fpt", "x", SDF.parse("12-11-2021"), 2, 122, "FPT");
        
        
        
        int choice;
        String xFirstName;
        String xLastName;
        String xPhone;
        String xEmail;
        String xAddress;
        Date xDOB;
        int xSex;
        double xSalary;
        String Egency;
        
        do {
            System.out.println("Main menu:\n" +
                                "1. Add employees \n" +
                                "2. Update employees\n" +
                                "3. Remove employees\n" +
                                "4. Search employees\n" +
                                "5. Sort employees by salary\n" +
                                "6. Display\n" +
                                "7. Exit\n");
            
            choice = Utility.getInt("Enter your choice: ", 1, 6);
            
            
            switch(choice) {
                case 1:      
                    String xId = Utility.getString("Enter id: ", false);
                    if(m.isDuplicated(xId) == false ) {
                    
                        xFirstName = Utility.getString("Enter first name: ", false);
                        xLastName = Utility.getString("Enter last name: ", false);
                        xPhone = Utility.getStringByRegex("Enter phone: ", Utility.PHONE_PATTERN);
                        xEmail = Utility.getStringByRegex("Enter email: ", Utility.EMAIL_PATTERN);
                        xAddress = Utility.getString("Enter address: ", false);
                        xDOB = Utility.getDate("Enter date: ", "dd-MM-yyyy");
                        xSex = Utility.getInt("Enter sex: " , 1, 3);
                        xSalary = Utility.getDouble("Enter salary: ", 0.0001, Double.POSITIVE_INFINITY);
                        Egency = Utility.getString("Enter Egency: ", false);
                        
                        m.add(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, Egency);
                    } else {
                        System.out.println("This id has existed!");
                    } 
                    
                    break;
                case 2:
                    xId = Utility.getString("Enter id: ", false);
                    if(m.isDuplicated(xId) == true ) {
                    
                        xFirstName = Utility.getString("Enter first name: ", false);
                        xLastName = Utility.getString("Enter last name: ", false);
                        xPhone = Utility.getStringByRegex("Enter phone: ", Utility.PHONE_PATTERN);
                        xEmail = Utility.getStringByRegex("Enter email: ", Utility.EMAIL_PATTERN);
                        xAddress = Utility.getString("Enter address: ", false);
                        xDOB = Utility.getDate("Enter date: ", "dd-MM-yyyy");
                        xSex = Utility.getInt("Enter sex: " , 1, 3);
                        xSalary = Utility.getDouble("Enter salary: ", 0.0001, Double.POSITIVE_INFINITY);
                        Egency = Utility.getString("Enter Egency: ", false);
                        
                        m.update(xId, xFirstName, xLastName, xPhone, xEmail, xAddress, xDOB, xSex, xSalary, Egency);
                    
                    } else {
                        System.out.println("This id doesn't exist!");
                    } 
                    
                    
                    
                    break;
                case 3:
                    xId = Utility.getString("Enter id: ", false);
                    if(m.isDuplicated(xId) == true ) {
                        m.remove(xId);
                    } else {
                        System.out.println("This id doesn't exist!");
                    } 
                    
                    break;
                case 4:
                    String searchName = Utility.getString("Enter name: ", false);
                    
                    m.printHeader();
                    ArrayList<Employee> list = m.searchName2(searchName);
                    for(Employee entry : list) {
                        System.out.println(entry);
                    }
                    
                    break;
                case 5:
                    m.sortMyList();
                    System.out.println("List has been sorted!");
                    break;  
                case 6:
                    m.printHeader();
                    m.display();
                    break;
            }
            
        }while(choice != 7);
        
    }
}
