package Number_20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע��
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

//����ע��
public @interface UseCase {
	public int id();

	// �����ע��ĳ������ʱû�и���description ֵ ��ʹ��Ĭ��ֵ ��no description��
	public String description() default "no description";
}
