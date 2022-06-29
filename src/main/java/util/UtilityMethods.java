package util;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class UtilityMethods {

	public static String currentdatetime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
}
