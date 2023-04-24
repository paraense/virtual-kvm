package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    private static final int PORT = 4456;

    public static void main(String[] args) {

        final String ip = JOptionPane
                .showInputDialog("Digite o IP do computador principal")
                .trim();

        try(Socket socket = new Socket(ip, PORT)) {

            Robot robot = new Robot();
            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);

            while (true) {
                String positions = reader.readLine();

                if(positions == null) {
                    continue;
                }

                String[] coordinates = positions.split(";");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                robot.mouseMove(x, y);

                System.out.println("Posição do mouse X: "+ x);
                System.out.println("Posição do mouse y: "+ y);
            }

        } catch (IOException | AWTException e) {
            System.err.println("Ocorreram erros: "+ e.getMessage());
        }
    }
}
