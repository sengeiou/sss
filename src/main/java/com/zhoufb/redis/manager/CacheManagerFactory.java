/**  
 * File Name:CacheManagerFactory.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:39:30  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:CacheManagerFactory.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:39:30  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.redis.manager;  
/**  
 * ClassName:CacheManagerFactory <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:39:30 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: CacheManagerFactory <br/>  
 * date: 2017年12月1日 上午9:39:30 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public abstract class CacheManagerFactory {

	static boolean jedisIsConnected = false;

	public static void init(boolean flag) {
		if (flag && jedisIsConnected) {
			jedisIsConnected = RedisCacheManager.getSingleton()
					.jedisIsConnected();
			System.out.println("RemoteCache check ---- " + jedisIsConnected);
		} else if (!flag) {
			jedisIsConnected = RedisCacheManager.getSingleton()
					.jedisIsConnected();
		}

	}

	public static void check() {
		if (jedisIsConnected) {
			jedisIsConnected = RedisCacheManager.getSingleton()
					.jedisIsConnected();
		}

	}

	public static CacheManager getRemoteCacheManager() {
		return (CacheManager) (jedisIsConnected ? RedisCacheManager
				.getSingleton() : getLocalCacheManager());
	}

	public static CacheManager getLocalCacheManager() {
		return LocalCacheManager.getSingleton();
	}

	static {
		init(false);
	}

}
  
