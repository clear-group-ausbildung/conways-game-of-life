package de.clearit.games.gameoflife;

import java.awt.*;

public class GameOfLife {
    private Cell[][] cellBoard;

    public void init(int x, int y) {
        cellBoard = new Cell[x][y];
        Draw.anzahlX = x;
        Draw.anzahlY = y;
        Gui.width = x * Draw.rectangleSize;
        Gui.height = y * Draw.rectangleSize;
        Gui g = new Gui();
        g.create();

        // In jedes Feld/ in jeden Index eine tote Zelle setzen
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; i < y; i++) {
//                cellBoard[i][j] = new CellImpl();
//            }
//        }
    }

    // Anzahl der lebenden Zellen um die betrachtete Zelle; benötigt für die Entscheidung ob sie lebt oder stirbt
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

    // Überprüft ob der benachbarte betrachtete Punkt eine lebende Zelle ist, da nur diese Relevanz haben
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

    // Gibt an ob Zelle stirbt oder lebt im nächsten Zyklus
    public boolean oracleDecision(int livingNeighborsCount) {
        if (livingNeighborsCount < 2 || livingNeighborsCount > 3) {
            return false;
        } else if (livingNeighborsCount == 3) {
            return true;
        } else {
            return true;
        }
    }

    // Gibt die Zelle an den eingegebenen Koordinaten im Zell-Grid zurück
    public Cell getSalAd(int x, int y) {
        return cellBoard[x][y];
    }

    // Setzt eine übergebene Zelle an eine übergebene Koordinate im Zell-Grid
    public void setCellAt(Point point, Cell cell) {
        cellBoard[point.x][point.y] = cell;
    }

    // Markiert die Zellen wie sie sich im nächsten Zyklus verändern werden
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

    // Setzt den Zustand der Zelle auf den durch markOfDeath vorausgesagten Zustand
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

    public int breiteSpielfeld() {
        return cellBoard.length;
    }

    public int höheSpielfeld(int b) {
        return cellBoard[b].length;
    }
}
