package N1;
/**
 * P11 Builderģʽ
 * ����˼�룺ʹ��һ���ڲ��ࣨBuilder�����ⲿ�ࣨBuilderPattern���ĳ�Ա�������и�ֵ�����ڱ�ѡ�Ĳ���ͨ���ڲ���Ĺ��������и���ֵ��
 * ���ڿ�ѡ����ͨ��������set�������и���
 * @author he
 *
 */
public class BuilderPattern {
	private final int requiredParam1;//��ѡ����
	private final int requiredParam2;
	private final int optionalParam1;//��ѡ����
	private final int optionalParam2;
	private final int optionalParam3;
	
	public  static class Builder{
		private final int requiredParam1;//��ѡ����
		private final int requiredParam2;
		
		private int optionalParam1;//��ѡ����
		private int optionalParam2;
		private int optionalParam3;
		
		public Builder(int rq1,int rq2) {
			requiredParam1=rq1;
			requiredParam2=rq2;
		}
		
		//������JavaBean��set���������������������ڲ���
		
		public Builder op1(int op1){
			optionalParam1=op1;
			return this;
		}
		
		public Builder op2(int op2){
			optionalParam2=op2;
			return this;
		}
		public Builder op3(int op3){
			optionalParam3=op3;
			return this;
		}
		
	
		public BuilderPattern build(){
			return new BuilderPattern(this);
		}
		
	}
	
	
	private BuilderPattern(Builder builder){
		requiredParam1=builder.requiredParam1;
		requiredParam2=builder.requiredParam2;
		optionalParam1=builder.optionalParam1;
		optionalParam2=builder.optionalParam2;
		optionalParam3=builder.optionalParam3;
	}
	
	
	public static void main(String[] args) {
		BuilderPattern p1=new BuilderPattern.Builder(1, 2).op1(3).op2(4).build();
	}
	
	
	

}
