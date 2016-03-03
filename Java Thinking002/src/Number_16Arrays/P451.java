package Number_16Arrays;

import java.util.Arrays;

/**
 * 如果复制对象数组，那么只是复制了对象的引用
 * 
 * @author he
 * 
 */

class A {
	private int id;

	A(int i) {
		id = i;
	}

	@Override
	public String toString() {

		return id + "";
	}
	public  static  A[] change(A[] a){
		
		a[0]=new A(2);
		return a;
	}
}





public class P451 {
	
	public static void main(String[] args) {
		A[] a1 = new A[3];
		Arrays.fill(a1, new A(0));
		System.out.println("a1: "+Arrays.toString(a1));
		
		A[] b1 = new A[3];
		System.arraycopy(a1, 0, b1, 0, a1.length);
		System.out.println("b1"+Arrays.toString(b1));
		
		A.change(b1);
	 
		System.out.println("c1"+Arrays.toString(b1));
		System.out.println("a1: "+Arrays.toString(a1));
		

	}

}
