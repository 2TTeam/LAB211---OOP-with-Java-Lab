/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Academic {
    private String Id;
    private int Semester;
    private String Course;

    public Academic() {
    }

    public Academic(String Id, int Semester, String Course) {
        this.Id = Id;
        this.Semester = Semester;
        this.Course = Course;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getSemester() {
        return Semester;
    }

    public void setSemester(int Semester) {
        this.Semester = Semester;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String Course) {
        this.Course = Course;
    }
    
    
}
