/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.LinkedList;
import Model.*;
import java.util.Collections;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class StudentManagement {
    private LinkedList<Student> sList;
    private LinkedList<Academic> aList;

    public StudentManagement() {
        sList = new LinkedList<Student>();
        aList = new LinkedList<Academic>();
    }
    
    public void create(String xID, String xName, int xSemester, String xCourse) {
        sList.add(new Student(xID, xName));
        aList.add(new Academic(xID, xSemester, xCourse));
    }
    
    public void create(String xID, int xSemester, String xCourse) {
        aList.add(new Academic(xID, xSemester, xCourse));
    }
     
   public void update(String xId) {
       if(findID(xId) >= 0) {
           LinkedList<Academic> temp = listAcademicByID(xId);
           for(int i = 0; i < temp.size(); ++i) {
               System.out.format("%-20d%-20s%-20s%-20d%-20s\n",
               i+1,
               xId,
               getNameByID(xId),
               temp.get(i).getSemester(),
               temp.get(i).getCourse()
               );
           } 
       int choice = Utility.GetInt("1. Update Name\n"
                         +"2. Update Semester\n"
                         +"3. Update Course\n", 1, 3);
       if(choice == 1) {
           String xName = Utility.GetString("Enter new Name: ", false);
           
           sList.get(findID(xId)).setName(xName);
           
       }else {
            int posInTempList = Utility.GetInt("Enter No you want to update: ",1, temp.size() ) - 1;
            Academic tempAcademic = temp.get(posInTempList);
            int posInAlist = aList.indexOf(tempAcademic);
            
            if(choice == 2) {
                int xSemester = Utility.GetInt("Enter new Semester: ", 1, Integer.MAX_VALUE);
                if(findAcademic(aList.get(posInAlist).getId(), xSemester, aList.get(posInAlist).getCourse()) >= 0) {
                    System.out.println("Duplicated Error!");
                    return;
                }
                aList.get(posInAlist).setSemester(xSemester);
                
            }
            
            if(choice == 3) {
                String xCourse = Utility.GetString("Enter new Semester: ", false);
                if(findAcademic(aList.get(posInAlist).getId(),aList.get(posInAlist).getSemester() , xCourse ) >= 0) {
                    System.out.println("Duplicated Error!");
                    return;
                }
                aList.get(posInAlist).setCourse(xCourse);
            }
       }
       
           
       }else {
           System.out.println("not exist");
       }
   }
    
   public String getNameByID(String xID) {
       int pos = findID(xID);
       return sList.get(pos).getName();
   }
   
    
    public LinkedList<Academic> listAcademicByID(String xID) {
        LinkedList<Academic> res = new LinkedList<Academic>();
        
        for(int i = 0; i < aList.size(); ++i) {
            Academic temp = aList.get(i);
            if(temp.getId().equalsIgnoreCase(xID) ) {
                res.add(temp);
            }
        }
        return res;
    }
    
    
    
    public void sortByName() {
        LinkedList<Student> res = new LinkedList<>(sList);
        Collections.sort(res);
        
        for(int i = 0; i < res.size(); ++i) {
            LinkedList<Academic> academicList = listAcademicByID(res.get(i).getId());
            for(int j = 0; j < academicList.size(); ++j) {
                System.out.format("%-20s%-20s%-20d%-20s\n",
                    res.get(i).getId(),
                    res.get(i).getName(),
                    academicList.get(j).getSemester(),
                    academicList.get(j).getCourse()
                    );
            }
        }
        
    }
    
    public void remove(String xID) {
        int pos = findID(xID);
        sList.remove(pos);
    }
    
    public void findByName(String xName) {
        LinkedList<Student> res = new LinkedList<Student>();
        
        for(int i = 0; i < sList.size(); ++i) {
            Student temp = sList.get(i);
            if(temp.getName().toLowerCase().contains(xName.toLowerCase())) {
                res.add(temp);
            }
        }
//        display
        for(int i = 0; i < res.size(); ++i) {
            LinkedList<Academic> academicList = listAcademicByID(res.get(i).getId());
            for(int j = 0; j < academicList.size(); ++j) {
                System.out.format("%-20s%-20s%-20d%-20s\n",
                    res.get(i).getId(),
                    res.get(i).getName(),
                    academicList.get(j).getSemester(),
                    academicList.get(j).getCourse()
                    );
            }
        }
    }
    
    
    
    
    public void report() {
        System.out.format("%-20s%-20s%-20s%-20s\n",
                                      "Id",
                                      "Name",
                                      "Semester",
                                      "Course"
                                     );
        for(int i = 0; i < sList.size(); ++i) {
            LinkedList<Academic> academicList = listAcademicByID(sList.get(i).getId());
            for(int j = 0; j < academicList.size(); ++j) {
                System.out.format("%-20s%-20s%-20d%-20s\n",
                    sList.get(i).getId(),
                    sList.get(i).getName(),
                    academicList.get(j).getSemester(),
                    academicList.get(j).getCourse()
                                    );
                        }
                    }
    }
    
    public int findID(String xID) {
        for(int i = 0; i < sList.size(); ++i) {
            if(sList.get(i).getId().equalsIgnoreCase(xID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int findAcademic(String xID, int xSemester, String xCourse) {
        for(int i = 0; i < aList.size(); ++i) {
            if(aList.get(i).getId().equalsIgnoreCase(xID)
               && aList.get(i).getCourse().equalsIgnoreCase(xCourse)
               && aList.get(i).getSemester() == xSemester
                    ) {
                return i;
            }
        }
        return -1;
    }

    public LinkedList<Student> getsList() {
        return sList;
    }

    public LinkedList<Academic> getaList() {
        return aList;
    }


    
    
    
}
