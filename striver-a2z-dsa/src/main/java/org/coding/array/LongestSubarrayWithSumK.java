package org.coding.array;

import org.coding.Timer;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        int[] a = {1, 1, 2, 3, 1, 1, 1, 1};
        System.out.println(longestSubArrayWithSumK(a,  3));
        timer.calculateTime();

        timer.start();
        System.out.println(longestSubarrayTwoPointer(a, 3)); // best for positive only
        timer.calculateTime();

        timer.start();
        int[] b = {-1, 1, 0};
        System.out.println(longestSubArrayMap(b, 0)); // best for negative and positive.
        timer.calculateTime();
    }

    private static int longestSubarrayTwoPointer(int[] a, int k) {
        int right = 0, left = 0;
        int max = 0, sum = a[0];
        while(right < a.length){
            while(left <= right && sum > k){
                sum -= a[left];
                left++;
            }

            if(sum == k)
                max = Math.max(max, right - left + 1);

            right++;
            if(right < a.length)
                sum += a[right];
        }
        return max;
    }

    private static int longestSubArrayMap(int[] a, int k) {
//        1, 2, 3, 1, 1, 1, 1; Number
//        1, 3, 6, 7, 8, 9, 10; Cumulative Sum
//        0, 0, 3, 4, 5, 6, 7, Diff with k, and see if it's present

        Map<Integer, Integer> map = new HashMap<>();
//        map.put(0, 0); // Sum is 0 at start at 0th index, default value. Either keep this or sum == k condition
        int sum = 0, max = 0;
        for(int i = 0; i < a.length; i++){
            sum += a[i];

            // If sum == k or sum - k == 0, it means that cumulative sum = k + 0, which means the sub array start from 0th index.
            // So the subarray sum + sum before sub array would be cumulative sum, ie, 0 + k(3) == sum (3)
            if(sum == k)
                max = Math.max(max, i + 1); // Either use this or map.put(0, 0)

            if(map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){ // to avoid situation in zeros, so that we can get the longest length from the end.
                map.put(sum, i);
            }
        }
        return max;
    }


    private static int longestSubArrayWithSumK(int[] a, int k) { // not for negative
        int i = 0, j = 0, sum = 0, max = 0; boolean flag = false;
        while(i < a.length && j < a.length){
            if(!flag)
                sum += a[i];
            if(sum == k){
                max = Math.max(max, i - j + 1);
                flag = false;
                i++;
            } else {
                if(sum > k){
                    sum = sum - a[j];
                    flag = true;
                    j++;
                } else {
                    i++;
                    flag = false;
                }
            }
        }
        return max;
    }
}
