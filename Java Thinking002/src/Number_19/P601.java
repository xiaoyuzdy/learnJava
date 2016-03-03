package Number_19;

import java.util.EnumSet;

/**
 * EnumSet �̳�AbstractSet��HashSet��ȷǳ��� �ŵ��� ��˵��һ��������λ�Ƿ����ʱ���и��õı������ ������long
 * 
 * @author he
 * 
 */
enum AlarmPoints {
	STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, 
	OFFICE3, OFFICE4,BATHROOM, UTILITY, KITCHEN
}

public class P601 {
	public static void main(String[] args) {
		EnumSet<AlarmPoints> enumSet =EnumSet.noneOf(AlarmPoints.class);
		enumSet.add(AlarmPoints.BATHROOM);
		enumSet.addAll(EnumSet.of(AlarmPoints.STAIR1,AlarmPoints.STAIR2, AlarmPoints.LOBBY));
		System.out.println(enumSet);
		System.out.println("-----------");
		enumSet=EnumSet.allOf(AlarmPoints.class);
		enumSet.removeAll(EnumSet.range(AlarmPoints.OFFICE1, AlarmPoints.OFFICE4));
		System.out.println(enumSet);
	}

}
