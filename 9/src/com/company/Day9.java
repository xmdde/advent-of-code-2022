package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9 {
    static Map tailMap = new Map();
    static Pos head = new Pos(0,0);
    static Pos tail = new Pos(0,0);

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(partOne());
    }

    public static int partOne() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/9/data.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
                int headOldX = head.getX();
                int headOldY = head.getY();
                head.move(arr[0].charAt(0));
                if (!goodDistance(head, tail)) {
                    tail = new Pos(headOldX, headOldY);
                    tailMap.addIfNotRepetetive(headOldX, headOldY);
                }
            }
        }
        scanner.close();
        return tailMap.size();
    }

    public static boolean goodDistance(Pos p1, Pos p2) {
        return Math.abs(p1.getY() - p2.getY()) <= 1 && Math.abs(p1.getX() - p2.getX()) <= 1;
    }

}
