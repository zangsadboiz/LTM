package ptbn;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class PTBNClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",4567);
		
		PrintWriter outClient = new PrintWriter(socket.getOutputStream(), true);
		Scanner inClient = new Scanner(socket.getInputStream());
		
		Scanner inputKB = new Scanner(System.in);
		System.out.println("Nhap gia tri a va b: ");
		String s = inputKB.nextLine();
		outClient.println(s);
		
		String kq = inClient.nextLine();
		System.out.println(kq);
	}
}
