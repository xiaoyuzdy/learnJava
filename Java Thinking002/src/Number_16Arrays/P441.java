package Number_16Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����������������� �ٴ���û��������Ȼ����ת��
 * 
 * @author he
 * 
 */
public class P441 {
	static List<String> ls[];
	static List[] la = new List[2];

	public static void main(String[] args) {
		// ����ͨ��
		// la[0] = new ArrayList<Integer>();
		ls = la;
		ls[0] = new ArrayList<String>();
		ls[0].add("1");
		// Type mismatch: cannot convert from ArrayList<Integer> to List<String>
		// ����ͨ����
		// ls[1]=new ArrayList<Integer>();

		// ��Ϊ������Э��ģ����� List<String>[] Ҳ��Object[]����
		Object[] obj = ls;

		obj[1] = new ArrayList<Integer>();
		System.out.println(Arrays.toString(obj));
	}
}
