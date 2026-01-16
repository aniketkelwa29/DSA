package ArrayImplementation.Sorting;

import java.util.*;
import java.lang.*;
import java.io.*;

class Quick_Sort
{
    public static void swap(int arr[],int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j]= temp;
    }
    public static int partition(int arr[],int low ,int high)
    {
        int i = low;
        int j = high-1;
        int pivot = arr[high];
        while(i<=j){
            while(i<=j && arr[i]<=pivot)
            {
                i++;
            }
            while(i<=j && arr[j]>=pivot)
            {
                j--;
            }

            if(i<j){
                swap(arr,i,j);
            }
        }
        swap(arr,i,high);
        return i;
    }
    public static void quickSort(int arr[],int low,int high)
    {
        if(low<high){
            int pivotIndex = partition(arr,low,high);

            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }
    public static void main(String[] args)
    {
        int arr[] = {10,8,1,3,7};
        int low= 0 ;
        int high= arr.length-1;
        int pivot =  arr[high];
        quickSort(arr,low,high);
        System.out.print("[");

        for(int r: arr){
            System.out.print(r+", ");
        }
        System.out.print("]");
    }
}
