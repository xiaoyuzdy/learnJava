package N1;

import java.util.LinkedList;
import java.util.List;

/**
 * P102 无限制通配符?的用法 如果一个容器使用?则该容器只能取元素不能添加元素，?的使用主要是不能确定具体的泛型声明是什么
 * 
 * @author he
 *
 */
public class Generic {

	// 不能确定list容器中的具体类型，使用? 对类型无限制，但不能添加任何非null的元素
	//把? 换成T 编译器报错
	public static void get(List<?> list) {
		//String o=(String) list.get(0);//不能指定具体类型除非你确定强转有效否则运行时会出现类型转换异常
		Object o=list.get(0);
		System.out.println(o);
		list.add(null);// 不报错
	//	list.add(1);//出错不能通过编译
	}
	
	public static void main(String[] args) {
		List<String> list=new LinkedList<String>();
		list.add("A");
		get(list);//可以
		List<Integer> list2=new LinkedList<Integer>();
		list2.add(1);
		get(list2);//可以
	}
	
}
