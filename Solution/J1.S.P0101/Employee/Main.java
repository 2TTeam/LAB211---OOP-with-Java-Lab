package Employee;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        EmployeeManager employeeManager = new EmployeeManager();
        String employeeId;

        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    employeeId = employeeManager.inputId();
                    employeeManager.add(employeeId);
                    break;
                case "2":
                    employeeId = employeeManager.inputId();
                    employeeManager.update(employeeId);
                    break;
                case "3":
                    employeeId = employeeManager.inputId();
                    employeeManager.remove(employeeId);
                    break;
                case "4":
                    employeeId = employeeManager.inputName();
                    employeeManager.search(employeeId);
                    break;
                case "5":
                    employeeManager.sortEmployeeBySalary();
                    break;
                case "6":
                    employeeManager.show();
                    break;
                case "0":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
    }
    public static void showMenu() {
        System.out.println("==============================");
        System.out.println(" EMPLOYEE MANAGEMENT SYSTEM ");
        System.out.println("==============================");
        System.out.println("--------------menu----------");
        System.out.println("1. Add employees.");
        System.out.println("2. Update employees.");
        System.out.println("3. Remove employees.");
        System.out.println("4. Search employees. ");
        System.out.println("5. Sort employees by salary");
        System.out.println("6. Show data.");
        System.out.println("0. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }

}
