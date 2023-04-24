package org.example;

import javax.swing.*;
import java.awt.*;

public class ScreenBlock extends JFrame {

    private static final Color color =  new Color(0, 0, 0, 150);

    public ScreenBlock(String title, int width, int height) {
        super(title);
        setLayout(new FlowLayout());
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(color);
        setSize(width, height);
        setContentPane(new InvisiblePanel(color));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class InvisiblePanel extends Panel {

    InvisiblePanel(Color color){
        setBackground(color);
    }


}
