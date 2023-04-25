package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
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

           OutputStream out = socket.getOutputStream();

           while (true) {

               if(!screenBlock.isActive()) {
                   continue;
               }

               int x = MouseInfo.getPointerInfo().getLocation().x;
               int y = MouseInfo.getPointerInfo().getLocation().y;

               String mousePositions = x+";"+y+"\n";
               out.write(mousePositions.getBytes());
               out.flush();

               Thread.sleep(2);
           }

       } catch (IOException e) {
           System.err.println("Erro de conexão: "+ e.getMessage());

       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

    }
}