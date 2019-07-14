package aggregation;

public class FirstOfAll {

	public static void main(String[] args) {
		/*
		 * 集合：储存任意数量的具有共同属性的对象
		 * 
		 * 集合的两大家族
		 * 
		 * 集合的作用 
		 * 1.在类的内部，对数据进行组织； 
		 * 2.简单而快速的搜索大数量的条目；
		 * 3.有的集合接口，提供了一系列排列有序的元素，并且可以在序列中间快速的插入或者删除有关元素；
		 * 4.有的集合接口，提供了映射关系，可以通过关键字（key）去快速查找到对应的唯一对象，而这个关键字可以是任意类型
		 * 
		 * 
		 * 
		 * 与数组的对比——为何选择集合而不是数组 
		 * 1.数组的长度固定，集合长度可变
		 * 2.数组只能通过下标访问元素，类型固定；而有的集合可以通过任意类型查找所映射的具体对象
		 * 
		 * 
		 * 
		 * List：元素有序且可重复的集合 称为	序列
		 * 元素存进集合中会变成Object类型所以foreach要Object
		 * 
		 * 所谓可变就是长度是已有长度+1 如果想添加到n+2位会越界
		 * 
		 * 
		 * 
		 * list.add(对象)把一个对象添加到另一个集合的队尾位置
		 * list.add(index,对象) 把一个对象添加一个集合的指定位置
		 * list.addAll(集合对象) 把一个集合添加到另一个集合的队尾位置
		 * list.addAll(index, 集合对象) 把一个集合添加到另一个集合的指定位置
		 * Arrays.asList(数组) 把一个数组转换成List集合  是传数组的时候，需要用方法把他弄成list，不然会直接把数组作为一个对象。
		 * 声明的时候带泛型实例化也要有泛型< > 会在编译期间检查泛型加了泛型就可以foreach了
		 * 
		 * 泛型中还可以存入类型子类型
		 * 泛型不能是基本类型（int啊。。。etc）包装类integer可以
		 */
		java.util.List l=new java.util.ArrayList();
		l.add("abq");
		//修改集合元素
		l.set(0,"ddd");
		//迭代器对象引用
		java.util.Iterator it=l.iterator();
		
		//List中有
		//remove(index)
		//remove(对象值)
		//removeAll(Arrays.asList(对象数组名)) 好像可以不连续
		//来删除容器中元素的值
		//用法和add类似
		}

}
