package de.clearit.games.gameoflife;

import java.awt.*;

public class GameOfLife {

    private static Cell[][] cellBoard;

    public void init(int x, int y){
        cellBoard = new Cell[x][y];
    }


    private static Point getPositionOfCell(Cell cell){
        // suche zelle und gib position zurück
        return null;
    }

    public static int getCountOfLivingNeighborCells(Cell cell){
        Point position = getPositionOfCell(cell);

        // suche in Array
        return 0;
    }
}
