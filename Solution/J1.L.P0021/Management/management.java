/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Management;

import Entity.Academic;
import Entity.Student;
import Validation.Utility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class management {
    private ArrayList<Student> sList;
    private ArrayList<Academic> aList;

    public management() {
        sList = new ArrayList<Student>();
        aList = new ArrayList<>();
        menu();
    }
    public management(ArrayList<Student> sList, ArrayList<Academic> aList) {
        this.sList = sList;
        this.aList = aList;
        menu();
    }
    
    void menu(){
        int choice;
        do{
            System.out.println("1. Create\n"
            +"2. Find/Sort\n"
            +"3. Update/Delete\n"
            +"4. Report\n");
            
            choice = Utility.GetInt("Enter your choice: ", 0, 4);
            switch (choice){
                case 1: create();
                    break;
                case 2: findAndsort();
                    break;
                case 3: updateAndDelete();
                    break;
                case 4: report();
                    break;
            } 
        }while(choice!=0);
    }
    void create(){
        String xId = Utility.GetString("Enter id: ", false);
        if(findID(xId)>=0) {
            addAcademic(xId);
        }else {
            System.out.println("This is a New student!");
            String newStudentName = Utility.GetString("Enter student Name: ", false);
            sList.add(new Student(xId, newStudentName));
            addAcademic(xId);
        }
    }
    void findAndsort(){
            int choice;
            
            System.out.println("1. Find by Name\n"
                                +"2. Sort by Name\n"
            );
            
            choice = Utility.GetInt("Enter your choice: ", 1, 2);
            switch (choice){
                case 1:
                    findName(Utility.GetString("Enter Name: ", false));
                    break;
                case 2: 
                    Collections.sort(sList);
                    System.out.println("The List has been sorted!");
                    break;
            } 
    }
    void findName(String xName){
        boolean isEmpty=true;
        
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n","ID","Name","Semester","Course","Total Course");
        for(int i=0;i<sList.size();++i){
            if( sList.get(i).getStudentName().toLowerCase().contains(xName.toLowerCase()) ){
                isEmpty=false;
                String xId = sList.get(i).getId();
                String tempName= sList.get(i).getStudentName();
                ArrayList<Academic> tempList = reportById(xId);
                for (Academic Entry : tempList) {
                    int xTotalCourse=getTotalCourse(xId);
                    System.out.format("%-15s%-15s%-15d%-15s%-15d\n", xId, tempName,Entry.getSemester(),Entry.getCourse(),xTotalCourse);
                    
                }
            }
        }
        if(isEmpty==true){
            System.out.println("Not found!");
        }
    }
    
    void updateAndDelete(){
        int choice;
        System.out.println("1. Update\n"
                                +"2. Delete\n"
        );
        
        choice = Utility.GetInt("Enter your choice: ", 1, 2);
        switch(choice){
            case 1:
                Update(Utility.GetString("Enter Id: ", false));
                break;
            case 2:
                Delete(Utility.GetString("Enter Id: ", false));
                break;
        }             
    }
    void Update(String xId){
        int x = findID(xId);
        if(x<0){
            System.out.println("This Id doesn't exist! ");
            return;
        }
        
        int choice;
        System.out.println("1. Update name\n"
        +"2. Update Academic"
        );
        
        choice = Utility.GetInt("Enter your choice: ", 1, 3);
        
        
        switch(choice){
            case 1:
                System.out.format("%-15s%-15s\n","ID","Name");
                System.out.format("%-15s%-15s\n",xId,sList.get(x).getStudentName());
                
                sList.get(x).setStudentName(Utility.GetString("Enter new Name", false));
                System.out.println("Update successfully!");
                break;
            case 2:
                ArrayList<Academic> tempList = reportById(xId);
                if(tempList.size()==0){
                    System.out.println("Empty!");
                    return;
                }else {
                    System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n","No","ID","Name","Semester","Course","Total Course");
                    for(int i=0;i<tempList.size();++i){
                        int xTotalCourse = getTotalCourse(xId);
                        System.out.format("%-15d%-15s%-15s%-15d%-15s%-15d\n",i+1,xId,sList.get(x).getStudentName(),tempList.get(i).getSemester(),tempList.get(i).getCourse(),xTotalCourse);
                    }
                    int positionInTempList = Utility.GetInt("Enter No: ", 1, tempList.size())-1;
                    int pos_In_aList = aList.indexOf( tempList.get(positionInTempList) );
                    
                    System.out.println("1. Update Semester\n"
                    +"2. Update Course\n");

                    choice = Utility.GetInt("Enter your choice", 1, 2);
                    switch(choice){
                        case 1:
                            int xSemester = Utility.GetInt("Enter semester: ", 1, Integer.MAX_VALUE);
                            if(findCourse(xId, xSemester, aList.get(pos_In_aList).getCourse() ) >= 0){
                                System.err.println("Duplicate Error!");
                            }else {
                                aList.get(pos_In_aList).setSemester(xSemester);
                                System.out.println("Updated Successfully");
                            }
                            break;
                        case 2:
                            String xCourse = Utility.getInArray(Utility.COURSES_LIST, "Enter Course");
                            if(findCourse(xId, aList.get(pos_In_aList).getSemester(), xCourse ) >= 0){
                                System.err.println("Duplicate Error!");
                            }else {
                                aList.get(pos_In_aList).setCourse(xCourse);
                                System.out.println("Updated Successfully");
                            }
                            break;
                    }
                }
                break;
        }
    }
    void Delete(String xId){
        int x = findID(xId);
        if(x<0){
            System.out.println("This Id doesn't exist! ");
            return;
        }
        
        int choice;
        System.out.println("1. Delete Student\n"
        +"2. Delete Academic Info"
        );
        
        choice = Utility.GetInt("Enter your choice: ", 1, 2);
        
        
        switch(choice){
            case 1:
                sList.remove(x);
                aList.removeAll(reportById(xId));
                System.out.println("The student has been removed!");
                break;
            case 2:
                ArrayList<Academic> tempList = reportById(xId);
                if(tempList.size()==0){
                    System.out.println("Empty!");
                    return;
                }else {
                    System.out.format("%-15s%-15s%-15s%-15s%-15s%-15s\n","No","ID","Name","Semester","Course","Total Course");
                    for(int i=0;i<tempList.size();++i){
                        int xTotalCourse = getTotalCourse(xId);
                        System.out.format("%-15d%-15s%-15s%-15d%-15s%-15d\n",i+1,xId,sList.get(x).getStudentName(),tempList.get(i).getSemester(),tempList.get(i).getCourse(),xTotalCourse);
                    }
                    int position_In_tempList = Utility.GetInt("Enter No: ", 1, tempList.size())-1;
                    
                    aList.remove( tempList.get(position_In_tempList) );
                    System.out.println("This academic info has been deleted!");
                }
                break;
        }
    }
    void report(){
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n","ID","Name","Semester","Course","Total Course");
        for (Student student : sList) {
            ArrayList<Academic> tmp = reportById(student.getId());
            if(tmp.size()==0){
                System.out.format("%-15s%-15s%-15s%-15s%-15d\n",student.getId(),student.getStudentName(),"","",0);
            }else{
                for (Academic Entry : tmp) {
                    int xTotalCourse = getTotalCourse(student.getId());
                    System.out.format("%-15s%-15s%-15s%-15s%-15d\n",student.getId(),student.getStudentName(),Entry.getSemester(),Entry.getCourse(),xTotalCourse);
                }
            }
        }
    }
    //    
    ArrayList<Academic> reportById(String xId){   
        ArrayList<Academic> res = new ArrayList<Academic>();
        
        for(int i=0;i<aList.size();++i){
            if(aList.get(i).getId().equalsIgnoreCase(xId)){
                res.add(aList.get(i));
            }
        }
        return res;
    }
    int getTotalCourse(String xId){
        int res=0;
        for(int i=0;i<aList.size();++i){
            if(aList.get(i).getId().equalsIgnoreCase(xId)) ++res;
        }
        return res;
    }
    // sList
    int findID(String xId){
        for(int i=0;i<sList.size();++i){
            if(sList.get(i).getId().equalsIgnoreCase(xId)) return i;
        }
        return -1;
    }
    
    void addAcademic(String xId){
        int xSemester = Utility.GetInt("Enter Semester: ", 1, Integer.MAX_VALUE);
        String xCourse = Utility.getInArray(Utility.COURSES_LIST, "Enter Course: ");
        if(findCourse(xId, xSemester, xCourse) >=0 ){
            System.out.println("This academic info has existed!");
        }else{
            aList.add(new Academic(xId, xSemester, xCourse));
        }
    }
    // aList
    int findCourse(String xId,int xSemester,String xCourse){
        for(int i=0;i<aList.size();++i){
            if(aList.get(i).getId().equalsIgnoreCase(xId) 
            && aList.get(i).getSemester() == xSemester
            && aList.get(i).getCourse().equalsIgnoreCase(xCourse)){
                return i;
            }
        }
        return -1;
    }

}
