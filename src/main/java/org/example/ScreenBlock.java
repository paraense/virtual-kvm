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
        setContentPane(new InvisiblePanel(color, title));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

class InvisiblePanel extends Panel {
    private static final Font FONT = new Font("Arial", Font.PLAIN, 180);

    InvisiblePanel(Color color, String title){
        JLabel label = new JLabel(title);
        label.setFont(FONT);
        label.setBackground(color);
        label.setEnabled(false);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label, BorderLayout.CENTER);
    }


}
