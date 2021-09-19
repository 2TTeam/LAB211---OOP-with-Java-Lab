/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H209;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Test{
    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<String, Integer>();
        
        
        /*
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
*/
        myMap.put("pennies", 1);
        myMap.put("nickels", 5);
        myMap.put("dimes", 10);
        myMap.put("quarters", 25);

        
        System.out.println(myMap.get("pennies"));
        
        
    }
}
