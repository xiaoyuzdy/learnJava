package Number_twelve;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * ͨ��RuntimeException���Ρ��������쳣��
 * 
 * @author he
 * 
 */

class CheckedException {
	void throwRuntimeException(int number) {

		try {
			switch (number) {
			case 0:
				throw new FileNotFoundException();
			case 1:
				throw new IOException();
			case 2:
//				throw new RuntimeException("where am i? ");
			default:
				return;
			}
		} catch (Exception e) {
			// ͨ��RuntimeException���������쳣ת��Ϊ�������쳣
			throw new RuntimeException(e);
//			e.printStackTrace();
		}

	}
}

class SomeOtherException extends Exception {
}

public class P280 {
	public static void main(String[] args) {

		CheckedException c = new CheckedException();
		c.throwRuntimeException(3);
		for (int i = 0; i < 4; i++) {
			try {
				if (i < 3) {
					c.throwRuntimeException(i);
				} else {

					throw new SomeOtherException();

				}
			} catch (SomeOtherException e) {
				System.out.println("SomeOtherException" + e);
			} catch (RuntimeException e2) {
				try {
					throw e2.getCause();
				} catch (FileNotFoundException e) {
					System.out.println("FileNotFoundException " + e);

				} catch (IOException e) {
					System.out.println("IOException" + e);
				} catch (Throwable e) {
					System.out.println("Throwable" + e);
				}
			}

		}

	}
}
