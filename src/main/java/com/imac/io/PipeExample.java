package com.imac.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * Created by ab054857 on 2017/9/6.
 */
public class PipeExample {

	public static void main(String[] args) throws Exception{
		final PipedOutputStream outputStream = new PipedOutputStream();
		final PipedInputStream inputStream = new PipedInputStream(outputStream);

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					outputStream.write("hello world, pipe!".getBytes());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						outputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				StringBuilder stringBuilder = new StringBuilder();
				try {
					stringBuilder.append("data:");
					int data = inputStream.read();
					while (data != -1) {
						stringBuilder.append((char)data);
						data = inputStream.read();
					}

					System.out.println(stringBuilder.toString());
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						inputStream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});

		t1.start();
		t2.start();

//		t2.join();

		TimeUnit.SECONDS.sleep(2);
	}
}
