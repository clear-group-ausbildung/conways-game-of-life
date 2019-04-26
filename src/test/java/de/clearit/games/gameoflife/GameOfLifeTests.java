package de.clearit.games.gameoflife;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameOfLifeTests {

    @Test
    @DisplayName("Spielregel 1 Tests")
    public void spielregel1Test(){
        // Eine tote Zelle mit genau drei lebenden Nachbarn
        // wird in der Folgegeneration neu geboren.

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        cell.setAlive(false);
        matrix[0][0] = cell;
        matrix[0][1] = new CellImpl();
        matrix[1][0] = new CellImpl();
        matrix[1][1] = new CellImpl();

        // Neue Generation



        // Erwartung: Zelle neu geboren


    }

}
