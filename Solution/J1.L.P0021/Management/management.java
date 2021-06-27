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
            
            choice = Utility.GetInt("Enter your choice: ", 0, 4);
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
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n","ID","Name","Semester","Course","Total Course");
        for(int i=0;i<sList.size();++i){
            if( sList.get(i).getStudentName().toLowerCase().contains(xName.toLowerCase()) ){
                reportById(sList.get(i).getId());
            }
        }
    }
    
    void updateAndDelete(){
        
                
    }
    void report(){
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n","ID","Name","Semester","Course","Total Course");
        for(int i=0;i<sList.size();++i){
            reportById(sList.get(i).getId());
        }
    }
    //    
    void reportById(String xId){   
        for(int i=0;i<aList.size();++i){
            
            if(aList.get(i).getId().equalsIgnoreCase(xId)) {
                if(getTotalCourse(xId)==0){
                   System.out.format("%-15s%-15s%-15s%-15s%-15d\n",
                           xId
                           ,sList.get(findID(xId)).getStudentName()
                           ,""
                           ,""
                           ,0);
                }else{
                     System.out.format("%-15s%-15s%-15d%-15s%-15d\n",
                           xId
                           ,sList.get(findID(xId)).getStudentName()
                           ,aList.get(i).getSemester()
                           ,aList.get(i).getCourse()
                           ,getTotalCourse(xId));
                }
            }
        }
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
