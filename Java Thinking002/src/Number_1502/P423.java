package Number_1502;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ����collection ��Ӷ���
 * 
 * @author he
 * 
 */

class Contract {
	private static int count = 0;//��̬������������  ��������ʱ��ʼ����
	private final int id = count++;

	@Override
	public String toString() {

		return getClass().getSimpleName() + " " + id;
	}
}

class Fill {
	// ��ָ�����͵�ʵ����ӵ�collection������
	static <T> void fill(Collection<T> collection, Class<? extends T> obj,
			int size) throws InstantiationException, IllegalAccessException {
		for (int i = 0; i < size; i++) {
			collection.add(obj.newInstance());
		}

	}

}

public class P423 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		List<Contract> list=new ArrayList<Contract>();
		Fill.fill(list,Contract.class, 3);
		for (Contract contract : list) {
			System.out.println(contract);
		}
		
	}
	
}
