package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatServerThread extends Thread {

	private String nickname;
	private Socket socket;
	private List<Writer> listWriters;
	PrintWriter printWriter;

	public ChatServerThread(Socket socket, List<Writer> listWriters) throws IOException {
		this.socket = socket;
		this.listWriters = listWriters;
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
				} else {
					doMessage(request);
				}
			}
		} catch (IOException e) {
			ChatServer.log("에러: 알수 없는 요청 IOException");
		}
	}

	private void doJoin(String nickName, Writer writer) {
		this.nickname = nickName;

		String data = nickName + "님이 참여하셨습니다.";
		broadcast(data);
		addWriter(writer);
		printWriter.flush();

	}

	private void addWriter(Writer writer) {
		synchronized (listWriters) {
			listWriters.add(writer);
		}
	}

	private void broadcast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
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

		listWriters.remove(writer2);

	}

}
