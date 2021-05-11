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
        Date d = Utility.GetDate("Enter the date: ");
        System.out.println(Utility.DayOfWeek(d));
    }
}
