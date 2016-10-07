package N1;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * P21 过期的引用以及消除过期的引用
 * @author he
 *
 */
public class Stack {
	private  Object  elements[];
	private int size=0;
	private static final int DEFAULT_INITIAL_CAPACITY=16;//默认数据大小
	
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
		 * 如果这么写，数组会保留对已经弹出去的元素的引用，该引用是过期引用，这样随着数组不断增大缩小会发生memory leak（内存泄漏）
		 */
		
//		return elements[--size];
		
		/**
		 * 要消除过期引用需要这样写
		 */
		
		Object result=elements[--size];
		elements[size]=null;//消除过期引用
		return result;
		
		
	}
	
	private void ensureCapacity(){
		if(elements.length==size)
			elements=Arrays.copyOf(elements, size*2+1);
	}
	
	
}
