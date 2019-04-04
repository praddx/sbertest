package com.plahotin.factorialcalculation;

import java.util.Scanner;

public class CalculateFunction {

    public static void main(String[] args) {
        FunctionCalculator fc = new FunctionCalculator();
        Scanner scanner = new Scanner(System.in);
        int r, m;
        System.out.print("Enter r: ");
        r = scanner.nextInt();
        System.out.print("Enter m: ");
        m = scanner.nextInt();
        scanner.close();
        try {
            System.out.println("m!/r!(m-r)! = " + fc.calculateFunction(m, r));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
