/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H210;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void flipLines(Scanner sc) {
        while(sc.hasNextLine()) {
            String first = sc.nextLine();
            
            if(sc.hasNextLine()) {
                String second = sc.nextLine();
                System.out.println(second);
            }
            
            System.out.println(first);
        }
    }

            
            
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File(".\\src\\J1\\S\\H210\\text.txt");
        
        Scanner sc = new Scanner(f);
       
        flipLines(sc);
    }
}
