/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        Date d1 = Utility.GetDate("Enter the first date: ");
        Date d2 = Utility.GetDate("Enter the second date: ");
        if(d1.before(d2)){
            System.out.println("Date1 is before Date2\n");
        }
        else if(d1.after(d2)){
            System.out.println("Date1 is after Date2\n");
        }
        else{
            System.out.println("Is the same date");
        }
    }
}
