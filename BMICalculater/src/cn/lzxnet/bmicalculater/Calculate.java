package cn.lzxnet.bmicalculater;

import java.math.BigDecimal;

public class Calculate {

	public static StringBuffer BmiCalculate(double weight,double height) {
		double bmi = weight / height / height;
		/*
		 * ��double�����ݱ�����λС���������
		 */
		BigDecimal b = new BigDecimal(bmi);   
				bmi = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		/*
		 * ��BMIֵ�������������״��
		 */
		StringBuffer str = new StringBuffer("���BMIָ��Ϊ");
		str.append(bmi+"\n��Ľ���״��Ϊ");
		if (bmi < 18.5) {
			str.append("����");

		} else if (bmi < 25) {
			str.append("����");
		} else if (bmi < 30) {
			str.append("����");
		}
		else if (bmi < 35) {
			str.append("����");
		}
		else {
			str.append("�ǳ�����");
		}
			return str;
	}
}
