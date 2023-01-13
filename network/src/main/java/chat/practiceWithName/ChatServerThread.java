package chat.practiceWithName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private Map<String, Writer> userList;
	PrintWriter printWriter;

	public ChatServerThread(Socket socket, Map<String, Writer> listFromServer) throws IOException {
		this.socket = socket;
		this.userList = listFromServer;
	}

	@Override
	public void run() {

		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8),
					true);

			while (true) {
				String request = bufferedReader.readLine();
				System.out.println(request);
				if (request == null) {
					doQuit(printWriter);
					break;
				}

				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], printWriter);
				} else if ("quit".equals(tokens[0])) {
					printWriter.println("quit");
				} else if("isValid".equals(tokens[0])){
					doCheck(tokens[1]);
				} else {
					doMessage(request);
				}
			}
		} catch (IOException e) {
			ChatServer.log("에러: 알수 없는 요청 IOException");
		}
	}

	private void doCheck(String string) {
		Boolean result =(userList.containsKey(string) ? false : true);
		printWriter.println("result:"+result);
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하셨습니다.";
		broadcast(data);
		addWriter(nickName,writer);
		printWriter.flush();

	}

	private void addWriter(String nickName,Writer writer) {
		synchronized (userList) {
			userList.put(nickName,writer);
		}
	}

	private void broadcast(String data) {
		synchronized (userList) {
			for (Writer writer : userList.values()) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}

	private void doMessage(String string) {
		broadcast(string);
	}

	private void doQuit(Writer writer) {
		String data = nickname + "님이 퇴장 하였습니다.";
		broadcast(data);
		removeWriter(writer);		
	}

	private void removeWriter(Writer writer2) {
		userList.remove(nickname);

	}

}
