package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {
    static List<String> data = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readData();
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    public static void readData() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/2/data.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }
        myReader.close();
    }

    public static int partOne() {
        int sum = 0;
        for (String i : data) {
            int res = 0;
            int shape = 1;
            String oponent = i.split(" ")[0];
            String me = i.split(" ")[1];

            switch (me) {
                case "X":
                    if (oponent.equals("C"))
                        res = 6;
                    else if (oponent.equals("A"))
                        res = 3;
                    break;
                case "Y":
                    shape = 2;
                    if (oponent.equals("A"))
                        res = 6;
                    else if (oponent.equals("B"))
                        res = 3;
                    break;
                case "Z":
                    shape = 3;
                    if (oponent.equals("B"))
                        res = 6;
                    else if (oponent.equals("C"))
                        res = 3;
                    break;
            }
            sum += res + shape;
        }
        return sum;
    }

    public static int partTwo() {
        int sum = 0;
        for (String i : data) {
            String oponent = i.split(" ")[0];
            String me = i.split(" ")[1];

            switch (me) {
                case "X" -> //lose
                        sum += loseShapePoints(oponent);
                case "Y" -> //draw
                        sum += 3 + shapePoints(oponent);
                case "Z" -> //win
                        sum += 6 + winShapePoints(oponent);
            }
        }
        return sum;
    }

    public static int shapePoints(String shape) {
        int p = switch (shape) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            default -> 0;
        };
        return p;
    }

    public static int loseShapePoints(String shape) {
        int p = (shapePoints(shape)+2)%3;
        if (p == 0)
            p = 3;
        return p;
    }

    public static int winShapePoints(String shape) {
        int p = (shapePoints(shape)+1)%3;
        if (p == 0)
            p = 3;
        return p;
    }

}
