package Number_thirteen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * pattern and matcher
 *运用命令行参数    abcabcabcdefabc "abc+" "(abc)+"  "(abc){2,}"
 * 
 * @author he
 * 
 */
public class P300 {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("expression");
			System.exit(0);

		}
		System.out.println("Inpot: \"" + args[0] + "\"");

		for (String arg : args) {
			System.out.println("Regular expression :\"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while (m.find()) {
				System.out.println("Match \"" + m.group() + "\" at position"
						+ m.start() + "-" + (m.end() - 1));
			}
		}
	}

}
