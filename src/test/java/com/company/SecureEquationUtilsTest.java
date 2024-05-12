package com.company;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SecureEquationUtilsTest {


    @Test
    public void functionalTesting() {
        final float MIN_FLOAT = 0.000000000000000000000000001f;
        final float MAX_FLOAT = 999999999999999999999999999f;
        final int MAX_INT = 2147483647;

        class FunctionalTestWrapper {

            public void testSolveLinearEquation_MinFloat_MinFloat() {
                float a = MIN_FLOAT;
                float b = MIN_FLOAT;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(-b / a, result, MIN_FLOAT);
            }

            public void testSolveLinearEquation_MaxFloat_MinFloat() {
                float a = MAX_FLOAT;
                float b = MIN_FLOAT;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(-b / a, result, MIN_FLOAT);
            }

            public void testSolveLinearEquation_MaxFloat_MaxFloat() {
                float a = MAX_FLOAT;
                float b = MAX_FLOAT;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(-b / a, result, MIN_FLOAT);
            }

            public void testSolveLinearEquation_MinFloat_MaxFloat() {
                float a = MIN_FLOAT;
                float b = MAX_FLOAT;

                assertThrows(ArithmeticException.class, () -> SecureEquationUtils.solveLinearEquation(a, b));
            }

            public void testSolveLinearEquation_ZeroB() {
                float a = 2.5f;
                float b = 0f;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(0, result, MIN_FLOAT);
            }

            public void testSolveLinearEquation_MinFloat_ZeroB() {
                float a = MIN_FLOAT;
                float b = 0f;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(0, result, MIN_FLOAT);
            }

            public void testSolveLinearEquation_MaxFloat_ZeroB() {
                float a = MAX_FLOAT;
                float b = 0f;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(0, result, MIN_FLOAT);
            }

            public void testSolveLinearEquation_ZeroA() {
                float a = 0f;
                float b = 2.5f;

                assertThrows(IllegalArgumentException.class, () -> SecureEquationUtils.solveLinearEquation(a, b));
            }

            public void testSolveLinearEquation_NormalInput() {
                float a = 2.5f;
                float b = 5f;

                double result = SecureEquationUtils.solveLinearEquation(a, b);

                assertEquals(-b / a, result, MIN_FLOAT);
            }

            public void testCalculateFactorial_Zero() {
                int n = 0;
                int expected = 1;

                int result = SecureEquationUtils.calculateFactorial(n);

                assertEquals(expected, result);
            }

            public void testCalculateFactorial_PositiveNumber() {
                int n = 5;
                int expected = 120;

                int result = SecureEquationUtils.calculateFactorial(n);

                assertEquals(expected, result);
            }

            public void testCalculateFactorial_NegativeNumber() {
                int n = -5;

                assertThrows(IllegalArgumentException.class, () -> SecureEquationUtils.calculateFactorial(n));
            }

            public void testCalculateFactorial_Overflow() {
                int n = MAX_INT;

                assertThrows(ArithmeticException.class, () -> SecureEquationUtils.calculateFactorial(n));
            }

            public void testCalculateGaussSumByDefinition_Zero() {
                int n = 0;
                int expected = 0;

                int result = SecureEquationUtils.calculateGaussSumByDefinition(n);

                assertEquals(expected, result);
            }

            public void testCalculateGaussSumByDefinition_PositiveNumber() {
                int n = 5;
                int expected = 15;

                int result = SecureEquationUtils.calculateGaussSumByDefinition(n);

                assertEquals(expected, result);
            }

            public void testCalculateGaussSumByDefinition_NegativeNumber() {
                int n = -5;
                int expected = 0;

                assertThrows(IllegalArgumentException.class, () -> SecureEquationUtils.calculateGaussSumByDefinition(n));
            }

            public void testCalculateGaussSumByDefinition_LargeNumber() {
                int n = 100;
                int expected = 5050;

                int result = SecureEquationUtils.calculateGaussSumByDefinition(n);

                assertEquals(expected, result);

            }

            public void testShowMenu_InvalidOperation() {
                String input = "4\r\n0\r\n";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                SecureEquationUtils.showMenu();

                String expectedOutput = "Select an operation:\r\n1. Solve linear equation\r\n2. Calculate factorial\r\n3. Calculate gauss sum\r\n0. Exit\r\n";
                expectedOutput += "Invalid operation selected\r\n";
                expectedOutput += "Select an operation:\r\n1. Solve linear equation\r\n2. Calculate factorial\r\n3. Calculate gauss sum\r\n0. Exit\r\n";

                assertEquals(expectedOutput, out.toString());
            }

            public void testShowMenu_Exit() {
                String input = "0\n";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                ByteArrayOutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                SecureEquationUtils.showMenu();

                String expectedOutput = "Select an operation:\r\n1. Solve linear equation\r\n2. Calculate factorial\r\n3. Calculate gauss sum\r\n0. Exit\r\n";

                assertEquals(expectedOutput, out.toString());
            }

            public void runTests() {
                testSolveLinearEquation_MaxFloat_MinFloat();
                testSolveLinearEquation_MinFloat_MinFloat();
                testSolveLinearEquation_MaxFloat_MaxFloat();
                testSolveLinearEquation_MinFloat_MaxFloat();
                testSolveLinearEquation_ZeroB();
                testSolveLinearEquation_MinFloat_ZeroB();
                testSolveLinearEquation_MaxFloat_ZeroB();
                testSolveLinearEquation_ZeroA();
                testSolveLinearEquation_NormalInput();
                testCalculateFactorial_Zero();
                testCalculateFactorial_PositiveNumber();
                testCalculateFactorial_NegativeNumber();
                testCalculateFactorial_Overflow();
                testCalculateGaussSumByDefinition_Zero();
                testCalculateGaussSumByDefinition_PositiveNumber();
                testCalculateGaussSumByDefinition_NegativeNumber();
                testCalculateGaussSumByDefinition_LargeNumber();
                testShowMenu_InvalidOperation();
                testShowMenu_Exit();
            }
        }
        FunctionalTestWrapper functionalTestWrapper = new FunctionalTestWrapper();
        functionalTestWrapper.runTests();
    }
}