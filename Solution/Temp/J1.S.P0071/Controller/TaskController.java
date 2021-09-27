/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class TaskController {
    private LinkedList<Task> myList;
    
    public TaskController() {
        myList = new LinkedList<Task>();
    }
    
    public void addTask(int xTaskTypeID, String xRequirementName, 
        Date xDate, double xFrom, double xTo, String xAssignee, String xReviewer) {
        
        int xId;
        if(myList.size() == 0) {
            xId = 1;
        } else {
            xId = myList.get(myList.size() - 1).getiD() + 1;
        }
        
        myList.add(new Task(xId, xTaskTypeID, xRequirementName, xDate, xFrom, xTo, xAssignee, xReviewer));
    }
    
    public double getFromTo(String msg, double min, double max) {
        Scanner sc = new Scanner(System.in);
        
        do{
            System.out.println(msg);
            String input = sc.nextLine();
//            8.5 -> 85.0 -> 85
//            8.3 -> 83   -> 83 % 5 == 3
//            8.55 -> 85.5 -> 85
            try {
                double x = Double.parseDouble(input);
                if(x >= min && x <= max) {
                    int n = (int) (x * 10) ;
                    if( x*10 - n == 0) {
                         if(n % 5 == 0) {
                             return x;
                         } else {
                             System.out.println("Wrong format 2");
                         }
                    }else {
                        System.out.println("Wrong format 1");
                    }
                    
                }else {
                    System.out.println("Out of range!");
                }
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        }while(true);
        
    }
    
    public void delete(int xID) {
        int pos = findID(xID);
        myList.remove(pos);
    }
    
    
    public int findID(int xID) {
        for(int i = 0; i < myList.size(); ++i) {
            if(myList.get(i).getiD() == xID) {
                return i;
            }
        }
        return -1;
    }
    
    public boolean isDupplicated(int xID) {
        return findID(xID) >= 0;
    }
 
    public void showTask() {
        for(Task entry : myList) {
            entry.display();
        }
    }
            
       
}
