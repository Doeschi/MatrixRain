package main;

import main.model.MatrixColumn;
import main.model.MatrixSymbol;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class Main extends PApplet {

    private int symbolSize = 10;
    private List<MatrixSymbol> symbolList;
    private MatrixSymbol[][] symbolsGrid;

    private SymbolChanger symbolChanger;
    private ColumnChanger columnChanger;
    private List<MatrixColumn> columns;

    public void settings() {
        size(1800, 805);
    }

    @Override
    public void setup() {
        frameRate(30);
        initSettings();
        initSymbols();
        initColumns();
        symbolChanger = new SymbolChanger(symbolList);
        symbolChanger.start();
        columnChanger = new ColumnChanger(columns);
        columnChanger.start();
    }

    public void draw() {
        background(13, 2, 8);
        drawSymbols();
    }

    private void drawSymbols() {
        for (MatrixSymbol symbol : symbolList) {
            symbol.draw();
        }
    }

    private void initSettings() {
        textSize(symbolSize);
        textAlign(CENTER, CENTER);
    }

    private void initSymbols() {
        symbolList = new ArrayList<>();
        symbolsGrid = new MatrixSymbol[width / symbolSize][height / symbolSize];
        for (int x = 0; x < symbolsGrid.length; x++) {
            for (int y = 0; y < symbolsGrid[x].length; y++) {
                MatrixSymbol symbol = new MatrixSymbol(parseChar(parseInt(random(65, 91))), (x * symbolSize) + (symbolSize / 2), (y * symbolSize) + (symbolSize / 2), parseInt(random(1, 101)), this);
                symbolList.add(symbol);
                symbolsGrid[x][y] = symbol;
            }
        }
    }

    private void initColumns() {
        columns = new ArrayList<>();
        for (MatrixSymbol[] column : symbolsGrid) {
            MatrixColumn symbolColumn = new MatrixColumn(column, this);
            columns.add(symbolColumn);
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"ProcessingTest"};
        Main main = new Main();
        PApplet.runSketch(processingArgs, main);
    }
}
