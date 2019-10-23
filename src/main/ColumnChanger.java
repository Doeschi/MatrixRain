package main;

import main.model.MatrixColumn;

import java.util.List;

public class ColumnChanger extends Thread {

    private List<MatrixColumn> columns;

    public ColumnChanger(List<MatrixColumn> columns) {
        this.columns = columns;
    }

    @Override
    public void run() {
        while (true) {
            for (MatrixColumn column : columns) {
                column.update();
            }
            try {
                sleep(1000 / 18);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
