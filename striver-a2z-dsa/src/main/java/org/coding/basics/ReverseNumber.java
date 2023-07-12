package org.coding.basics;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 123100;
        reverseNumber(n);
    }

    private static void reverseNumber(int n) {
        int res = 0;
        while(n != 0){
            if(res == 0 && n % 10 == 0)
                n = n/10;
            else {
                res = res * 10 + (n % 10);
                n = n/10;
            }

        }
        System.out.println(res);
    }
}
