package Number_16Arrays;

import java.util.Arrays;

/**
 * 练习3
 * 
 * @author he
 * 
 */
public class P440 {

	public static double[][] arrayIn(int i, int j) {
		double[][] a = new double[i][j];
		int k = 0;
		for (int i2 = 0; i2 < i; i2++) {
			for (int l = 0; l < j; l++) {
				a[i2][l] = k;
				k++;
			}
		}

		return a;
	}

	public static void main(String[] args) {
		int []a1={1,2,3,4,5};
	     Arrays.sort(a1);
		//给定值返回下标
		System.out.println(Arrays.binarySearch(a1, 2));
		
		
		System.out.println(Arrays.deepToString(arrayIn(3, 4)));
	}

}
