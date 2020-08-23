package com.neighbours;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    public static final String ERROR_MESSAGE = "Input values are not valid!";
    public static final String CELLS_FIELD_NAME = "cells";

    @ParameterizedTest
    @MethodSource("provideInvalidInputsForMatrixConstructor")
    @DisplayName("Matrix constructor should throws IllegalArgumentException when input arguments are not valid")
    void matrixConstructor_throwsException(int rowsCount, int columnsCount, int selectedCellValue) {

        // act
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Matrix(rowsCount, columnsCount, selectedCellValue));
        // assert
        assertEquals(ERROR_MESSAGE, exception.getMessage());
    }

    private static Stream<Arguments> provideInvalidInputsForMatrixConstructor() {
        return Stream.of(
                Arguments.of(1, 3, 3),
                Arguments.of(0, 5, 0),
                Arguments.of(1, -1, 0),
                Arguments.of(3, 3, -1));
    }

    @Test
    @DisplayName("Matrix constructor should create list of with correct size Cells when input arguments are valid")
    void matrixConstructor_createCellList() {

        // act
        Matrix matrix = new Matrix(4, 3, 2);

        // assert
        final List<Cell> createdCells = (List<Cell>) ReflectionTestUtils.getField(matrix, CELLS_FIELD_NAME);
        assertAll(
                () -> assertNotNull(createdCells),
                () -> assertEquals(4 * 3, createdCells.size())
        );

    }

    @ParameterizedTest
    @MethodSource("provideForFindNeighboursTest")
    @DisplayName("findNeighbours should find correct neighbours when input arguments are valid")
    void findNeighbours(int inputRowsCount, int inputColumnsCount, int inputSelectedCellValue, List<Integer> neighboursExpected) {

        // arrange
        Matrix matrix = new Matrix(inputRowsCount, inputColumnsCount, inputSelectedCellValue);

        // act
        final List<Integer> neighbours = matrix.findNeighbours();

        // assert
        assertAll(
                () -> assertNotNull(neighbours),
                () -> assertEquals(8, neighbours.size()),
                () -> assertEquals(neighboursExpected, neighbours)
        );
    }

    private static Stream<Arguments> provideForFindNeighboursTest() {
        return Stream.of(
                Arguments.of(4, 4, 5, Arrays.asList(0, 1, 2, 4, 6, 8, 9, 10)),
                Arguments.of(4, 4, 0, Arrays.asList(15, 12, 13, 3, 1, 7, 4, 5)),
                Arguments.of(4, 5, 1, Arrays.asList(15, 16, 17, 0, 2, 5, 6, 7)),
                Arguments.of(1, 3, 2, Arrays.asList(1, 2, 0, 1, 0, 1, 2, 0)),
                Arguments.of(1, 1, 0, Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0)),
                Arguments.of(4, 4, 3, Arrays.asList(14, 15, 12, 2, 0, 6, 7, 4)));
    }

}