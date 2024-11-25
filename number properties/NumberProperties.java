import java.util.Scanner;

public class NumberProperties {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        boolean isPalindrome = isPalindrome(number);
        boolean isArmstrong = isArmstrong(number);
        boolean isPerfect = isPerfect(number);
        boolean isStrong = isStrong(number);
        boolean isInFibonacci = isInFibonacci(number);
        boolean isPrime = isPrime(number);
        boolean isComposite = isComposite(number);
        long factorial = factorial(number);
        String evenOrOdd = (number % 2 == 0) ? "Even" : "Odd";

        System.out.println("Palindrome: " + isPalindrome);
        System.out.println("Armstrong: " + isArmstrong);
        System.out.println("Perfect: " + isPerfect);
        System.out.println("Strong: " + isStrong);
        System.out.println("In Fibonacci series: " + isInFibonacci);
        System.out.println("Prime: " + isPrime);
        System.out.println("Composite: " + isComposite);
        System.out.println("Factorial: " + factorial);
        System.out.println("Even/Odd: " + evenOrOdd);

        scanner.close();
    }

    public static boolean isPalindrome(int number) {
        int reversedNumber = 0, originalNumber = number;
        while (number != 0) {
            int remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;
        }
        return originalNumber == reversedNumber;
    }

    public static boolean isArmstrong(int number) {
        int originalNumber = number, result = 0, power = String.valueOf(number).length();
        while (number != 0) {
            int digit = number % 10;
            result += Math.pow(digit, power);
            number /= 10;
        }
        return originalNumber == result;
    }

    public static boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0)
                sum += i;
        }
        return sum == number;
    }

    public static boolean isStrong(int number) {
        int sum = 0, originalNumber = number;
        while (number != 0) {
            int digit = number % 10;
            sum += factorial(digit);
            number /= 10;
        }
        return sum == originalNumber;
    }

    public static boolean isInFibonacci(int number) {
        int a = 0, b = 1;
        while (a <= number) {
            if (a == number)
                return true;
            int temp = a + b;
            a = b;
            b = temp;
        }
        return false;
    }

    public static boolean isPrime(int number) {
        if (number <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isComposite(int number) {
        return !isPrime(number);
    }

    public static long factorial(int number) {
        long factorial = 1;
        for (int i = 1; i <= number; i++)
            factorial *= i;
        return factorial;
    }
}
