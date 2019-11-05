package echoserver;

import java.io.IOException;
import java.net.Socket;
import java.net.ConnectException;

public class EchoClient {
	public static final int PORT_NUMBER = 6013;

	public static void main(String[] args) {
		try {
			EchoClient client = new EchoClient();
			client.start();
		} catch (ConnectException ce) {
			System.out.println("We were unable to connect to localhost");
			System.out.println("You should make sure that the server is running.");
		} catch (IOException ioe) {
			System.out.println("We caught an unexpected exception");
			System.err.println(ioe);
		}
	}

	private void start() throws IOException {
			Socket socket = new Socket("localhost", PORT_NUMBER);
			EchoClientRunnable echoClientRunnable = new EchoClientRunnable(socket);
			Thread t = new Thread(echoClientRunnable);
			t.start();
	}
}