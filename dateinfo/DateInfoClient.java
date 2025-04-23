package dateinfo;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class DateInfoClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost", 1234);
		PrintWriter outClient = new PrintWriter(socket.getOutputStream(), true);
		Scanner inClient = new Scanner(socket.getInputStream());
		
		Scanner inputKB = new Scanner(System.in);
		System.out.println("Nhap cu phap: ");
		String s = inputKB.nextLine();
		outClient.println(s);
		
		String kq = inClient.nextLine();
		System.out.println(kq);
		socket.close();
	}
}
