package com.neighbours;

import com.neighbours.Cell;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    private final List<Cell> cells;
    private Cell selectedCell;
    private final int rowsCount;
    private final int columnsCount;

    public Matrix(int rowsCount, int columnsCount, int selectedCellValue) {

        if (rowsCount <= 0 || columnsCount <= 0 || selectedCellValue < 0 || selectedCellValue > (rowsCount * columnsCount) - 1) {
            throw new IllegalArgumentException("Input values are not valid!");
        }

        cells = new ArrayList<>();

        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
        int value = 0;
        for (int i = 0; i < rowsCount; i++) {
            for (int j = 0; j < columnsCount; j++) {
                Cell cell = new Cell(i, j, value);
                if (value == selectedCellValue) {
                    selectedCell = cell;
                }
                cells.add(cell);
                value++;
            }
        }

    }

    public List<Integer> findNeighbours() {

        List<Integer> neighbours = new ArrayList<>();

        final int selectedCellRowCoordinate = selectedCell.getRowCoordinate();
        final int selectedCellColumnCoordinate = selectedCell.getColumnCoordinate();

        int rowPositionMinusOne;
        if (selectedCellRowCoordinate == 0) {
            rowPositionMinusOne = rowsCount == 1 ? 0 : rowsCount - 1;
        } else {
            rowPositionMinusOne = selectedCellRowCoordinate - 1;
        }

        int rowPositionPlusOne;
        if (rowsCount == 1 || selectedCellRowCoordinate == rowsCount - 1) {
            rowPositionPlusOne = 0;
        } else {
            rowPositionPlusOne = selectedCellRowCoordinate + 1;
        }

        int columnPositionMinusOne;
        if (selectedCellColumnCoordinate == 0) {
            columnPositionMinusOne = columnsCount == 1 ? 0 : columnsCount - 1;
        } else {
            columnPositionMinusOne = selectedCellColumnCoordinate - 1;
        }

        int columnPositionPlusOne;
        if (columnsCount == 1 || selectedCellColumnCoordinate == columnsCount - 1) {
            columnPositionPlusOne = 0;
        } else {
            columnPositionPlusOne = selectedCellColumnCoordinate + 1;
        }

        neighbours.add(getCellValueByPosition(rowPositionMinusOne, columnPositionMinusOne));
        neighbours.add(getCellValueByPosition(rowPositionMinusOne, selectedCellColumnCoordinate));
        neighbours.add(getCellValueByPosition(rowPositionMinusOne, columnPositionPlusOne));

        neighbours.add(getCellValueByPosition(selectedCellRowCoordinate, columnPositionMinusOne));
        neighbours.add(getCellValueByPosition(selectedCellRowCoordinate, columnPositionPlusOne));

        neighbours.add(getCellValueByPosition(rowPositionPlusOne, columnPositionMinusOne));
        neighbours.add(getCellValueByPosition(rowPositionPlusOne, selectedCellColumnCoordinate));
        neighbours.add(getCellValueByPosition(rowPositionPlusOne, columnPositionPlusOne));

        return neighbours;
    }

    private int getCellValueByPosition(int rowPosition, int columnPosition) {
        int cellValue = -1;
        for (Cell cell : cells) {
            if (cell.getRowCoordinate() == rowPosition && cell.getColumnCoordinate() == columnPosition) {
                cellValue = cell.getCellValue();
            }
        }
        return cellValue;
    }
}
