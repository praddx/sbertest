package com.plahotin.factorialcalculation;

import java.math.BigInteger;

public class FunctionCalculator {

    public BigInteger calculateFunction(int divisible, int divisor) throws Exception {
        if (!isValidInput(divisible, divisor)) {
            throw new IllegalArgumentException("r must be smaller or equal to m");
        }
        return calculateDivisionOfFactorials(divisible, divisor).multiply(calculateFactorial(divisible - divisor));
    }

    private boolean isValidInput(int divisible, int divisor) {
        return divisible >= divisor;
    }

    private BigInteger calculateDivisionOfFactorials(int divisible, int divisor) {
        if (divisor == divisible) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(divisible).multiply(calculateDivisionOfFactorials(--divisible, divisor));
        }
    }

    private BigInteger calculateFactorial(int num) {
        if (num == 0 || num == 1) {
            return BigInteger.ONE;
        } else if (num == 2) {
            return BigInteger.valueOf(num);
        } else {
            return BigInteger.valueOf(num).multiply(calculateFactorial(--num));
        }


    }
}
