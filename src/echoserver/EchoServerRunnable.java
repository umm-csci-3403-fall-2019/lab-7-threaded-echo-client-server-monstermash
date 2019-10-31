package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerRunnable implements Runnable {

    Socket socket;

    EchoServerRunnable(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            int b;
            while ((b = input.read()) != -1) {
                output.write(b);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
            System.out.println("We caught an unexpected exception");
            System.err.println(e);
        }
    }
}