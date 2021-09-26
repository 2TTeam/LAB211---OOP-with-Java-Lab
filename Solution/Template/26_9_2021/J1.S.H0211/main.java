/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class main {
    public static void main(String[] args) {
        int[] inp =  { 5, 2, 2, -5, 4, 3, 2, 4, 1, 1, 1, 0, 2, 17 };
        
        ArrayIntList a = new ArrayIntList(inp, inp.length);
        
        a.display();
        
        a.fromCounts().display();
    }
}
