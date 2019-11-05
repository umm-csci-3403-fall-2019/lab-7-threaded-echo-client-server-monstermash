package echoserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) {
		try {
			EchoServer server = new EchoServer();
			server.start();
		} catch (IOException ioe) {
			System.out.println("We caught an unexpected exception:");
			System.err.println(ioe);
		}
	}

	private void start() throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT_NUMBER);
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("Made a new friend!");

			EchoServerRunnable echoServerRunnable = new EchoServerRunnable(socket);
			Thread t = new Thread(echoServerRunnable);
			t.start();
		}
	}
}