package Number_1502;
/**
 * 用适配器和泛型仿真潜在类型机制
 * @author he
 *
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class SimpleQueue<T> implements Iterable<T> {
	LinkedList<T> list = new LinkedList<T>();

	public void add(T item) {
		list.add(item);
	}

	public T get() {
		return list.poll();// 获取并移除列表的第一个元素
	}

	public Iterator<T> iterator() {

		return list.iterator();
	}

}

// 需要的接口
interface Addable<T> {
	void add(T t);
}

class Ax {
	@Override
	public String toString() {

		return getClass().getName().toString();
	}
}

class Bx extends Ax {
}

class SimpleQueueSon<T> extends SimpleQueue<T> implements Addable<T> {
	@Override
	public void add(T item) {
		super.add(item);
	}
}

/**
 * 最底层的适配器类
 * 
 * @author he
 *
 */

class AddableCollectionAdapter<T> implements Addable<T> {
	private Collection<T> collection;

	public AddableCollectionAdapter(Collection<T> collection) {
		this.collection = collection;
	}
	public void add(T t) {
		collection.add(t);
	}
}
/**
 * 向外提供静态方法的类
 * @author he
 *
 */
class Adapter{
	public static<T> Addable<T> collectionAdapter(Collection<T> c){
		return new AddableCollectionAdapter<T>(c);
	}
}



class Fill2 {
	// 这样可以自己定制一些类，只要它实现了Addalbe接口，且add方法可行就能使用该方法，比如SimpleQueueSon
	public static <T> void fill(Addable<T> addable, Class<? extends T> class1Token, int size) {
		for (int i = 0; i < size; i++) {
			try {
				addable.add(class1Token.newInstance());// 向addable中添加实例
			} catch (Exception e) {
				throw new RuntimeException();// 如果捕获到异常就抛出运行时异常
			}
		}
	}
}

public class P425 {
	public static void main(String[] args) {
		List<Ax> listA = new ArrayList<Ax>();
		 Fill2.fill(new AddableCollectionAdapter<Ax>(listA), Ax.class, 3);// 没问题
		 Fill2.fill(Adapter.collectionAdapter(listA), Bx.class, 2);// 没问题

		/**
		 * SimpleQueueSon实现了Addable接口因此可以使用fill()方法
		 */
		SimpleQueueSon<Ax> sq = new SimpleQueueSon<Ax>();
		 Fill2.fill(sq, Ax.class, 3);//没问题
		 Fill2.fill(sq, Bx.class,2);//没问题
		 for(Ax c:sq)
			 System.out.println(c);//
	}
}
