package org.coding.array.medium;

import org.coding.Timer;

public class StockBuySell {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.start();
        int[] a = {7, 1, 5, 3, 6, 2};
        int[] b = {7, 3, 2};
        stockBuySell(a);
        stockBuySell(b);
        timer.calculateTime();

        timer.start();
        stockSellBuyFamous(a);
        timer.calculateTime();
    }

    private static void stockBuySell(int[] a) {
        int min = Integer.MAX_VALUE, maxDiff = 0;
        for(int i: a){
            if(i < min){
                min = i;
            } else if(i > min){
                maxDiff = Math.max(maxDiff, i - min);
            }
        }
        System.out.println("Min " + maxDiff);
    }

    private static void stockSellBuyFamous(int[] a) {
        int maxProfit = 0, minSoFar = a[0];
        for(int i: a){
            maxProfit = Math.max(maxProfit, i - minSoFar);
            minSoFar = Math.min(i, minSoFar);
        }
        System.out.println("Min " + maxProfit);
    }
}
