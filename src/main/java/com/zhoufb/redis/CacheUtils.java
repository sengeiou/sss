/**  
 * File Name:CacheUtils.java  
 * Package Name:com.zhoufb.redis  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:35:01  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:CacheUtils.java  
 * Package Name:com.zhoufb.redis  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:35:01  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.redis;  

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zhoufb.redis.manager.CacheManagerFactory;

/**  
 * ClassName:CacheUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:35:01 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public abstract class CacheUtils {

	public static void initCacheManagerFactory(boolean flag) {
		CacheManagerFactory.init(flag);
	}

	public static void put(Object key, Serializable value) {
		CacheManagerFactory.getRemoteCacheManager().put(key, value);
	}

	public static void put(Object key, Object value) {
		CacheManagerFactory.getRemoteCacheManager().put(key, value);
	}

	public static void update(Object key, Serializable value) {
		CacheManagerFactory.getRemoteCacheManager().update(key, value);
	}

	public static boolean exists(Object key) {
		return CacheManagerFactory.getRemoteCacheManager().exists(key);
	}

	public static <T> T get(Class<? extends Serializable> type, Object key) {
		Serializable value = CacheManagerFactory.getRemoteCacheManager().get(
				type, key);
		return value == null ? null :(T) value;
	}

	public static <T> T getT(Class type, Object key) {
		Object value = CacheManagerFactory.getRemoteCacheManager().getT(type,
				key);
		return value == null ? null :(T) value;
	}

	public static String getValue(String key) {
		return CacheManagerFactory.getRemoteCacheManager().getValue(key);
	}

	public static List<Map<String, String>> getAllKey(String key) {
		return CacheManagerFactory.getRemoteCacheManager().getAllKey(key);
	}

	public <T> List<T> getAll(Class<? extends Serializable> type) {
		List values = CacheManagerFactory.getRemoteCacheManager().getAll(type);
		if (values == null) {
			values = CacheManagerFactory.getRemoteCacheManager().getAll(type);
		}

		return values == null ? null : values;
	}

	public <T> List<T> getAll(Class<? extends Serializable> type, List keys) {
		List values = CacheManagerFactory.getRemoteCacheManager().getAll(type,
				keys);
		if (values == null) {
			values = CacheManagerFactory.getRemoteCacheManager().getAll(type,
					keys);
		}

		return values == null ? null : values;
	}

	public static void remove(Object key) {
		CacheManagerFactory.getRemoteCacheManager().remove(key);
	}

	public static void clear() {
		CacheManagerFactory.getRemoteCacheManager().clear();
	}

	public static void clearAll() {
		CacheManagerFactory.getRemoteCacheManager().clearAll();
	}

	public static void put(Object key, Serializable value, int seconds) {
		CacheManagerFactory.getRemoteCacheManager().putex(key, value, seconds);
	}

	public static Set<String> getSet(String key) {
		return CacheManagerFactory.getRemoteCacheManager().getSet(key);
	}

	public static String getHash(String key, String field) {
		return CacheManagerFactory.getRemoteCacheManager().getHash(key, field);
	}

}
  
