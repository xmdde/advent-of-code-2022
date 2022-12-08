package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    public static int partOne() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/1/data.txt");
        Scanner scanner = new Scanner(file);
        int max = 0;
        int cal = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                cal += Integer.parseInt(line);
            }
            else {
                if (cal > max)
                    max = cal;
                cal = 0;
            }
        }

        scanner.close();
        return max;
    }

    public static int partTwo() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/1/data.txt");
        Scanner scanner = new Scanner(file);
        int[] max = new int[3];
        int cal = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                cal += Integer.parseInt(line);
            }
            else {
                if (cal > max[2]) {
                    max[2] = cal;
                    if (cal > max[1]) {
                        max[2] = max[1];
                        max[1] = cal;
                        if (cal > max[0]) {
                            max[1] = max[0];
                            max[0] = cal;   //hej
                        }
                    }
                }
                cal = 0;
            }
        }
        scanner.close();
        return max[0] + max[1] + max[2];
    }
}
