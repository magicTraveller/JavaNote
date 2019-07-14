package socket_other;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class url {

	//URL（Uniform Resource Locator）统一资源定位符，表示Internet上某一资源的地址。
	//标记着网路上的资源 就是网址 组成  协议名:资源名
	public static void main(String[] args) {
		try {
			URL baidu=new URL("http://www.baidu.com");
			URL b1=new URL(baidu,"/index.html?username=碎叶落叶#test");//?后是参数 #锚点或者说相对路径 锚点是一种超链接，只是它是页面内部的超链接。
			//文件名就是路径+参数 路径就是/index.html 地址
			//若未指定端口号则使用默认端口号，getPort()方法返回值为-1
			
			//通过URL的openStream方法获取URL对象所表示的资源的字节输入流
			InputStream s=baidu.openStream();
			//转换成字符输入流
			InputStreamReader sr=new InputStreamReader(s,"utf-8");
			//为输入流添加缓冲
			BufferedReader r=new BufferedReader(sr);
			String ss;
			do {			
			System.out.println(ss=r.readLine());
			}while(ss!=null);
			
			sr.close();
			s.close();
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}		

	}

}
