/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cp;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class BubbleSort {
    public static void main(String[] args) {
        int n = Utility.GetInt("Enter size: ", 1, 100);
            int arr[] = new int[n];
            
            for(int i = 0; i < n; ++i) {
                arr[i] = Utility.GetInt("["+i+"]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            for(int i = 0; i < n - 1; ++i) {
//                boolean isSorted = true;
                
                for(int j = i; j < n - i - 1; ++j) {
                    if( arr[j] > arr[j+1]) {
                        int c = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = c;
//                        isSorted = false;
                    }
                }
                
//                if( isSorted == true) {
//                    break;
//                }
            }
            
            
            
            for(int i = 0; i < n; ++i) {
                System.out.println(arr[i] + ", ");
            }
    }
}
