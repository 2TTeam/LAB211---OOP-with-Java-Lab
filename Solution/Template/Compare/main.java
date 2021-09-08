/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import javax.rmi.CORBA.Util;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        LinkedList<Person> myList = new LinkedList<Person>();
        
        myList.add( new Person("c", 1));
        myList.add( new Person("b", 2));
        myList.add( new Person("b", 0));
        
        Collections.sort(myList, new CompareByName());
        
        for(int i = 0; i < myList.size(); ++i) {
            System.out.println(myList.get(i));
        }
    }
}
