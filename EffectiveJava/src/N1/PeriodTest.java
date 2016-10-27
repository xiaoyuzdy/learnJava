package N1;

import java.util.Date;

/**
 * P159
 * @author he
 *
 */
final class Period {
	private final Date start; 
	private final Date end;
	
	
//	public Period(Date start,Date end) {
//		if(start.compareTo(end)>0)
//			throw new IllegalArgumentException(start+" after "+end);
//		this.start=start;//虽然指向实例的引用不能被修改，但是Date本身的实例中的数据可以修改
//		this.end=end;
//	}
	
	/**
	 * 因此使用保护性拷贝,这样外部类就不发对内部使用的Date进行修改
	 * @return
	 */
	
	public Period(Date start,Date end) {
		this.start=new Date(start.getTime());
		this.end=new Date(start.getTime());
		if(this.start.compareTo(this.end)>0)
			throw new IllegalArgumentException(start+" after "+end);
	}
	
	
	
	
	public Date getStart(){
		return new Date(start.getTime());//防止在Period类的内部篡改数据
	}
	
	public Date getEnd(){
		return new Date(end.getTime());
	}
	
}


public class PeriodTest{
	public static void main(String[] args) {
		Date start=new Date();
		Date end=new Date();
		Period period=new Period(start,end);
	//	period.start=new Date();//引用指向不能被修改
		start.setTime(0);//Date类本身能修改
	}
	
}


