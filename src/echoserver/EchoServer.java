package echoserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) throws IOException {
		EchoServer server = new EchoServer();
		server.start();
	}

	private void start() throws IOException {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("Made a new friend!");

				// Put your code here.
				EchoServerRunnable echoServerRunnable = new EchoServerRunnable(socket);
				Thread t = new Thread(echoServerRunnable);
				t.start();
			}
		} catch (IOException ioe) {
			System.out.println("We caught an unexpected exception");
			System.err.println(ioe);
		}
	}
}