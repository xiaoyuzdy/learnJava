package Number_five;
/**
 * java se5 ֮��ɱ�����б�
 * @author he
 *
 */
public class ke_bian_can_shu_lie_biao02 {
	public static void print(int i, Object... args) {
		System.out.println(i);
		for (Object obj : args) {

			System.out.print(obj);
		}
	}

	public static void main(String[] args) {

		print(1, 3,"xxx", 2, 'c');

	}
}

/**
 * һ�����񴫲�
 */

/*public class ke_bian_can_shu_lie_biao02 {
	public static void printf(int i, Object args) {
		System.out.println(i);
		System.out.println(args.toString());
	}

	public static void main(String[] args) {

		printf(1, "222");
		// printf(1, "223","xxx");

	}
}*/
