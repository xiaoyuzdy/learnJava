package N1;

import java.util.LinkedList;
import java.util.List;

/**
 * P102 ������ͨ���?���÷� ���һ������ʹ��?�������ֻ��ȡԪ�ز������Ԫ�أ�?��ʹ����Ҫ�ǲ���ȷ������ķ���������ʲô
 * 
 * @author he
 *
 */
public class Generic {

	// ����ȷ��list�����еľ������ͣ�ʹ��? �����������ƣ�����������κη�null��Ԫ��
	//��? ����T ����������
	public static void get(List<?> list) {
		//String o=(String) list.get(0);//����ָ���������ͳ�����ȷ��ǿת��Ч��������ʱ���������ת���쳣
		Object o=list.get(0);
		System.out.println(o);
		list.add(null);// ������
	//	list.add(1);//������ͨ������
	}
	
	public static void main(String[] args) {
		List<String> list=new LinkedList<String>();
		list.add("A");
		get(list);//����
		List<Integer> list2=new LinkedList<Integer>();
		list2.add(1);
		get(list2);//����
	}
	
}
