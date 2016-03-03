package Number_thirteen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * …®√Ë ‰»Î
 * 
 * @author he
 * 
 */
public class P310 {

	public static BufferedReader input = new BufferedReader(new StringReader(
			"xiaoming\n22 44.33"));
	public static void main(String[] args) throws IOException {
		System.out.print("my name :");
		Scanner sc=new Scanner(input);
        System.out.print(sc.nextLine());
        System.out.print("my ages:");
        System.out.println(sc.nextInt());
        System.out.printf("prices: %f",sc.nextDouble());
        
        
	}

}
