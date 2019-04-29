package de.clearit.games.gameoflife;

import java.awt.*;

public class GameOfLife {

    private Cell[][] cellBoard;

    public void init(int x, int y) {
        cellBoard = new Cell[x][y];

        // In jedes Feld/ in jeden Index eine tote Zelle setzen
    }


    private int getCountOfLivingNeighborCells(Point cellPosition) {

        int count = 0;
        // suche in Array

        // Zellen oben
        for (int i = cellPosition.x - 1; i < ((cellPosition.x - 1) + 3); i++) {
            if (hasPositionLivingCell(new Point(i, cellPosition.y - 1))) {
                count++;
            }
        }
        // Zellen unten
        for (int i = cellPosition.x - 1; i < ((cellPosition.x - 1) + 3); i++) {
            if (hasPositionLivingCell(new Point(i, cellPosition.y + 1))) {
                count++;
            }
        }
        // Zellen links und rechts
        if (hasPositionLivingCell(new Point(cellPosition.x - 1, cellPosition.y))) {
            count++;
        }
        if (hasPositionLivingCell(new Point(cellPosition.x + 1, cellPosition.y))) {
            count++;
        }

        return count;
    }

    private boolean hasPositionLivingCell(Point cellPosition) {
        try {
            Cell checkCell = cellBoard[cellPosition.x][cellPosition.y];
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
        } else if (livingNeighborsCount == 3) {
            return true;
        } else {
            return true;
        }
    }

    public Cell getSalAd(int x, int y) {
        return cellBoard[x][y];
    }

    public void setCellAt(Point point, Cell cell) {
        cellBoard[point.x][point.y] = cell;
    }

    public void markOfDeath() {
        for (int row = 0; row < cellBoard.length; row++) {
            for (int column = 0; column < cellBoard[row].length; column++) {
                // Überprüfen ob Zelle vorhanden
                if (cellBoard[column][row] != null) {
                    // Anzahl der lebenden Nachbarn ermitteln
                    int livingNeighbors = getCountOfLivingNeighborCells(new Point(column, row));
                    // Oracle setzen
                    if (livingNeighbors != 2) {
                        cellBoard[column][row].setOracle(oracleDecision(livingNeighbors));
                    } else {
                        cellBoard[column][row].setOracle(cellBoard[column][row].isAlive());
                    }
                }

            }
        }
    }

    public void naturalSelection() {
        for (int row = 0; row < cellBoard.length; row++) {
            for (int column = 0; column < cellBoard[row].length; column++) {
                // Überprüfen ob Zelle vorhanden
                if (cellBoard[column][row] != null) {
                    // Natural selektieren
                    cellBoard[column][row].setAlive(cellBoard[column][row].getOracle());
                }

            }
        }
    }
}
