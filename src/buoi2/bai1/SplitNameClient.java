package buoi2.bai1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class SplitNameClient {
	
	private final static int PORT = 69;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", PORT);
		InputStream inputStream = socket.getInputStream();
		OutputStream outputStream = socket.getOutputStream();
		Scanner sc = new Scanner(System.in);

		while(true) {
			//Input full name
			System.out.print("Nhap vao ho ten: ");
			String fullNameString = sc.nextLine();
			outputStream.write(fullNameString.getBytes());
			
			//Receive last name from server
			byte b[] = new byte[1024];
			inputStream.read(b);
			String lastName = new String(b);
			System.out.println("Ten: " + lastName.trim());
		}
	}

}
