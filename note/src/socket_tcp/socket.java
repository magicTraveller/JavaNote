package socket_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class socket {

	//基于tcp 要建立链接 有顺序 以字节流传输
	//客户段的Socket 服务器的ServerSocket
	public static void main(String[] args) {
		try {
			//Socket要指定服务器段地址
			Socket s=new Socket("localhost",2388);
			//用输出流向服务器发送信息
			OutputStream os=s.getOutputStream();
			//变成打印流
			PrintWriter pw=new PrintWriter(os);
			pw.write("admin:Traveller;password:123");
			//刷新缓存
			pw.flush();
			
			InputStream	is=s.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader r=new BufferedReader(isr); 
			
			s.shutdownInput();
			is.close();
			isr.close();
			r.close();
			
			s.shutdownOutput();
			pw.close();
			os.close();
			s.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
