package capitalize;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeToolClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("localhost",2345);
		//nhan dl tu server gui sang
		Scanner inClient = new Scanner(socket.getInputStream());
		//Gui dl tu client sang server, true de luon gui dl
		PrintWriter outClient = new PrintWriter(socket.getOutputStream(),true);
		Scanner inputKB = new Scanner(System.in); //nhap dl tu ban phim
		System.out.println("Nhap cu phap: ");
		String s = inputKB.nextLine(); //doc du lieu vua nhap
		outClient.println(s); //gui dl vua nhap sang server
		
		String kq = inClient.nextLine(); //nhan/doc ket qua tu server
		System.out.println(kq);
		socket.close();
		
	}
}
