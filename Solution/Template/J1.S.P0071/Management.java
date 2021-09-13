/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Management {
    private LinkedList<task> myList;

    public Management() {
        myList = new LinkedList<task>();
        menu();
    }
    
    public void menu() {
        int choice;
        
        do {
            choice = Utility.GetInt("1. Add the task\n"
                + "2. Update the task\n"
                + "3. Delete the task\n"
                + "4. Show Task\n"
                + "0. Exist\n"
                + "Enter your choice: ", 0, 4);
            
            switch(choice) {
                case 1:
                    addTask();
                break;
                case 2:
                    updateTask();
                break;
                case 3:
                    deleteTask();
                break;
                case 4:
                    displayTask();
                break;
            }
            
        
        }while(choice != 0);
        
    }
    
    public void addTask() {
        int xID = 1;
        if(myList.size() > 0) {
            xID = myList.get(myList.size() - 1).getId() + 1;
        } 
        
        
        
        String xName = Utility.GetString("Requirement Name: ",
                false);
        int xTaskTypeID = Utility.GetInt("Task Type ID:", 1, 4);
        Date xDate = Utility.GetDate("Date: ", "MMM-dd-yyyy");
        double xFrom = getFromTo("From: ", 8.0, 17.5 - 0.5, false) ;
        double xTo = getFromTo("To: ", xFrom + 0.5, 17.5, false) ;
        String xAssignee = Utility.GetString("Assignee: ", false);
        String xReviewer = Utility.GetString("Reviewer: ", false);
        
        myList.add(new task(xID, xTaskTypeID, xName, xDate, xFrom, xTo, xAssignee, xReviewer));
        System.out.println("Add successfully");
    }
    
    public static double getFromTo(String msg, double min,double max, boolean isIncludeNope){
        double i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                String inputString = sc.nextLine();
                
                if(isIncludeNope == true && inputString.equals("nope")) {
                    return -1;
                }
                                
                i = Double.parseDouble(inputString);
                
                
                if(i < min || i > max) {
                    System.out.println("Out of range!");
                    continue;
                }
                
                int a = (int) (i * 10); 
                
//              8.55
                if( i * 10 - a == 0) {
                    // 8.4
                    if(a % 5 == 0) {
                        return i;
                    } else {
                        System.out.println("Wrong format 1");
                    }
                } else {
                    System.out.println("Wrong format 2");
                }
                
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(true);    
    }
    
    public void deleteTask() {
        int xID = Utility.GetInt("Enter ID: ", 1, Integer.MAX_VALUE);
        int pos = findID(xID);
        
        if( pos < 0) {
            System.out.println("This ID doesn't exist !");
            return;
        } else {
            myList.remove(pos);   
            System.out.println("Remove successfully! ");
        }
        
    }
    
    public void displayTask() {
        LinkedList<task> temp = new LinkedList<>(myList);
        Collections.sort(temp);

        System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                "ID",
                "Name",
                "Task Type",
                "Date",
                "Time",
                "Assignee",
                "Reviewer"
                );
        
        for(task entry : temp) {
            System.out.println(entry);
        }
    }
    
    
    public int findID(int xID) {
        
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getId() == xID) {
                return i;
            }
        }
        return -1;
    }
    
    public void updateTask()  {
        int xID = Utility.GetInt("Enter ID: ", 1, Integer.MAX_VALUE);
        int pos = findID(xID);
        
        System.out.println(myList.get(pos));
        
        if(pos < 0) {
            System.out.println("This ID doesn't exist! ");
        } else {
            String xName = Utility.GetString("Requirement Name: ", false);
            if(! "nope".equals(xName)) {
                myList.get(pos).setRequirementName(xName);
            }
            
            String xTaskTypeID = Utility.GetStringByRegex("Task Type ID: ", "^[1-4]$|^nope$");
            if( !xTaskTypeID.equals("nope")) {
                myList.get(pos).setTaskTypeID(Integer.parseInt(xTaskTypeID));
            }
            
            String[] ANOTHER_INPUT = { "nope" };
             
            String xDate = Utility.GetDate("Date", "MMM-dd-yyyy" , "dd-MMM-yyyy", ANOTHER_INPUT);
            if(!xDate.equals("nope") ) {
                SimpleDateFormat SDFtemp = new SimpleDateFormat("dd-MMM-yyyy");
                
                try {
                    myList.get(pos).setDate(SDFtemp.parse(xDate));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            
            double xFrom = getFromTo("From: ", 8, 17, true);
            if(xFrom != -1) {
                myList.get(pos).setFrom(xFrom);
            }
            
            do{
                double xTo = getFromTo("To: ", xFrom + 0.5, 17.5 , true);
                
                if(xTo == -1) {
                    xTo = myList.get(pos).getTo();
                }
                
                if(xTo <= xFrom) {
                    System.out.println("To Must Larger than From!");
                } else {
                    myList.get(pos).setTo(xTo);
                    break;
                }
                
            }while(true);
            
            String xAssignee = Utility.GetString("Assignee: ", false);
            if( ! xAssignee.equals("nope")) {
                myList.get(pos).setAssignee(xAssignee);
            }
            
            String xReviewer = Utility.GetString("Reviewer: ", false);
            if( ! xReviewer.equals("nope")) {
                myList.get(pos).setReviewer(xReviewer);
            }
            
            System.out.println("Update Successfully! ");
        }
    }
    
    
    public static void main(String[] args) {
        Management m = new Management();
    }
}
