package org.coding.basics;

public class Pattern {
    public static void main(String[] args) {
        int n = 5;
        buildPattern(n);
        buildInvertPattern(n);
    }

    private static void buildInvertPattern(int n) {
        for(int i = n; i >= 1 ; i--){
            for(int j = n-1; j >= i;j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void buildPattern(int n) {
        for(int i = 1; i <= n ; i++){
            for(int j = n-1; j >= i;j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            for(int j = 1; j <= i - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
