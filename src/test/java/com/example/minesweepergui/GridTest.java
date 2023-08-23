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
}