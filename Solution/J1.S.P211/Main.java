/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H211;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        int tSize = Utility.GetEven("Enter size is even number: ", 2, Integer.MAX_VALUE); 
        int[] tElementData = new int[tSize];    
        
        for(int i = 0; i < tSize; ++i) {
            if(i % 2 == 0) {
                tElementData[i] = Utility.GetInt("Enter int (>=0): ", 0, Integer.MAX_VALUE);
            }else {
                tElementData[i] = Utility.GetInt("Enter int: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }

//
//        int tSize = 14;
//        int[] tElementData = {5, 2, 2, -5, 4, 3, 2, 4, 1, 1, 1, 0, 2, 17};        
        
        ArrayIntList list = new ArrayIntList(tElementData, tSize);
        System.out.println(list);
        
        ArrayIntList list2 = list.fromCounts();
        System.out.println(list2);
        
        
        
        
        

    }
    
}
