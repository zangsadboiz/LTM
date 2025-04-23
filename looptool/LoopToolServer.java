package looptool;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class LoopToolServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(7896);
		while(true) {
			Socket socket = serverSocket.accept();
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
			Scanner inServer = new Scanner(socket.getInputStream());
			
			String s = inServer.nextLine();
			String cp[] = s.split(" ");
			int n = Integer.parseInt(cp[1]);
			int kq = 0;
			if(cp[0].equalsIgnoreCase("SUM")) {
				for(int i =0; i<=n; i++) {
					kq += i;
				}
			}else {
				kq = 1;
				for(int i = 1; i<=n; i++) {
					kq *= i;
				}
			}
			
			outServer.println(kq);
			socket.close();
		}
	}
}
