package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {

	private static String SERVER_IP = "";
	static final int PORT = 5000;
	Socket socket=null;

	public static void main(String[] args) {

		ChatClient chatClient = new ChatClient();
		chatClient.start();

	}

	private void start() {
		String nickname = "";
		PrintWriter printWriter = null;
		try {
			SERVER_IP = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(SERVER_IP, PORT);
			ChatServer.log("connected");

			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			
			Scanner scanner = new Scanner(System.in);
			while (nickname.equals("")) {
				System.out.println("닉네임을 입력해주세요");
				System.out.print("닉네임 >>");
				nickname = scanner.nextLine();
			}

			if (nickname != null) {
				printWriter.println("join:" + nickname);
				printWriter.flush();

				Thread chatClientThread = new ChatClientThread(socket, nickname);
				chatClientThread.start();

				while (true) {
					System.out.print(">>");
					String input = scanner.nextLine();
					printWriter.println(nickname + "1:" + input);
					if ("quit".equals(input) == true) {
						printWriter.println("quit");
						break;
					}
				}
				printWriter.println("끝");
			}
		} catch (IOException ex) {
			System.out.println("서버 접속 끊김" + ex);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("에러");
			}

		}
		System.out.println("서버 종료");
	}
}
