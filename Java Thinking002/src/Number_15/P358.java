package Number_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RandomList
 * 
 * @author he
 * @param <T>
 * 
 */
public class P358<T> {
	private List<T> list = new ArrayList<T>();
	Random rand = new Random(47);

	public void add(T ele) {
		list.add(ele);
	}

	public T select() {
		return list.get(rand.nextInt(list.size()));
	}

	public static void main(String[] args) {
		P358 <String> s=new P358<String>();
		for(String ss: "hello every body happy new year".split(" ")){
			s.add(ss);
		}
		for (int i = 0; i <11 ; i++) {
			System.out.println(s.select());
		}
		
	}
}
