package Number_19;

import java.util.Random;

/**
 * P609 使用enum的状态机 。 
 * 一个状态机有多个状态，通常根据输入，从一个状态转移到下一个状态
 * 
 * @author he
 * 
 */
public enum Inupt {
	DIME(10), SODA(100),

	STOP {
		int amount() {
			throw new RuntimeException("SHOT_DOWN.amount()");
		}
	};

	int value;

	Inupt() {
	}

	Inupt(int value) {
		this.value = value;
	}

	int amount() {
		return value;
	}

	static Random random = new Random(47);

	public static Inupt randomSel() {
		// 随机获取enum实例
		return values()[random.nextInt(values().length - 1)];
	}

}
