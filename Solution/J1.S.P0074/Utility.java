/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0074;

import java.util.Scanner;

/**
 *
 * @author SAKURA
 */
public class Utility {
    public static int GetInt(String msg,int min,int max)
    {
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.print(msg);
            String input=sc.nextLine();
            try
            {
                int res=Integer.parseInt(input);
                if( min <= res && res<=max)
                    return res;
            }
            catch (Exception e)
            {
                System.out.println("Invalid input! Please enter again!");
            }
        }
        while(true);
    }
}
