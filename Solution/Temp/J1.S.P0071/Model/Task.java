/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Task {
    private static String taskType[] = {"","Code", "Test", "Design","Review"};
    
    private int iD;
    private int taskTypeID; 
    private String requirementName;
    private Date date;
    private double from;
    private double to;
    private String assignee;
    private String reviewer;

    public Task() {
    }

    public Task(int iD, int taskTypeID, String requirementName, Date date, double from, double to, String assignee, String reviewer) {
        this.iD = iD;
        this.taskTypeID = taskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.from = from;
        this.to = to;
        this.assignee = assignee;
        this.reviewer = reviewer;
    }

    public static String[] getTaskType() {
        return taskType;
    }

    public static void setTaskType(String[] taskType) {
        Task.taskType = taskType;
    }

    public int getiD() {
        return iD;
    }

    public int getTaskTypeID() {
        return taskTypeID;
    }

    public void setTaskTypeID(int taskTypeID) {
        this.taskTypeID = taskTypeID;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String Assignee) {
        this.assignee = Assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.reviewer = Reviewer;
    }
    
    SimpleDateFormat outFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    @Override
    public String toString() {
        return String.format("%-20s%-20s%-20s%-20s%-20.1f%-20s%-20s",
                this.iD,
                this.requirementName,
                this.taskType[this.taskTypeID],
                outFormat.format(date),
                this.to - this.from,
                this.assignee,
                this.reviewer
                );
    }
    
    public void display() {
        System.out.println(this.toString());
    }
    
    
    
}

