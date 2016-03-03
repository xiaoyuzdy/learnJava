package Number_thirteen;

import java.util.Random;
//using StringBuilder

public class P286 {

	public static Random random=new Random(47);
	@Override
	public String toString() {
		StringBuilder result=new StringBuilder("[");
		for (int i = 0; i < 25; i++) {
			result.append(random.nextInt(100));
			result.append(",");
			
		}
		result.delete(result.length()-1, result.length());
		result.append("]");
		return result.toString();
		
	}
	
	public static void main(String[] args) {
		P286 a=new P286();
		System.out.println(a);
	}
	
}
