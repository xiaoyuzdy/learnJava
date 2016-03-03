package Number_19;

/**
 * switchÖÐµÄenum
 * 
 * @author he
 * 
 */

enum Signal {
	GREEN, YELLOW, RED
}

public class P593 {
	Signal color = Signal.RED;

	public void change() {
		switch (color) {
		case RED:
			color = Signal.GREEN;
			break;
		case GREEN:
			color = Signal.YELLOW;
			break;
		case YELLOW:
			color = Signal.RED;
			break;
		}

	}

	@Override
	public String toString() {

		return "The color is " + color;
	}

	public static void main(String[] args) {
		P593 p = new P593();
		for (int i = 0; i < 7; i++) {
			System.out.println(p);
			p.change();
		}

	}

}
