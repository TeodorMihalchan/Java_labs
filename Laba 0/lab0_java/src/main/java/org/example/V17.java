package org.example;

import java.util.ArrayList;
import java.util.List;
public class V17 {

    public static int extractHundredsDigit(int number) {
        return (number / 100) % 10;
    }


    public static boolean isOddThreeDigitNumber(int number) {
        return number > 99 && number < 1000 && number % 2 != 0;
    }
    public static double[] ifTask(double A, double B, double C) {
        if ((A < B && B < C) || (A > B && B > C)) {
            // Значення упорядковані по зростанню або спаданню, тому подвоюємо їх
            A *= 2;
            B *= 2;
            C *= 2;
        } else {
            // Значення не упорядковані, змінюємо їх на протилежні
            A = -A;
            B = -B;
            C = -C;
        }

        return new double[]{A, B, C};
    }
    public static String describeEducationalTasks(int n) {
        if (n / 10 == 1) {
            return switch (n) {
                case 10 -> "десять учебных заданий.";
                case 11 -> "одинадцать учебных заданий.";
                case 12 -> "двенадцать учебных заданий.";
                case 13 -> "тринадцать учебных заданий.";
                case 14 -> "четырнадцать учебных заданий.";
                case 15 -> "пятнадцать учебных заданий.";
                case 16 -> "шестнадцать учебных заданий.";
                case 17 -> "семнадцать учебных заданий.";
                case 18 -> "восемнадцать учебных заданий.";
                case 19 -> "девятнадцать учебных заданий.";
                default -> "";
            };
        } else {
            String result = switch (n / 10) {
                case 2 -> "двадцать ";
                case 3 -> "тридцать ";
                case 4 -> "сорок ";
                default -> "";
            };

            switch (n % 10) {
                case 1 -> result += "одно ";
                case 2 -> result += "два ";
                case 3 -> result += "три ";
                case 4 -> result += "четыре ";
                case 5 -> result += "пять ";
                case 6 -> result += "шесть ";
                case 7 -> result += "семь ";
                case 8 -> result += "восемь ";
                case 9 -> result += "девять ";
            }

            switch (n % 10) {
                case 0, 5, 6, 7, 8, 9 -> result += "учебных заданий.";
                case 1 -> result += "учебное задание.";
                case 2, 3, 4 -> result += "учебных задания.";
            }

            return result;
        }
    }
    public static double forTask(double a, int n) {
        assert n >= 0 : "N should be greater than or equal to 0";
        double result = 0.0;
        double powerOfA = 1.0;

        for (int i = 0; i <= n; i++) {
            result += powerOfA;
            powerOfA *= a;
        }

        return result;
    }

    public static List<Integer> reverseDigitsN(int n) {
        assert n > 0 : "N should be greater than 0";

        List<Integer> digits = new ArrayList<>();

        while (n > 0) {
            int digit = n % 10;
            digits.add(digit);
            n /= 10;
        }

        return digits;
    }
    public static String minmaxTask(double b, double[] numbers) {
        double max = Double.NEGATIVE_INFINITY;
        int maxIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }

        if (maxIndex == -1 || max <= b) {
            return "0, 0";
        }

        return "minmax: " + max + "; index: " + maxIndex;
    }

    public static int[] arrayTask(int[] a) {
        int n = a.length;
        int[] result = new int[n];
        int j = 0;

        for (int i = 0; i <= n / 2; i += 2) {
            result[j++] = a[i];

            if (i < n / 2) {
                result[j++] = a[i + 1];
            }

            if (n - i - 1 > n / 2) {
                result[j++] = a[n - i - 1];
            }

            if (n - i - 2 > n / 2) {
                result[j++] = a[n - i - 2];
            }
        }

        return result;
    }
    public static int[] findSumAndProductOfKRow(int[][] matrix, int k) {
        int n = matrix[0].length;
        int sum = 0;
        int product = 1;

        for (int j = 0; j < n; j++) {
            sum += matrix[k - 1][j];
            product *= matrix[k - 1][j];
        }

        return new int[]{sum, product};
    }
}



