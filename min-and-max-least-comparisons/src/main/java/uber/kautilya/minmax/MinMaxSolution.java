package uber.kautilya.minmax;

import java.util.Arrays;

public class MinMaxSolution {
    public static void main(String[] args) {
        Integer[] values = Arrays.stream(args).map(Integer::valueOf).toArray(Integer[]::new);
        Integer sumOfMinAndMaxValues = findMinAndMaxWithMinComparisons(values);
        System.out.println("The sum of min and max values in the array: " + sumOfMinAndMaxValues);
    }

    private static Integer findMinAndMaxWithMinComparisons(Integer[] values) {
        System.out.println("values = " + Arrays.toString(values));
        switch (values.length) {
            case 0 -> {
                return -1;
            }
            case 1 -> {
                return values[0];
            }
            default -> {
                Integer min = values[0];
                Integer max = values[0];
                Integer count = 0;

                for (int i = 1; i < values.length; i++) {
                    if (max < values[i]) {
                        count++;
                        max = values[i];
                    } else if (min > values[i]) {
                        count++;
                        min = values[i];
                    }
                }
                System.out.println("The number of comparisons: " + count);
                System.out.printf("Min: %s, Max: %s%n", min, max);
                return min + max;
            }
        }
    }
}
