package Number_thirteen;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对于字符串 Java now has regular expression验证下列正则表达式是否能够发现一个匹配
 * ^Java
 * \Breg.*
 * n.w\s+h(a|i)s
 * s?
 * s*
 * s+
 * s{4}
 * s{1}
 * s{0,3}
 * 
 * @author he
 * 
 */
public class P301 {

	public static void main(String[] args) {
		String s="Java now has regular expression";
		String []regex={"^Java","\\Breg.*","n.w\\s+h(a|i)s","s?",
				"s*","s+","s{4}","s{1}","s{0,3}"};
		
		System.out.println("String :\""+s+"\"");
		
		for (String pattern : regex) {
			System.out.println("Regular expression: \""+pattern+"\"");
			Pattern p=Pattern.compile(pattern);
			Matcher m=p.matcher(s);
			while(m.find()){
				System.out.println("Match \""+m.group()+"\""+"atposition"
			                        +m.start()+"-"+(m.end()-1));
			}
		}	
	}	
}
