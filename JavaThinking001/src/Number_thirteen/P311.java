package Number_thirteen;

import java.util.Scanner;
import java.util.regex.MatchResult;

/**
 * ��������ʽɨ��
 * @author he
 *
 */
public class P311 {

	static String threatDate=
			"58.27.82.161@02/10/2005\n"+
	        "204.45.234.40@20/11/2005";
	public static void main(String[] args) {
		Scanner sc=new Scanner(threatDate);
		//����������ʽ  \\d+ ��ʾһ����������
		String pattern ="(\\d+[.]\\d+[.]+\\d+[.]+\\d+)@"+"(\\d{2}/\\d{2}/\\d{4})";
		while(sc.hasNext(pattern)){
			sc.next(pattern);
			MatchResult matchResult=sc.match();
			
			System.out.println("Ip :"+matchResult.group(1));;
			System.out.println("Time :"+matchResult.group(2));
			
		}
		
	}
	
}
