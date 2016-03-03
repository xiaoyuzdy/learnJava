package Number_19;

import java.util.Random;

/**
 * 多路分发 Java只支持单路分发 实现自己的动态绑定行为 剪刀石头布的游戏，用到二次分发
 * 
 * @author he
 * 
 */

enum Outcome {
	WIN, LOSE, DRAW
}

interface Item {
	Outcome compete(Item it);

	Outcome eval(Paper p);

	Outcome eval(Scissors s);

	Outcome eval(Rock r);

}

// comptet() 实现二次分发， 即二次绑定
class Paper implements Item {

	public Outcome compete(Item it) {
		return it.eval(this);
	}

	public Outcome eval(Paper p) {
		return Outcome.DRAW;
	}

	public Outcome eval(Scissors s) {
		return Outcome.WIN;
	}

	public Outcome eval(Rock r) {
		// TODO Auto-generated method stub
		return Outcome.LOSE;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Paper";
	}
}

class Scissors implements Item {

	public Outcome compete(Item it) {
		// TODO Auto-generated method stub
		return it.eval(this);
	}

	public Outcome eval(Paper p) {
		// TODO Auto-generated method stub
		return Outcome.LOSE;
	}

	public Outcome eval(Scissors s) {
		// TODO Auto-generated method stub
		return Outcome.DRAW;
	}

	public Outcome eval(Rock r) {
		// TODO Auto-generated method stub
		return Outcome.WIN;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Scissors";
	}

}

class Rock implements Item {

	public Outcome compete(Item it) {
		// TODO Auto-generated method stub
		return it.eval(this);
	}

	public Outcome eval(Paper p) {
		// TODO Auto-generated method stub
		return Outcome.WIN;
	}

	public Outcome eval(Scissors s) {
		// TODO Auto-generated method stub
		return Outcome.LOSE;
	}

	public Outcome eval(Rock r) {
		// TODO Auto-generated method stub
		return Outcome.DRAW;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rock";
	}

}

public class P613 {
	static Random rand = new Random(47);

	// 产生随机的item对象
	static Item newItem() {
		switch (rand.nextInt(3)) {
		case 0:
			return new Paper();
		case 1:
			return new Scissors();
		case 2:
			return new Rock();
		}
		return null;
	}

	static void matchs(Item i1, Item i2) {
		System.out.println(i1 + " vs " + i2 + " : " + i1.compete(i2));
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			matchs(newItem(), newItem());
		}
	}
}
