package ArrayImplementation.Sorting;

import java.util.*;
import java.lang.*;
import java.io.*;

class Insertion_Sort{
    public static int []insertionSort(int arr[])
    {

        for(int i=1;i<arr.length;i++){
            int key = arr[i];
            int j =i-1;
            //
            while(j>=0&& arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key ;
        }
        return arr;
    }
    public static void main(String[] args) {
        int arr[] = {10,50,30,5,18,15,45};
        System.out.println("array before Sorting : ");
        System.out.print("[ ");
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println("]");

        insertionSort(arr);
        System.out.println("array after Sorting : ");
        System.out.print("[ ");
        for(int i : arr){
            System.out.print(i+", ");
        }
        System.out.println("]");
    }
}
