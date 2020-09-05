package com.patterrn;

/**
 * a + ib
 * a =  real number
 * b = imaginary number
 * i = sqrt(-1)
 */
public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (imag > 0)
            return real + " + i" + imag;
        else
            return real + " - i" + imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public static ComplexNumber add(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getReal() + second.getReal(),
                first.getImag() + second.getImag());

    }

    public static ComplexNumber subtract(ComplexNumber first, ComplexNumber second) {
        return new ComplexNumber(first.getReal() - second.getReal(),
                first.getImag() - second.getImag());

    }

    public static ComplexNumber mul(ComplexNumber first, ComplexNumber second) {
        double real = (first.getReal() * second.getReal()) - (first.getImag() * second.getImag());
        double imag = (first.getReal() * second.getImag()) + (first.getImag() * second.getReal());

        return new ComplexNumber(real, imag);
    }

    public static void main(String[] args) {
        ComplexNumber complexNumber1 = new ComplexNumber(3, 5);
        ComplexNumber complexNumber2 = new ComplexNumber(5, 7);
        System.out.println(complexNumber1.toString());
        System.out.println(complexNumber2.toString());
        ComplexNumber result = add(complexNumber1, complexNumber2);
        System.out.println("ADD " + result.toString());

        ComplexNumber result1 = subtract(complexNumber1, complexNumber2);
        System.out.println("SUB " + result1.toString());

        ComplexNumber result2 = mul(complexNumber1, complexNumber2);
        System.out.println("MULMUL ka kurta " + result2.toString());

    }
}
