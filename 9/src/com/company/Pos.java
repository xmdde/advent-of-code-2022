package com.company;

public class Pos {
    private int x;
    private int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void move(Character dir) {
        switch (dir) {
            case 'U':
                this.y++;
                break;
            case 'D':
                this.y--;
                break;
            case 'R':
                this.x++;
                break;
            case 'L':
                this.x--;
                break;
        }
    }

}
