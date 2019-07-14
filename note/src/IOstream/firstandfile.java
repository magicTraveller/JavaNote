package IOstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

//流的本质是字节序列 类似于一个暂时的缓存文件吧
public class firstandfile {
	//getBytes(“utf8”)会把字符等东西转换成字节数组 不加参数用的是项目默认的编码
	//字节字符间转换要编码一致
	//File只用于存储文件对应的信息(目录名称大小之类),不能用于文件内容的访问
	static void main() {
		File file;
	    file=new File("./src/afile");// \\或者/或是File.separator
	    //file.list()返回的是字符串数组
	    //file.listFiles()返回的是File对象数组
	    //RandomAccessFile(file,"rw") java提供对文件内容的访问，既可以读文件，也可以写文件
	    //RandomAccessFile类支持随机访问文件，可以访问文件的任意位置
	    //RandomAccessFile(file,"rw").read/write 两个方法可以读写一个字符字节或者对象数组 同样有内部指针
	    
	    //FileInputStream和FileOutputStream具体实现了在文件上读写数据 同样的read和write 像下面的例子
	    //或者说前者类似于fopen的r 后者类似与w如果加一个true就是a 甚至直接就是 一个封装 
	}
	void printHexByByteArray(String fileName)throws IOException{
    	FileInputStream in=new FileInputStream(fileName);
    	byte[] buf=new byte[20*1024];
    	int bytes=0;
    	//一个buf放不下的话
    	while((bytes=in.read(buf,0,buf.length))!=-1){
    	for(int i=0;i<bytes;i++){
    	System.out.print(Integer.toHexString(buf[i] & 0xff)+" ");}}
    
    	}
}
