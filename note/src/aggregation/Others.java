package aggregation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student_ implements Comparable<Student_>{
	Integer id;
	String name;
	@Override
	public int compareTo(Student_ o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.id);//这里调用的是integer的comparaTo方法
	}
}
class SC implements Comparator<Student_>{
	@Override
	public int compare(Student_ o1, Student_ o2) {
		// TODO Auto-generated method stub
		return o1.id.compareTo(o2.id);
	}
	
}


public class Others {

	public static void main(String[] args) {
		List<String>l = new ArrayList<String>();
		List<Student_>ss=new ArrayList<Student_>();
		Collections.sort(ss);
		Collection<String>c;
		Collections.sort(l);
		
		ss.sort(new SC());
		Collections.sort(ss,new SC());
		/*
		 * Collections.sort(List);可以进行排序
		 * 其中所有元素必须实现Comparable接口 列如说 Student_对象
		 * 
		 * Sort()方法内部会调用Comparable接口的compareTo()规则
		 * 
			Comparable和Comparotor都是JAVA集合框架的成员。
			Comparable接口——可比较的：
			    默认比较规则
			    类的实例可以比较大小，可以自然排序
			    其实现类需要实现compareTo()方法，返回正数表示大，负数表示小，0表示相等
			Comparator接口——比较工具接口：
			    用于定义临时比较规则
			    其实现类徐亚实现compare()方法

		 * 
		 * 基本类型不能当泛型 必须用包装类
		 * 
		 * contains和containsAll方法都是Collection接口的方法 做为他的子类自然可以调用
		 * 
		 * l.contains(xxx)方法判断某个序列中是否包含xxx元素
		 * 内部是现是遍历List，然后对其中的每一个元素使用equals()方法来判断对象的引用是否相同，一旦存在一个相同引用则返回true。
		 * 
		 * 若要判断是否有属性相同的元素，则需要重写xxx元素对应的类的equals()方法。
		 * 因为equals比对的是引用是地址而不是值
		 * 
		 * HashSet里用contains比对会用hashCode()方法获得hash码，再equals 
		 * 所以要重写hashCode和equals两个方法
		 * 由于hashCode方法用的是哈希算法生成并返回的所以最好还是自动生成吧
		 * 右键source就可以找着了
		 * 
		 * Map虽然不是Collection，但HashMap也是同样的
		 * containsKey和containValues都要重写equals
		 */
//		indexOf()返回第一个匹配的元素的索引，内部也是调用equals()方法。
//		lastIndexOf()返回最后一个匹配的元素的索引
//		若没有找到匹配的元素，则返回-1
		
		

	}

}
