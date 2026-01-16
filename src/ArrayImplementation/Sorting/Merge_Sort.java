package ArrayImplementation.Sorting;

import java.util.*;
import java.lang.*;
import java.io.*;


class Merge_Sort {
    public static void divide(int arr[], int lower, int higher) {
        int mid = (lower + higher) / 2;
        if (lower >= higher) {
            return;
        }
        System.out.print("[");

        for (int i = lower; i < mid + 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");

        System.out.print("[");

        for (int i = mid + 1; i < higher + 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println("]");
        divide(arr, lower, mid);
        divide(arr, mid + 1, higher);


        merge(arr, lower, mid, higher);
    }

    public static void merge(int arr[], int lower, int mid, int higher) {
        int n1 = mid - lower + 1;
        int n2 = higher - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[lower + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = lower;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }

        }
    }
}
