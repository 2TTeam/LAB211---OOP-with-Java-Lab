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
public class task implements Comparable<task>{
    private String[] TaskType = 
    {"Code", "Test", "Design", "Review" };
    
    private int id;
    private int TaskTypeID;
    private String requirementName;
    private Date date;
    private double From;
    private double To;
    private String Assignee;
    private String Reviewer;

    public task() {
    }

    public task(int id, int TaskTypeID, String requirementName, Date date, double From, double To, String Assignee, String Reviewer) {
        this.id = id;
        this.TaskTypeID = TaskTypeID;
        this.requirementName = requirementName;
        this.date = date;
        this.From = From;
        this.To = To;
        this.Assignee = Assignee;
        this.Reviewer = Reviewer;
    }

    public String getDataTasks(String outFormat) {
        SimpleDateFormat SDF = new SimpleDateFormat(outFormat);
        
        return SDF.format(this.date);
    }

    
    @Override
    public String toString() {
        return String.format("%-20d%-20s%-20s%-20s%-20.1f%-20s%-20s",
                id,
                requirementName,
                TaskType[this.TaskTypeID - 1],
                getDataTasks("dd/MMM/yyyy"),
                To - From,
                Assignee,
                Reviewer
                );
    }


    public int getId() {
        return id;
    }


    public int getTaskTypeID() {
        return TaskTypeID;
    }

    public void setTaskTypeID(int TaskTypeID) {
        this.TaskTypeID = TaskTypeID;
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
        return From;
    }

    public void setFrom(double From) {
        this.From = From;
    }

    public double getTo() {
        return To;
    }

    public void setTo(double To) {
        this.To = To;
    }

    public String getAssignee() {
        return Assignee;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public String getReviewer() {
        return Reviewer;
    }

    public void setReviewer(String Reviewer) {
        this.Reviewer = Reviewer;
    }

    @Override
    public int compareTo(task o) {
        return -(this.id - o.getId());
    }
    
    
    
    
}
