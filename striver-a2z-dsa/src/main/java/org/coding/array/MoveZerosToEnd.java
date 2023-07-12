package org.coding.array;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] a = {1, 0, 2, 0, 0, 3, 4, 0};
        moveZeros(a);

        int[] b = {1, 0, 2, 0, 0, 3, 4, 0};
        moveZerosSecondWay(a);
    }

    private static void moveZeros(int[] a) {
        int zerosCount = 0;
        int j = 0;
        for(int i: a){
            if(i == 0){
                zerosCount++;
            } else {
                a[j] = i;
                j++;
            }
        }
        while(zerosCount > 0){
            a[j] = 0;
            j++;
            zerosCount--;
        }

        Arrays.stream(a).forEach(System.out::println);
    }

    private static void moveZerosSecondWay(int[] a) {
        int j = 0;
        for(int i: a){
            if(i != 0){
                a[j] = i;
                j++;
            }
        }
        int len = a.length; // Don't keep on calculating length in a loop, as it takes memory.
        while(j < len){
            a[j] = 0;
            j++;
        }

        Arrays.stream(a).forEach(System.out::println);
    }
}
