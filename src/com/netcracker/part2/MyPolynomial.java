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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyPolynomial myPolynomial = (MyPolynomial) obj;

        if (coeffs.length != myPolynomial.coeffs.length) return false;

        for (int i = 0; i<coeffs.length; i++)
            if (Double.compare(coeffs[i], myPolynomial.coeffs[i]) != 0)
                return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        long t;
        // либо вывести, либо побитовый сдвиг, XOR
        for (double c: coeffs) {
            t = Double.doubleToLongBits(c);
            result = result * 31 + (int) (t ^ t >>> 32);
        }
        return result;
    }
}
