package Number_1502;

/**
 * ��ϰ31
 * 
 * @author he
 * 
 */

// interface Payable<T>{}
// class Employee implements Payable<Employee>{}
// �˴�������ͨ���������в�ͬ
// class Hourly extends Employee implements Payable<Hourly>{}

interface Payable<T> {
}

class Employee implements Payable {
}

class Hourly extends Employee implements Payable {
}

public class P401 {
	public static void main(String[] args) {
		new Employee();
		new Hourly();
	}

}
