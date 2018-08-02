package com.Test;

import android.util.Log;
import android.util.Slog;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import java.lang.Thread;
import java.io.InputStream;
import java.io.IOException;
import android.net.LocalSocketAddress;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class javaLocalServer extends Thread {
	private static final String TAG = "javaLocalServer";
	
	final static String SOCKET_ADDRESS = "AppSocketAddress";
	private LocalServerSocket serverSocket;

	@Override
	public void run()
	{
		try{
			System.out.println("run");
			serverSocket = new LocalServerSocket(SOCKET_ADDRESS);
			
			while(true) {				
				final LocalSocket receiver = serverSocket.accept();			
				InputStream input = receiver.getInputStream();
				
				byte[] bytes = new byte[1024];
				int ret = input.read(bytes);
				
				String msg = new String(bytes);
				System.out.println("read buffer[" + ret + "]: " + msg);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		javaLocalServer obj = new javaLocalServer();
		
		obj.start();
	}
}


//dalvikvm -cp javaLocalServer.jar  javaLocalServer
//dalvikvm -cp javaLocalServer.jar  com.TestJni.javaLocalServer
//CLASSPATH=/data/javaLocalServer.jar app_process /data/ com.Test.javaLocalServer
