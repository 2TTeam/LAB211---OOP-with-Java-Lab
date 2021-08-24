/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0071;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Management {
    
    private LinkedList<Task> myList;

    public Management() {
        myList = new LinkedList<Task>();
        
        int choice;
        do{
            choice = Utility.GetInt(
                  "1. Add Task\n"
                + "2. Update Task\n"
                + "3. Delete Task\n"
                + "4. Display Task\n"
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
                    display();
                    break;
            }
        
        }while(choice != 0);   
    }
    
    
//    0, 1, 2, 3, 4, 5
    
   public void addTask() {
       
       int xID;
       if( myList.size() == 0 ) {
           xID = 1;
       }else {
           xID = myList.get(myList.size() - 1).getID() + 1;
       }
       
       String xName = Utility.GetString("Enter Name: ", false);
       int xTaskTypeID = Utility.GetInt("Enter Task Type ID: ", 1, 4);
       Date xdate = Utility.GetDate("Enter date: ");
       double xFrom = getFromTo("Enter From: ",8, 17.5);
       double xTo = getFromTo("Enter To: ", xFrom+0.1, 17.5);
       String xAssignee = Utility.GetString("Enter Assignee: ", false);
       String xReviewer = Utility.GetString("Enter Reviewer", false);
       
       myList.add(new Task(xID ,xTaskTypeID, xName, xdate, xFrom, xTo, xAssignee, xReviewer));
       System.out.println("Add Successfully!");
   }
   
   public double getFromTo(String msg, double min, double max) {
       double n;
       do{
           n = Utility.GetDouble(msg, min, max );
           int a = (int) (n*10);
           if(a % 5 == 0) {
               return n;
           }
          
       }while(true);
   }
    
   public void updateTask() {
       int xID = Utility.GetInt("Enter ID want to update: ", 1,  Integer.MAX_VALUE);
       int pos = findID(xID);
       
       if(pos == -1) {
           System.out.println("This ID isn't exist! ");
           return;
       }else {
           System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","ID","Name", "TaskType","Date","Time", "Assignee","Reviewer");
           System.out.println(myList.get(pos));
           
           String xName = Utility.GetString("Task name: ", false);
           if( !xName.equals("nope")) {
              myList.get(pos).setRequiredmentName(xName);
           }
           
            String xTaskTypeID = Utility.GetStringByRegex("Task Type: ", "^nope$|^[1-4]$");
           if( !xTaskTypeID.equals("nope") ) {
               myList.get(pos).setTaskTypeID(  Integer.parseInt(xTaskTypeID) );
           }
           
           
           SimpleDateFormat SDF = new SimpleDateFormat("MMM-dd-yyyy");
           String xDate = GetDateAndnope("Date: ");
           
           if(!xDate.equals("nope")) {
               try {
                   myList.get(pos).setxDate( SDF.parse(xDate) );
               } catch (Exception e) {
                   System.out.println(e);
               }
           }
           
           double xFrom = GetFromToAndnope("From: ", 8, 17.5);
           if(! (xFrom == -1) ) {
               myList.get(pos).setFrom(xFrom);
           }
           
           
           double xTo;
           
           do{
               
               xTo = GetFromToAndnope("To: ", myList.get(pos).getFrom()+0.1, 17.5);
               if(xTo == -1 && myList.get(pos).getTo() < myList.get(pos).getFrom()){
                   System.out.println("To must be larger than from!");
               } else {
                   myList.get(pos).setTo(xTo);
                   break;
               }  
           }while(true);   
           
           
           
           String xAssignee = Utility.GetString("Assignee: ", false);
           if( !xAssignee.equals("nope")) {
               myList.get(pos).setAssignee(xAssignee);
           }
           
           
           
           String xReviewer = Utility.GetString("Reviewer: ", false);
           if( !xReviewer.equals("nope")) {
               myList.get(pos).setReviewer(xReviewer);
           }
   
           
       }
   }
   
   
   public void deleteTask() {
       int xID = Utility.GetInt("Enter ID want to delete: ", 1, Integer.MAX_VALUE);
       int pos = findID(xID);
       
       if( pos == -1) {
           System.out.println("This ID isn't exist! ");
           return;
       } else {
           myList.remove(pos); 
           System.out.println("Delete successfully! ");
       }
   }
   
   
   
   
   public int findID(int xID) {
       for(int i = 0; i < myList.size(); ++i) {
           if(myList.get(i).getID() == xID) {
               return i;
           }
       }
       return -1;
   }
   
   
   public void display(){
       LinkedList<Task> displayList = new LinkedList<Task>(myList);
         Collections.sort(displayList);
//       Collections.sort(displayList, new CompareByID_Desc());
       
       System.out.println("                     -----Task descending order-----");
       System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s%-15s\n","ID","Name", "TaskType","Date","Time", "Assignee","Reviewer");
       
       for(int i = 0; i < displayList.size(); ++i) {
           System.out.println(displayList.get(i));
       }
       
       
   }
   
   public String GetDateAndnope(String msg){
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("MMM-dd-yyyy");

        SDF.setLenient(false);
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println(msg);
            String sDate = sc.nextLine();
            if(sDate.equals("nope")) {
                return "nope";
            }
            
            try {
                date = SDF.parse(sDate);
                return SDF.format(date).toString();
            } catch (Exception e) {
                System.out.print(e);
            }
        }while(true);
        
    }

    public double GetFromToAndnope(String msg, double min,double max){
        double i;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.print(msg);
            try {
                String s = sc.nextLine();
                if(s.equals("nope")) {
                    return -1;
                }
                
                i=Double.parseDouble(s);
                if(i>=min && i<=max) {
                    int a = (int) (i*10);
                    if( a % 5 ==0) {
                        return i;
                    }else{
                        System.out.println("Wrong format");
                    }
                }
                else System.out.println("Out of range");
                
            } catch (Exception e) {
                System.err.println(e);
            }
        }while(true);    
    }
   

   
    public static void main(String[] args) {
        Management xM = new Management();
    }
}
