package com.imac.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by ab054857 on 2017/9/6.
 */
public class OutStream {

	public static void main(String[] args) throws Exception{
//		wirteByteToFile();
//		readFromFile();
		readFromFileNio();
	}

	public static void wirteByteToFile() throws Exception {
		String str = "hello world";

		byte[] bytes = str.getBytes();
		File file = new File("E:/io/test.txt");

//		if (!file.exists()) {
//			file.mkdir();
//		}
		OutputStream outputStream = new FileOutputStream(file);
		outputStream.write(bytes);
		outputStream.close();

	}

	public static void readFromFile() throws Exception{
		File file = new File("E:/io/test.txt");

		byte[] bytes = new byte[(int) file.length()];
		InputStream inputStream = new FileInputStream(file);

		int size = inputStream.read(bytes);

		System.out.printf("大小：" + size + "内容：" + new String(bytes));

		inputStream.close();
	}

	public static void readFromFileNio() throws Exception{
		File file = new File("E:/io/test.txt");

		FileInputStream inputStream = new FileInputStream(file);
		FileChannel fileChannel = inputStream.getChannel();

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

		int size = fileChannel.read(byteBuffer);

		System.out.printf("大小：" + size + "内容：" + new String(byteBuffer.array()));

		inputStream.close();
	}

}
