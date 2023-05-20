package uber.kautitlya.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 */

public class Solution {
    public static void main(String[] args) {
        Integer[] values = Arrays.stream(args).map(Integer::valueOf).toArray(Integer[]::new);
        Integer sum = findTripletSum(values);
    }

    private static Integer findTripletSum(Integer[] values) {
        List<Integer> sumList = new ArrayList<>();
        boolean valid = Boolean.FALSE;

        for (int i = 0; i < values.length; i++) {
            Integer first = values[i];
            Integer second = null;
            Integer third = null;

            for (int j = i + 1; j < values.length; j++) {
                if (values[j] > values[i]) {
                    second = values[j];
                    for (int k = j + 1; k < values.length; k++) {
                        if (values[k] > values[j]) {
                            third = values[k];
                            System.out.printf("First: %s, Second: %s, Third: %s, Sum: %s%n", first, second, third, first + second + third);
                            sumList.add(first + second + third);
                            valid = Boolean.TRUE;
                        }
                    }
                }
            }
        }

        if (valid) {
            System.out.println("The largest sum of the triplet: " + sumList.stream().reduce(Integer::max).orElse(-1));
            return sumList.stream().reduce(Integer::max).orElse(-1);
        } else {
            System.out.println("The triplet satisfying the conditions do not exist");
            return 0;
        }
    }
}
