package org.example;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class V17Test {

    @Test(dataProvider = "testCasesExtractHundredsDigit")
    public void testExtractHundredsDigit(int number, int expectedDigit) {
        int result = V17.extractHundredsDigit(number);
        assertEquals(result, expectedDigit);
    }

    @DataProvider
    public Object[][] testCasesExtractHundredsDigit() {
        return new Object[][] {
                {1100, 1},
                {4444, 4},
                {4580, 5}
        };
    }

    @Test(dataProvider = "testCasesIsOddThreeDigitNumber")
    public void testIsOddThreeDigitNumber(int number, boolean expectedResult) {
        boolean result = V17.isOddThreeDigitNumber(number);
        assertEquals(result, expectedResult);
    }

    @DataProvider
    public Object[][] testCasesIsOddThreeDigitNumber() {
        return new Object[][] {
                {101, true},
                {100, false},
                {99, false}
        };
    }

    @Test(dataProvider = "testCasesIfTask")
    public void testIfTask(int a, int b, int c, double[] expected) {
        double[] result = V17.ifTask(a, b, c);
        assertEquals(result, expected);
//        for (int i = 0; i < expected.length; i++) {
//            double tolerance = 1e-6; // Tolerance limit
//            assertEquals(result[i], expected[i], tolerance);
//        }
    }


    @DataProvider
    public Object[][] testCasesIfTask() {
        return new Object[][] {
                {1, 2, 3, new double[]{2, 4, 6}},
                {3, 1, 2, new double[]{-3, -1, -2}},
                {2, 3, 1, new double[]{-2, -3, -1}}
        };
    }

    @Test(dataProvider = "testCasesDescribeEducationalTasks")
    public void testDescribeEducationalTasks(int input, String expected) {
        String result = V17.describeEducationalTasks(input);
        assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testCasesDescribeEducationalTasks() {
        return new Object[][] {
                {10, "десять учебных заданий."},
                {11, "одинадцать учебных заданий."},
                {12, "двенадцать учебных заданий."},
                {13, "тринадцать учебных заданий."},
                {14, "четырнадцать учебных заданий."},
                {15, "пятнадцать учебных заданий."},
                {16, "шестнадцать учебных заданий."},
                {17, "семнадцать учебных заданий."},
                {18, "восемнадцать учебных заданий."},
                {19, "девятнадцать учебных заданий."},
                {20, "двадцать учебных заданий."},
                {21, "двадцать одно учебное задание."},
                {22, "двадцать два учебных задания."},
                {30, "тридцать учебных заданий."},
                {31, "тридцать одно учебное задание."},
                {35, "тридцать пять учебных заданий."},
                {40, "сорок учебных заданий."}
        };
    }

    @Test(dataProvider = "testCasesForTask")
    public void testForTask(int a, int b, double expected) {
        double result = V17.forTask(a, b);
        assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testCasesForTask() {
        return new Object[][] {
                {1, 1, 2.0},
                {2, 1, 3.0},
                {3, 2, 13.0}
        };
    }

    @Test(dataProvider = "testCasesReverseDigitsN")
    public void testReverseDigitsN(int number, List<Integer> expected) {
        List<Integer> result = V17.reverseDigitsN(number);
        assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testCasesReverseDigitsN() {
        return new Object[][] {
                {12345, List.of(5, 4, 3, 2, 1)},
                {987654321, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)},
                {42, List.of(2, 4)}
        };
    }

    @Test(dataProvider = "testCasesMinMaxTask")
    public void testMinMaxTask(double input, double[] array, String expected) {
        String result = V17.minmaxTask(input, array);
        assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testCasesMinMaxTask() {
        return new Object[][] {
                {4.0, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, "minmax: 10.0; index: 9"},
                {3, new double[]{1., 1., 1., 1., 1., 1., 1., 1., 0, 0}, "0, 0"}
        };
    }

    @Test(dataProvider = "testCasesArrayTask")
    public void testArrayTask(int[] inputArray, int[] expectedOutput) {
        int[] result = V17.arrayTask(inputArray);
        assertArrayEquals(expectedOutput, result);
    }

    @DataProvider
    public Object[][] testCasesArrayTask() {
        return new Object[][] {
                {new int[]{1, 2, 3, 4}, new int[]{1, 2, 4, 3}},
                {new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 4, 3}},
                {new int[]{1, 2, 3}, new int[]{1, 2, 3}}
        };
    }

    @Test(dataProvider = "testCasesFindSumAndProductOfKRow")
    public void testFindSumAndProductOfKRow(int[][] matrix, int k, int[] expected) {
        int[] result = V17.findSumAndProductOfKRow(matrix, k);
        assertArrayEquals(expected, result);
    }

    @DataProvider
    public Object[][] testCasesFindSumAndProductOfKRow() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 2; //
        int expectedSum = 15;
        int expectedProduct = 120;

        return new Object[][] {
                {matrix, k, new int[]{expectedSum, expectedProduct}}
        };
    }
}
