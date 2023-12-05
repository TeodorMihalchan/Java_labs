public class Main {
    public static void main(String[] args) {
        int number = 145;

        printDigitsReversed(number);
        findHundredsDigit();
        checkOddThreeDigitNumber();
        doubleOrNegate();
        describeTaskCount();
        findPowerSum();
    }

    public static int digitsReversed(int n) {
        if (n <= 0 || n < 999 ) {
            System.out.println("Number must be greater than zero.");
            return;
        }

       // System.out.println("Digits of the number, starting from the rightmost (ones digit):");

        while (n > 0) {
            int digit = n % 10;
            //System.out.println(digit);
            n /= 10;
        }
        return n;
    }

    public static void findHundredsDigit() {
        int number = 1234;
        int hundredsDigit = (number / 100) % 10;
        System.out.println("Hundreds digit: " + hundredsDigit);
    }

    public static void checkOddThreeDigitNumber() {
        int num = 135;
        boolean isOddThreeDigit = (num >= 100 && num <= 999) && (num % 2 != 0);
        System.out.println("Number " + num + " is an odd three-digit number: " + isOddThreeDigit);
    }

    public static void doubleOrNegate() {
        double A = 5.0;
        double B = 3.0;
        double C = 7.0;

        if ((A <= B && B <= C) || (A >= B && B >= C)) {
            A *= 2;
            B *= 2;
            C *= 2;
        } else {
            A = -A;
            B = -B;
            C = -C;
        }

        System.out.println("A: " + A);
        System.out.println("B: " + B);
        System.out.println("C: " + C);
    }

    public static void describeTaskCount() {
        int tasks = 23;
        String description;

        if (tasks >= 10 && tasks <= 20) {
            description = tasks + " educational tasks";
        } else {
            int lastDigit = tasks % 10;
            String lastDigitWord;

            switch (lastDigit) {
                case 1:
                    lastDigitWord = "one educational task";
                    break;
                case 2:
                case 3:
                case 4:
                    lastDigitWord = tasks + " educational tasks";
                    break;
                default:
                    lastDigitWord = tasks + " educational tasks";
            }

            description = lastDigitWord;
        }

        System.out.println(description);
    }

    public static void findPowerSum() {
        double A = 2.0;
        int N = 5;
        double sum = 0;
        double power = 1;

        for (int i = 0; i < N; i++) {
            sum += power;
            power *= A;
        }

        System.out.println("Sum of powers of A: " + sum);
    }
}
