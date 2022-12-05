package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Day5 {
    static ArrayList<Stack> stacks = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
	    initValues();
        partOne();
        stacks = new ArrayList<>();
        initValues();
        partTwo();
    }

    public static void initValues() {
        Character[][] data = {
                {'H', 'R', 'B', 'D', 'Z', 'F', 'L', 'S'},
                {'T', 'B', 'M', 'Z', 'R'},
                {'Z', 'L', 'C', 'H', 'N', 'S'},
                {'S', 'C', 'F', 'J'},
                {'P', 'G', 'H', 'W', 'R', 'Z', 'B'},
                {'V', 'J', 'Z', 'G', 'D', 'N', 'M', 'T'},
                {'G', 'L', 'N', 'W', 'F', 'S', 'P', 'Q'},
                {'M', 'Z', 'R'},
                {'M', 'C', 'L', 'G', 'V', 'R', 'T'}
        };
        for (int i = 0; i < 9; i++) {
            Stack<Character> tmpStack = new Stack<>();
            for (Character j : data[i]) {
                tmpStack.push(j);
            }
            stacks.add(tmpStack);
        }
    }

    public static void move1(int num, int from, int to) {
        from--;
        to--;
        for (int i = 0; i < num; i++) {
            Character tmp = (Character) stacks.get(from).peek();
            stacks.get(to).push(tmp);
            stacks.get(from).pop();
        }
    }

    public static void partOne() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/5/data.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String tmp = myReader.nextLine();
            int n = Integer.parseInt(tmp.split(" ")[1]);
            int f = Integer.parseInt(tmp.split(" ")[3]);
            int t = Integer.parseInt(tmp.split(" ")[5]);
            move1(n, f, t);
        }
        myReader.close();
        results();
        System.out.println();
    }

    public static void move2(int num, int from, int to) {
        from--;
        to--;
        Character[] arr = new Character[num];
        for (int i = 0; i < num; i++) {
            arr[num - 1 - i] = (Character) stacks.get(from).peek();
            stacks.get(from).pop();
        }
        for (int i = 0; i < num; i++) {
            stacks.get(to).push(arr[i]);
        }
    }

    public static void partTwo() throws FileNotFoundException {
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/5/data.txt");
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String tmp = myReader.nextLine();
            int n = Integer.parseInt(tmp.split(" ")[1]);
            int f = Integer.parseInt(tmp.split(" ")[3]);
            int t = Integer.parseInt(tmp.split(" ")[5]);
            move2(n, f, t);
        }
        myReader.close();
        results();
    }

    public static void results() {
        for (Stack s : stacks) {
            System.out.print(s.peek());
        }
    }

}
