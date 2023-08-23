package com.example.minesweepergui;

import java.util.Random;



public class Coordinate {
    int x;
    int y;

    static Random rand = new Random();

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinate getRandomCoordinate(int size) {
        return new Coordinate(rand.nextInt(size), rand.nextInt(size));
    }
}
