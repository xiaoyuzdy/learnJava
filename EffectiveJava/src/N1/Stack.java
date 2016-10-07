package N1;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * P21 ���ڵ������Լ��������ڵ�����
 * @author he
 *
 */
public class Stack {
	private  Object  elements[];
	private int size=0;
	private static final int DEFAULT_INITIAL_CAPACITY=16;//Ĭ�����ݴ�С
	
	public Stack() {
		elements=new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e){
		ensureCapacity();
		elements[size++]=e;
	}
	
	public Object pop(){
		if(size==0)
			throw new EmptyStackException();
		
		/**
		 * �����ôд������ᱣ�����Ѿ�����ȥ��Ԫ�ص����ã��������ǹ������ã������������鲻��������С�ᷢ��memory leak���ڴ�й©��
		 */
		
//		return elements[--size];
		
		/**
		 * Ҫ��������������Ҫ����д
		 */
		
		Object result=elements[--size];
		elements[size]=null;//������������
		return result;
		
		
	}
	
	private void ensureCapacity(){
		if(elements.length==size)
			elements=Arrays.copyOf(elements, size*2+1);
	}
	
	
}
