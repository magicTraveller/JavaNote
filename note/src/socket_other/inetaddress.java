package socket_other;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
public class inetaddress {

	/*
	 * 主要用于标识ip信息
	*/
	public static void main(String[] args) throws UnknownHostException {
		// get local host
		InetAddress address=InetAddress.getLocalHost();
		//相当于
		InetAddress _address=InetAddress.getByName("127.0.1.1");
		//类似的还有主机名啊什么的等等
		System.out.println(address);
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());		
		System.out.println(Arrays.toString(address.getAddress()));
		
	}

}
