package p02.chatting2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//서버는 항상 열려있음
public class ServerEx2 {

	public static void main(String[] args) {
		
		
		
		ServerSocket ss =null;
		Socket sk = null;
		
		try {
			 ss = new ServerSocket(5000);
			 sk = ss.accept();
			 
			 Thread t1 = new SenderThread(sk);//송신
			 Thread t2 = new ReceiverThread(sk);//수신
			 t1.start();
			 t2.start();
			 
		} catch (IOException e) {
			
		}finally {
			try {
				ss.close();
			} catch (IOException e) {
				
			}
			
			
		}
		
		
	}

}