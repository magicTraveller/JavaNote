package socket_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class datagramclient {

	public static void main(String[] args) throws Exception {
		//1.定义服务器的地址 发送信息
		InetAddress address=InetAddress.getByName("localhost");		
		byte[] data="用户名：admin;密码：123".getBytes();
		//2.创建DatagramPacket，包含将要发送的信息
		int port=2388;
		DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
		//3.创建DatagramSocket
		DatagramSocket socket=new DatagramSocket();
		//4.发送数据
		socket.send(packet);
		
		
		//接受服务器的信息
		byte[] da=new byte[1024];
		DatagramPacket pa=new DatagramPacket(da,da.length);
		socket.receive(pa);
		String info=new String(da,0,pa.getLength());
		
		socket.close();
	}

}
