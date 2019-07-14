package unusual;

import com.sun.tools.javadoc.Main;

/*** test1():抛出“喝大了”异常
* test2():调用test1()，捕获喝大了异常，并且包装成运行*时异常继续抛出
* main方法中调用test2()尝试捕获test2()方法抛出的异常
* 
* e.printStrackTrace();    作用是进行深层次的输出异常调用的流程 
* RunTimeException();   这是运行时异常，是所有java虚拟机正常操作期间可以被抛出异常的父类！
* newExc.initCause(e);   这是一种对异常的一种包装技巧。
* initCause()的作用是保存原始的异常，当想要知道底层发生了什么异常的时候调用getCause()就能获得原始异常。
* 假设B模块完成自己的逻辑需要调用A模块的方法，如果A模块发生异常，则B也将不能完成而发生异常，但是B在抛出异常时，会将A的异常信息掩盖掉，这将使得异常的根源信息丢失。异常的链化可以将多个模块的异常串联起来，使得异常信息不会丢失。
* 异常链化:以一个异常对象为参数构造新的异常对象。新的异对象将包含先前异常的信息。主要是异常类中一个带Throwable参数的函数来实现，这个当做参数的异常，被称为根源异常（cause）
* */


//自定义
class DrunkException extends Exception{
	DrunkException(){}
	DrunkException (String message){
		//Exception的构造方法
		super(message);
	}
}
public class First {
	public static void test2() throws Throwable{
		throw new DrunkException("First Blood");
	}
	public static void test1()throws DrunkException{
		throw new DrunkException("喝车别开酒，开酒不喝车"); 
	}
	
	public static void test()throws Throwable{
		
/*		  try { test2(); } 		
		  catch(DrunkException a) {
				RuntimeException newExc=new RuntimeException("司机一滴酒，天堂一座房");
				newExc.initCause(a);
				throw newExc;
				}*/
		 
		try {
			test1();	
		}
		catch(DrunkException a) {
		RuntimeException newExc=new RuntimeException("司机一滴酒，天堂一座房");
		newExc.initCause(a);
		throw newExc;
		}
	}
	public static void main(String[] args)throws Throwable{		
		//异常DrunkException由test1或者test2抛给test再抛给main由main来处理
		//这就是异常链
		
		//尽量的去处理异常而不仅仅是PrintStackTrace()
		//尽量finally释放资源
		try {
			test();
		}
		catch(RuntimeException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			//捕捉可能遗漏的异常
			e.printStackTrace();
		}
		//Throwable是真祖
		//Exception和Error（系统错误 如：虚拟机错误，线程死锁）是初代种
		//RuntimeException非检查异常运行时错误 Java虚拟机会自动抛出，检查时异常 需要自己手动捕获
		
		/*
		 * throw -将产生的异常抛出(动作)抛到上一层（更底层？）去 
		 * throws-声明将要抛出何种类型的异常(声明) 通常在方法后
		 * public void 方法名(参数列表) throws
		 * 异常列表{ 调用会抛出异常的方法或者： throw new Exception(); }
		 */
	}

}
