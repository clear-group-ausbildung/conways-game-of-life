package de.clearit.games.gameoflife;

import javax.swing.*;
import java.awt.*;

public class Gui {
    JFrame jf = new JFrame("test");
    Draw d;
    public static int width, height;

    public void create() {
        d = new Draw();
        d.setBounds(0, 0, width, height);
        jf.setSize(d.getWidth() + 20 , d.getHeight());
//        jf.setMinimumSize(new Dimension(width, height));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(true);

        d.setVisible(true);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);
    }
}
