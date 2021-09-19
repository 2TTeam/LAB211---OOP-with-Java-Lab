
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        List<Student> myList = new ArrayList<Student>();
        
        myList.add(new Student("B", 11));
        myList.add(new Student("A", 9));
        myList.add(new Student("A", 10));
        myList.add(new Student("B", 10));
        
        Collections.sort(myList, new CompareByMark());
        
        for(Student entry: myList){
            System.out.println(entry);
        }
        
        
                
    }
}
