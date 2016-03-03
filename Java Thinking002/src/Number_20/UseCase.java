package Number_20;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注释
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)

//定义注解
public @interface UseCase {
	public int id();

	// 如果在注解某个方法时没有给定description 值 则使用默认值 “no description”
	public String description() default "no description";
}
