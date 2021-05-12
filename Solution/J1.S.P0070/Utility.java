/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0070;

import java.util.Scanner;

/**
 *
 * @author SAKURA
 */
public class Utility {
    public static String GetStrWRegEx(String msg,String pattern,String msg_wrong)
    {
        Scanner sc = new Scanner(System.in);
        String inp;
        do
        {
            System.out.print(msg);
            inp=sc.nextLine();
            if(inp.matches(pattern))
                return inp;
            System.out.println(msg_wrong);
        }
        while(true);
    }
}
