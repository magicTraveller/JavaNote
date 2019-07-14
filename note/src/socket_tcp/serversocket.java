package socket_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serversocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int count=0;
			//绑定端口，并监听
			ServerSocket ss=new ServerSocket(2388);
			Socket s=null;
			//开始循环监听，等待客户段的链接
			while(true){
				s=ss.accept();
				s.getInetAddress();//获取ip
				//新线程
				serverthread t=new serverthread(s);
				//链接客户段的数目
				count++;
				t.start();
			}
			
			
			/*
			 * //用输入流获取信息 InputStream is=s.getInputStream(); InputStreamReader isr=new
			 * InputStreamReader(is); BufferedReader r=new BufferedReader(isr);
			 * 
			 * OutputStream os=s.getOutputStream(); PrintWriter pw=new PrintWriter(os);
			 * pw.write("Welecome here,Traveller"); pw.flush();
			 * 
			 * s.shutdownOutput(); os.close(); pw.close();
			 * 
			 * s.shutdownInput(); is.close(); isr.close(); r.close(); s.close(); ss.close();
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//1023往后的端口
	}

}
