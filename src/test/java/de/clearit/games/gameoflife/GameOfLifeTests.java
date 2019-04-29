package de.clearit.games.gameoflife;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class GameOfLifeTests {

    @Test
    @DisplayName("Spielregel 1, Test: Positiv")
    public void spielregel1TestPositiv() {
        // Eine tote Zelle mit genau drei lebenden Nachbarn
        // wird in der Folgegeneration neu geboren.

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        cell.setAlive(false);
        Cell cell2 = new CellImpl();
        cell2.setAlive(false);

        gameOfLife.setCellAt(new Point(0, 0), cell);
        gameOfLife.setCellAt(new Point(0, 1), new CellImpl());
        gameOfLife.setCellAt(new Point(1, 0), new CellImpl());
        gameOfLife.setCellAt(new Point(1, 1), new CellImpl());

        gameOfLife.markOfDeath();

        // Neue Generation
        gameOfLife.naturalSelection();

        // Erwartung: Zelle neu geboren
        Assertions.assertTrue(cell.isAlive());


    }

    @Test
    @DisplayName("Spielregel 1, Test: Negativ")
    public void spielregel1TestNegativ() {
        /* Eine tote Zelle mit genau zwei lebenden und einem toten Nachbarn
           wird in der Folgegeneration NICHT neu geboren.
           Lebende Zellen sterben wegen Einsamkeit. */

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        cell.setAlive(false);
        Cell cell2 = new CellImpl();
        cell2.setAlive(false);

        gameOfLife.setCellAt(new Point(0, 0), cell);
        gameOfLife.setCellAt(new Point(0, 1), cell2);
        gameOfLife.setCellAt(new Point(1, 0), new CellImpl());
        gameOfLife.setCellAt(new Point(1, 1), new CellImpl());

        // Zellen vor der Selektion
        System.out.print("Before:\t\t\t\t\t");
        System.out.print(cell.isAlive() + " ");                         //f
        System.out.print(gameOfLife.getSalAd(0, 0).isAlive() + " ");    //f
        System.out.print(cell2.isAlive() + " ");                        //f
        System.out.print(gameOfLife.getSalAd(0, 1).isAlive() + " ");    //f
        System.out.print(gameOfLife.getSalAd(1, 0).isAlive() + " ");    //t
        System.out.println(gameOfLife.getSalAd(1, 1).isAlive());        //t

        // Todesmarke setzen
        gameOfLife.markOfDeath();

        System.out.print("Mark of death:\t\t\t");
        System.out.print(cell.getOracle() + " ");                       //f
        System.out.print(gameOfLife.getSalAd(0, 0).getOracle() + " ");  //f
        System.out.print(cell2.getOracle() + " ");                      //f
        System.out.print(gameOfLife.getSalAd(0, 1).getOracle() + " ");  //f
        System.out.print(gameOfLife.getSalAd(1, 0).getOracle() + " ");  //f
        System.out.println(gameOfLife.getSalAd(1, 1).getOracle());      //f


        // Neue Generation
        gameOfLife.naturalSelection();

        System.out.print("Natural Selection:\t\t" );
        System.out.print(cell.isAlive() + " ");                         //f
        System.out.print(gameOfLife.getSalAd(0, 0).isAlive() + " ");    //f
        System.out.print(cell2.isAlive() + " ");                        //f
        System.out.print(gameOfLife.getSalAd(0, 1).isAlive() + " ");    //f
        System.out.print(gameOfLife.getSalAd(1, 0).isAlive() + " ");    //f
        System.out.print(gameOfLife.getSalAd(1, 1).isAlive() + " ");    //f


        // Erwartung: Zelle neu geboren
        Assertions.assertFalse(cell.isAlive());


    }

    @Test
    @DisplayName("Spielregel 2, Test: Positiv")
    public void spielregel2TestPositiv() {

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        Cell cell2 = new CellImpl();

        gameOfLife.setCellAt(new Point(0, 0), cell);
        gameOfLife.setCellAt(new Point(0, 1), cell2);

        gameOfLife.markOfDeath();

        gameOfLife.naturalSelection();

        System.out.print(cell.isAlive() + " ");    //f
        System.out.print(cell2.isAlive() + " ");    //f

        Assertions.assertFalse(cell.isAlive());


    }

    @Test
    @DisplayName("Spielregel 3, Test: Positiv")
    public void spielregel3TestPositiv() {

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        Cell cell2 = new CellImpl();
        Cell cell3 = new CellImpl();
        Cell cell4 = new CellImpl();

        gameOfLife.setCellAt(new Point(0, 0), cell);
        gameOfLife.setCellAt(new Point(0, 1), cell2);
         gameOfLife.setCellAt(new Point(1, 0), cell3);

        gameOfLife.markOfDeath();

        gameOfLife.naturalSelection();

        System.out.print(cell.isAlive() + " ");
        System.out.print(cell2.isAlive() + " ");
        System.out.print(cell3.isAlive() + " ");
        System.out.print(cell4.isAlive() + " ");

        Assertions.assertTrue(cell.isAlive());
    }
}
