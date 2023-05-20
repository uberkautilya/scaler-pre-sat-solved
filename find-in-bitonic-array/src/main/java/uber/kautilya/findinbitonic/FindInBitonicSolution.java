package uber.kautilya.findinbitonic;

import java.util.Arrays;

public class FindInBitonicSolution {
    public static void main(String[] args) {
        Integer[] input = Arrays.stream(args).map(Integer::valueOf).toArray(Integer[]::new);
        if (input.length < 2) {
            System.out.println("Required values are not provided in the argument to the application");
            return;
        }
        Integer needle = input[0];
        input = Arrays.copyOfRange(input, 1, input.length);

        Integer position = findPositionInBitonicArray(input, needle);
        System.out.printf("The position of %s in %s: %s%n", needle, Arrays.toString(input), position);
    }

    private static Integer findPositionInBitonicArray(Integer[] input, Integer needle) {
        int index = input.length / 2;
        int position = -1;
        if (input[index] == needle) {
            return position;
        }
        if (input[index] < input[index + 1]) {
            if (input[index] < needle) {
                for (int i = index + 1; i < input.length; i++) {
                    if (input[i] == needle) {
                        position = i;
                    }
                }
            } else {
                for (int i = index - 1; i >= 0; i--) {
                    if (input[i] == needle) {
                        position = i;
                    }
                }
            }
        } else {
            if (input[index] > needle) {
                for (int i = index + 1; i < input.length; i++) {
                    if (input[i] == needle) {
                        position = i;
                    }
                }
            } else {
                for (int i = index - 1; i >= 0; i--) {
                    if (input[index] == needle) {
                        position = i;
                    }
                }
            }
        }
        return position;
    }
}
