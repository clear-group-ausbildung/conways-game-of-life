package de.clearit.games.gameoflife;

import javax.swing.*;
import java.awt.*;

public class Gui {
    JFrame jf = new JFrame("test");
    Draw d;
    public static int width, height;

    public void create() {
        jf.setSize(1920, 1080);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
        jf.setResizable(false);

        d = new Draw();
        d.setBounds(0, 0, width, height);
        d.setVisible(true);
        jf.add(d);

        jf.requestFocus();
        jf.setVisible(true);
    }
}
