package com.company;

import org.junit.jupiter.api.Test;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class SquaredNormOfADotXMinusBTest {
    @Test
    public void functionalTesting() throws InvalidOperationsOnArraysException {
        class FunctionalTestsWrapper {
            private double epsilon = Math.pow(10, -5);

            public void testConvergenceUsingRandomData(int[] mValues, int[] nValues) throws InvalidOperationsOnArraysException {
                assertEquals(mValues.length, nValues.length);
                for (int index = 0; index < mValues.length; ++index) {
                    int m = mValues[index];
                    int n = nValues[index];

                    // generare date random din distributia normala standard (mean=0, std=1)
                    INDArray A = Nd4j.randn(m, n);
                    INDArray b = Nd4j.randn(m);
                    // pornim algoritmul cu elementul neutru al spatiului vectorial R^n (adica un vector cu n elemente de 0)
                    INDArray xInit = Nd4j.zeros(n);

                    SquaredNormOfADotXMinusB squaredNormOfADotXMinusB = new SquaredNormOfADotXMinusB(A, xInit, b, this.epsilon);
                    INDArray xOptim = squaredNormOfADotXMinusB.getOptimumXByMinimizingTheObjectiveFunction();
                    // obiectivul este sa obtinem punctul de minim global (xOptim)
                    // stim deja ca functia de optimizat este convexa
                    // daca in plus norma euclidiana a gradientului functiei de optimizat este 0 atunci xOptim este punct de minim global si implicit algoritmul este implementat corect
                    double gradientOfXOptim = squaredNormOfADotXMinusB.getNormOfGradientFunction(xOptim);
                    assertEquals(0.0, gradientOfXOptim, this.epsilon);
                    // assert-ul de mai jos este utilizat pentru a arata ca algoritmul a rulat (adica optimul nu este xInit, adica valoarea de intrare)
                    assertTrue(squaredNormOfADotXMinusB.getNoIterations() > 0);
                }
            }

            public void testInvalidAArrays() {
                int m = 50;
                int n = 1000;

                // dimensiunile pentru matricea A si numarul de elemente din vectorii xInit si b au sens din punct de vedere al operatiilor algebrice
                // dar sistemul este incompatibil deoarece nr de linii din matricea A este strict mai mic ca numarul de coloane din matricea A
                assertThrows(InvalidOperationsOnArraysException.class, () -> new SquaredNormOfADotXMinusB(
                        Nd4j.randn(m, n),
                        Nd4j.randn(n),
                        Nd4j.randn(m),
                        this.epsilon));
            }

            public void testInvalidXArrays() {
                int m = 1000;
                int n = 50;

                // vectorul xInit nu e ok deoarece nr lui de elemente este mai mare ca nr de coloane din matricea A
                assertThrows(InvalidOperationsOnArraysException.class, () -> new SquaredNormOfADotXMinusB(
                        Nd4j.randn(m, n),
                        Nd4j.randn(n + 1),
                        Nd4j.randn(m),
                        this.epsilon));

                // vectorul xInit nu e ok deoarece nr lui de elemente este mai mic ca nr de coloane din matricea A
                assertThrows(InvalidOperationsOnArraysException.class, () -> new SquaredNormOfADotXMinusB(
                        Nd4j.randn(m, n),
                        Nd4j.randn(n - 1),
                        Nd4j.randn(m),
                        this.epsilon));

            }

            public void testInvalidBArrays() {
                int m = 1000;
                int n = 50;

                // vectorul b nu e ok deoarece nr lui de elemente este mai mare ca nr de linii din matricea A
                assertThrows(InvalidOperationsOnArraysException.class, () -> new SquaredNormOfADotXMinusB(
                        Nd4j.randn(m, n),
                        Nd4j.randn(n),
                        Nd4j.randn(m + 1),
                        this.epsilon));

                // vectorul b nu e ok deoarece nr lui de elemente este mai mic ca nr de linii din matricea A
                assertThrows(InvalidOperationsOnArraysException.class, () -> new SquaredNormOfADotXMinusB(
                        Nd4j.randn(m, n),
                        Nd4j.randn(n),
                        Nd4j.randn(m - 1),
                        this.epsilon));
            }

            public void runTests() throws InvalidOperationsOnArraysException {
                // testam convergenta algoritmului
                int[] mValues = {10, 20, 50, 100};
                int[] nValues = {4, 8, 20, 50};
                this.testConvergenceUsingRandomData(mValues, nValues);

                // rulam diferite teste privind validarea input-urilor (dimensiunile matricii A si nr de elemente din vectorii xInit si b)
                this.testInvalidAArrays();
                this.testInvalidXArrays();
                this.testInvalidBArrays();
            }
        }

        FunctionalTestsWrapper functionalTestsWrapper = new FunctionalTestsWrapper();
        functionalTestsWrapper.runTests();


    }
}
