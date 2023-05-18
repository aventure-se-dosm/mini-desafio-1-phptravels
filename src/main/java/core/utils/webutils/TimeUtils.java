package core.utils.webutils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils {

	/**
	 * deixar essas config aqui não parece legal: não deveria ser uma config 'de
	 * regra de negócio"? resolve as do core primeiro, mas pensa nisso depois!
	 */
	private final String DATE_TIME_FORMAT_STRING = "dd_MM_YYYY_HH_mm_ss";

	private DateTimeFormatter DEFAULT_DATE_TIME_FORMAT = DateTimeFormatter
	        .ofPattern(DATE_TIME_FORMAT_STRING);

	public String getFormattedDateTimeNow() {
		return getFormattedDateTime(DEFAULT_DATE_TIME_FORMAT,
		        LocalDateTime.now());
	}

	public String getFormattedDateTime(DateTimeFormatter dateTimeFormat,
	        LocalDateTime localDateTime) {
		return localDateTime.format(dateTimeFormat);
	}

	public String getFormattedDateTime(String formatString) {
		return LocalDateTime.now()
		        .format(DateTimeFormatter.ofPattern(formatString));
	}

}
