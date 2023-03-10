package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoRequestHandler extends Thread {

	private Socket socket;

	public EchoRequestHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

	public static final int PORT = 8000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();

			serverSocket.bind(new InetSocketAddress("0.0.0.0", 8000));
			log("starts...[port:" + PORT + "]");

			while (true) {
				Socket socket = serverSocket.accept();
				new EchoRequestHandler(socket).start();

				InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
				String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
				int remotePort = inetRemoteSocketAddress.getPort();
				log("connected by client[" + remoteHostAddress + ":" + remotePort + "]");

				try {
					PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));

					while (true) {
						String data = br.readLine();
						if (data == null) {
							log("closed by client");
							break;
						}

						log("received:" + data);
						pw.println(data);
					}
				} catch (IOException ex) {
					log("error:" + ex);
				} finally {
					try {
						if (socket != null && !socket.isClosed()) {
							socket.close();
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			}
		} catch (IOException e) {
			log("error:" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed()) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void log(String message) {
		System.out.println("[EchoServer#"+ Thread.currentThread().getId()+"] " + message);
		
	}

}
