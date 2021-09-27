/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.TaskController;
import Controller.Utility;
import java.util.Date;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
     public static void main(String[] args) {
        TaskController m = new TaskController();
         
        int choice;
        
        int xID;
        int xTypeTypeID;
        String xName;
        Date xDate;
        double xFrom;
        double xTo;
        String xAssignee;
        String xReviewer;
        
        do{
            System.out.println("1. Add Task\n" +
                               "2. Delete Task\n"+
                               "3. Show Task\n"+
                               "4. Exit the program\n");
            
            choice = Utility.GetInt(
                    "Enter your choice: ", 1, 4);
            
            switch(choice) {
                case 1:
                    xName = Utility.GetString(
                            "Requirement Name:", false);
                    xTypeTypeID = Utility.GetInt(
                            "Task Type: ", 1, 4);
                    xDate = Utility.GetDate("Date: ");
                    
                    xFrom = m.getFromTo("From: ", 8.0, 17.0);
                    
                    xTo = m.getFromTo("To: ", xFrom + 0.5, 17.5);
                    xAssignee = Utility.GetString(
                            "Assignee: ", false);
                    xReviewer = Utility.GetString(
                            "Reviewer: ", false);
                    
                    m.addTask(xTypeTypeID, xName, xDate, xFrom, xTo, xAssignee, xReviewer);
                    System.out.println("Add Successfully");
                    break;
                case 2:
                    xID = Utility.GetInt("Enter ID you want to delete: ",1 , Integer.MAX_VALUE);
                    if(m.isDupplicated(xID) == true) {
                        m.delete(xID);
                        System.out.println("Deleted successfully!");
                    } else {
                        System.out.println("This ID doesn't exist!");
                    }
                    break;
                case 3:
                    System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n",
                                  "ID",
                                  "Name",
                                  "Task Type",
                                  "Date",
                                  "Time",
                                  "Assignee",
                                  "Reviewer"
                );
                    m.showTask();
                    break;
            }
            
        }while(choice != 4);
    }
}
