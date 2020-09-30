package buoi2.bai1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SplitNameServer {
	private final static int PORT = 69;
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server is ready...");
		while(true) {			
			Socket socket = serverSocket.accept();
			
			Request request = new Request(socket);
			request.start();
		}
	}

}
