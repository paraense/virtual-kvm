package org.example;

import javax.swing.*;
import java.net.Socket;

public class KeyBoardKeyPressCapture extends Thread {
    private final Socket socket;
    private final JFrame screenBlock;

    public KeyBoardKeyPressCapture(Socket socket, JFrame screenBlock) {
        this.socket = socket;
        this.screenBlock = screenBlock;
    }

    @Override
    public void run() {
        super.run();
    }
}
