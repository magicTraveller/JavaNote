package socket_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 服务器线程处理类
 * 
 * 使用流传递的大多应该是对象而不仅仅是字符串
 * 
 * 多线程要设计优先级 thread.setPriority(int);
 * 没有优先级 效率可能会低一点，运行速度较慢
 */
public class serverthread extends Thread {
	//和本线程相关socket
	Socket s=null;
	public serverthread(Socket ss) {
		this.s=ss;
	}
	//执行线程，响应客户段请求
	public void run(){
		InputStream is;
		try {
			is = s.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			BufferedReader r=new BufferedReader(isr); 
			
			OutputStream os=s.getOutputStream();
			PrintWriter pw=new PrintWriter(os);
			pw.write("Welecome here,Traveller");
			pw.flush();
			
			s.shutdownOutput();
			os.close();
			pw.close();
						
			//关闭输出流可能会关闭socket 关闭socket会吧输出流关了
			s.shutdownInput();
			is.close();
			isr.close();
			r.close();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

	}

}
/*
 * 如何实现发送文件？ 客户端： 新建文件字节输入流 循环将输入流写入到发送的输出流中 Socket socket=new
 * Socket("localhost", 8881);
 * OutputStream os=socket.getOutputStream();
 * 
 * File file=new File("e:/Table.java"); 
 * FileInputStream fs=new FileInputStream(file); 
 * byte[] data=new byte[1024*4]; int length;
 * while((length=fs.read(data))!=-1){
 * 	os.write(data, 0, length); 
 *	os.flush(); 
 * }
 * socket.shutdownOutput(); 
 * socket.close(); 
 * os.close(); 
 * fs.close();
 * 
 * 服务器端： 新建文件字节输出流 循环将接收到输入流写入到文件字符输出流 ServerSocket server =new
 * ServerSocket(8881); 
 * Socket socket=server.accept(); 
 * InputStream is=socket.getInputStream(); 
 * File file=new File("e:/153.java");
 * FileOutputStream fs=new FileOutputStream(file); 
 * byte[] data=new byte[1024*4];
 * int length; 
 * while((length=is.read(data))!=-1){ 
 * 	fs.write(data, 0, length);
 *  fs.flush(); 
 * } 
 *  socket.shutdownInput(); server.close(); socket.close();
 * is.close(); fs.close();
 */