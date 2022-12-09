package com.company;
import java.util.ArrayList;

public class Map extends ArrayList<Pos> {

    public Map() {
        this.add(new Pos(0,0));
    }

    public void addIfNotRepetetive(int x, int y) {
        Boolean add = true;
        for (Pos pos : this) {
            if (pos.getX() == x && pos.getY() == y) {
                add = false;
                break;
            }
        }
        if (add) {
            this.add(new Pos(x, y));
            //System.out.println("dodaje!");
        }
    }

}
