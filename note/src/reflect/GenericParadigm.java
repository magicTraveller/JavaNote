package reflect;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import com.sun.jdi.Method;

public class GenericParadigm {

	public static void main(String[] args) throws Exception {
		/*1、Java集合中的泛型，是防止我们错误输入的，只在编译阶段有效，绕过编译机无效了*/
		ArrayList list1 = new ArrayList();
		ArrayList<String> list2 = new ArrayList<String>();
		
		list1.add(2);//可以
		//list2.add(2);就错了
		
		Class c1 = list1.getClass();
		Class c2 = list2.getClass();
		System.out.println(c1 == c2);
		//打印出true，说明编译后集合的泛型是去泛型化的

		/*
		 * 2、验证
		 * 我们可以通过方法的反射来操作，绕过编译
		 */
		java.lang.reflect.Method m = c1.getMethod("add",Object.class);
		m.invoke(list2,100);//绕过编译操作就绕过了泛型
		System.out.println(list2.size());
		//打印出1，说明加进去了
		//此时就不能用foreach来遍历了，否则会报类型转换异常 毕竟还有个整型100
	}

}
