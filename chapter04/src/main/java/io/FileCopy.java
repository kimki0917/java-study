package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopy {

	public static void main(String[] args) {
		for(String arg : args) {
			System.out.println(arg);
		}
		
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("pic.jpg");
			os = new FileOutputStream("pic.copy.jpg");
			
			int data = -1;
			while((data = is.read())!= -1) {
				os.write(data);	
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not fount:" + e);
			e.printStackTrace();
		}  catch (IOException e) {
			System.out.println("error:" + e);
		}finally {
			if(is !=null) {
			}
		}
		
	}

}
