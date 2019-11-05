package echoserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClientRunnable implements Runnable {

    Socket socket;

    EchoClientRunnable(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            OutputStream output = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            int b;
            int response;
            while ((b = System.in.read()) != -1) {
                output.write(b);
                output.flush();
                response = input.read();
                System.out.write(response);
            }
            System.out.flush();

            output.flush();
            output.close();
            input.close();

        } catch (Exception e) {
            System.out.println("We caught an unexpected exception");
            System.err.println(e);
        }
    }
}