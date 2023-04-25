package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenBlock extends JFrame {

    private static final Color color =  new Color(0, 0, 0, 150);
    private static final BufferedImage arrow = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
    private static final Cursor hideCursor = Toolkit.getDefaultToolkit().createCustomCursor(arrow, new java.awt.Point(0, 0), "hideCursor");

    public ScreenBlock(String title, int width, int height) {
        super(title);
        Panel panel = new InvisiblePanel(color, title);
        setLayout(new FlowLayout());
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setBackground(color);
        setCursor(hideCursor);
        setContentPane(panel);
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
