package dateinfo;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateInfoServerThread extends Thread{
	private static ServerSocket serverSocket;
	private static Socket socket;
	
	public void run() {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception{
		serverSocket = new ServerSocket(1234);
		while(true) {
			socket = serverSocket.accept();
			DateInfoServerThread dt = new DateInfoServerThread();
			dt.start();
		}
	}
}
