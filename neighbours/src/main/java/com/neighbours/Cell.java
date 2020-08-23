package com.neighbours;

import lombok.Getter;

@Getter
public class Cell {

    int rowCoordinate;

    int columnCoordinate;

    int cellValue;

    public Cell(int rowCoordinate, int columnCoordinate, int cellValue) {
        this.rowCoordinate = rowCoordinate;
        this.columnCoordinate = columnCoordinate;
        this.cellValue = cellValue;
        System.out.println("Created cell: [" + rowCoordinate + ", " + columnCoordinate + "] with value: " + cellValue);
    }

}
