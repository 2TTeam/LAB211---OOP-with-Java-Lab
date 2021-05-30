package Employee;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class EmployeeManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Employee> employeeList;
    private EmployeeWR employeeWR;

    public EmployeeManager() {
        employeeWR = new EmployeeWR();
        employeeList = employeeWR.read();
    }
    public void add(String Id) {
        boolean isExisted = false;
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId().equals(Id)) {
                isExisted = true;
                System.out.printf("Employee ID : %s is already available !\n", Id);
                break;
            }
        }
        if (!isExisted) {
            String firstName = inputFirstName();
            String lastName = inputLastName();
            String Phone = inputPhone();
            String Email = inputEmail();
            String Address = inputAddress();
            String DOB = inputDOB();
            String Sex = inputSex();
            int Salary = inputSalary();
            String Egency = inputEgency();
            Employee employee = new Employee(Id, firstName, lastName, Phone, Email, Address, DOB, Sex,
                    Salary, Egency);
            System.out.println("Information of course has been added!");
            employeeList.add(employee);
            employeeWR.write(employeeList);
        }
    }
    public void search(String Name){
        boolean isExisted = false;
        String fullname ;

        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            fullname = employeeList.get(i).getFirstName() + " " +  employeeList.get(i).getLastName();
            if (employeeList.get(i).getFirstName().equals(Name) || employeeList.get(i).getLastName().equals(Name) || fullname.equals(Name)) {
                isExisted = true;
                System.out.println("Information of course : ");
                System.out.println("Employee ID : " + employeeList.get(i).getId());
                System.out.println("Employee FirstName : " + employeeList.get(i).getFirstName());
                System.out.println("Employee LastName : " + employeeList.get(i).getLastName());
                System.out.println("Employee Phone : " + employeeList.get(i).getPhone());
                System.out.println("Employee Email : " + employeeList.get(i).getEmail());
                System.out.println("Employee Address : " + employeeList.get(i).getAddress());
                System.out.println("Employee DOB : " + employeeList.get(i).getDOB());
                System.out.println("Employee Sex : " + employeeList.get(i).getSex());
                System.out.println("Employee Salary : " + employeeList.get(i).getSalary());
                System.out.println("Employee Egency : " + employeeList.get(i).getEgency());
                break;
            }
        }
        if (!isExisted) {
            System.out.printf("Name : %s not existed.\n", Name);
        }
    }

    public void remove(String Id) {
        Employee employee = null;
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId().equals(Id)) {
                employee = employeeList.get(i);
                break;
            }
        }
        if (employee != null) {
            employeeList.remove(employee);
            employeeWR.write(employeeList);
            System.out.println("Information has been deleted!");

        } else {
            System.out.printf("id = %s not existed.\n", Id);
        }
    }
    public class SortEmployeeBySalary implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            if (employee1.getSalary()> employee2.getSalary()) {
                return 1;
            }
            return -1;
        }
    }


    public void sortEmployeeBySalary() {
        Collections.sort(employeeList, new SortEmployeeBySalary());
        employeeWR.write(employeeList);
        System.out.println("Information of course has been update !");
    }
    public void show() {
        System.out.println(" ID       |            Name           |   Sex   |       Phone      " +
                "|               Email              |                 Address              " +
                "|      DOB      |   Salary   |  Egency ");
        for (Employee employee : employeeList) {
            System.out.printf("%3s%17s %s%13s%18s%35s%30s%26s%14d%10s\n", employee.getId(), employee.getFirstName(),
                    employee.getLastName(),employee.getSex(), employee.getPhone(), employee.getEmail(), employee.getAddress(),
                    employee.getDOB(), employee.getSalary(), employee.getEgency());
        }

    }
    public void update(String Id) {
        boolean isExisted = false;
        int size = employeeList.size();
        for (int i = 0; i < size; i++) {
            if (employeeList.get(i).getId().equals(Id)) {
                isExisted = true;
                employeeList.get(i).setFirstName(inputFirstName());
                employeeList.get(i).setLastName(inputLastName());
                employeeList.get(i).setId(inputId());
                employeeList.get(i).setPhone(inputPhone());
                employeeList.get(i).setEmail(inputEmail());
                employeeList.get(i).setAddress(inputAddress());
                employeeList.get(i).setDOB(inputDOB());
                employeeList.get(i).setSex(inputSex());
                employeeList.get(i).setSalary(inputSalary());
                employeeList.get(i).setEgency(inputEgency());
                break;
            }
        }

        if (!isExisted) {
            System.out.printf("Id = %s not existed.\n", Id);
        } else {
            employeeWR.write(employeeList);
        }
    }
    public String inputName(){
        String Name;
        System.out.print("Enter employee name :");
        Name = scanner.nextLine();
        return Name;
    }

    public String inputId(){
        String Id;
        System.out.print("Enter employee id: ");
        Id = scanner.nextLine();
        return Id;
    }
    public String inputFirstName(){
        String firstName;
        System.out.print("Enter employee Firstname :");
        firstName = scanner.nextLine();
        return firstName;
    }
    public String inputLastName(){
        String lastName;
        System.out.print("Enter employee Lastname :");
        lastName = scanner.nextLine();
        return lastName;
    }

    public String inputPhone(){
        String Phone;
        String regex = "^0[123456789]{1}\\d{8}$";
        while(true){
            System.out.print("Enter employee Phone: ");
            Phone = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Phone);
            if(matcher.find()){
                break;
            }else{
                System.out.println("Invalid phone phone !");
            }
        }
        return Phone;
    }

    public String inputEmail(){
        String Email;
        String regex = "^\\w+[a-z0-9]*@{1}[a-zA-Z]+mail.com$";
        while(true){
            System.out.print("Enter employee email (email@address.com): ");
            Email = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Email);
            if(matcher.find()){
                break;
            }else{
                System.out.println("Invalid phone email !");
            }
        }
        return Email;
    }

    public String inputAddress(){
        String Address;
        System.out.print("Enter employee address : ");
        Address = scanner.nextLine();
        return Address;
    }

    public String inputDOB(){
        String DOB;
        String regex = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))|((29|30)[\\/]" +
                "(0[4,6,9]|11)))[\\/](19|[2-9][0-9])\\d\\d$)|(^29[\\/]02[\\/](19|[2-9][0-9])" +
                "(00|04|08|12|16|20|24|28|32|36|40|44|48|52|56|60|64|68|72|76|80|84|88|92|96)$)";
        while(true){
            System.out.print("Enter employee DBO (dd/MM/yyyy): ");
            DOB = scanner.nextLine();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(DOB);
            if(matcher.find()){
                break;
            }else{
                System.out.println("Invalid phone DOB !");
            }
        }
        return DOB;
    }

    public String inputSex(){
        String Sex;
        while(true){
            System.out.print("Enter employee Sex : ");
            Sex = scanner.nextLine();
            if(Sex.equals("Nam")){
                break;
            }else if (Sex.equals("Nu")){
                break;
            }else{
                System.out.println("Invalid phone sex !");
            }
        }
        return Sex;
    }

    public int inputSalary(){
        int Salary;
        while(true){
            try{
                System.out.print("Enter employee salary : ");
                Salary = Integer.parseInt(scanner.nextLine());
                break;
            }catch (Exception e){
                System.out.println("Invalid phone salary");
            }
        }
        return Salary;
    }
    public String inputEgency(){
        String Egency;
        System.out.print("Enter employee egency : ");
        Egency = scanner.nextLine();
        return Egency;
    }

}
