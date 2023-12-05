package org.example;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class V17 {

    public static int extractHundredsDigit(int number) {
        int hundredsDigit = (number / 100) % 10;
        return hundredsDigit;
    }


    public static boolean isOddThreeDigitNumber(int number) {
        return (number > 99 && number < 1000 && number % 2 != 0);
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
            switch (n) {
                case 10:
                    return "десять учебных заданий.";
                case 11:
                    return "одинадцать учебных заданий.";
                case 12:
                    return "двенадцать учебных заданий.";
                case 13:
                    return "тринадцать учебных заданий.";
                case 14:
                    return "четырнадцать учебных заданий.";
                case 15:
                    return "пятнадцать учебных заданий.";
                case 16:
                    return "шестнадцать учебных заданий.";
                case 17:
                    return "семнадцать учебных заданий.";
                case 18:
                    return "восемнадцать учебных заданий.";
                case 19:
                    return "девятнадцать учебных заданий.";
                default:
                    return "";
            }
        } else {
            String result = "";

            switch (n / 10) {
                case 2:
                    result = "двадцать ";
                    break;
                case 3:
                    result = "тридцать ";
                    break;
                case 4:
                    result = "сорок ";
                    break;
            }

            switch (n % 10) {
                case 1:
                    result += "одно ";
                    break;
                case 2:
                    result += "два ";
                    break;
                case 3:
                    result += "три ";
                    break;
                case 4:
                    result += "четыре ";
                    break;
                case 5:
                    result += "пять ";
                    break;
                case 6:
                    result += "шесть ";
                    break;
                case 7:
                    result += "семь ";
                    break;
                case 8:
                    result += "восемь ";
                    break;
                case 9:
                    result += "девять ";
                    break;
            }

            switch (n % 10) {
                case 0:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    result += "учебных заданий.";
                    break;
                case 1:
                    result += "учебное задание.";
                    break;
                case 2:
                case 3:
                case 4:
                    result += "учебных задания.";
                    break;
            }

            return result;
        }
    }
    public static double forTask(double A, int N) {
        assert N > 0 : "N should be greater than 0";
        double result = 1.0;
        double powerOfA = 1.0;

        for (int i = 1; i <= N; i++) {
            powerOfA *= A;
            result += powerOfA;
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



