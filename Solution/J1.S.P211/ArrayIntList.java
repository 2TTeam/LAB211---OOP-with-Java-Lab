/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.H211;

import java.util.ArrayList;

/**
 *
 * @author Ryuunosuke Akasaka
 */

public class ArrayIntList {
    private int[] elementData;
    private int size;
    
    public ArrayIntList(int n) {
        this.elementData = new int[n];
        this.size = n;
    }
    
    public ArrayIntList(int[] elementData, int size) {
        this.elementData = elementData;
        this.size = size;
    }
    
    public ArrayIntList fromCounts(){
        
        int nSize = 0;
        for(int i = 0; i < this.size; i += 2) {
            nSize += elementData[i];
        }
        int[] nElementData = new int[nSize];
        
        int j = 0;
        for(int i = 0; i < this.size - 1; i += 2) {
            
            int c = 0;
            while(c < this.elementData[i]){
                c++;
                nElementData[j] = elementData[i + 1];
                j++;
                
            }
        }

        return new ArrayIntList(nElementData, nSize);
    }

    @Override
    public String toString() {
        if(this.size == 0 ) {
            System.out.println("List is Empty!");
            return "[ ]";
        }else {
            String res = "[ ";
            for(int i = 0; i < this.size; ++i) {
                res += elementData[i]  + " ";
            }
            return res + "]";
        }
        
    }
   
}
