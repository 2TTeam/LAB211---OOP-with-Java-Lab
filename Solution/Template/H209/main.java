/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H209;
import Template.Utility;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void countCoins(Scanner sc) {
        int Total = 0;

        while(sc.hasNext()) {
            int q;
            
            try {
                q = Integer.parseInt(sc.next());
            } catch (Exception e) {
                System.out.println("Wrong format");
                return;
            }       
            int coinValue = 0;
            if(sc.hasNext()) {
                
                String coinType = sc.next().toLowerCase();
                
                switch (coinType) {
                    case "pennies":
                        coinValue = 1;
                    break;
                    case "nickels":
                        coinValue = 5;
                    break;
                    case "dimes":
                        coinValue = 10;
                    break;
                    case "quarters":
                        coinValue = 25;
                    break;
                    default:
                        System.out.println("Wrong format 3");
                        return; 
                }
                
                Total += q * coinValue; 
                
            } else {
                System.out.println("Wrong format 2");
                return;
            }   
        }
        
        
        System.out.println("Total money: $"+1.0*Total/100 );
    } 
    
    public static void main(String[] args) throws FileNotFoundException {
        
        File file = new File(".\\src\\J1\\S\\H209\\text.txt");
        Scanner sc = new Scanner(file);
        
        countCoins(sc);
        
    }
}
