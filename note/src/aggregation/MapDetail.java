package aggregation;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


import java.util.HashMap;
class Student{
	String ID,name;	
}
public class MapDetail {

	public static Map<String,Student>m;
	MapDetail(){
		m=new HashMap<String,Student>();
		
		String id = null;
		Student freshman = null;
		
		m.put(id, freshman);//添加新生
		
		//m.keySet()可以返回key的set集合
		//m.values()可以返回value的集合
		//这就可以遍历整个map
	}
	public static void main(String[] args) {
		MapDetail M=new MapDetail();
		Student st=m.get(new Scanner(System.in).next());
		if(st==null)System.out.print("空的");
		/*
		 * 1：Map接口提供了一种无序的映射关系，其中的元素是键值对（key-value）的形式存储的，能够实现根据Key快速查找value。
		 * 2：map中的键值对是以Entry类型的对象实例存在的。
		 * 3：Key值是不可以重复的，Value是可以重复的。
		 * 4：map支持泛型，形式如：map<Key,Value>
		 * 5:通过put(Key,Value)方法添加键值对的映射
		 * 6：通过remove(Object Key)方法移除键值对
		 * 7：HashMap是map的一个重要实现类，也是最长用的，基于哈希表实现
		 * HashMap中的Entry对象是无序排列
		 * Key值和value值都可以为null，但是一个HashMap只能有一个key值 为null的映射（key值不可重复）
		 */
		
		//接下来通过枚举映射来 遍历所有数据
		Set<Entry<String,Student>>entrySet = MapDetail.m.entrySet();//获取所有映射
		for(Entry<String,Student> e:entrySet) 
		{
			e.getKey();
			e.getValue();
		}
	}

}
