package com.shpp.p2p.cs.asvidlo.assignment8;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MouseLoopSecond extends WindowProgram {

    /**
     * Width and height of application window in pixels
     */
    public static final int APPLICATION_WIDTH = 900;
    public static final int APPLICATION_HEIGHT = 800;
    public static final int SQUARE_OFFSET = 30;

    public static final int M = 8;
    public static final int N = 12;
    public static final double RATIO = 16.0;

    ArrayList<GRect> list = new ArrayList<>();
    int currentBlue = 11;
    int currentRed = 0;

    int currentSelected = -1;

    public void run() {
        addMouseListeners();
        createPath();
        move();

    }

    private void move() {
        while (true) {
            moveBlue();
            moveRed();

            pause(200);
        }
    }

    private void moveBlue() {
        if (currentSelected != currentBlue) {
            GRect rectAfter = list.get(currentBlue);
            rectAfter.setFillColor(Color.GREEN);

            if (currentBlue < list.size() - 1) {
                currentBlue++;
            } else {
                currentBlue = 0;
            }
            GRect rectCurrent = list.get(currentBlue);
            rectCurrent.setFillColor(Color.blue);
        } else {
            GRect rectAfter = list.get(currentBlue);
            rectAfter.setFillColor(Color.GREEN);

            if (currentBlue < list.size() - 1) {
                currentBlue--;
            } else {
                currentBlue = 0;
            }
            GRect rectCurrent = list.get(currentBlue);
            rectCurrent.setFillColor(Color.blue);
        }

    }

    public void mouseMoved (MouseEvent e) {
        Object selectedObject = getElementAt(e.getX(), e.getX());

        if (selectedObject != null) {
            currentSelected = list.indexOf(selectedObject);
        }
    }

    private void moveRed() {

    }

    private void createPath() {
        int x = 0;
        int y = SQUARE_OFFSET;
        double sideSquare = (getWidth() / RATIO);

        for (int i = 0; i < M; i++) {
            x = SQUARE_OFFSET + (int) sideSquare * i;
            newRect(x, y, sideSquare, Color.GREEN);
        }

        for (int i = 0; i < N - 1; i++) {
            y = SQUARE_OFFSET + (int) sideSquare + (int) sideSquare * i;
            newRect(x, y, sideSquare, Color.GREEN);
        }

        for (int i = M - 2; i >= 0; i--) {
            x = SQUARE_OFFSET + (int) sideSquare * i;
            newRect(x, y, sideSquare, Color.GREEN);
        }

        for (int i = N - 3; i >= 0; i--) {
            y = SQUARE_OFFSET + (int) sideSquare + (int) sideSquare * i;
            newRect(x, y, sideSquare, Color.GREEN);
        }
    }

    private GRect newRect(int x, int y, double size, Color color) {
        GRect square = new GRect(x, y, size, size);
        square.setFilled(true);
        square.setFillColor(color);
        add(square);
        list.add(square);
        return square;
    }
}
