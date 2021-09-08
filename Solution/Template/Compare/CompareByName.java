/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trash;

import java.util.Comparator;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class CompareByName implements Comparator<Person>{

   

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
    
}
