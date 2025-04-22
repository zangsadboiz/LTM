package capitalize;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CapitalizeToolServerThread extends Thread{
	private static ServerSocket serverSocket;
	private static Socket socket;
	
	public void run() {
		try {
			Scanner inServer = new Scanner(socket.getInputStream());
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			
			String s = inServer.nextLine();
			String sS = s.toUpperCase(); 
			outServer.println(sS);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		serverSocket = new ServerSocket(2345); 
		while(true) {
			socket = serverSocket.accept(); 
			CapitalizeToolServerThread cl = new CapitalizeToolServerThread(); 
			cl.start(); 
		}
	}
}
