package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MouseCoordinateCapture extends Thread {

    private Socket socket;
    private JFrame screenBlock;

    public MouseCoordinateCapture(Socket socket, JFrame screenBlock) {
        this.socket = socket;
        this.screenBlock = screenBlock;
    }

    @Override
    public void run() {
        while (true) {

            if (!screenBlock.isActive()) {
                continue;
            }
            try {
                int x = MouseInfo.getPointerInfo().getLocation().x;
                int y = MouseInfo.getPointerInfo().getLocation().y;

                String mousePositions = x + ";" + y + "\n";

                synchronized (socket.getOutputStream()) {
                    OutputStream out = socket.getOutputStream();
                    out.write(mousePositions.getBytes());
                    out.flush();
                }

                Thread.sleep(2);

            } catch (IOException | InterruptedException e) {
                System.err.println("Ocorreram erros na caputad dos movimentos do mouse");
            }
        }
    }
}
