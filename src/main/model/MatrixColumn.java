package main.model;

import processing.core.PApplet;

public class MatrixColumn {

    private PApplet pApplet;
    private MatrixSymbol[] symbols;

    private int start;
    private int end;
    private int visibleSymbols;
    private int counter;
    private long expire;

    public MatrixColumn(MatrixSymbol[] symbols, PApplet pApplet) {
        this.symbols = symbols;
        this.pApplet = pApplet;
        randomizeColumn();
    }

    public void update() {
        if (visibleSymbols < end - start) {
            showColumn();
        } else if (System.currentTimeMillis() > expire) {
            if (counter > end + 16) {
                resetColumn();
                return;
            }
            fadeColumn();
        }
    }

    private void showColumn() {
        symbols[start + visibleSymbols].changeVisibility();
        symbols[start + visibleSymbols].drawWhite();
        visibleSymbols++;
        if (visibleSymbols == end - start) {
            expire = System.currentTimeMillis() + PApplet.parseInt(pApplet.random(4000, 10000));
        }
    }

    private void resetColumn() {
        resetColorAlpha();
        changeVisibility();
        randomizeColumn();
    }

    private void fadeColumn() {
        for (int i = start; i < end; i++) {
            if (i > start + counter) {
                break;
            }
            symbols[i].reduceColorAlpha();
        }
        counter++;
    }

    private void changeVisibility() {
        for (int i = start; i < end; i++) {
            symbols[i].changeVisibility();
        }
    }

    private void resetColorAlpha() {
        for (int i = start; i < end; i++) {
            symbols[i].resetColorAlpha();
        }
    }

    private void randomizeColumn() {
        start = PApplet.parseInt(pApplet.random(symbols.length / 2));
        end = PApplet.parseInt(pApplet.random(start, symbols.length - 5)) + 5;
        visibleSymbols = 0;
        expire = System.currentTimeMillis() + 1_000_000;
        counter = 0;
    }
}
