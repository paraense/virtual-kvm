package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final int PORT = 4456;
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();

    public static void main(String[] args) {

       try (final ServerSocket server = new ServerSocket(PORT)){
           Socket socket = server.accept();

           System.out.println("Conexão recebida de: "+ socket.getInetAddress());
           String title = JOptionPane.showInputDialog("Novo dispositivo detectado! Como deseja chama-lo?");

           JFrame screenBlock = new ScreenBlock(title, SCREEN_SIZE.width, SCREEN_SIZE.height);

           MouseCoordinateCapture mouseCoordinateCapture = new MouseCoordinateCapture(socket, screenBlock);
           MouseClickCapture mouseClickCapture  = new MouseClickCapture(socket, screenBlock);
           KeyBoardKeyPressCapture keyBoardCap = new KeyBoardKeyPressCapture(socket, screenBlock);

           mouseCoordinateCapture.start();
           mouseClickCapture.start();
           keyBoardCap.start();

       }catch (IOException e) {
           System.err.println("Ocorreram erros na conexão com o cliente");
       }

    }
}