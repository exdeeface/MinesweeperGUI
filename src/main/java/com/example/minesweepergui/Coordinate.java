package com.example.minesweepergui;
import java.security.SecureRandom;

public class Coordinate {
    static SecureRandom rand = new SecureRandom();

    int x;
    int y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    static Coordinate getRandomCoordinate(int size) {
        return new Coordinate(rand.nextInt(size), rand.nextInt(size));
    }
}
