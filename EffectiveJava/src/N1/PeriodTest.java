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
//		this.start=start;//��Ȼָ��ʵ�������ò��ܱ��޸ģ�����Date�����ʵ���е����ݿ����޸�
//		this.end=end;
//	}
	
	/**
	 * ���ʹ�ñ����Կ���,�����ⲿ��Ͳ������ڲ�ʹ�õ�Date�����޸�
	 * @return
	 */
	
	public Period(Date start,Date end) {
		this.start=new Date(start.getTime());
		this.end=new Date(start.getTime());
		if(this.start.compareTo(this.end)>0)
			throw new IllegalArgumentException(start+" after "+end);
	}
	
	
	
	
	public Date getStart(){
		return new Date(start.getTime());//��ֹ��Period����ڲ��۸�����
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
	//	period.start=new Date();//����ָ���ܱ��޸�
		start.setTime(0);//Date�౾�����޸�
	}
	
}


