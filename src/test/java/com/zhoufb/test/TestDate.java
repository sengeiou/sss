/**  
 * File Name:TestDate.java  
 * Package Name:com.zhoufb.test  
 * Description: (That's the purpose of the file)
 * Date:2017年12月21日下午4:36:00  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestDate.java  
 * Package Name:com.zhoufb.test  
 * Description: That's the purpose of the file
 * Date:2017年12月21日下午4:36:00  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.test;  

import java.text.SimpleDateFormat;
import java.util.Date;

/**  
 * ClassName:TestDate <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月21日 下午4:36:00 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class TestDate {

	
	public static void main(String[] args) {
	/*	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HHmmss");
		 System.out.println(sdf.format(new Date()));
		 
		 String url="https://item.m.jd.com/product/2680560.html?utm_source=iosapp&utm_medium=appshare&utm_campaign=t_335139774&utm_term=Wxfriends";
		System.out.println( url.split(".html")[0]);
		String st= url.split(".html")[0];
		System.out.println(st.split("/")[4]);*/
		
		String p1="19.80";
		String p2="2.0";
		System.out.println(Double.parseDouble(p1)*Double.parseDouble(p2)/100+"");
		 
	}

}
  
