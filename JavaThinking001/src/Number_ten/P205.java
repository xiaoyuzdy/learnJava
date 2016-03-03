package Number_ten;

/**
 * œ∞Ã‚23
 * 
 * @author he
 * 
 */
interface U {
	void f1();

	void h1();

	void g1();
}

class AA {
	public U getU() {
		return new U() {

			public void f1() {
				System.out.println("A.f");

			}

			public void h1() {
				System.out.println("A.h");

			}

			public void g1() {
				System.out.println("A.g");

			}

		};
	}

}

class BB {
	U ux[];

	BB(int size) {
		ux = new U[size];
	}

	public boolean addU(U elem) {
		for (int i = 0; i < ux.length; i++) {
			if (ux[i] == null) {
				ux[i] = elem;
				return true;
			}

		}
		return false;

	}

	public boolean set_NULL(int i) {

		ux[i] = null;
		return true;

	}

	public void getUx() {

		for (int j = 0; j < ux.length; j++) {
			if (ux[j] != null) {
				ux[j].f1();
				ux[j].g1();
				ux[j].h1();
			}

		}
	}

}

public class P205 {
	public static void main(String[] args) {
		AA[] a1 = { new AA(), new AA(), new AA() };
		BB b1 = new BB(3);
		for (int i = 0; i < a1.length; i++)
			b1.addU(a1[i].getU());

		b1.getUx();
	}
}
