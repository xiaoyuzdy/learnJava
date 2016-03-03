package Number_twelve;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * �쳣����־�ļ�
 * 
 * @author he
 * 
 */

class loggerException extends Exception {
	// logger����������¼�ض�ϵͳ��Ӧ�ó����������־��Ϣ
	
	// Ϊָ����ϵͳ���һ򴴽�һ�� logger��
	private Logger logger = Logger.getLogger("loggerException");

	public loggerException() {
		// �ַ�������
		StringWriter trace = new StringWriter();
		// ָ���ļ������������Զ�ˢ��,��ʾ�����λ��
		printStackTrace(new PrintWriter(trace));
		// ��¼һ��sever��Ϣ
		logger.severe(trace.toString());
	}

}

public class P253_rizhi {

	public static void main(String[] args) {
		try {
			throw new loggerException();
		} catch (loggerException e) {
			System.err.println("Caught 1   " + e);
		}

		try {
			throw new loggerException();
		} catch (loggerException e) {
			System.err.println("Caught 2   " + e);
		}

	}

}
