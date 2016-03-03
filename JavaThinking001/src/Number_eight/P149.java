package Number_eight;

import Number_eight.P149.Note;

/**
 * 只是向上转型
 * 
 * @author he
 * 
 */
class Instrument {
	public void play(Note n) {
		System.out.println("instrument play" + n);
	}
}

class wind extends Instrument {

}

public class P149 {

	public enum Note {
		MIDDLE_C, C_SHARP;
	}

	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}

	public static void main(String[] args) {
               
		wind w =new wind();
		tune(w);
	}
}
