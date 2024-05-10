package com.beginsecure.domain;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        File file = new File("values.txt");
        try {
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            //System.out.println(line);
            String[] valuesStr = line.split(" ");
            int[] values = new int[valuesStr.length];
            for (int i = 0; i < valuesStr.length; i++) {
                values[i] = Integer.parseInt(valuesStr[i]);
            }
            scanner.close();
            System.out.println(_min(values));
            System.out.println(_max(values));
            System.out.println(_sum(values));
            System.out.println(_mult(values));
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
    public static int _min(int[] values) {
        int min = values[0];
        for (int num : values) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
    public static int _max(int[] values) {
        int max = values[0];
        for (int num : values) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    public static int _sum(int[] values) {
        int sum = 0;
        for (int num : values) {
            sum += num;
        }
        return sum;
    }
    public static long _mult(int[] values) {
        long mult = 1;
        for (int num : values) {
            mult *= num;
        }
        return mult;
    }
}


