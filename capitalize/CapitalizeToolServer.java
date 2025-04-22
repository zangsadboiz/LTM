package capitalize;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeToolServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(2345);
		while(true) {
			Socket socket = serverSocket.accept();
			//nhan dl tu client gui sang
			Scanner inServer = new Scanner(socket.getInputStream());
			//Gui dl tu server sang client, true de luon gui dl
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			
			String s = inServer.nextLine();
			String sS = s.toUpperCase(); //chuyen chu thuong sang chu hoa
			outServer.println(sS);
			socket.close();
		}
	}
}
