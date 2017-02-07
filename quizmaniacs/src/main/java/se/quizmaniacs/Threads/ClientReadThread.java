package se.quizmaniacs.Threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by LeoAsp on 2017-01-25.
 */

public class ClientReadThread implements Runnable {
    Socket socket;
    Scanner in;
    private boolean running = true;


    public ClientReadThread(Socket socket) throws IOException {
        this.socket = socket;
        in = new Scanner(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        String incomingMessage;
        while (running) {
            while (in.hasNext()) {
                incomingMessage = in.nextLine();
                System.out.println(socket.getPort() + ": " + incomingMessage);

            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}
