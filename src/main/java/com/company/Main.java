package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operation;

        while(true) {
            System.out.println("Select an operation:");
            System.out.println("1. Solve linear equation");
            System.out.println("2. Solve quadratic equation");
            System.out.println("3. Calculate factorial");
            System.out.println("4. Calculate gauss sum");
            operation = scanner.nextInt();
            switch (operation) {
                case 1:
                    solveLinearEquation(scanner);
                    break;
                case 2:
                    solveQuadraticEquation(scanner);
                    break;
                case 3:
                    calculateFactorial(scanner);
                    break;
                case 4:
                    calculateGaussSum(scanner);
                    break;
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

    private static void solveQuadraticEquation(Scanner scanner) {
        
        System.out.println("Enter the value of a:");
        float a = scanner.nextFloat();
        
        System.out.println("Enter the value of b:");
        float b = scanner.nextFloat();
        
        System.out.println("Enter the value of c:");
        float c = scanner.nextFloat();
        
        double result = SecureEquationUtils.solveQuadraticEquation(a, b, c);
        System.out.println("The solution to the quadratic equation is: " + result);
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
}
