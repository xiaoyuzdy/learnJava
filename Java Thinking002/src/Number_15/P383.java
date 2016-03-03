package Number_15;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class P383 {
	private static Pattern pattern = Pattern.compile("\\w+\\.");

	public static void getMethods(Class<?> t) throws SecurityException,
			InstantiationException, IllegalAccessException {
		Method[] method = t.newInstance().getClass().getMethods();
		for (Method method2 : method) {
			System.out.println(pattern.matcher(method2.toString()).replaceAll(
					""));
		}

	}

	public static Object getObject(Class<?> T) throws InstantiationException,
			IllegalAccessException {
		return T.newInstance();
	}

	public static void main(String[] args) throws SecurityException,
			InstantiationException, IllegalAccessException {
		getMethods(TreeMap.class);
		System.out.println("-------------------------");
	    ArrayList list= (ArrayList) getObject(ArrayList.class);
	    list.add("aa");
	    System.out.println(list);
	    
	}
}
