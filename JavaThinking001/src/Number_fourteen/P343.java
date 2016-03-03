package Number_fourteen;

import java.util.Arrays;
import java.util.List;

/**
 * 空白对象
 * 
 * @author he
 * 
 */

interface NULL {
}

interface Operation {
	String description();// 描述方法

	void command();// 命令
}

interface Rebot {
	String name();// 名字

	String model();// 模型

	List<Operation> operations();

	class Test {
		public static void test(Rebot r) {
			if (r instanceof NULL) {
				System.out.println("No Rebot!!!");
			}

			System.out.println("Rebot name: " + r.name());
			System.out.println("Rebot model: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}

}

public class P343 implements Rebot {

	private String name;

	public P343(String name) {
		this.name = name;
	}

	public String name() {

		return name;
	}

	public String model() {
		return "SnowBot Series 11";
	}

	public List<Operation> operations() {

		return Arrays.asList(new Operation() {

			public String description() {
				return name + "can shovel snow";
			}

			public void command() {
				System.out.println(name + "shoveling snow");
			}

		}, new Operation() {

			public String description() {

				return name + " can chip ice";
			}

			public void command() {
				System.out.println(name + "chipping ice");

			}
		});
	}

	public static void main(String[] args) {
		Rebot.Test.test(new P343("Slusher"));
	}

}
