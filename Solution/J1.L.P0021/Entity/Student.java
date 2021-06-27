/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Student implements Comparable<Student>{
    private String id;
    private String studentName;

    public Student() {
    }

    public Student(String id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    
    public String getId() {
        return id;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public int compareTo(Student o) {
        return this.studentName.compareToIgnoreCase(o.studentName);
    }
    
    
    
}
