package com.shpp.p2p.cs.asvidlo.assignment8;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MouseLoop extends WindowProgram {

    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 900;
    public static final int APPLICATION_HEIGHT = 800;
    public static final int SQUARE_OFFSET = 30;

    public static final int M = 8;
    public static final int N = 12;
    public static final double RATIO = 16.0;
    private GRect square;
    ArrayList<Double> array = new ArrayList<>();


    public void run() {
        double sideSquare = (getWidth() / RATIO);
        addMouseListeners();
        drawRectangle(sideSquare);
//        square = drawSquare(sideSquare);
        moveBlueSquare(sideSquare);
    }

    private GRect drawSquare(double sideSquare) {
        GRect square = new GRect(SQUARE_OFFSET, SQUARE_OFFSET, sideSquare, sideSquare);
        square.setFilled(true);
        square.setFillColor(Color.BLUE);
        add(square);
        return null;
    }

    private void moveBlueSquare(double sideSquare) {
        while (true) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == 0 || j == N - 1) {
                    GRect square = new GRect(SQUARE_OFFSET + (sideSquare * i), SQUARE_OFFSET +
                            (sideSquare * j), sideSquare, sideSquare);
                    square.setFilled(true);
                    square.setFillColor(Color.BLUE);
                        add(square);
                        pause(200);
                        remove(square);
                    }
                }
            }

            for (int i = M; i > 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (i == M - 1) {
                    GRect square = new GRect(SQUARE_OFFSET + (sideSquare * i), SQUARE_OFFSET +
                            (sideSquare * j), sideSquare, sideSquare);
                    square.setFilled(true);
                    square.setFillColor(Color.BLUE);
                        add(square);
                        pause(200);
                        remove(square);
                    }
                }
            }

            for (int i = M - 1; i >= 0; i--) {
                GRect square = new GRect(SQUARE_OFFSET +
                        (sideSquare * i), SQUARE_OFFSET, sideSquare, sideSquare);
                square.setFilled(true);
                square.setFillColor(Color.BLUE);
                add(square);
                pause(200);
                remove(square);
            }
        }
    }


    private void drawRectangle(double sideSquare) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || j == N - 1) {
                GRect square = new GRect(SQUARE_OFFSET + (sideSquare * i),
                        SQUARE_OFFSET + (sideSquare * j), sideSquare, sideSquare);
                square.setFilled(true);
                square.setFillColor(Color.GREEN);
                    add(square);
                }
            }
        }

        for (int i = M; i > 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == M - 1) {
                GRect square = new GRect(SQUARE_OFFSET + (sideSquare * i),
                        SQUARE_OFFSET + (sideSquare * j), sideSquare, sideSquare);
                square.setFilled(true);
                square.setFillColor(Color.GREEN);
                    add(square);
                }
            }
        }

        for (int i = M - 1; i >= 0; i--) {
            GRect square = new GRect(SQUARE_OFFSET + (sideSquare * i),
                    SQUARE_OFFSET, sideSquare, sideSquare);
            square.setFilled(true);
            square.setFillColor(Color.GREEN);
            add(square);
        }
    }
}
