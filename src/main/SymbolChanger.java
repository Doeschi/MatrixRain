package main;

import main.model.MatrixSymbol;

import java.util.List;

public class SymbolChanger extends Thread {

    private List<MatrixSymbol> symbols;

    public SymbolChanger(List<MatrixSymbol> symbols) {
        this.symbols = symbols;
    }

    @Override
    public void run() {
        while (true) {
            for (MatrixSymbol symbol : symbols) {
                symbol.changeSymbol();
            }
            try {
                // This equals 20 FPS
                sleep(1000 / 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
