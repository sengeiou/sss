/**  
 * File Name:LocalCacheManager.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:40:41  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:LocalCacheManager.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:40:41  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.redis.manager;  

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhoufb.util.JsonUtils;
import com.zhoufb.util.StringUtils;

/**  
 * ClassName:LocalCacheManager <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:40:41 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: LocalCacheManager <br/>  
 * date: 2017年12月1日 上午9:40:41 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class LocalCacheManager implements CacheManager{

	private static Logger logger = LoggerFactory
			.getLogger(LocalCacheManager.class);
	private static Map<Object, Object> localCacheMap = new ConcurrentHashMap();
	private static volatile LocalCacheManager singleton;

	public static LocalCacheManager getSingleton() {
		if (singleton == null) {
			Class arg = LocalCacheManager.class;
			synchronized (LocalCacheManager.class) {
				if (singleton == null) {
					singleton = new LocalCacheManager();
				}
			}
		}

		return singleton;
	}

	public void put(Object key, Serializable value) {
		localCacheMap.put(key, value);
	}

	public void put(Object key, Object value) {
		localCacheMap.put(key, value);
	}

	public void update(Object key, Serializable value) {
		localCacheMap.put(key, value);
	}

	public boolean exists(Object key) {
		return localCacheMap.containsKey(key);
	}

	public Serializable get(Class<? extends Serializable> type, Object key) {
		return localCacheMap.containsKey(key) ? (Serializable) type
				.cast(localCacheMap.get(key)) : null;
	}

	public Object getT(Class type, Object key) {
		return localCacheMap.containsKey(key) ? localCacheMap.get(key) : null;
	}

	public void remove(Object key) {
		if (localCacheMap.containsKey(key)) {
			localCacheMap.remove(key);
		}

	}

	public List<Serializable> getAll(Class<? extends Serializable> type) {
		return null;
	}

	public List<Serializable> getAll(Class<? extends Serializable> type,
			List<Object> keys) {
		return null;
	}

	public void clear() {
		localCacheMap.clear();
	}

	public void clearAll() {
		localCacheMap.clear();
	}

	public void destory() {
	}

	public List<Map<String, String>> getAllKey(String keyStr) {
		Set set = localCacheMap.keySet();
		Iterator it = set.iterator();

		try {
			ArrayList e = new ArrayList();
			HashMap map = null;

			while (true) {
				while (it.hasNext()) {
					map = new HashMap();
					String key = (String) it.next();
					if (!StringUtils.isBlank(keyStr) && key.contains(keyStr)) {
						map.put("key", key);
						e.add(map);
					} else if (StringUtils.isBlank(keyStr)) {
						map.put("key", key);
						e.add(map);
					}
				}

				return e;
			}
		} catch (Exception arg6) {
			arg6.printStackTrace();
			return null;
		}
	}

	public String getValue(String key) {
		if (localCacheMap.containsKey(key)) {
			Object obj = localCacheMap.get(key);
			if (obj instanceof String) {
				return obj.toString();
			}

			try {
				return JsonUtils.writer().writeValueAsString(
						localCacheMap.get(key));
			} catch (JsonProcessingException arg3) {
				System.out.println("缓存对象转换异常");
				arg3.printStackTrace();
			}
		}

		return null;
	}

	public void putex(Object key, Serializable value, int seconds) {
		localCacheMap.put(key, value);
	}

	public Set<String> getSet(String key) {
		return null;
	}

	public String getHash(String key, String field) {
		return null;
	}

}
  
