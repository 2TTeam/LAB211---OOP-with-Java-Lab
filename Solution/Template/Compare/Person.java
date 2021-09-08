/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trash;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Person implements Comparable<Person>{
    private String name;
    private int mark;

    public Person() {
    }

    public Person(String name, int mark) {
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
        return this.name + "\t" + this.getMark();
    
    }
    
    @Override
    public int compareTo(Person o) {
        if( this.getName().compareTo(o.getName()) != 0) {
            return this.getName().compareTo(o.getName());
        } else {
            return -(this.getMark() - o.getMark());
        }
    }

    
/**
 * 1, sort theo ten tang dan diem giam dan
 * 2, sort theo diem tang dan
 
**/

    
    
    
             
}
