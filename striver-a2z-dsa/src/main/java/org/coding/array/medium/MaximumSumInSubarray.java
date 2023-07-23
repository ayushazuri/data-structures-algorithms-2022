package org.coding.array.medium;

import org.coding.Timer;

import java.util.Arrays;

public class MaximumSumInSubarray {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int maxSum = kadaneAlgorithm(a);
        System.out.println(maxSum);
        kadaneAlgorithmPrintArray(a);
        timer.calculateTime();


    }

    private static int kadaneAlgorithm(int[] a) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        for (int j : a) {
            if (sum <= 0) {
                sum = 0;
            }
            sum += j;
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    private static void kadaneAlgorithmPrintArray(int[] a){
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int[] ind = new int[2];
        int t = 0;
        for(int i=0;i<a.length;i++){
            if(sum <= 0){
                sum = 0;
                t = i;
            }
            sum += a[i];
            if(sum > maxSum){
                maxSum = sum;
                ind[0] = t;
                ind[1] = i;
            }
        }
        System.out.println("Indexes are " + Arrays.toString(ind));
    }
}
