
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Character, Integer> m = new HashMap<>();
        String s = "aaabbccdddd";
        
        for(int i = 0; i < s.length(); ++i) {
            m.put(s.charAt(i), m.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> entry : m.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+" "+ value);
        }
                
    }
}
