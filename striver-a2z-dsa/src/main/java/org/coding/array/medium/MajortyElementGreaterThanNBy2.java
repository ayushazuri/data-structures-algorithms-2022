package org.coding.array.medium;

import org.coding.Timer;

public class MajortyElementGreaterThanNBy2 {
    public static void main(String[] args) {
        //We can make a map of frequency as well.
        int[] a = {4,4,2,4,3,4,4,3,2,4};
        int[] b = {2,2,1,1,1,2,2};
        Timer timer = new Timer();
        timer.start();
        findMajorityElement(a);
        findMajorityElement(b);
        timer.calculateTime();
    }

    private static void findMajorityElement(int[] a) {// 2O(N)
        int count = 0, elem = 0;
        for(int i: a){
            if(count == 0){
                count = 1;
                elem = i;
            } else if(elem == i){
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for(int i: a){
            if(i == elem){
                count++;
            }
        }

        if(count > a.length/2)
            System.out.println("Result " + elem);
        else
            System.out.println("Result " + -1);
    }
}
