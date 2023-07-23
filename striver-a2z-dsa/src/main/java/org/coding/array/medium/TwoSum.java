package org.coding.array.medium;

import org.coding.Timer;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.start();
        int[] a = {2,7,11,15};
        int target = 9;
        int[] res = twoSumMap(a, target);
        timer.calculateTime();
        System.out.println("Result = " + a[res[0]] + " " + a[res[1]]);

        timer.start();
        res = twoSumTwoPointer(a, target);
        timer.calculateTime();
        System.out.println("Result = " + a[res[0]] + " " + a[res[1]]);
    }

    private static int[] twoSumTwoPointer(int[] a, int target) { // Needs to sort, so only useful when array is already sorted and space is not
        // needed. Time complexity O(nlogn)
        Arrays.sort(a);
        int n = a.length, left = 0, right = n - 1;
        int[] res = new int[2];
        while(left < right){
            if(a[left] + a[right] == target){
                res[0] = left;
                res[1] = right;
                break;
            } else if(a[left] + a[right] > target){
                right--;
            }  else if(a[left] + a[right] < target){
                left++;
            }
        }
        return res;
    }

    private static int[] twoSumMap(int[] a, int target) { // best if space is not a problem. O(nlogn) where logn is 1, hence O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0;i < a.length;i++){
            if(map.containsKey(target - a[i])){
                res[1] = i;
                res[0] = map.get(target - a[i]);
                break;
            }
            map.put(a[i], i);
        }
        return res;
    }


}
