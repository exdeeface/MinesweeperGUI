package com.example.minesweepergui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    @Test
    void plantBombs() {
        assertAll(
                () ->  assertEquals(1, new Grid(0).bombLocations.size()),
                () ->  assertEquals(1, new Grid(0).bombLocations.size()),
                () ->  assertEquals(1, new Grid(0).bombLocations.size()),
                () ->  assertEquals(1, new Grid(0).bombLocations.size())
        );
    }

    @Test
    void createGrid() {
        assertAll(
                () -> {
                    int exp = 4;
                    Grid g = new Grid(0);
                    assertEquals(exp, g.size);
                    for (int i = 0; i < g.size; i++) { assertEquals(exp, g.matrix.get(i).size()); }
                },
                () -> {
                    int exp = 8;
                    Grid g = new Grid(1);
                    assertEquals(exp, g.size);
                    for (int i = 0; i < g.size; i++) { assertEquals(exp, g.matrix.get(i).size()); }
                },
                () -> {
                    int exp = 12;
                    Grid g = new Grid(2);
                    assertEquals(exp, g.size);
                    for (int i = 0; i < g.size; i++) { assertEquals(exp, g.matrix.get(i).size()); }
                },
                () -> {
                    int exp = 16;
                    Grid g = new Grid(3);
                    assertEquals(exp, g.size);
                    for (int i = 0; i < g.size; i++) { assertEquals(exp, g.matrix.get(i).size()); }
                }
        );
    }

    @Test
    void checkGridState() {
        Grid g = new Grid(0);
        g.initGame();

        assertFalse(g.checkGridState());
        for (Tile t : g.bombLocations) { t.setFlag(); }
        assert(g.checkGridState());
    }

    @Test
    void getTileFromCoordinate() {
        assertAll(
                () -> {
                    Grid g = new Grid(0);
                    g.initGame();

                    for (int i = 0; i < g.matrix.size(); i++) {
                        for (int j = 0; j < g.matrix.get(i).size(); j++) {
                            assertNotNull(g.getTileFromCoordinate(i, j));
                        }
                    }
                },
                () -> {
                    Grid g = new Grid(1);
                    g.initGame();

                    for (int i = 0; i < g.matrix.size(); i++) {
                        for (int j = 0; j < g.matrix.get(i).size(); j++) {
                            assertNotNull(g.getTileFromCoordinate(i, j));
                        }
                    }
                },
                () -> {
                    Grid g = new Grid(2);
                    g.initGame();

                    for (int i = 0; i < g.matrix.size(); i++) {
                        for (int j = 0; j < g.matrix.get(i).size(); j++) {
                            assertNotNull(g.getTileFromCoordinate(i, j));
                        }
                    }
                },
                () -> {
                    Grid g = new Grid(3);
                    g.initGame();

                    for (int i = 0; i < g.matrix.size(); i++) {
                        for (int j = 0; j < g.matrix.get(i).size(); j++) {
                            assertNotNull(g.getTileFromCoordinate(i, j));
                        }
                    }
                }
        );
    }
}