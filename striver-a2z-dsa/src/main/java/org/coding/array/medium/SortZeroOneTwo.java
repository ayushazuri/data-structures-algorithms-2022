package org.coding.array.medium;

import org.coding.Timer;

import java.util.Arrays;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        // We can either sort the array or much better, we can simply count the occurrences of 0, 1, 2, and reiterate with the correct fields.

        // Most optimal solution
        Timer timer = new Timer();
        timer.start();
        sortZeroOneTwo(a);
        timer.calculateTime();
        Arrays.stream(a).forEach(System.out::println);
    }

    private static void sortZeroOneTwo(int[] a) {
        int z = 0, t = a.length - 1, i = 0;
        while(i <= t){
            if(a[i] == 0){
                int swap = a[z];
                a[z] = a[i];
                a[i] = swap;

                i++;
                z++;
            } else if(a[i] == 1){
                i++;
            } else if(a[i] == 2){
                int swap = a[t];
                a[t] = a[i];
                a[i] = swap;
                t--;
            }
        }
    }
}
