package Number_1502;

import java.util.HashMap;
import java.util.Map;

/**
 * ÎŞ½çÍ¨Åä·û <?>
 * 
 * @author he
 * 
 */
public class P396 {
	static Map map;
	static Map<?, ?> map2;
	static Map<String, ?> map3;

	public static void setMap1(Map mapx) {
		map = mapx;
	}

	public static void setMap2(Map<?, ?> map2x) {
		map2 = map2x;
	}

	public static void setMap3(Map<String, ?> map3x) {
		map = map3x;

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		setMap1(new HashMap());
		setMap2(new HashMap());
		setMap3(new HashMap());
	}
}
