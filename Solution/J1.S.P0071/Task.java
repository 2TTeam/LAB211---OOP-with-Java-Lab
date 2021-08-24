/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0071;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Task implements Comparable<Task>{
    SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
    
    private static  String[] typeTask = {
        "Code", "Test", "Design", "Review"
    };
//    public static int autoID = 0;
    
    private int ID;
    private int TaskTypeID;
    private String RequiredmentName;
    private Date xDate;
    private double From;
    private double To;
    private String Assignee;
    private String Reviewer;

    public Task() {
    }

    public Task(int ID, int TaskTypeID, String RequiredmentName, Date xDate, double From, double To, String Assignee, String Reviewer) {
//        this.autoID++;
        
        this.ID = ID;
        
        this.TaskTypeID = TaskTypeID;

        this.RequiredmentName = RequiredmentName;
        this.xDate = xDate;
        this.From = From;
        this.To = To;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public void setTypeTask(String[] typeTask) {
        this.typeTask = typeTask;
    }

    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
    }

    public void setRequiredmentName(String RequiredmentName) {
        this.RequiredmentName = RequiredmentName;
    }

    public void setxDate(Date xDate) {
        this.xDate = xDate;
    }

    public void setFrom(double From) {
        this.From = From;
    }

    public void setTo(double To) {
        this.To = To;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    
    
    public String[] getTypeTask() {
        return typeTask;
    }

    public int getID() {
        return ID;
    }

    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public String getRequiredmentName() {
        return RequiredmentName;
    }

    public Date getxDate() {
        return xDate;
    }

    public double getFrom() {
        return From;
    }

    public double getTo() {
        return To;
    }

    public String getAssignee() {
        return Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    @Override
    public int compareTo(Task o) {
        return -(this.getID() - o.getID());
    }

    @Override
    public String toString() {
       
       return String.format("%-15d%-15s%-15s%-15s%-15.1f%-15s%-15s", this.ID, 
               this.RequiredmentName,this.typeTask[this.getTaskTypeID()-1] ,
               SDF.format(xDate).toString(), this.To - this.From, this.Assignee, this.Reviewer);
    }

    
    
}


