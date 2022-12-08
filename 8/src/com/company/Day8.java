package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {
    static Integer[][] trees;
    static int row;
    static int col;

    public static void main(String[] args) throws FileNotFoundException {
        importData();
        System.out.println(partOne());
        System.out.println(partTwo());
    }

    public static int partOne() {
        int num = 2 * row + 2 * col - 4; //trees around the edge of the grid
        for (int i = 1; i <= row - 2; i++) {
            for (int j = 1; j <= col - 2; j++) {
                if (treeVisible(i, j))
                    num++;
            }
        }
        return num;
    }

    public static int partTwo() {
        int maxScore = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (score(i,j) > maxScore)
                    maxScore = score(i,j);
            }
        }
        return maxScore;
    }

    public static int score(int n, int m) {
        return countLeft(n, m) * countRight(n, m) * countDown(n, m) * countUp(n, m);
    }

    public static int countUp(int n, int m) {
        if (n == 0)
            return 0;
        int num = 0;
        for (int i = n - 1; i >= 0; i--) {
            num++;
            if (trees[i][m] >= trees[n][m])
                return num;
        }
        return num;
    }

    public static int countLeft(int n, int m) {
        if (m == 0)
            return 0;
        int num = 0;
        for (int i = m - 1; i >= 0; i--) {
            num++;
            if (trees[n][i] >= trees[n][m])
                return num;
        }
        return num;
    }

    public static int countDown(int n, int m) {
        if (n == row - 1)
            return 0;
        int num = 0;
        for (int i = n + 1; i < row; i++) {
            num++;
            if (trees[i][m] >= trees[n][m])
                return num;
        }
        return num;
    }

    public static int countRight(int n, int m) {
        if (m == col - 1)
            return 0;
        int num = 0;
        for (int i = m + 1; i < col; i++) {
            num++;
            if (trees[n][i] >= trees[n][m]) {
                return num;
            }
        }
        return num;
    }

    public static Boolean treeVisible(int n, int m) {
        return visibleDown(n, m) || visibleTop(n, m) || visibleLeft(n, m) || visibleRight(n, m);
    }

    public static Boolean visibleTop(int n, int m) {
        for (int i = 0; i < n; i++) {
            if (trees[i][m] >= trees[n][m]) {
                return false;
            }
        }
        return true;
    }

    public static Boolean visibleDown(int n, int m) {
        for (int i = n + 1 ; i < row; i++) {
            if (trees[i][m] >= trees[n][m]) {
                return false;
            }
        }
        return true;
    }

    public static Boolean visibleLeft(int n, int m) {
        for (int i = 0 ; i < m; i++) {
            if (trees[n][i] >= trees[n][m]) {
                return false;
            }
        }
        return true;
    }

    public static Boolean visibleRight(int n, int m) {
        for (int i = m + 1; i < col; i++) {
            if (trees[n][i] >= trees[n][m])
                return false;
        }
        return true;
    }

    public static void importData() throws FileNotFoundException {
        ArrayList<String> data = new ArrayList<>();
        File file = new File("/Users/justynaziemichod/Documents/advent-of-code-2022/8/data.txt");
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            data.add(scanner.nextLine());
        }
        scanner.close();
        col = data.get(0).length();
        row = data.size();
        trees = new Integer[row][col];
        int row = 0;
        for (String s : data) {
            for (int i = 0; i < col; i++) {
                trees[row][i] = Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            row++;
        }
    }
}
