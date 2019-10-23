package main.model;

/**
 * Used Color Scheme: https://www.schemecolor.com/matrix-code-green.php
 */
public enum MatrixColor {
    VAMPIRE_BLACK(13, 2, 8),
    DARK_GREEN(0, 59, 0),
    ISLAMIC_GREEN(0, 143, 17),
    MALACHITE(0, 255, 65),
    WHITE(255, 255, 255);

    private final int red;
    private final int green;
    private final int blue;

    MatrixColor(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }
}
