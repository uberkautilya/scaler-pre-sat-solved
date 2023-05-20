package uber.kautilya.positionincircle;

import java.util.Arrays;

public class PositionCircleSolution {
    public static void main(String[] args) {
        Integer[] values = Arrays.stream(args).map(Integer::valueOf).toArray(Integer[]::new);
        if (values.length < 3) {
            System.out.println("The input array does not have required values");
        }
        Integer numberOfItemsA = values[0];
        Integer sizeOfCircleB = values[1];
        Integer startPositionC = values[2];
        System.out.printf("numberOfItems: %s, sizeOfCircle: %s, startPosition: %s%n", numberOfItemsA, sizeOfCircleB, startPositionC);
        Integer positionOfLastElement = null;

        while (numberOfItemsA > sizeOfCircleB) {
            numberOfItemsA -= sizeOfCircleB;
        }
        int availableSlots = sizeOfCircleB - (startPositionC - 1);
        if (numberOfItemsA <= availableSlots) {
            positionOfLastElement = startPositionC + numberOfItemsA - 1;
        } else positionOfLastElement = numberOfItemsA - availableSlots;
        System.out.printf("Calc: numberOfItems: %s, sizeOfCircle: %s, startPosition: %s%n", numberOfItemsA, sizeOfCircleB, startPositionC);
        System.out.println("The position of the last element: " + positionOfLastElement);
    }
}
