package Number_20;

/**
 * ע�� ��һ���̶��ϰ�Ԫ������Ԫ�����ļ������һ��
 * 
 * @author he
 *
 */

public class P622 {
	@UseCase(id = 47, description = "password must contain at least one numeric")
	public boolean Password(String password) {
		return (password.matches("\\w*\\d\\w*"));
	}

	@UseCase(id = 48)
	public String encryptPassword(String password) {
		return new StringBuilder(password).reverse().toString();
	}

}
