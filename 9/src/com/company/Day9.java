package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day9 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    public static int partOne() throws FileNotFoundException {
        Map tailMap = new Map();
        Pos head = new Pos(0,0);
        Pos tail = new Pos(0,0);
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

    public static int partTwo() throws FileNotFoundException {
        Map tailMap = new Map();
        Pos[] rope = new Pos[10];
        for (int i = 0; i < 10; i++) {
            rope[i] = new Pos(0,0);
        }
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/9/data.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] arr = scanner.nextLine().split(" ");
            for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
                int oldX = rope[0].getX();
                int oldY = rope[0].getY();
                int tmpX;
                int tmpY;
                rope[0].move(arr[0].charAt(0));
                for (int j = 1; j < 10; j++) { //idk jak z tymi ruchami
                    if (goodDistance(rope[j-1], rope[j]))
                        break;
                    if (!goodDistance(rope[j-1], rope[j])) {
                        tmpX = rope[j].getX();
                        tmpY = rope[j].getY();
                        rope[j] = new Pos(oldX, oldY);
                        oldX = tmpX;
                        oldY = tmpY;
                        if (j == 9) {
                            tailMap.addIfNotRepetetive(rope[j].getX(), rope[j].getY());
                        }
                    }
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
