package buoi2.bai1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


public class Request extends Thread{
	
	private Socket socket;

	public Request(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			
			while(true) {
				byte[] b = new byte[1024];
				inputStream.read(b);
				String fullName = new String(b);
				System.out.println("Server receive " + fullName.trim());
				String lastName = fullName.trim().substring(fullName.lastIndexOf(" ") + 1);
				outputStream.write(lastName.getBytes());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
