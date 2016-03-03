package Number_nine;

import java.util.Arrays;

class Processor {
	public String name() {
		return getClass().getSimpleName();// �õ��򵥵�����

	}

	Object process(Object input) {
		return input;

	}
}

class Upcase extends Processor {
	String process(Object input) {
		return ((String) input).toUpperCase();// ��string�е������ַ�ת��Ϊ��д�ַ�
	}
}

class Downcase extends Processor {
	String process(Object input) {
		return ((String) input).toLowerCase();// ��string�е������ַ�ת��ΪСд�ַ�
	}
}

class Splitter extends Processor {
	String process(Object input) {
		return Arrays.toString(((String) input).split(" "));
	}
}

public class p175 {

	public static void process(Processor p, Object s) {
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(s));

	}

	public static String s = "Disagreement with beliefs is by definition incorrect";

	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);

	}
}
