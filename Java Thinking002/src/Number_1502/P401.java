package Number_1502;

/**
 * 练习31
 * 
 * @author he
 * 
 */

// interface Payable<T>{}
// class Employee implements Payable<Employee>{}
// 此处编译器通不过与书中不同
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
