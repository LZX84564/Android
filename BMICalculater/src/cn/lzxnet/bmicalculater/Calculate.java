package cn.lzxnet.bmicalculater;

import java.math.BigDecimal;

public class Calculate {

	public static StringBuffer BmiCalculate(double weight,double height) {
		double bmi = weight / height / height;
		/*
		 * 对double型数据保留两位小数便于输出
		 */
		BigDecimal b = new BigDecimal(bmi);   
				bmi = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();  
		/*
		 * 对BMI值输出并分析健康状况
		 */
		StringBuffer str = new StringBuffer("你的BMI指数为");
		str.append(bmi+"\n你的健康状况为");
		if (bmi < 18.5) {
			str.append("过轻");

		} else if (bmi < 25) {
			str.append("适中");
		} else if (bmi < 30) {
			str.append("过重");
		}
		else if (bmi < 35) {
			str.append("肥胖");
		}
		else {
			str.append("非常肥胖");
		}
			return str;
	}
}
