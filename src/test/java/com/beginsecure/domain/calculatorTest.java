package com.beginsecure.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;
import java.awt.*;

class calculatorTest {

    @Test
    public void test_min() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(1, calculator._min(numbers));
    }

    @Test
    public void test_max() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(9, calculator._max(numbers));
    }

    @Test
    public void test_sum() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(25, calculator._sum(numbers));
    }

    @Test
    public void test_mult() {
        int[] numbers = {5, 2, 8, 1, 9};
        assertEquals(720, calculator._mult(numbers));
    }

    @Test
    void testDifferentSpeed() throws IOException {
        Random random = new Random();

        int limit = 13;
        int[] sizes = new int[limit];
        for (int i = 0; i < limit; ++i) {
            sizes[i] = (int) Math.pow(2, i);
        }
        long[] times = new long[limit];

        for (int i = 0; i < limit; i++) {
            int[] numbers = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) {
                numbers[j] = random.nextInt(1000);
            }

            long startTime = System.nanoTime();
            calculator._min(numbers);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;

            assertTrue(times[i] <= 20000000, "Performance test failed" + " " + times[i]);
        }
    }

    @Test
    void testMaxSpeed() throws IOException {
        Random random = new Random();

        int limit = 30;
        int[] sizes = new int[limit];
        for (int i = 0; i < limit; ++i) {
            sizes[i] = (int) Math.pow(10, 6);
        }
        long[] times = new long[limit];

        for (int i = 0; i < limit; i++) {
            int[] numbers = new int[sizes[i]];
            for (int j = 0; j < sizes[i]; j++) {
                numbers[j] = random.nextInt(1000);
            }

            long startTime = System.nanoTime();
            calculator._min(numbers);
            long endTime = System.nanoTime();
            times[i] = endTime - startTime;

            assertTrue(times[i] <= 20000000, "Performance test failed" + " " + times[i]);
        }
    }
}