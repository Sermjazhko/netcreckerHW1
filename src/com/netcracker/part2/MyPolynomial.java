package com.netcracker.part2;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length-1;
    }

    @Override
    public String toString() {
        String polynomial = new String();
        int deg = this.getDegree();
        boolean flag = false;
        for(int i=deg; i>0; i--) {
            if (coeffs[i] != 0) {
                polynomial += coeffs[i] + "x^" + i;
                flag = true;
            }
            if(flag && coeffs[i-1]>0)
                polynomial += "+";
        }
        if (coeffs[0] == 0 && flag)
            return polynomial;
        polynomial += coeffs[0];
        return polynomial;
        /*String polynomial = new String();
        int deg = this.getDegree();
        boolean flag = false;
        for(int i=deg; i>=0; i--) {
            if (coeffs[i] != 0 && i!=0) {
                polynomial += coeffs[i] + "x^" + i;
                flag = true;
            }
            if (coeffs[i - 1] > 0 && coeffs[i] != 0)
                polynomial += "+";
        }
        if (coeffs[0] == 0 && flag)
            return polynomial;
        polynomial += coeffs[0];
        return polynomial;*/
    }

    public double evaluate(double x) {
        double result = 0;
        int deg = 0;
        for (double coeff:coeffs){
            result += coeff * Math.pow(x,deg);
            deg+=1;
        }
        return result;
    }

    public MyPolynomial add(MyPolynomial right) {
        int maxDeg = this.getDegree() >= right.getDegree() ? this.getDegree() : right.getDegree();
        double[] arr = new double[maxDeg+1];
        for (int i = 0; i <= this.getDegree(); i++)
            arr[i] += coeffs[i];
        for (int i = 0; i <= right.getDegree(); i++)
            arr[i] += right.coeffs[i];
        return new MyPolynomial(arr);
    }

    public MyPolynomial multiply(MyPolynomial right) {
        int maxDeg = this.getDegree() + right.getDegree();
        double[] arr = new double[maxDeg+1];
        for (int i = 0; i <= this.getDegree(); i++)
            for (int j = 0; j <= right.getDegree(); j++)
                arr[j+i] += coeffs[i] * right.coeffs[j];
        return new MyPolynomial(arr);
    }
}
