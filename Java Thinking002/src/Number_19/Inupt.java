package Number_19;

import java.util.Random;

/**
 * P609 ʹ��enum��״̬�� �� 
 * һ��״̬���ж��״̬��ͨ���������룬��һ��״̬ת�Ƶ���һ��״̬
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
		// �����ȡenumʵ��
		return values()[random.nextInt(values().length - 1)];
	}

}
