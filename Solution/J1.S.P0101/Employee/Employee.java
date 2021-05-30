package Employee;

import java.io.Serializable;

public class Employee implements Serializable {
    String Id;
    String firstName;
    String lastName;
    String Phone;
    String Email;
    String Address;
    String DOB;
    String Sex;
    int Salary;
    String Egency;

    public Employee() {

    }

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String DOB, String sex, int salary, String egency) {
        Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Phone = phone;
        Email = email;
        Address = address;
        this.DOB = DOB;
        Sex = sex;
        Salary = salary;
        Egency = egency;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getEgency() {
        return Egency;
    }

    public void setEgency(String egency) {
        Egency = egency;
    }
}
