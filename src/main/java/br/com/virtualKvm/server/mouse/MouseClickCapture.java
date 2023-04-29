package br.com.virtualKvm.server.mouse;

import br.com.virtualKvm.server.Capture;
import br.com.virtualKvm.server.ScreenBlock;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.Socket;

public class MouseClickCapture extends Capture implements MouseListener {

    private final ScreenBlock screenBlock;

    public MouseClickCapture(Socket socket, ScreenBlock screenBlock) {
        super(socket);
        this.screenBlock = screenBlock;
        this.screenBlock.getPanel().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!screenBlock.isActive()) {
            return;
        }
        String message = "MOUSE_CLICK: " + e.getButton() + "\n";
        send(message);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
