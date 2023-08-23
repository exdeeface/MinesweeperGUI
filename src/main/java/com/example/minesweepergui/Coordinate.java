package com.example.minesweepergui;

import java.util.Random;

public class Coordinate {
    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinate getRandomCoordinate(int size) {
        Random rand = new Random();

        return new Coordinate(rand.nextInt(size), rand.nextInt(size));
    }
}
