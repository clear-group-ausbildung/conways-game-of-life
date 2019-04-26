package de.clearit.games.gameoflife;

import java.awt.*;

public class GameOfLife {

    private Cell[][] cellBoard;

    public void init(int x, int y) {
        cellBoard = new Cell[x][y];
    }


    private int getCountOfLivingNeighborCells(Point cellPosition) {

        int count = 0;
        // suche in Array

        // Zellen oben
        for (int i = cellPosition.x - 1; i < 3; i++) {
            if (hasPositionLivingCell(new Point(cellPosition.y - 1, i))) {
                count++;
            }
        }
        // Zellen unten
        for (int i = cellPosition.x - 1; i < 3; i++) {
            if (hasPositionLivingCell(new Point(cellPosition.y + 1, i))) {
                count++;
            }
        }
        // Zellen links und rechts
        if (hasPositionLivingCell(new Point(cellPosition.y, cellPosition.x - 1))) {
            count++;
        }
        if (hasPositionLivingCell(new Point(cellPosition.y, cellPosition.x + 1))) {
            count++;
        }

        return count;
    }

    private boolean hasPositionLivingCell(Point cellPosition) {
        try {
            Cell checkCell = cellBoard[cellPosition.y][cellPosition.x];
            if (checkCell != null && checkCell.isAlive()) {
                return true;
            }
        } catch (IndexOutOfBoundsException ex) {
            return false;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public boolean oracleDecision(int livingNeighborsCount) {
        if (livingNeighborsCount < 2 || livingNeighborsCount > 3) {
            return false;
        } else {
            return true;
        }
    }

    public Cell getSalAd(int x, int y) {
        return cellBoard[x][y];
    }

    public void setCellAt(Point point, Cell cell) {
        cellBoard[point.y][point.x] = cell;
    }

    public void markOfDeath() {
        for (int row = 0; row < cellBoard.length; row++) {
            for (int column = 0; column < cellBoard[row].length; column++) {
                // Überprüfen ob Zelle vorhanden
                if (cellBoard[row][column] != null) {
                    // Anzahl der lebenden Nachbarn ermitteln
                    int livingNeighbors = getCountOfLivingNeighborCells(new Point(row, column));
                    // Oracle setzen
                    cellBoard[row][column].setOracle(oracleDecision(livingNeighbors));
                }

            }
        }
    }

    public void naturalSelection() {
        for (int row = 0; row < cellBoard.length; row++) {
            for (int column = 0; column < cellBoard[row].length; column++) {
                // Überprüfen ob Zelle vorhanden
                if (cellBoard[row][column] != null) {
                    // Natural selektieren
                    cellBoard[row][column].setAlive(cellBoard[row][column].getOracle());
                }

            }
        }
    }
}
