import java.util.Arrays;

public class RecursionBasic {
    public static void main(String[] args) {
        int n = 4;
        print1ToNRecursively(n);
        System.out.println();
        printNTo1Recursively(n);
        System.out.println();
        System.out.println(sumOfNNumbers(n));

        int[] a = new int[]{1, 4, 3, 0, 10, 6};
        reverseAnArray(a, 0, a.length - 1);
        Arrays.stream(a).forEach(System.out::print);
    }

    private static void reverseAnArray(int[] a, int start, int end) {
        if( start > end)
            return;

        int t = a[start];
        a[start] = a[end];
        a[end] = t;

        reverseAnArray(a, start + 1, end - 1);
    }

    private static int sumOfNNumbers(int n) {
        if (n == 0) return 0;

        return n + sumOfNNumbers(n-1);
    }

    private static void printNTo1Recursively(int n) {
        if(n == 0)
            return;

        System.out.println(n);
        printNTo1Recursively(n-1);
    }

    private static void print1ToNRecursively(int n) {
        if(n == 0)
            return;

        print1ToNRecursively(n-1);
        System.out.println(n);
    }

}
