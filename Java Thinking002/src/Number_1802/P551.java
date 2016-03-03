package Number_1802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ½ø³Ì¿ØÖÆ
 * 
 * @author he
 * 
 */
public class P551 {

	public static void command(String command) throws IOException {
		Process process = new ProcessBuilder(command.split(" ")).start();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				process.getInputStream()));
		String s;
		while ((s = in.readLine()) != null) {
			System.out.println(s);
		}

		BufferedReader err = new BufferedReader(new InputStreamReader(
				process.getErrorStream()));

		while ((s = err.readLine()) != null) {
			System.err.println(s);
		}

	}

	public static void main(String[] args) throws IOException {
		command("javap F:\\workspace\\Java Thinking002\\src\\Number_1802.\\P551");
	}

}
