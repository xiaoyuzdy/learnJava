package Number_19;

import java.text.DateFormat;
import java.util.Date;

/**
 * enum�ĳ�����ط��� enumʵ�������д������ ����ҪΪenumдһ���������󷽷�Ȼ��enumʵ��ʵ�ָó��󷽷�
 * 
 * @author he
 * 
 */

public enum P603 {
	DATE_TIME {

		@Override
		String getInfo() {
			return DateFormat.getInstance().format(new Date());
		}

	},
	CLASSPATH {

		@Override
		String getInfo() {
			// TODO Auto-generated method stub
			//��ȡJava�汾��Ϣ
			return System.getProperty("java.version");
		}

	};

	abstract String getInfo();

	public static void main(String[] args) {

		for (P603 p : values()) {
			System.out.println(p.getInfo());
		}
	}
}
