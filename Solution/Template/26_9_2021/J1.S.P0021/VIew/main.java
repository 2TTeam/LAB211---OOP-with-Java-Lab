/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIew;

import Controller.*;
import Model.*;
import java.util.*;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        StudentManagement m = new StudentManagement();
        
        int choice;
        int miniChoice;
        
        String xId;
        String xName;
        int xSemester;
        String xCourse;
        
        do {            
            System.out.println("WELCOME TO STUDENT MANAGEMENT\n" +
                               "1. Create\n" +
                               "2. Find and Sort\n" +
                               "3. Update/Delete\n" +
                               "4. Report\n" +
                               "5. Exit\n");
            choice = Utility.GetInt("Enter your choice: ", 1, 5);
            
            switch (choice) {
                case 1:
                    xId = Utility.GetString("Enter Student ID: ", false);
                    if(m.findID(xId) >= 0 ) {
                        xSemester = Utility.GetInt("Enter Semester: ", 1, Integer.MAX_VALUE);
                        xCourse = Utility.getInArray(Utility.COURSES_LIST, "Enter Course");
                        
                        if(m.findAcademic(xId, xSemester, xCourse) >= 0) {
                            System.out.println("This academic info has exist!");
                        } else {
                            m.create(xId, xSemester, xCourse);
                            System.out.println("Add Successfully");
                        }
                        
                    } else {
                        System.out.println("This is new Student!");
                        xName = Utility.GetString("Enter Student Name: ", false);
                        
                        xSemester = Utility.GetInt("Enter Semester: ", 1, Integer.MAX_VALUE);
                        xCourse = Utility.getInArray(Utility.COURSES_LIST, "Enter Course");
                           
                        m.create(xId, xName, xSemester, xCourse);     
                        System.out.println("Add Successfully");
                        
                    }
                break;
                case 2:
                    System.out.println("1. Find by Name\n"
                                      +"2. Sort by Name\n"
                                      );
                    miniChoice = Utility.GetInt("Enter your choice: ", 1, 2);
                    switch(miniChoice) {
                        case 1:
                            xName = Utility.GetString("Enter name: ", false);
                            m.findByName(xName);     
                            break;
                        case 2:
                            m.sortByName();
                            break;
                    }
                    
                break;
                case 3:
                    System.out.println("1. Update Student"
                                      +"2. Delete Student");
                    
                    miniChoice = Utility.GetInt("Enter your choice: ", 1, 2);
                    switch(miniChoice) {
                        case 1:
                            xId = Utility.GetString("Enter id: ", false);
                            m.update(xId);
                            break;
                        case 2:
                            xId = Utility.GetString("Enter xID: ", false);
                            if(m.findID(xId) >= 0) {
                            m.remove(xId);
                            }else {
                                System.out.println("not exist!");
                            }
                            break;
                    }
                
                break;
                
                case 4:
                    LinkedList<Student> studentList = m.getsList();
                    
                    System.out.format("%-20s%-20s%-20s%-20s\n",
                                      "Id",
                                      "Name",
                                      "Semester",
                                      "Course"
                                     );
                    for(int i = 0; i < studentList.size(); ++i) {
                        LinkedList<Academic> academicList = m.listAcademicByID(studentList.get(i).getId());
                        for(int j = 0; j < academicList.size(); ++j) {
                            System.out.format("%-20s%-20s%-20d%-20s\n",
                                    studentList.get(i).getId(),
                                    studentList.get(i).getName(),
                                    academicList.get(j).getSemester(),
                                    academicList.get(j).getCourse()
                                    );
                        }
                    }
                break;
            }
            
        } while (choice != 5);
        
    }            
}
