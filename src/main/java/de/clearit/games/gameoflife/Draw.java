package de.clearit.games.gameoflife;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel {

    static int rectangleSize = 25;
    Point p;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        // Draw Background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Gui.width, Gui.height);

        //Draw Grid
        g.setColor(Color.GREEN);
        for (int i = 0; i < Gui.width; i++) {
            for (int j = 0; j < Gui.height; j++) {
                g.drawRect(i * rectangleSize, j * rectangleSize, rectangleSize, rectangleSize);
            }
        }


        //Draw Cell

        for (int i = 0; i <; i++) {
            for (int j = 0; j < Gui.height; j++) {
                g.drawRect(i * rectangleSize, j * rectangleSize, rectangleSize, rectangleSize);
            }
        }

        g.setColor(new Color(0, 153, 0));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g.fillRect(p.x, p.y, rectangleSize, rectangleSize);

        //Draw Border
        g.setColor(Color.RED);
        g.drawRect(0, 0, Gui.width, Gui.height);

        repaint();
    }

    public void printCell() {

    }
}
