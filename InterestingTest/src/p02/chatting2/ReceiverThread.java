package p02.chatting2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceiverThread extends Thread {

	
	Socket sk;

	
	ReceiverThread(Socket sk) {
		super();
		this.sk = sk;
	}
	
	
	@Override
	public void run() {
		InputStreamReader ir;
		try {
			ir = new InputStreamReader(sk.getInputStream());//주 스트림
			BufferedReader br = new BufferedReader(ir);//보조 스트림(외부에서 주 스트림을 넣어줌)
			
			while(true) {
				
				String str = br.readLine();
				if(str== null)	//"bye" 입력시 채팅 종료
					break;
				System.out.println("수신>" +str);
			}
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
		
		} 
		
		
	}
	
	}
	
	
