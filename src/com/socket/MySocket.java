package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @moudle: MySocket 
 * @version:v1.0
 * @Description: 使用多线程测试套接字
 * @author: xukai
 * @date: 2017年5月13日 上午12:24:49
 *
 */ 
public class MySocket {

	private static final int SERVER_PORT = 9081;
	private static final String HOST = "localhost";
	
	public static void main(String[] args) {
		new MySocket();
	}
	
	public MySocket() {
		new Thread(new ServerThread()).start();
		new Thread(new ClientThread()).start();
	}
	
	/**
	 * 
	 * @moudle: ServerThread 
	 * @version:v1.0
	 * @Description: 接受请求，作出响应
	 * @author: xukai
	 * @date: 2017年5月13日 上午12:28:13
	 *
	 */
	class ServerThread implements Runnable {
		DataInputStream dis;
		DataOutputStream dos;
		ServerSocket server;
		Socket socket;
		
		@Override
		public void run() {
			try {
				server = new ServerSocket(SERVER_PORT);
				socket = server.accept();
				dis = new DataInputStream(socket.getInputStream());
				dos = new DataOutputStream(socket.getOutputStream());
				while(true) {
					socket.setKeepAlive(true);
					double r = dis.readDouble();
					System.out.println("Server get: r=" + r);
					double area = Math.PI * r * r;
					System.out.println("Server send: area=" + area);
					dos.writeDouble(area);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * @moudle: ClientThread 
	 * @version:v1.0
	 * @Description: 发出请求，接受响应
	 * @author: xukai
	 * @date: 2017年5月13日 上午12:28:02
	 *
	 */ 
	class ClientThread implements Runnable {

		DataInputStream dis;
		DataOutputStream dos;
		Socket socket;
		
		@Override
		public void run() {
			try {
				socket = new Socket(HOST, SERVER_PORT);
				socket.setKeepAlive(true);
				double r = 1.0;
				dos = new DataOutputStream(socket.getOutputStream());
				dis = new DataInputStream(socket.getInputStream());
				while (true) {
					System.out.println("Client send: r=" + r);
					dos.writeDouble(r);
					System.out.println("Client get: area=" + dis.readDouble());
					Thread.sleep(2000L);
					r++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
