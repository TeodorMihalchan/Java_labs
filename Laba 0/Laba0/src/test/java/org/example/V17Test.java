package org.example;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class V17Test {

    @Test
    public void testIntegerNumberTask() {
        assertEquals(V17.extractHundredsDigit(1100), 1);
        assertEquals(V17.extractHundredsDigit(4444), 4);
        assertEquals(V17.extractHundredsDigit(4580), 5);
    }
    @Test
    public void testBooleanTask() {
        assertTrue(V17.isOddThreeDigitNumber(101));
        assertFalse(V17.isOddThreeDigitNumber(100));
        assertFalse(V17.isOddThreeDigitNumber(99));

    }
    @Test(dataProvider = "ifProvider")
    public void testIf17(int a, int b, int c, double[] expected) {
        double[] result = V17.ifTask(a, b, c);
        for (int i = 0; i < 3; i++) {
            double tolerance = 1e-6; // Межа толерантності
            assertEquals(result[i], expected[i], tolerance);
        }
    }


    @DataProvider
    public Object[][] ifProvider() {
        return new Object[][]{
                {1, 2, 3, new double[]{2, 4, 6}},
                {3, 1, 2, new double[]{-3, -1, -2}},
                {2, 3, 1, new double[]{-2, -3, -1}}
        };
    }
    @Test
    public void testDescribeEducationalTasks() {
        assertEquals(V17.describeEducationalTasks(10), "десять учебных заданий.");
        assertEquals(V17.describeEducationalTasks(11), "одинадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(12), "двенадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(13), "тринадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(14), "четырнадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(15), "пятнадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(16), "шестнадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(17), "семнадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(18), "восемнадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(19), "девятнадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(20), "двадцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(21), "двадцать одно учебное задание.");
        assertEquals(V17.describeEducationalTasks(22), "двадцать два учебных задания.");
        assertEquals(V17.describeEducationalTasks(30), "тридцать учебных заданий.");
        assertEquals(V17.describeEducationalTasks(31), "тридцать одно учебное задание.");
        assertEquals(V17.describeEducationalTasks(35), "тридцать пять учебных заданий.");
        assertEquals(V17.describeEducationalTasks(40), "сорок учебных заданий.");
    }
    @Test
    public void testForTask() {
        assertEquals(V17.forTask(1, 1), 1.0);
        assertEquals(V17.forTask(2, 1), 2.0);
        assertEquals(V17.forTask(3, 2), 8.0);
    }

    public void testReverseDigitsN() {
        // Тести для числа 12345
        List<Integer> digits1 = V17.reverseDigitsN(12345);
        assertEquals(digits1, List.of(5, 4, 3, 2, 1));

        // Тести для числа 987654321
        List<Integer> digits2 = V17.reverseDigitsN(987654321);
        assertEquals(digits2, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

        // Тести для числа 42
        List<Integer> digits3 = V17.reverseDigitsN(42);
        assertEquals(digits3, List.of(2, 4));

        // Тести для числа 0
        List<Integer> digits4 = V17.reverseDigitsN(0);
        assertEquals(digits4, List.of(0));
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test(expectedExceptions = AssertionError.class)
    public void testReverseDigitsNNegative() {
        V17.reverseDigitsN(-1);
    }


    @Test
    public void testMinmaxTaskWithDifferentNumbers() {
        assertEquals(V17.minmaxTask(4.0, new double[]{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}),
                "minmax: 10.0; index: 9");
        assertEquals(V17.minmaxTask(3, new double[]{1., 1., 1., 1., 1., 1., 1., 1., 0, 0}), "0, 0");
    }

    public void testArrayTask() {
        int[] inputArray1 = {1, 2, 3, 4};
        int[] expectedOutput1 = {1, 2, 4, 3};

        assertEquals(expectedOutput1, V17.arrayTask(inputArray1));

        int[] inputArray2 = {1, 2, 3, 4, 5};
        int[] expectedOutput2 = {1, 2, 5, 4, 3};

        assertEquals(expectedOutput2, V17.arrayTask(inputArray2));

        int[] inputArray3 = {1, 2, 3};
        int[] expectedOutput3 = {1, 2, 3};

        assertEquals(expectedOutput3, V17.arrayTask(inputArray3));
    }

    @Test
    public void testFindSumAndProductOfKRow() {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 2; // Ваш номер рядка для тесту

        int[] result = V17.findSumAndProductOfKRow(matrix, k);

        int expectedSum = 15; // Сума другого рядка (4 + 5 + 6)
        int expectedProduct = 120; // Добуток другого рядка (4 * 5 * 6)

        assertEquals(expectedSum, result[0]);
        assertEquals(expectedProduct, result[1]);
    }
}











