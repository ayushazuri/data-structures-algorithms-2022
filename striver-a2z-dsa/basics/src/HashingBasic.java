import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashingBasic {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 1};
        countFrequency(a);
        findMaxAndMinFrequentElement(a);
    }

    private static void findMaxAndMinFrequentElement(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] res = new int[2];

        Arrays.stream(a).forEach(item -> map.put(item, map.getOrDefault(item, 0) + 1));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer k = entry.getKey();
            Integer v = entry.getValue();
            if (v >= max) {
                max = v;
                res[0] = k;
            }
            if (v <= min) {
                min = v;
                res[1] = k;
            }
        }

        System.out.println("Minimum value : " + res[1] + " Maximum value : " + res[0]);
    }

    private static void countFrequency(int[] a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(a).forEach(item -> map.put(item, map.getOrDefault(item, 0) + 1));
        map.forEach( (k, v) -> System.out.println("Number " + k + " is present " + v + " times"));
    }
}
