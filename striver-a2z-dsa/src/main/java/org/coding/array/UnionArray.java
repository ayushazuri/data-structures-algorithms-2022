package org.coding.array;

import org.coding.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class UnionArray {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 2, 3, 5, 5, 6};
        timer.start();
        unionArraySet(a, b).forEach(System.out::println); // Can make a map of frequencies as well
        timer.calculateTime();

        a = new int[]{1, 2, 3, 4, 6};
        b = new int[]{2, 3, 5};
        timer = new Timer();
        timer.start();
        unionSet(a, b).forEach(System.out::println);
        timer.calculateTime();

    }

    private static List<Integer> unionSet(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int i  = 0, j = 0, m = a.length, n = b.length, count = 0;
        while(i < m && j < n){
            if(a[i] == b[j]){
                list.add(a[i]);
                i++;
                j++;
                count++;
            } else if(a[i] < b[j]){
                if(i == 0 || list.get(count - 1) != a[i]) {
                    list.add(a[i]);
                    count++;
                }
                i++;
            } else if(a[i] > b[j]){
                if(j == 0 || list.get(count - 1) != b[j]) {
                    list.add(b[j]);
                    count++;
                }
                j++;
            }
        }

        while(i < m){
            if(list.get(count - 1) != a[i])
                list.add(a[i]);
            i++;
            count++;
        }

        while(j < n){
            if(list.get(count - 1) != b[j])
                list.add(b[j]);
            j++;
            count++;
        }
        return list;
    }

    private static List<Integer> unionArraySet(int[] a, int[] b) {
        TreeSet<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i: a){
            if(set.add(i)){
                list.add(i);
            }
        }
        for(int i: b){
            if(set.add(i)){
                list.add(i);
            }
        }
        return list;
    }
}
