package com.example.minesweepergui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {

    @Test
    void hasBomb() {
        Coordinate c = Coordinate.getRandomCoordinate(8);
        Tile t = new Tile(null, c.x, c.y);
        assertFalse(t.hasBomb());
        t.plantBomb();
        assert(t.hasBomb());
    }

    @Test
    void hasFlag() {
        Coordinate c = Coordinate.getRandomCoordinate(8);
        Tile t = new Tile(null, c.x, c.y);
        assertFalse(t.hasFlag());
        t.setFlag();
        assert(t.hasFlag());
    }

    @Test
    void isRevealed() {
        Coordinate c = Coordinate.getRandomCoordinate(8);
        Grid g = new Grid(2);
        Tile t = new Tile(g, c.x, c.y);
        assertFalse(t.isRevealed());
        t.revealTile();
        assert(t.isRevealed());
    }
}