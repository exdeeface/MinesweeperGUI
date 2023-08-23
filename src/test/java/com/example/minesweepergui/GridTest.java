package com.example.minesweepergui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GridTest {

    @Test
    void plantBombs() {
        assertAll(
                () ->  assertEquals(new Grid(0).bombLocations.size(), 1),
                () ->  assertEquals(new Grid(1).bombLocations.size(), 10),
                () ->  assertEquals(new Grid(2).bombLocations.size(), 15),
                () ->  assertEquals(new Grid(3).bombLocations.size(), 20)
        );
    }
}