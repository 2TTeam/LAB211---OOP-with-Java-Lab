/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Student implements Comparable<Student>{
    private String name;
    private int mark;

    public Student() {
    }

    public Student(String name, int mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
       return this.getName()+"\t" +this.getMark();
    }

    @Override
    public int compareTo(Student o) {
       if(this.getName().compareToIgnoreCase(o.getName()) == 0) {
           return  - (this.getMark() - o.getMark());
       }else {
           return this.getName().compareToIgnoreCase(o.getName());
       }
    }
    
    
    
}
