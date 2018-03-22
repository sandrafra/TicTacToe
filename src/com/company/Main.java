package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random gen = new Random();
        int[] array = new int[10];
        double sum = 0;
        int lpwieksze = 0;
        int lpmniejsze = 0;
        for (int i = 0; i < 10; i++) {
            array[i] = gen.nextInt(10 + 10 + 1) - 10;
            System.out.print(array[i] + " ");
        }
        int maximum = array[0];
        int minimum = array[0];
        for (int i = 0; i < 10; i++) {
            if (maximum < array[i]) {

                maximum = array[i];
            }
            if (minimum > array[i]) {
                minimum = array[i];
            }
        }
        System.out.println("Minimum: " + minimum);
        System.out.println("Maksimum: " + maximum);
        for (int i = 0; i < 10; i++) {
            sum += array[i];
        }
        double srednia = sum / 10;
        System.out.println("Średnia: " + srednia);

        for (int i = 0; i < 10; i++) {
            if (array[i] > srednia)
                lpwieksze++;
            if (array[i] < srednia)
                lpmniejsze++;
        }
        System.out.println("Większe od sredniej: " + lpwieksze);
        System.out.println("mniejsze od sredniej: " + lpmniejsze);
        for (int i = 9; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}
