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
public class Academic {
    private String id;
    private int semester;
    private String course;

    public Academic() {
    }
    
    public Academic(String id, int semester, String course) {
        this.id = id;
        this.semester = semester;
        this.course = course;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setCourse(String course) {
        this.course = course;
    }
    
    
    public String getId() {
        return id;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }
    
    
}
