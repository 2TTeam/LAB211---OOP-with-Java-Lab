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
public class SelectionSort {
    public static void main(String[] args) {    
            int n = Utility.GetInt("Enter size: ", 1, 100);
            int arr[] = new int[n];
            
            for(int i = 0; i < n; ++i) {
                arr[i] = Utility.GetInt("["+i+"]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }

            for(int i = 0 ; i < n - 1; ++i) {
                int minPos = i;
                
                for(int j = i + 1; j < n; ++j) {
                    if(arr[minPos] > arr[j] ) {
                        minPos = j;
                    }
                }
                if( minPos != i ) {
                    int c = arr[i];
                    arr[i] = arr[minPos];
                    arr[minPos] = c;
                }
            } 
            
            for(int i = 0; i < n; ++i) {
                System.out.println(arr[i] + ", ");
            }
            

    }
}
