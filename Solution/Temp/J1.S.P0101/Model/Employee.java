/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0101.Model;

import J1.S.P0011.Utility;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Employee implements Comparable<Employee>{
    
    private String[] TYPESEX  = {"M", "FM", "03"};
    
    private String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    private Date DOB;
    private int sex; //1 ,2 ,3
    private double salary;
    private String Egency;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName,
           String phone, String email, String address, Date DOB, int sex, double salary, String Egency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.DOB = DOB;
        this.sex = sex;
        this.salary = salary;
        this.Egency = Egency;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEgency() {
        return Egency;
    }

    public void setEgency(String Egency) {
        this.Egency = Egency;
    }
    
    
    
    @Override
    public String toString() {
       
        return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20.2f%-20s", 
                this.getId(),
                this.getFirstName(),
                this.getLastName(),
                this.getPhone(),
                this.getEmail(),
                this.getAddress(),
                SDF.format(this.getDOB()),
                this.TYPESEX[this.getSex() - 1],
                this.getSalary(),
                this.getEgency()
                );
    }
    
    
    
//    public static void main(String[] args) {
//        Date d = new Date(2021, 12, 31);
//        Employee e = new Employee("001", "a", "b", "01234", "@gmail", "asd", d, 1, 1231231.2, "FPT");
//        System.out.println(e);
//    }

    @Override
    public int compareTo(Employee o) {
        
        if(this.getSalary() < o.getSalary()) {
            return -1;
        } else if(this.getSalary() > o.getSalary()) {
            return 1;
        } else {
            return 0;
        }
    }
    
    
    
            
}
