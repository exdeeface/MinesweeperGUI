package com.example.minesweepergui;

public class Main {
    public static void main(String[] args) {
        //add difficulty select
        //add way to start new game without closing exe
        //check for bombs without flagging each one
        //add more robust input
        GameInstance g = new GameInstance(0);
        g.start();
    }
}