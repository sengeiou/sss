/**  
 * File Name:RedisKey.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:19:38  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:RedisKey.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:19:38  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.redis.manager;  

import java.io.Serializable;

/**  
 * ClassName:RedisKey <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:19:38 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: RedisKey <br/>  
 * date: 2017年12月1日 上午10:19:38 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class RedisKey implements Serializable{

	private String type;
	private String key;

	public RedisKey() {
	}

	public RedisKey(String type, String key) {
		this.type = type;
		this.key = key;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKey() {
		return this.key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
  
