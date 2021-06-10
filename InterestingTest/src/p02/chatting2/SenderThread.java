package p02.chatting2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SenderThread extends Thread {

	Socket sk;

	SenderThread(Socket sk) {
		super();
		this.sk = sk;
	}
	
	
	@Override
	public void run() {
		
		try {
			InputStreamReader ir = new InputStreamReader(System.in); //주 스트림
			BufferedReader br = new BufferedReader(ir);//보조 스트림(외부에서 주 스트림을 넣어줌)
			
			PrintWriter pw = new PrintWriter(sk.getOutputStream());
			
			while(true) {
				
				String str = br.readLine();
				if(str.equals("bye"))  //"bye" 입력시 채팅 종료
					break;
				else{
					pw.println(str);//송신
					pw.flush(); //버퍼 비우기
				}
				
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		
		}finally {
			
			try {
				sk.close();
			} catch (IOException e) {
				
		}
		

		
	}
	
	
	
	}
}
