package Number_18;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * ʹ�ù�������P528��PPrint
 * 
 * �����ļ���ΪF:\workspace\3\src\file_io_liu
 * 
 * @author he
 * 
 */

public class P530 {

	public static void main(String[] args) {
		
		
		// ��ӡF:/workspace�µ��ļ���,��������ôд���� ���밴���漸�ַ�ʽд
		//����ԭ������P528����д��tostring ����
//		 PPrint.pprint(P528.walk("F:/workspace/3/src").dirs);
		for (int i = 0; i < P528.walk("F:/workspace/3/src").dirs.size(); i++) {
			PPrint.pprint(P528.walk("F:/workspace/3/src").dirs.get(i));
		}
		// ������һ�ַ�ʽ
		// System.out.println(P528.walk("F:/workspace/3/src").dirs);

		// ��ӡF:/workspace/3/src/file_io_liu Ŀ¼��D��ͷ��׺��.java���ļ�
		for (File file : P528.local("F:/workspace/3/src/file_io_liu",
				"D.*\\.java")) {
			System.out.println(file);

		}
		System.out.println("--------------------------------");

	}
}
