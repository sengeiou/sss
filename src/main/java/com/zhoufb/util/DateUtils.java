/**  
 * File Name:DateUtils.java  
 * Package Name:com.zhoufb.util  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:03:58  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:DateUtils.java  
 * Package Name:com.zhoufb.util  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:03:58  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util;  
/**  
 * ClassName:DateUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:03:58 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class DateUtils {

	public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final Locale DEFAULT_LOCALE;
	private static final String[] sADatePatterns;

	public static Date pownerParseDate(String sPDateStr) throws ParseException {
		int i = 0;

		while (i < sADatePatterns.length) {
			try {
				SimpleDateFormat oFmt = new SimpleDateFormat(sADatePatterns[i]);
				Date oDate = oFmt.parse(sPDateStr);
				return oDate;
			} catch (Exception arg3) {
				++i;
			}
		}

		throw new ParseException("can\'t parse date:" + sPDateStr, 0);
	}

	public static Date getCurrent() {
		return new Date(System.currentTimeMillis());
	}

	public static String formatDate(Date Date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",
				DEFAULT_LOCALE);
		return sdf.format(Date);
	}

	public static String formatTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", DEFAULT_LOCALE);
		return sdf.format(date);
	}

	public static String formatDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				DEFAULT_LOCALE);
		return sdf.format(date);
	}

	public static String formatDateTime(Calendar calendar, String format,
			Locale locale) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
		return sdf.format(calendar.getTime());
	}

	public static String formatDateTime(Date date, String format, Locale locale) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, locale);
		return sdf.format(date);
	}

	public static String getCurrentDate() {
		return formatDateTime(getCurrent(), "yyyy-MM-dd", DEFAULT_LOCALE);
	}

	public static String getCurrentTime() {
		return formatDateTime(getCurrent(), "HH:mm:ss", DEFAULT_LOCALE);
	}

	public static String getCurrentDateTime() {
		return formatDateTime(getCurrent(), "yyyy-MM-dd HH:mm:ss",
				DEFAULT_LOCALE);
	}

	public static Timestamp getTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static Timestamp getTimestamp(long time) {
		return new Timestamp(time);
	}

	public static Timestamp getCurrentTimestamp() {
		return new Timestamp(getCurrent().getTime());
	}

	public static Date getDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}

	public static long getTime(Date date) {
		return date.getTime();
	}

	public static Date parseDateTime(String format, Locale locale, String str) {
		SimpleDateFormat sdf = new SimpleDateFormat(format, locale);

		try {
			return sdf.parse(str);
		} catch (ParseException arg4) {
			return null;
		}
	}

	public static Date parseDateTime(String str) {
		return parseDateTime("yyyy-MM-dd HH:mm:ss", DEFAULT_LOCALE, str);
	}

	public static Date parseDate(String str) {
		return parseDateTime("yyyy-MM-dd", DEFAULT_LOCALE, str);
	}

	public static Date parseTime(String str) {
		return parseDateTime("HH:mm:ss", DEFAULT_LOCALE, str);
	}

	public static String getMonthStart(Date date, String format) {
		Calendar localTime = Calendar.getInstance(DEFAULT_LOCALE);
		localTime.setTime(date);
		localTime.set(5, 1);
		return formatDateTime(localTime, format, DEFAULT_LOCALE);
	}

	public static String getMonthEnd(Date date, String format) {
		Calendar localTime = Calendar.getInstance(DEFAULT_LOCALE);
		localTime.setTime(date);
		localTime.add(2, 1);
		localTime.set(5, 1);
		localTime.add(5, -1);
		return formatDateTime(localTime, format, DEFAULT_LOCALE);
	}

	public static String addDateTime(Date date, int calendarField, int amount,
			String format) {
		Calendar localTime = Calendar.getInstance(DEFAULT_LOCALE);
		localTime.setTime(date);
		localTime.add(calendarField, amount);
		return formatDateTime(localTime, format, DEFAULT_LOCALE);
	}

	public static int comparaDateTime(Date src, Date dst) {
		return src.compareTo(dst);
	}

	public static Date truncateTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		return cal.getTime();
	}

	public static java.sql.Date transfer2SqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	public static Timestamp transfer2Timestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public static Date AddDate(Date date, int DateField, int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(DateField, num);
		return cal.getTime();
	}

	public static void main(String[] args) {
	}

	static {
		DEFAULT_LOCALE = Locale.CHINA;
		sADatePatterns = new String[]{"yyyy-MM-dd HH:mm:ss",
				"yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
				"MM/dd/yyyy HH:mm:ss", "yyyy.MM.dd HH:mm:ss", "yyyy-MM-dd",
				"yyyy/MM/dd", "MM/dd/yyyy", "yyyy.MM.dd"};
	}

}
  
