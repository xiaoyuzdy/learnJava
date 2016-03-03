package Number_five;
/**
 * java se5 之前可变参数列表
 * @author he
 *
 */
public class ke_bian_can_shu_lie_biao {
	public static void printf(Object[] args) {

		for (Object obj : args) {

			System.out.println(obj);
		}
	}

	public static void main(String[] args) {

		printf(new String[] { "xx", "2w" });

	}
}
