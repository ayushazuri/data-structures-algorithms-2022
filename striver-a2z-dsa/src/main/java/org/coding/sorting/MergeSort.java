package org.coding.sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = new int[]{13, 2, 34, 31, 22, 20};
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int start, int end) {
        int mid = (start + end)/2;

//        how to stop the loop, what condition based on mid and start end
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    private static void merge(int[] a, int start, int mid, int end) {
        int[] left = new int[start + mid + 1];
        int[] right = new int[end - mid];

        
    }
}

