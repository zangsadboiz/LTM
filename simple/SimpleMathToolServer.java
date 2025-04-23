package simple;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SimpleMathToolServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(1111);
		while(true) {
			Socket socket = serverSocket.accept();
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(),true);
			Scanner inServer = new Scanner(socket.getInputStream());
			
			String s = inServer.nextLine();
			String cp[] = s.split(" ");
			String kq = tinhToan(cp[0], cp[1], cp[2]);
			outServer.println(kq);
			socket.close();
		}
	}
	
	public static String tinhToan(String cp, String aS, String bS) {
		String kq = "";
		int a = Integer.parseInt(aS);
		int b = Integer.parseInt(bS);
		if(cp.equalsIgnoreCase("SUM")) {
			kq += (a+b);
		}else {
			kq += (a*b);
		}
		return kq;
	}
}
