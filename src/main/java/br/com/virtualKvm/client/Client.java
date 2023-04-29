package br.com.virtualKvm.client;

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
                String message = reader.readLine();

                if(message == null) {
                    continue;
                }

                Events event = Events.findByStringMessage(message);
                event.apply(message, robot);
            }

        } catch (IOException | AWTException e) {
            System.err.println("Ocorreram erros: "+ e.getMessage());
        }
    }

}
