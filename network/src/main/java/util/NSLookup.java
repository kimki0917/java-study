package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			String scn = s.next();
			if (scn.equals("exit")) {
				break;
			}
			InetAddress[] aArr = null;
			try {
				aArr = InetAddress.getAllByName(scn);
				for (InetAddress IpAddress : aArr) {
					System.out.print(IpAddress);
					System.out.println();
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
	}

}
