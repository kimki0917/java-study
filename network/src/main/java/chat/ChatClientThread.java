package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientThread extends Thread {

	Socket socket;
	private String nickname=null;
	
	public ChatClientThread(Socket socket, String nickname) {
	this.socket=socket;
	this.nickname=nickname;
	}

	@Override
	public void run() {
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			
			while(true) {
				String msg = bufferedReader.readLine();
				System.out.println(msg);
				
			}
		} catch(SocketException e) {
			System.out.println("asdf");
		}catch (IOException e) {
		}finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
