package ptbn;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class PTBNServerThread extends Thread{
	private static ServerSocket serverSocket;
	private static Socket socket;
	
	@Override
	public void run() {
		try {
			PrintWriter outServer = new PrintWriter(socket.getOutputStream(), true);
			Scanner inServer = new Scanner(socket.getInputStream());
			
			String s = inServer.nextLine();
			String cp[] = s.split(" ");
			String kq = "";
			Double a = Double.parseDouble(cp[0]);
			Double b = Double.parseDouble(cp[1]);
			if(cp.length == 2) {
				if(a == 0) {
					if(b==0) {
						kq = "Phương trình vo so nghiem";
					}else{
						kq = "Phuong trinh vo nghiem";
					}
				} else {
					double k = -b/a;
					kq = "Phuong trinh co nghiem: "+k;
				}
			}
			outServer.println(kq);
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		serverSocket = new ServerSocket(4567);
		while(true) {
			socket = serverSocket.accept();
			PTBNServerThread pt = new PTBNServerThread();
			pt.start();
		}
	}
}
