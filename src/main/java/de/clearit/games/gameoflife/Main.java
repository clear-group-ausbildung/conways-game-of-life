package de.clearit.games.gameoflife;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();

        // CellBoard wird erstellt und tote Zellen eingefügt
        gol.init(40, 40);

        // ************************************************************************************************************
        // Endlosschleife
        while (true) {
            System.out.println(gol.toString());

            // markOfDeath und naturalSelection
            gol.markOfDeath();
            gol.naturalSelection();

            // Kurzer sleep timer
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ie) {
                System.out.println("Hier exception und so");
            }

            // ********************************************************************************************************
        }
    }
}
