package com.company;

import java.util.Scanner;

public class SecureEquationUtils {
    public static double solveLinearEquation(float a, float b) throws IllegalArgumentException, ArithmeticException {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' cannot be zero.");
        }

        float result = -b / a;

        validateFloat(result);

        return result;
    }

    public static int calculateFactorial(int n) throws IllegalArgumentException, ArithmeticException {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }

        int factorial = 1;
        while (n > 0) {
            factorial = Math.multiplyExact(factorial, n);
            n--;
        }

        return factorial;
    }

    public static int calculateGaussSumByDefinition(int n) throws IllegalArgumentException, ArithmeticException {
        if (n < 0) {
            throw new IllegalArgumentException("Gauss sum is not defined for negative numbers.");
        }

        int sum = 0;
        do {
            sum = Math.addExact(sum, n);
            n--;
        } while (n > 0);

        return sum;
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int operation;
        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Solve linear equation");
            System.out.println("2. Calculate factorial");
            System.out.println("3. Calculate gauss sum");
            System.out.println("0. Exit");
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    solveLinearEquation(scanner);
                    break;
                case 2:
                    calculateFactorial(scanner);
                    break;
                case 3:
                    calculateGaussSum(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid operation selected");
            }
        }
    }

    private static void solveLinearEquation(Scanner scanner) {

        System.out.println("Enter the value of a:");
        float a = scanner.nextFloat();

        System.out.println("Enter the value of b:");
        float b = scanner.nextFloat();

        double result = SecureEquationUtils.solveLinearEquation(a, b);
        System.out.println("The solution to the linear equation is: " + result);
    }

    private static void calculateFactorial(Scanner scanner) {

        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();

        int result = SecureEquationUtils.calculateFactorial(n);
        System.out.println("The factorial of " + n + " is: " + result);
    }

    private static void calculateGaussSum(Scanner scanner) {

        System.out.println("Enter the value of n:");
        int n = scanner.nextInt();

        int result = SecureEquationUtils.calculateGaussSumByDefinition(n);
        System.out.println("The Gauss sum of " + n + " is: " + result);
    }

    private static void checkFloatOverflow(float a) {
        if (a == Float.POSITIVE_INFINITY || a == Float.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Invalid float");
        }
    }

    private static void checkFloatUnderflow(float a) {
        if (Float.compare(a, 0.0f) == 0 || Float.compare(a, -0.0f) == 0) {
            throw new ArithmeticException("Invalid float");
        }
    }

    private static void validateFloat(float a) {
        checkFloatOverflow(a);
    }
}
