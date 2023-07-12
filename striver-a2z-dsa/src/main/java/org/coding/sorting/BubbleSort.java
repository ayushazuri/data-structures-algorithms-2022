package org.coding.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] a = new int[]{13, 2, 34, 31, 22, 20};
        bubbleSort(a);
    }

    private static void bubbleSort(int[] a) {
        for(int i = 0;i < a.length;i++){
            boolean isSorted = true;

            for(int j = i + 1; j < a.length;j++){
                if(a[j - 1] > a[j]){
                    int t = a[j-1];
                    a[j-1] = a[j];
                    a[j] = t;
                    isSorted = false;
                }
            }
            if(isSorted)
                break;
        }

        Arrays.stream(a).forEach(System.out::println);
    }
}
