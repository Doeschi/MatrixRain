package main.model;

import processing.core.PApplet;

public class MatrixSymbol {

    private PApplet pApplet;

    private int changeProbability;
    private boolean visible;
    private boolean drawWhite;

    private char symbol;
    private MatrixColor color;
    private int colorAlpha;
    private int xCord;
    private int yCord;

    public MatrixSymbol(char symbol, int xCord, int yCord, int changeProbability, PApplet pApplet) {
        this.symbol = symbol;
        this.xCord = xCord;
        this.yCord = yCord;
        this.changeProbability = changeProbability;
        this.pApplet = pApplet;
        this.visible = false;
        this.drawWhite = false;
        this.colorAlpha = 255;
        randomColor();
    }

    public void draw() {
        if (this.visible) {
            if (drawWhite) {
                pApplet.fill(255);
                drawWhite = false;
            } else {
                pApplet.fill(color.getRed(), color.getGreen(), color.getBlue(), colorAlpha);
            }
            pApplet.text(symbol, xCord, yCord);
            pApplet.noFill();
        }
    }

    public void changeSymbol() {
        if (PApplet.parseInt(pApplet.random(0, 100)) < changeProbability) {
            symbol = PApplet.parseChar(PApplet.parseInt(pApplet.random(65, 91)));
        }
    }

    public void changeVisibility() {
        visible = !visible;
    }

    public void reduceColorAlpha() {
        // 1/16 of 256
        colorAlpha -= 16;
    }

    public void resetColorAlpha() {
        colorAlpha = 255;
    }

    public void drawWhite() {
        drawWhite = true;
    }

    private void randomColor() {
        switch (PApplet.parseInt(pApplet.random(3))) {
            case 0:
                color = MatrixColor.DARK_GREEN;
                break;
            case 1:
                color = MatrixColor.ISLAMIC_GREEN;
                break;
            case 2:
                color = MatrixColor.MALACHITE;
                break;
        }
    }
}
