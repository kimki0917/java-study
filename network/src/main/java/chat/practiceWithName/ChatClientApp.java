package chat.practiceWithName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClientApp {
	private static String SERVER_IP = "";
	static final int PORT = 5000;

	public static void main(String[] args) {
		String name;
		Socket socket = null;
		BufferedReader bufferedReader = null;
		PrintWriter printWriter = null;
		try {

			SERVER_IP = InetAddress.getLocalHost().getHostAddress();
			socket = new Socket(SERVER_IP, PORT);
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

			name = inputname(printWriter, bufferedReader);

			ChatWindow chatWindow = new ChatWindow(name, socket);
			chatWindow.show();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String inputname(PrintWriter printWriter, BufferedReader bufferedReader) {
		Scanner scanner = new Scanner(System.in);
		Boolean isValid = false;
		String name = null;
		while (true) {
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			if(name.isEmpty()) {
				System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
			}else if(!name.isEmpty()) {
				isValid = sendAndCheckName(printWriter,bufferedReader,name);
			}
			if (!name.isEmpty()&isValid) {
				break;
			}
		}
		
		return name;
	}

	private static Boolean sendAndCheckName(PrintWriter printWriter, BufferedReader bufferedReader,String name) {
		Boolean isValid=false;
		printWriter.println("isValid:" + name);
		String msg;
		try {
			msg = bufferedReader.readLine();

			if (msg.split(":")[0].equals("result")) {
				System.out.println("ChatClient.msg" + msg);

				isValid = Boolean.parseBoolean(msg.split(":")[1]);
				System.out.println("ChatClient.check" + isValid);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isValid;
	}
}
//		String name = null;
//		Scanner scanner = new Scanner(System.in);
//

//
//		scanner.close();
//		Socket socket = null;
//		try {
//			
//			SERVER_IP = InetAddress.getLocalHost().getHostAddress();
//			socket = new Socket(SERVER_IP, PORT);
//
//			new ChatWindow(name, socket).show();
//
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//	private static String inputName(Boolean check) {
//		String name = null;
//		Scanner scanner = new Scanner(System.in);
//		while (true) {
//			System.out.println("대화명을 입력하세요.");
//			System.out.print(">>> ");
//			name = scanner.nextLine();
//			if (!name.isEmpty()) {
//				break;
//			}
//			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
//		}
//		return name;
//	}
