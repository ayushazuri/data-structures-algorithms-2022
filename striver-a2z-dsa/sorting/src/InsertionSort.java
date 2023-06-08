import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[]{13, 2, 34, 31, 22, 20};
        insertionSort(a);
    }

    private static void insertionSort(int[] a) {
        for(int i = 1; i < a.length; i++){
            int j = i;
            while( (j > 0) && (a[j] < a[j-1])){
                    int t = a[j];
                    a[j] = a[j-1];
                    a[j-1] = t;
                    j--;
                }
        }

        Arrays.stream(a).forEach(System.out::println);
    }
}
