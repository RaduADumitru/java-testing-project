package com.company;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.EigenDecomposition;

import java.util.Arrays;

// aceasta clasa minimizeaza functia ||Ax-b||**2, unde ||x|| reprezinta norma euclidiana a vectorului x
// A matrice cu m linii si n coloane
// x vector cu n elemente (adica un IndArary din nd4j cu o singura linie si n coloane)
// b vector cu m elemente (adica un IndArary din nd4j cu o singura linie si m coloane)
public class SquaredNormOfADotXMinusB {
    private INDArray A;
    private INDArray xCurrent;
    private INDArray b;
    private double epsilon;
    private int noIterations;

    public SquaredNormOfADotXMinusB(INDArray A, INDArray xInitial, INDArray b, double epsilon) throws InvalidOperationsOnArraysException {
        this.A = A;
        this.xCurrent = xInitial.dup();
        this.b = b;
        this.epsilon = epsilon;
        this.noIterations = 0;

        this.validateInputs();
    }

    private void validateInputs() throws InvalidOperationsOnArraysException {
        double noRowsA = this.A.rows();
        double noColumnsA = this.A.columns();
        double noRowsX = this.xCurrent.rows();
        double noColumnsX = this.xCurrent.columns();
        double noRowsB = this.b.rows();
        double noColumnsB = this.b.columns();

        String errorMessage = "Invalid inputs: A should be an INDArray with m rows and n columns, x_init should be an INDArray with 1 row and n columns and b should be an INDArray with 1 row and m columns!";
        if (noRowsX != 1 && noRowsB != 1) {
            throw new InvalidOperationsOnArraysException(errorMessage);
        }
        if (noColumnsA != noColumnsX) {
            throw new InvalidOperationsOnArraysException(errorMessage);
        }
        if (noRowsA != noColumnsB) {
            throw new InvalidOperationsOnArraysException(errorMessage);
        }
        if (noRowsA < noColumnsA) {
            throw new InvalidOperationsOnArraysException(errorMessage);
        }
    }

    public INDArray getOptimumXByMinimizingTheObjectiveFunction() {
        INDArray gradient;
        double adjustingFactor = 0.95, gradientNorm;

        double learningRate = this.estimateLearningRate(adjustingFactor);
        while (true) {
            gradient = this.getGradientFunction(this.xCurrent);
            gradientNorm = gradient.norm2Number().doubleValue();
            if (gradientNorm <= this.epsilon) {
                break;
            }

            this.xCurrent = this.xCurrent.sub(gradient.mul(learningRate));
            this.noIterations += 1;
        }

        return this.xCurrent;
    }

    public int getNoIterations() {
        return this.noIterations;
    }

    private INDArray getGradientFunction(INDArray x) {
        INDArray gradient = this.A.transpose().mmul(this.A.mmul(x).sub(this.b)).mul(2);

        return gradient;
    }

    public double getNormOfGradientFunction(INDArray x) {
        INDArray gradient = this.getGradientFunction(x);
        double normOfGradient = gradient.norm2Number().doubleValue();

        return normOfGradient;
    }

    private INDArray getHessianMatrixOfLossFunction() {
        INDArray hessianMatrix = this.A.transpose().mmul(this.A).mul(2);

        return hessianMatrix;
    }

    private double estimateLearningRate(double adjustingFactor) {
        INDArray hessianMatrix = this.getHessianMatrixOfLossFunction();

        double[][] matrixAsArray = new double[hessianMatrix.rows()][hessianMatrix.columns()];
        for (int rowIndex = 0; rowIndex < hessianMatrix.rows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < hessianMatrix.columns(); columnIndex++) {
                matrixAsArray[rowIndex][columnIndex] = hessianMatrix.getDouble(rowIndex, columnIndex);
            }
        }
        Array2DRowRealMatrix hessianMatrixAsArray2D = new Array2DRowRealMatrix(matrixAsArray);

        EigenDecomposition eigenDecomposition = new EigenDecomposition(hessianMatrixAsArray2D);
        double[] hessianMatrixEigenValues = eigenDecomposition.getRealEigenvalues();
        double maxHessianEigenValue = Arrays.stream(hessianMatrixEigenValues).max().getAsDouble();

        double learningRate = 2.0 / maxHessianEigenValue * adjustingFactor;

        return learningRate;
    }
}
