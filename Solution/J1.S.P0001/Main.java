/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

/**
 *
 * @author Ryuunosuke Akasaka
 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = Utility.GetInt("Enter size of Array: ", 1, 100);
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=rand.nextInt(32); 
        // random value in range [0, 32]
        System.out.println("Before sort: ");
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
        
//        Bubble sort
        for(int i=0;i<n-1;i++){
            
            boolean haveSwap = false;
            
            for(int j=0;j<n-i-1;j++){
               if(arr[j]>arr[j+1]){
                   int temp = arr[j];
                   arr[j]=arr[j+1];
                   arr[j+1]=temp;
                   haveSwap = true;
               }
            }
            if(haveSwap == false){
                break;
            }
        }

        System.out.println("\nAfter sort: ");
        for(int i=0;i<n;i++) System.out.print(arr[i]+" ");
        
        
    }
}