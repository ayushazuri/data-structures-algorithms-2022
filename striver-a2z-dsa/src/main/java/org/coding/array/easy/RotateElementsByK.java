package org.coding.array.easy;

import java.util.*;

public class RotateElementsByK {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        leftRotateBy1(a);

        boolean isRight = false; // Rotate left or rotate right by k elements

        System.out.println();
        int[] b = {1, 2, 3, 4, 5, 6, 7};
        rotateByKAnyDirection(b, 2, isRight);

        System.out.println();
        int[] c = {1, 2, 3, 4, 5, 6, 7};
        rotateByKAnyDirectionOptimised(c, 2, isRight);
    }

    private static void leftRotateBy1(int[] a) {
        int lastDigit = a[0];
        for(int i = 0;i <a.length - 1; i++){
            a[i] = a[i+1];
        }
        a[a.length-1] = lastDigit;
        Arrays.stream(a).forEach(System.out::print);
    }

    private static void rotateByKAnyDirection(int[] b, int k, boolean isRight){
        if(k < 0) return;

        k = isRight ? k : b.length- k; // if k = 2, then right shift by 2 if right rotate, and right shift by 5 if left rotate
        k = k % b.length; // if k > n, then it keeps rotating in a circle
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0;i < k; i++){
            queue.add(b[i]);
        }
        for(int i = k;i <b.length; i++){
            queue.add(b[i]);
            b[i] = queue.poll();
        }
        for(int i = 0;i < k; i++){
            b[i] = queue.poll();
        }
        Arrays.stream(b).forEach(System.out::println);
    }

    private static void rotateByKAnyDirectionOptimised(int[] b, int k, boolean isRight){
        if(k < 0) return;

        k = k % b.length; // if k > n, then it keeps rotating in a circle

        reverse(b, 0, k-1);
        reverse(b, k, b.length-1);
        reverse(b, 0, b.length-1);
        Arrays.stream(b).forEach(System.out::println);

    }

    private static void reverse(int[] b, int start, int end){
        while(start <= end){
            int temp = b[start];
            b[start] = b[end];
            b[end] = temp;

            start++;
            end--;
        }
    }
}
