package Number_twelve;

class AException extends Exception{}
class BException extends Exception{}





public class P268_yichang_diushi {

   static void f() throws AException{
		throw new AException();
	}
	
   static void g()throws BException{
		throw new BException();
	}
	
	public static void main(String[] args) {

		/**
		 * 
		 * Ƕ��try����� �����finally ������һ���쳣�� �ڶ���try����쳣��ʧ
		 * 
		 */
		//��һ��try
		try {
			//�ڶ���try
			try {
				f();
				
			} finally{
				g();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * ��finally�ﷵ�����쳣��ʧ
		 */
//		try {
//			throw new RuntimeException();
//		} finally{
//			return;
//		}
		
	}
}
