package socket_udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class datagramServer {
	
	//DatagraPacket数据报包
	//DatagraSocket进行端到端的通信类
	public static void main(String[] args) throws Exception {
		//1.创建DatagramSocket，指定端口号
		DatagramSocket socket=new DatagramSocket(2388);
		//2.创建DatagramPacket数据报
		byte[] data=new byte[1024];
		DatagramPacket packet=new DatagramPacket(data,data.length);
		//3.接收客户端发送的数据信息并保存在byte中 在接收到数据前一直阻塞
		socket.receive(packet);
		//4.读取数据
		String info=new String(data,0,packet.getLength());
		
		//获取客户端的地址 端口 数据
		InetAddress sa=packet.getAddress();
		int po=packet.getPort();
		byte[] da=new byte[1024];
		DatagramPacket pa=new DatagramPacket(da,da.length,sa,po);
		socket.send(pa);
		
		socket.close();
	}

}
