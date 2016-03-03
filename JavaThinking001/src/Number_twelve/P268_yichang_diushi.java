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
		 * 嵌套try语句内 里面的finally 返回另一个异常则 第二个try里的异常丢失
		 * 
		 */
		//第一个try
		try {
			//第二个try
			try {
				f();
				
			} finally{
				g();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * 在finally里返回则异常丢失
		 */
//		try {
//			throw new RuntimeException();
//		} finally{
//			return;
//		}
		
	}
}
