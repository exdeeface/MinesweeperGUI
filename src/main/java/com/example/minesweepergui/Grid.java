package com.example.minesweepergui;
import java.util.ArrayList;

public class Grid {
    boolean gridCreated = false;

    int difficulty;
    int size;
    int bombs;

    String padText = "\n    ";

    ArrayList<ArrayList<Tile>> matrix = new ArrayList<>();
    ArrayList<Tile> bombLocations = new ArrayList<>();

    Grid(int difficulty) {
        this.difficulty = difficulty;
        this.initGame();
    }

    void initGame() {
        this.createGrid();
        this.plantBombs();
        this.setDisplayNumbers();
    }

    void createGrid() {
        switch (this.difficulty) {
            case 0 -> {
                this.size = 4;
                this.bombs = 1;
            }

            case 1 -> {
                this.size = 8;
                this.bombs = 10;
            }

            case 2 -> {
                this.size = 12;
                this.bombs = 15;
            }

            case 3 -> {
                this.size = 16;
                this.bombs = 20;
            }

            default -> System.exit(0);
        }

        for (int i = 0; i < size; i++) {
            matrix.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                matrix.get(i).add(new Tile(this, i, j));
            }
        }

        gridCreated = true;
    }

    void setDisplayNumbers() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix.get(i).get(j).checkNeighbours();
            }
        }
    }

    boolean checkGridState() {
        for (Tile tile : bombLocations) {
            if (!tile.hasFlag()) {
                System.out.println("Still bombs out there!");
                return false;
            } else {
                System.out.println("All bombs found!");
                return true;
            }
        }

        return true;
    }

    Tile getTileFromCoordinate(int x, int y) {
        return matrix.get(x).get(y);
    }

    void printGrid() {
        if (!gridCreated) {
            System.out.println("Need to create grid before printing.");
            return;
        }

        int sideNumbersY = 1;

        System.out.print(padText);
        for (int i = 0; i < this.size; i++) {
            if (sideNumbersY < 10) {
                System.out.print(" ");
            }
            System.out.print(sideNumbersY + " ");
            sideNumbersY++;
        }

        System.out.print(padText);
        for (int i = 0; i < this.size; i++) { System.out.print("__ "); }
        System.out.println();

        int sideNumbersX = 1;

        for (ArrayList<Tile> col : matrix) {
            if (sideNumbersX < 10) { System.out.print(" "); }
            System.out.print(sideNumbersX + " | ");
            sideNumbersX++;

            for (Tile tile : col) {
                if (tile.isRevealed()) {
                    if (tile.hasFlag()) {
                        System.out.print("F  ");
                    } else {
                        System.out.print(tile.getNeighbouringBombs() + "  ");
                    }
                } else {
                    System.out.print("?  ");
                }
            }

            System.out.println();
        }
    }

    void printGridAsIs() {
        if (!gridCreated) {
            System.out.println("Need to create grid before printing.");
            return;
        }

        int sideNumbersY = 1;

        System.out.print(padText);
        for (int i = 0; i < this.size; i++) {
            if (sideNumbersY < 10) { System.out.print(" "); }
            System.out.print(sideNumbersY + " ");
            sideNumbersY++;
        }

        System.out.print(padText);
        for (int i = 0; i < this.size; i++) { System.out.print("__ "); }
        System.out.println();

        int sideNumbersX = 1;

        for (ArrayList<Tile> col : matrix) {
            if (sideNumbersX < 10) { System.out.print(" "); }
            System.out.print(sideNumbersX + " | ");
            sideNumbersX++;

            for (Tile tile : col) {
                if (tile.hasBomb()) { System.out.print("B  "); }
                else { System.out.print(tile.getNeighbouringBombs() + "  "); }
            }
            System.out.println();
        }
    }

    void plantBombs() {
        for (int i = 0; i < bombs; i++) {
            boolean isValid = false;
            while (!isValid) {
                isValid = true;
                Coordinate c = Coordinate.getRandomCoordinate(this.size);
                if (matrix.get(c.x).get(c.y).hasBomb()) {
                    isValid = false;
                } else {
                    bombLocations.add(matrix.get(c.x).get(c.y));
                    matrix.get(c.x).get(c.y).plantBomb();
                }
            }
        }
    }
}

