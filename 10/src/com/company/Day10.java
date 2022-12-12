package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10 {
    static ArrayList<String> data = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readData();
        solve();
    }

    public static void solve() {
        int cycle = 0; //after
        int register = 1;
        int strength = 0;
        for (String i : data) {
            String[] arr = i.split(" ");
            switch (arr[0]) {
                case "noop":
                    if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 179 || cycle == 219)
                        strength += (cycle + 1) * register;
                    cycle++;
                    drawPixel(cycle, register);
                    break;
                case "addx":
                    if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 179 || cycle == 219)
                        strength += (cycle + 1) * register;
                    cycle++;
                    drawPixel(cycle, register);
                    if (cycle == 19 || cycle == 59 || cycle == 99 || cycle == 139 || cycle == 179 || cycle == 219)
                        strength += (cycle + 1) * register;
                    cycle++;
                    drawPixel(cycle, register);
                    register += Integer.parseInt(arr[1]);
                    break;
            }
        }
        System.out.println(strength);
    }

    public static void drawPixel(final int cycle, final int register) {
        final int SPRITE_WIDTH = 3;
        final int CRT_WIDTH = 40;
        int pos = cycle % CRT_WIDTH;
        if (pos < register || pos >= register + SPRITE_WIDTH) {
            System.out.print('.');
        }
        else {
            System.out.print('#');
        }
        if (pos == 0)
            System.out.println();
    }

    public static void readData() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/10/data.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            data.add(myReader.nextLine());
        }
        myReader.close();
    }
}
