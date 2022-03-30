package com.netcracker.part2;

import static java.lang.Double.compare;
public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(){}

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (imag < 0.0)
            return "(" + real  + imag + "i" +
                    ')';

        return "(" + real + "+" + imag + "i" +
                ')';
    }

    public boolean isReal() {
        return  (compare(imag,0)==0);
    }

    public boolean isImaginary() {
        return (compare(real,0)==0) && !(compare(imag,0)==0);
    }

    public boolean equals(double real, double imag) {
        return (compare(this.real,real)==0) && (compare(this.imag, imag)==0);
    }

    public boolean equals(MyComplex another) {
        return (compare(this.real, another.getReal())==0) && (compare(this.imag, another.getImag())==0);
    }

    public double magnitude() {
        return Math.sqrt(Math.pow(this.real,2) + Math.pow(this.imag,2));
    }

    public double argument() {
        return Math.atan(this.imag/this.real);
    }

    public MyComplex add(MyComplex right) {
        this.setValue(real + right.real, imag + right.imag);

        return  this;
    }

    public MyComplex addNew(MyComplex right) {
        MyComplex myComplex = new MyComplex(right.real+real, right.imag+imag);
        return myComplex;
    }

    public MyComplex subtract(MyComplex right) {
        this.setValue(real - right.real, imag - right.imag);
        return  this;
    }

    public MyComplex subtractNew(MyComplex right) {
        MyComplex myComplex = new MyComplex(real - right.real, imag - right.imag);
        return myComplex;
    }

    public MyComplex multiply(MyComplex right) {
        this.setValue(real*right.real - imag*right.imag,
                imag*right.real + real*right.imag);
        return this;
    }

    public MyComplex divide(MyComplex right) {
        if (right.magnitude() == 0)
            throw new ArithmeticException("Division on zero");

        double denominatoe = Math.pow(right.magnitude(),2);
        MyComplex myComplex = new MyComplex(right.real/denominatoe, -right.imag/denominatoe);
        this.multiply(myComplex);
        return this;
    }

    public MyComplex conjugate() {
        return new MyComplex(real, -imag);
    }

}
