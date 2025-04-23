package simple;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleMathToolServerThread extends Thread{
	private static ServerSocket serverSocket;
	private static Socket socket;
	
	public void run() {
		try {
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			Scanner inServer = new Scanner(socket.getInputStream());
			
			String s = inServer.nextLine();
			String cp[] = s.split(" ");
			String kq = tinhToan(cp[0], cp[1], cp[2]);
			outServer.println(kq);
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String tinhToan(String cp, String aS, String bS) {
		String kq = "";
		int a = Integer.parseInt(aS);
		int b = Integer.parseInt(bS);
		if(cp.equalsIgnoreCase("SUM")) {
			kq += (a-b);
		}else {
			kq += (a*b);
		}
		return kq;
	}
	
	public static void main(String[] args) throws Exception {
		serverSocket = new ServerSocket(1111);
		while(true) {
			socket = serverSocket.accept();
			SimpleMathToolServerThread sm = new SimpleMathToolServerThread();
			sm.start();
		}
	}
}
