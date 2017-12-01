/**  
 * File Name:RedisTest.java  
 * Package Name:com.zhoufb.test  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:54:17  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:RedisTest.java  
 * Package Name:com.zhoufb.test  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:54:17  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.test;  

import com.zhoufb.model.sys.SystemUserInfoT;
import com.zhoufb.redis.CacheUtils;

/**  
 * ClassName:RedisTest <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:54:17 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: RedisTest <br/>  
 * date: 2017年12月1日 上午10:54:17 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class RedisTest {

	/** 
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) {

		SystemUserInfoT userInfoT = CacheUtils.get(SystemUserInfoT.class, "5673285f309c49c985906972cfb0c5ef");
		System.out.println(userInfoT.getName());

	}

}
  
