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
        cell.setAlive(true);
        Cell cell2 = new CellImpl();
        cell2.setAlive(true);
        Cell cell3 = new CellImpl();
        cell3.setAlive(true);


        gameOfLife.setCellAt(new Point(0, 0), new CellImpl());
        gameOfLife.setCellAt(new Point(0, 1), cell);
        gameOfLife.setCellAt(new Point(1, 0), cell2);
        gameOfLife.setCellAt(new Point(1, 1), cell3);

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
        cell.setAlive(true);
        Cell cell2 = new CellImpl();
        cell2.setAlive(true);

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
        System.out.print(cell.isAlive() + " ");                               //f
        System.out.print(gameOfLife.getSalAd(0, 0).isAlive() + " ");    //f
        System.out.print(cell2.isAlive() + " ");                              //f
        System.out.print(gameOfLife.getSalAd(0, 1).isAlive() + " ");    //f
        System.out.print(gameOfLife.getSalAd(1, 0).isAlive() + " ");    //f
        System.out.print(gameOfLife.getSalAd(1, 1).isAlive() + " ");    //f


        // Erwartung: Zelle stirbt
        Assertions.assertFalse(cell.isAlive());


    }

    @Test
    @DisplayName("Spielregel 2, Test: Positiv")
    public void spielregel2TestPositiv() {

        // Wenn eine Zelle nur einen oder weniger lebende Nachbarn hat stirbt sie in der Folgegeneration an Einsamkeit

        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        // Nur 2 lebende Zellen nebeneinander

        gameOfLife.setCellAt(new Point(0, 0), new CellImpl());
        gameOfLife.setCellAt(new Point(0, 1), new CellImpl());

        // Todesmarke setzen
        gameOfLife.markOfDeath();

        // Neue Generation
        gameOfLife.naturalSelection();

        System.out.print(gameOfLife.getSalAd(0, 0).isAlive() + " ");    //f
        System.out.print(gameOfLife.getSalAd(0, 1).isAlive() + " ");    //f

        // Zelle stirbt
        Assertions.assertFalse(gameOfLife.getSalAd(0, 0).isAlive());


    }

    @Test
    @DisplayName("Spielregel 3, Test: Positiv")
    public void spielregel3TestPositiv() {

        // Lebende Zelle mit 2 oder 3 lebenden Nachbarn bleibt in der Folgegeneration am Leben

        // 4 lebende Zellen die miteinander benachbart sind
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.init(100, 100);

        Cell cell = new CellImpl();
        cell.setAlive(true);
        Cell cell2 = new CellImpl();
        cell2.setAlive(true);
        Cell cell3 = new CellImpl();
        cell3.setAlive(true);
        Cell cell4 = new CellImpl();
        cell4.setAlive(true);

        gameOfLife.setCellAt(new Point(0, 0), cell);
        gameOfLife.setCellAt(new Point(0, 1), cell2);
         gameOfLife.setCellAt(new Point(1, 0), cell3);

         // Todesmarke setzen
        gameOfLife.markOfDeath();

        // Nächste Generation
        gameOfLife.naturalSelection();

        System.out.print(cell.isAlive() + " ");
        System.out.print(cell2.isAlive() + " ");
        System.out.print(cell3.isAlive() + " ");
        System.out.print(cell4.isAlive() + " ");

        // Zelle überlebt
        Assertions.assertTrue(cell.isAlive());
    }
}
