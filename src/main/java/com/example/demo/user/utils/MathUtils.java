package com.example.demo.user.utils;

public class MathUtils {

    // Método estático que calcula el máximo de tres números
    public static int maxOfThree(int num1, int num2, int num3) {
        if (num1 > 10 || num2 > 10 || num3 > 10) {
            throw new IllegalArgumentException("Los números no deben ser mayores que 10.");
        }

        int max = num1;

        if (num2 > max) {
            max = num2;
        }

        if (num3 > max) {
            max = num3;
        }

        return max;

    }
}