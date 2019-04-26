package de.clearit.games.gameoflife;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

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
        Cell cell2 = new CellImpl();
        cell2.setAlive(false);

        gameOfLife.setCellAt(new Point(0,0), cell);
        gameOfLife.setCellAt(new Point(0,1), new CellImpl());
        gameOfLife.setCellAt(new Point(1,0), new CellImpl());
        gameOfLife.setCellAt(new Point(1,1), new CellImpl());

//        System.out.println(cell.isAlive());
//        System.out.println(gameOfLife.getSalAd(0,1).isAlive());
//        System.out.println(cell2.isAlive());
//
//        System.out.println(gameOfLife.getSalAd(1,0).isAlive());
//        System.out.println(gameOfLife.getSalAd(1,1).isAlive());

        gameOfLife.markOfDeath();

        // Neue Generation
        gameOfLife.naturalSelection();

        // Erwartung: Zelle neu geboren
        Assertions.assertTrue(cell.isAlive());



    }

    @Test
    @DisplayName("Spielregel 1 Tests 2")
    public void spielregel1TestFehler(){
        // Eine tote Zelle mit genau zwei lebenden und einem toten Nachbarn
        // wird in der Folgegeneration NICHT neu geboren.
        // Lebende Zellen sterben wegen Einsamkeit.

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        cell.setAlive(false);
        Cell cell2 = new CellImpl();
        cell2.setAlive(false);

        gameOfLife.setCellAt(new Point(0,0), cell);
        gameOfLife.setCellAt(new Point(0,1), new CellImpl());
        gameOfLife.setCellAt(new Point(1,0), new CellImpl());
        gameOfLife.setCellAt(new Point(1,1), new CellImpl());

        System.out.println(cell.isAlive());
        System.out.println(gameOfLife.getSalAd(0,1).isAlive());
        System.out.println(cell2.isAlive());

        System.out.println(gameOfLife.getSalAd(1,0).isAlive());
        System.out.println(gameOfLife.getSalAd(1,1).isAlive());

        gameOfLife.markOfDeath();

        // Neue Generation
        gameOfLife.naturalSelection();


        System.out.println(cell.isAlive());
        System.out.println(gameOfLife.getSalAd(0,1).isAlive());
        System.out.println(cell2.isAlive());

        System.out.println(gameOfLife.getSalAd(1,0).isAlive());
        System.out.println(gameOfLife.getSalAd(1,1).isAlive());


        // Erwartung: Zelle neu geboren
        Assertions.assertFalse(cell.isAlive());



    }

}
