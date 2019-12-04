package com.labs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lab1 {
    public static void main() {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int count = s.nextInt();

        int[] array =new int[count];

        System.out.println("Enter elements");

        for (int i = 0; i < count; ++i) {
            array[i] = s.nextInt();
        }

        System.out.print("Two maximum values of array: ");
        System.out.println(twoMaxValues(array));

        System.out.print("Average: ");
        System.out.println(average(array));

        System.out.print("First Positive: ");
        System.out.println(firstPositive(array));

        System.out.print("Count zeros: ");
        System.out.println(countZeros(array));

        System.out.print("Duplicated: ");
        System.out.println(duplicated(array));
    }

    public static ArrayList<Integer> twoMaxValues(int[] array) {
        return IntStream.of(array)
                .boxed()
                .sorted(Collections.reverseOrder())
                .limit(2)
                .collect(Collectors.toCollection(ArrayList<Integer>::new));
    }

    public static double average(int[] array) {
        return IntStream.of(array).average().orElse(0);
    }

    public static int firstPositive(int[] array) {
        return IntStream.of(array).filter(x -> x > 0).findFirst().orElse(0);
    }

    public static int countZeros(int[] array) {
        return IntStream.of(array)
                .reduce(0, (left, right) -> right == 0 ? ++left : left);
    }

    public static ArrayList<Integer> duplicated(int[] array) {
        return IntStream.of(array)
                .distinct()
                .filter(x -> IntStream.of(array).filter(y -> x == y).count() > 1)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
