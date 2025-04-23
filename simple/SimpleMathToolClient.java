package simple;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleMathToolClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",1111);
		
		PrintWriter outClient = new PrintWriter(socket.getOutputStream(),true);
		Scanner inClient = new Scanner(socket.getInputStream());
		
		Scanner inputKB = new Scanner(System.in);
		System.out.println("Nhap cu phap (Sum a b) / (Mul a b): ");
		String s = inputKB.nextLine();
		outClient.println(s);
		
		String kq = inClient.nextLine();
		System.out.println(kq);
		socket.close();
	}
}
