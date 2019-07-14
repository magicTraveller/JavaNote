//反射——关于一切类都是Class类的一个实例对象的笔记
package reflect;

import java.lang.reflect.Method;

class Test1{
	public Test1() {
		System.out.println("Test1 is excuted");
	}
}

class Test2{
	int i=0;
	public void setI(int i) {
		this.i=i;
	}
	public Test2() {
		System.out.println("Test2 is excuted");
	}
	void test() {
		System.out.println("This is just a test    "+i);
	}
}
public class _class {

	@SuppressWarnings("deprecation")
	
	
	public static void main(String[] args) throws Exception, IllegalAccessException{
		Object t = null;
		t=new Test1();
		System.out.println("类也是对象");
		/**
		 * 每个类都有一个隐含的静态成员变量class 官方称这个叫类的类型 读起来很难受啊
		 *  
		 *  我感觉与其说每个类都是Class的一个实例
		 *  不如说每个类里都有一个Class类的实例对象
		 *  这个实例对象记录了这个类的信息
		 *  可以用这个实例来代表这个类
		 *  
		 *  of course这只是我的一个推测 真实情况怎么说还得看源码
		 * */
		
		//类的三种表示方式  这里只是给ca，cb，cc赋值说他们可以表示Test1这个类
		Class ca=Test1.class;	//1
		
		//这里t是一个object类型这是一个测试
		//证明他的类类型是随对象类型改变还是因为构造方法改变
		Class cb=t.getClass();	//2   
		Class cc=null;		    //3
		
		
		//其实不用try的毕竟上面throws了 抛给系统了 系统调用的吗
		try {
			cc=Class.forName("reflect.Test1");
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(ca.getName());
		System.out.println(cc.getName());
		System.out.println(cb.getName());
		System.out.println("");
				
		//各个类型也有类的类型 getSimpleName()可以不显包名
		ca=int.class;
		ca=void.class;
		
		
		cc=Test2.class;
		
		//newInstance只能用无参构造函数 
		//但是现在基本不用newInstance了看见上的那条杠了吗
		//如果没有throws也要try
		t=(Test2)cc.newInstance();
		Test2 tt=(Test2)cc.newInstance();
		
		
		//t用不了setI也用不了test
		//应该是上型函数（动态绑定）的原因 
		//或者说t的声明类型是Object 毕竟Object类里没有test和setI方法 
		//要是用个类或者抽象类做直接父类就可以了
		//for example:
		//Class c=Class.forName(args[0]);
		//DadClass t=(DadClass)c.newInstance();
		//动态的加载这个类列如说yy这个类 我并没有申明然而编译不会出错 只要以后写出来 这段代码也不用改
		tt.setI(2);
		tt.test();
		System.out.println(t.toString());
		
		
		//储存开设出来的对象
		//object obj1[];
		//obj1=new Object[4]; 这里只是创建了obj1这个数组引用 要给每个引用对象赋值还得new或者把已经有引用的付给他如 obj1=Test2.class;或者obj1=cc;
		//用来动态的开设对象
		//Object []obj= {ca,cb,cc};
		//int i=0;
		//for(Object o:obj){
		//	obj1[i++]=(Object)o.newInstance();
		//}
		System.out.println("");
		
		
		//方法也是Method的对象
		Method []method=cc.getMethods();//all public方法
		//m=ca.getDeclaredMethods();      all 自己申明的方法
		
		//获取方法的信息
		for(Method m:method) {
			ca=m.getReturnType();
			System.out.print(ca.getName()+" ");
			System.out.print(m.getName()+"(");
			Class []pa=m.getParameterTypes();
			for(Class p1:pa) {
				System.out.print(p1.getClass()+",");
			}
			System.out.println(")");
		}
		//还可以调用方法：
		Method m=cc.getMethod("test2",new Class[] {});
		
		//如果没有返回值就返回null
		Object o=m.invoke(cc.newInstance());
		//还有好多可以获取的东西像构造方法，成员变量filed，权限啊什么的
														
	}

}	
