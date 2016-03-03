package Number_thirteen;

/**
 * 测试正则表达式
 * 
 * @author he
 * 
 */

public class P296 {
	public static void main(String[] args) {
		System.out.println("123456".matches("-?\\d+"));// matches
														// 检查此字符串是否匹配给定的正则表达式
		System.out.println("+23456".matches("-?\\d+"));
		System.out.println("+23456".matches("(-|\\+)?\\d+"));
	}
}
