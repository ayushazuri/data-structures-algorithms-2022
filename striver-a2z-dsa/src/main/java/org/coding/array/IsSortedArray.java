package org.coding.array;

import org.coding.Timer;

public class IsSortedArray {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        int[] a = {2, 4, 10, 2, 5, 7};
        System.out.println(isSortedArray(a));
        timer.calculateTime();
        int[] b = {1, 2, 30, 99};
        System.out.println(isSortedArray(b));
        int[] c = {1, 1, 1};
        System.out.println(isSortedArray(c));
    }

    private static boolean isSortedArray(int[] a) {
        if( a.length == 0 || a.length == 1)
            return true;

        boolean asc = a[0] < a[1];

        if(asc){
            for(int i = 1;i < a.length;i++){
                if(a[i] < a[i-1])
                    return false;
            }
        } else {
            for(int i = 1;i < a.length;i++){
                if(a[i] > a[i-1])
                    return false;
            }
        }
        return true;
    }
}
