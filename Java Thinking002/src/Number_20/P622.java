package Number_20;

/**
 * 注解 在一定程度上把元数据与元代码文件结合在一起
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
