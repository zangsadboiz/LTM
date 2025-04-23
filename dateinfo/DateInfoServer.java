package dateinfo;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInfoServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(1234);
		while(true) {
			Socket socket = serverSocket.accept();
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
			Scanner inServer = new Scanner(socket.getInputStream());
			
			String s = inServer.nextLine(); 
			Date d = new Date();
			SimpleDateFormat sdfDate = new SimpleDateFormat("dd-MM-yyyy");
			SimpleDateFormat sdfTime = new SimpleDateFormat("hh:mm:ss");
			
			String kq;
			if(s.equalsIgnoreCase("Date")) {
				kq = sdfDate.format(d);
			}else {
				kq = sdfTime.format(d);
			}
			
			outServer.println(kq);
			socket.close();
		}
	}
}
