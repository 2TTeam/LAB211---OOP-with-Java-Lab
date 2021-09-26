
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class ArrayIntList {
    private int[] elementData;
    private int size;

    public ArrayIntList() {
    }

    public ArrayIntList(int[] elementData, int size) {
        this.elementData = elementData;
        this.size = size;
    }
    
    public ArrayIntList fromCounts() {
        if(size % 2 != 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < size - 1; i+=2) {
            if(i < 0) {
                return null;
            }
            for(int j = 0; j < elementData[i]; ++j) {
                list.add(elementData[i+1]);
            }

        }
        
        
//      List<Integer> -> int[]
        int[] out = list.stream().mapToInt(i->i).toArray();
        
        return new ArrayIntList(out, list.size());
    }
    
    public void display() {
        for(int i = 0; i < size; ++i) {
            System.out.print(elementData[i] +", ");
        }
        System.out.println("");
    }
    
}
