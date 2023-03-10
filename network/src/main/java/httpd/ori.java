package httpd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.file.Files;


public class ori extends Thread {
	private static final String DOCUMENT_ROOT = "./webapp";
	private Socket socket;

	public ori(Socket socket) {
		this.socket = socket;
	}

	//RequestHandler
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream outputStream = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
			consoleLog("connected from " + inetSocketAddress.getAddress().getHostAddress() + ":"
					+ inetSocketAddress.getPort());
			String request = null;
			while (true) {
				String line = br.readLine();

				// 브라우저 연결을 끊으면
				if (line == null) {
					break;
				}
				// SimpleHttpServer는 요청의 헤더만 처리한다.
				if ("".equals(line)) {
					break;
				}
				
				consoleLog(line);
			}
			// 요청 처리
			consoleLog(request);

			String[] tokens = request.split(" ");
			if ("GET".equals(tokens[0])) {
				responseStaticResource(outputStream, tokens[1], tokens[2]);
			} else {
				// methods: POST,PUT,DELETE,HEAD,CONNECT
				// SimpleHttpServer 에서는 무시(400 Bad Request)

				//http 프로토콜로 이거 구현하는거 과제
				response400Error(outputStream, tokens[2]);
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.

//			outputStream.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			outputStream.write( "\r\n".getBytes() );
//			outputStream.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch (Exception ex) {
			consoleLog("error:" + ex);
		} finally {
			// clean-up
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}

			} catch (IOException ex) {
				consoleLog("error:" + ex);
			}
		}
	}

	private void responseStaticResource(OutputStream outputStream, String url, String protocol) throws IOException {
		//default(welcome) file set
		if("/".equals(url)) {
			url="/index.html";
		}
		File file = new File(DOCUMENT_ROOT + url);
		if(!file.exists()) {
			//이거 구현
			response404Error(outputStream,protocol);
			return;
		}
		
		//nio
		byte[] body =Files.readAllBytes(file.toPath());
	String contentType = Files.probeContentType(file.toPath());
		
		// 응답
		outputStream.write((protocol + " 200 OK\r\n").getBytes("UTF-8"));
		outputStream.write(("Content-Type:" + contentType + "; charset=utf-8\r\n").getBytes("UTF-8"));
		outputStream.write("\r\n".getBytes());
		outputStream.write(body);
		
	}

	private void response400Error(OutputStream outputStream, String protocol) {
		// HTTP/1.1 400 Bad Request
		// Content-Type:....
		// \r\n
		// .....
		
	}
	
	private void response404Error(OutputStream outputStream, String protocol) {
		// TODO Auto-generated method stub
		
	}

	public void consoleLog(String message) {
		System.out.println("[RequestHandler#" + getId() + "] " + message);
	}
}
