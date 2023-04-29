package br.com.virtualKvm.server.mouse;

import br.com.virtualKvm.server.Capture;
import br.com.virtualKvm.server.ScreenBlock;

import java.awt.*;
import java.net.Socket;

public class MouseCoordinateCapture extends Capture {
    private ScreenBlock screenBlock;

    public MouseCoordinateCapture(Socket socket, ScreenBlock screenBlock) {
        super(socket);
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

                String mousePositions = "MOUSE_MOVE :"+ x + ";" + y + "\n";
                send(mousePositions);

                Thread.sleep(2);

            } catch (InterruptedException e) {
                System.err.println("Ocorreram erros na caputad dos movimentos do mouse");
            }
        }
    }
}
