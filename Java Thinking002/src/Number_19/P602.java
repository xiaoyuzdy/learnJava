package Number_19;

import java.util.EnumMap;
import java.util.Map;
import static Number_19.AlarmPoints.*;

/**
 * EnumMap 继承AbstractMap
 * 
 * @author he
 * 
 */

interface Command {
	void action();
}

public class P602 {
	public static void main(String[] args) {
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(
				AlarmPoints.class);
		em.put(KITCHEN, new Command() {
			public void action() {
				System.out.println("Kitchen file");
			}
		});
		em.put(BATHROOM, new Command() {

			public void action() {
				System.out.println("Bathroom file");
			}
		});
		// 这样也行
		// for(Entry<AlarmPoints, Command> s: em.entrySet()){
		// System.out.println(s.getKey());
		// }

		for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
			System.out.println(e.getKey() + "--");
			e.getValue().action();
		}

	}

}
