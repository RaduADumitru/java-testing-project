package com.company;

public class SecureEquationUtils {
    public static double solveLinearEquation(float a, float b) {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' cannot be zero.");
        }
        
        float result = -b / a;
        
        return result;
    }
    
    public static double solveQuadraticEquation(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("Coefficient 'a' should not be zero; use solveLinearEquation instead.");
        }
        double discriminant = b * b - 4 * a * c;
        
        if (discriminant < 0) {
            throw new IllegalArgumentException("Equation has no real roots.");
        } else if (discriminant == 0) {
            double result = -b / (2 * a);
            return result;
        } else {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return Math.max(root1, root2);
        }
    }
    
    public static int calculateFactorial(int n) {
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
    
    public static int calculateGaussSumByDefinition(int n) {
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

    public static int calculateGaussSumByFormula(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Gauss sum is not defined for negative numbers.");
        }

        int sum = 0;
        sum = Math.multiplyExact(n, Math.addExact(n, 1)) / 2;

        return sum;
    }
}
