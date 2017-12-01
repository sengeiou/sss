/**  
 * File Name:StringUtils.java  
 * Package Name:com.zhoufb.util  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:46:32  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:StringUtils.java  
 * Package Name:com.zhoufb.util  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:46:32  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util;  

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**  
 * ClassName:StringUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:46:32 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: StringUtils <br/>  
 * date: 2017年12月1日 上午9:46:32 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class StringUtils {

	public static boolean isEmpty(String s) {
		return s == null || s.length() == 0;
	}

	public static boolean isBlank(String s) {
		return s == null || s.trim().length() == 0;
	}

	public static Object firstNotNull(Object a, Object b) {
		return a == null ? b : a;
	}

	public static String toUnderlineName(String s) {
		if (s == null) {
			return null;
		} else {
			String regexStr = "[A-Z]";
			Matcher matcher = Pattern.compile(regexStr).matcher(s);
			StringBuffer sb = new StringBuffer();

			while (matcher.find()) {
				String g = matcher.group();
				matcher.appendReplacement(sb, "_" + g.toLowerCase());
			}

			matcher.appendTail(sb);
			if (sb.charAt(0) == 95) {
				sb.delete(0, 1);
			}

			return sb.toString();
		}
	}

	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		} else {
			StringBuilder sb = new StringBuilder(s);
			Matcher mc = Pattern.compile("_").matcher(s);
			int i = 0;

			while (mc.find()) {
				int position = mc.end() - i++;
				sb.replace(position - 1, position + 1,
						sb.substring(position, position + 1).toUpperCase());
			}

			return sb.toString();
		}
	}

	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String addZeroForNum(String str, int strLength) {
		int strLen = str.length();
		if (strLen < strLength) {
			while (strLen < strLength) {
				StringBuffer sb = new StringBuffer();
				sb.append("0").append(str);
				str = sb.toString();
				strLen = str.length();
			}
		}

		return str;
	}

}
  
