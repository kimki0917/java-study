package chat.practiceWithName;

import java.io.IOException;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ChatServer {

	static final int PORT = 5000;

	//private static List<Writer> listWriters = new ArrayList<Writer>();
	private static Map<String, Writer> userList = new HashMap<>();

	public static void main(String[] args) {
		ChatServer.go();
	}
	public static void go() {
		try {
			ServerSocket serverSocket = new ServerSocket();
			String hostAddress = InetAddress.getLocalHost().getHostAddress();

			serverSocket.bind(new InetSocketAddress(hostAddress, PORT));
			log("연결기다림"+ hostAddress + ":"+ PORT);
			
			while(true) {
				Socket socket = serverSocket.accept();
			
			 log("연결됨");
			new ChatServerThread(socket,userList).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
	}
	public static void log(String string) {
		System.out.println(string);
	}

}
