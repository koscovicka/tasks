package com.neighbours;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class NeighboursApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeighboursApplication.class, args);

        // Matrix(int rowsCount, int columnsCount, int selectedCellValue)
        Matrix matrix = new Matrix(4, 4, 0);
        final List<Integer> neighbours = matrix.findNeighbours();
        System.out.println("Result: " + neighbours);
    }

}
