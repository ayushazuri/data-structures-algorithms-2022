package org.coding.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] a = new int[]{13, 2, 34, 31, 22, 20};
        selectionSort(a);
    }

    private static void selectionSort(int[] a) {
        if(a.length == 0) return;

        for(int i = 0; i < a.length; i++){
            int min = i;
            for(int j = i + 1; j < a.length; j++){
                if(a[j] < a[i]){
                    min = j;
                }
            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }

        Arrays.stream(a).forEach(System.out::println);
    }
}
