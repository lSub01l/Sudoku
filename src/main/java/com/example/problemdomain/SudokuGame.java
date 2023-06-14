package com.example.problemdomain;

import java.io.Serializable;

import com.example.computationlogic.SudokuUtilities;
import com.example.constants.GameState;

public class SudokuGame implements Serializable {
    private final GameState gameState;
    private final int[][] gridState;
    
    public static final int GRID_BOUNDARY = 9;

        public SudokuGame(GameState gameState, int[][] gridState) {
        this.gameState = gameState;
        this.gridState = gridState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int[][] getCopyOfGridState() {
        return SudokuUtilities.copyToNewArray(gridState);
    }
}
