package aggregation;

import java.util.Set;
import java.util.HashSet;
public class SetDetail {

	SetDetail(){
		this.S=new HashSet();
		//this.s.add("abb");
		this.S.add("abb");
		System.out.print(S.size());
	}
	public HashSet<String> S;
	public Set<String> s;
	
	public static void main(String[] args) {
		//set是 无序 且不可以重复的集合，被称为集
		//set和list不同的是没有set方法修改元素 也不能用get方法 遍历只能foreach和iterator
		//HashSet哈希集
		SetDetail d=new SetDetail();
	}

}
