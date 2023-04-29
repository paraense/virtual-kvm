package br.com.virtualKvm.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Capture extends Thread {
    private static Socket socket;

    public Capture(Socket socket) {
        Capture.socket = socket;
    }

    public static synchronized void send(String message) {
      try {
          OutputStream out = socket.getOutputStream();
          out.write(message.getBytes());
          out.flush();

      } catch (IOException e) {
          System.err.println("Erro ao enviar mensagem para socket");
      }
    }
}
