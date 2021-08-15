package uz.bcgroup.sample.decathlon.util;

import java.math.BigDecimal;

public class NumberUtil {

	public static BigDecimal parseBigDecimal(String str) {
		return new BigDecimal(String.valueOf(str).trim());
	}
	
	public static BigDecimal parseBigDecimal(Integer intVal) {
		return new BigDecimal(intVal);
	}
}
