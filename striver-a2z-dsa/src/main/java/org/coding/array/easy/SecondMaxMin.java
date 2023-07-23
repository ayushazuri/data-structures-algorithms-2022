package org.coding.array.easy;

public class SecondMaxMin {
    public static void main(String[] args) {
        int[] a = {2, 4, 10, 2, 5, 7};
        findSecondMaxMin(a);

        int[] b = {9};
        findSecondMaxMin(b);

        int[] c = {9, 9};
        findSecondMaxMin(c);
    }

    private static void findSecondMaxMin(int[] a) {
        if(a.length == 0 || a.length == 1) return;

        int max = Integer.MIN_VALUE, smax = Integer.MIN_VALUE, min = Integer.MAX_VALUE, smin = Integer.MAX_VALUE;

        for (int i : a) {
            if (i > max) {
                smax = max;
                max = i;
            } else if(i > smax && i != max){
                smax = i;
            }

            if (i < min) {
                smin = min;
                min = i;
            } else if(i < smin && i != min){
                smin = i;
            }
        }

        if( smax != Integer.MIN_VALUE)
            System.out.println("Max "+max+" "+smax);
        if( smin != Integer.MAX_VALUE)
            System.out.println("Min "+min+" "+smin);
    }
}
