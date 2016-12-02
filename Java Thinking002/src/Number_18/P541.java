package Number_18;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * 格式化的内存输入
 * 

 * @author he
 * 
 */
public class P541 {

	public static void main(String[] args) throws IOException {
		DataInputStream d = new DataInputStream(new ByteArrayInputStream(P540
				.read("F:/workspace/Java Thinking002/src/Number_18/P541.java").getBytes()));
		while(true){
			System.out.print((char)d.readByte());
		}
		
	}

}
