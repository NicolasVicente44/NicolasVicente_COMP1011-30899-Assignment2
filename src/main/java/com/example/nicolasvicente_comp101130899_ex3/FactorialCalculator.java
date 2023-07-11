package com.example.nicolasvicente_comp101130899_ex3;

import java.math.BigInteger;

public class FactorialCalculator {

    public BigInteger calculateFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be negative");
        }

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
}
