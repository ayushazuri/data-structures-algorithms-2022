package org.coding.array;

import org.coding.Timer;

public class MissingNumber {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int[] a = {2, 1, 0, 3, 5}; // 4 is missing from 1 to N = 5
        timer.start();
        System.out.println(missingNumber(a));
        timer.calculateTime();

        timer.start();
        System.out.println(missingNumberXor(a));
        timer.calculateTime();
    }

    private static int missingNumberXor(int[] a) {
        int len = a.length;
        int xorNum = 0, xorArr = 0;
        for(int i = 0; i < len; i++){
            xorArr = xorArr ^ a[i]; // xor of all elements in the arr
            xorNum = xorNum ^ (i + 1); // xor of i = 1 to n = N
        }

        return xorNum ^ xorArr;
    }

    private static int missingNumber(int[] a) { // if not considering zero, then len must be taken len + 1 to include the missing element
        int len = a.length;

        int sum2 = 0;
        for(int i: a){
            sum2 += i;
        }
        return len*(len+1)/2 - sum2;
    }


}
