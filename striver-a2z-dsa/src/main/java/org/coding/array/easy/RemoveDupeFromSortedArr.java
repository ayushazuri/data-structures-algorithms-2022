package org.coding.array.easy;

public class RemoveDupeFromSortedArr {
    public static void main(String[] args) {
        int[] a = {0,0,1,1,1,2,2,3,3,4};
        int[] k = {0, 1, 2, 3, 4};
        int i = removeDuplicates(a);

        for(int j = 0; j < i; j++){
            if(a[j] != k[j])
                System.out.println(false);
        }

    }

    static int removeDuplicates(int[] a) {
        if(a.length == 0) return 0;

        int j = 0;
        for (int i = 1; i < a.length; i++){
            if(a[i] != a[i-1]){
                j++;
                a[j] = a[i];
            }
        }
        return j+1;
    }
}
