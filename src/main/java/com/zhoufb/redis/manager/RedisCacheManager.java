/**  
 * File Name:RedisCacheManager.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:51:19  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:RedisCacheManager.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:51:19  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.redis.manager;  


import com.fasterxml.jackson.core.JsonProcessingException;
import com.zhoufb.redis.RCacheConfig;
import com.zhoufb.util.JsonUtils;
import com.zhoufb.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**  
 * ClassName:RedisCacheManager <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:51:19 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: RedisCacheManager <br/>  
 * date: 2017年12月1日 上午9:51:19 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
@Component("redisCacheManager")
public class RedisCacheManager implements CacheManager{

	private static Logger logger = LoggerFactory
			.getLogger(RedisCacheManager.class);
	private static volatile RedisCacheManager singleton;
	private static JedisPool jedisPool = null;

	public static RedisCacheManager getSingleton() {
		if (singleton == null) {
			Class arg = RedisCacheManager.class;
			synchronized (RedisCacheManager.class) {
				if (singleton == null) {
					singleton = new RedisCacheManager();
				}
			}
		}

		return singleton;
	}

	public void put(Object key, Serializable value) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString(key);
			jedis.set(e, JsonUtils.writer().writeValueAsString(value));
		} catch (Exception arg7) {
			logger.error("缓存添加数据异常：" + arg7.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

	}

	public void update(Object key, Serializable value) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString(key);
			jedis.set(e, JsonUtils.writer().writeValueAsString(value));
		} catch (JsonProcessingException arg7) {
			logger.error("缓存UPDATE数据异常：" + arg7.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

	}

	public boolean exists(Object key) {
		Jedis jedis = this.getJedis();

		boolean arg4;
		try {
			String e = this.writeAsString(key);
			Boolean flag1 = jedis.exists(e);
			if (null == flag1 || !flag1.booleanValue()) {
				arg4 = false;
				return arg4;
			}

			arg4 = true;
		} catch (JsonProcessingException arg8) {
			this.broken(jedis);
			boolean flag = false;
			return flag;
		} finally {
			this.release(jedis);
		}

		return arg4;
	}

	public Serializable get(Class<? extends Serializable> type, Object key) {
		Jedis jedis = this.getJedis();

		Serializable arg5;
		try {
			String value;
			try {
				String e = this.writeAsString(key);
				value = jedis.get(e);
				if (!StringUtils.isEmpty(value)) {
					arg5 = (Serializable) JsonUtils.reader().readValue(value,
							type);
					return arg5;
				}

				arg5 = null;
			} catch (Exception arg9) {
				logger.error("缓存GET数据异常：" + arg9.getMessage());
				this.broken(jedis);
				value = null;
				return value;
			}
		} finally {
			this.release(jedis);
		}

		return arg5;
	}

	private String writeAsString(Object key) throws JsonProcessingException {
		String redisKey;
		if (key instanceof String) {
			redisKey = key.toString();
		} else {
			redisKey = JsonUtils.writer().writeValueAsString(key);
		}

		return redisKey;
	}

	public void remove(Object key) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString(key);
			jedis.del(e);
		} catch (Exception arg6) {
			logger.error("缓存remove数据异常：" + arg6.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

	}

	public List<Serializable> getAll(Class<? extends Serializable> type) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString("*");
			Set keys = jedis.keys(e);
			if (keys == null || keys.size() <= 0) {
				return null;
			} else {
				ArrayList result = new ArrayList();
				Iterator iter = keys.iterator();

				while (iter.hasNext()) {
					String key = (String) iter.next();
					String value = jedis.get(key);
					result.add(StringUtils.isBlank(value)
							? null
							: (Serializable) JsonUtils.reader().readValue(
									value, type));
				}

				ArrayList key1 = result;
				return key1;
			}
		} catch (Exception arg11) {
			logger.error("缓存GETALL数据异常：" + arg11.getMessage());
			this.broken(jedis);
			return null;
		} finally {
			this.release(jedis);
		}
	}

	public List<Serializable> getAll(Class<? extends Serializable> type,
			List<Object> keys) {
		Jedis jedis = this.getJedis();

		Iterator iter;
		try {
			if (keys == null || keys.size() <= 0) {
				return null;
			}

			ArrayList e = new ArrayList();
			iter = keys.iterator();

			while (iter.hasNext()) {
				Object key = iter.next();
				if (key != null) {
					String value = jedis.get(this.writeAsString(key));
					e.add(StringUtils.isBlank(value)
							? null
							: (Serializable) JsonUtils.reader().readValue(
									value, type));
				}
			}

			ArrayList key1 = e;
			return key1;
		} catch (Exception arg10) {
			logger.error("缓存GETALL_KEYS数据异常：" + arg10.getMessage());
			this.broken(jedis);
			iter = null;
		} finally {
			this.release(jedis);
		}

		return (List<Serializable>) iter;
	}

	public void clear() {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString("*");
			Set keys = jedis.keys(e);
			if (keys != null && keys.size() > 0) {
				String[] arr = new String[keys.size()];
				jedis.del((String[]) keys.toArray(arr));
			}
		} catch (Exception arg7) {
			logger.error("缓存clear异常：" + arg7.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

	}

	public void clearAll() {
		Jedis jedis = this.getJedis();

		try {
			jedis.flushDB();
		} finally {
			this.release(jedis);
		}

	}

	public void destory() {
	}

	private RedisKey getRedisKey(Object key) throws JsonProcessingException {
		return new RedisKey("REDIS", JsonUtils.writer().writeValueAsString(key));
	}

	public boolean jedisIsConnected() {
		boolean flag = false;
		Jedis jedis = null;

		try {
			if (null == jedisPool) {
				logger.info("创建远程缓存连接池");
				initRedisPool();
			}

			jedis = jedisPool.getResource();
			flag = true;
		} catch (Exception arg6) {
			logger.error("远程缓存连接失败(redis connect error)" + arg6.getMessage());
			this.broken(jedis);
			flag = false;
		} finally {
			this.release(jedis);
		}

		return flag;
	}

	private Jedis getJedis() {
		Jedis jedis = null;

		try {
			if (null == jedisPool) {
				logger.info("创建远程缓存连接池");
				initRedisPool();
			}

			jedis = jedisPool.getResource();
		} catch (Exception arg2) {
			logger.error("获取远程缓存连接池失败" + arg2.getMessage());
			this.broken(jedis);
		}

		return jedis;
	}

	private void broken(Jedis jedis) {
		if (null != jedis && null != jedisPool) {
			jedisPool.returnBrokenResource(jedis);
		}

	}

	private void release(Jedis jedis) {
		if (null != jedis && null != jedisPool) {
			jedisPool.returnResource(jedis);
		}

	}

	public static synchronized void initRedisPool() {
		logger.info("开始初始化缓存连接池");

		try {
			JedisPoolConfig e = new JedisPoolConfig();
			e.setMaxTotal(RCacheConfig.maxActive.intValue());
			e.setMaxIdle(RCacheConfig.maxIdle.intValue());
			e.setMinIdle(RCacheConfig.mindle.intValue());
			e.setMaxWaitMillis((long) RCacheConfig.maxWait.intValue());
			e.setTestOnBorrow(RCacheConfig.testOnBorrow.booleanValue());
			e.setTestOnReturn(RCacheConfig.testOnBorrow.booleanValue());
			jedisPool = new JedisPool(e, RCacheConfig.host,
					RCacheConfig.port.intValue(),
					RCacheConfig.timeout.intValue(), RCacheConfig.password);
			logger.info("初始化完成缓存连接池");
		} catch (Exception arg0) {
			logger.error("初始化失败缓存连接池" + arg0.getMessage());
		}

	}

	public static void main(String[] args) {
		getSingleton().getJedis();
	}

	public void put(Object key, Object value) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString(key);
			jedis.set(e, JsonUtils.writer().writeValueAsString(value));
		} catch (Exception arg7) {
			logger.error("缓存PUT数据异常：" + arg7.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

	}

	public Object getT(Class type, Object key) {
		Jedis jedis = this.getJedis();

		Object arg5;
		try {
			String value;
			try {
				String e = this.writeAsString(key);
				value = jedis.get(e);
				if (StringUtils.isEmpty(value)) {
					arg5 = null;
					return arg5;
				}

				arg5 = JsonUtils.reader().readValue(value, type);
			} catch (Exception arg9) {
				logger.error("缓存GETT数据异常：" + arg9.getMessage());
				arg9.printStackTrace();
				this.broken(jedis);
				value = null;
				return value;
			}
		} finally {
			this.release(jedis);
		}

		return arg5;
	}

	public List<Map<String, String>> getAllKey(String keyStr) {
		Jedis jedis = this.getJedis();

		try {
			if (!StringUtils.isBlank(keyStr) && !"null".equals(keyStr)) {
				keyStr = keyStr + "*";
			}

			String e = this.writeAsString("*" + keyStr);
			Set keys = jedis.keys(e);
			HashMap map = null;
			if (keys == null || keys.size() <= 0) {
				return null;
			} else {
				ArrayList result = new ArrayList();
				Iterator iter = keys.iterator();

				while (iter.hasNext()) {
					map = new HashMap();
					String key = (String) iter.next();
					Long expire = jedis.ttl(key);
					map.put("key", key);
					map.put("expire", String.valueOf(expire));
					result.add(map);
				}

				ArrayList key1 = result;
				return key1;
			}
		} catch (Exception arg12) {
			logger.error("缓存getAllKey数据异常：" + arg12.getMessage());
			this.broken(jedis);
			return null;
		} finally {
			this.release(jedis);
		}
	}

	public String getValue(String key) {
		Jedis jedis = this.getJedis();

		String arg3;
		try {
			String e = this.writeAsString(key);
			arg3 = jedis.get(e);
			return arg3;
		} catch (Exception arg7) {
			logger.error("缓存getValue数据异常：" + arg7.getMessage());
			arg7.printStackTrace();
			this.broken(jedis);
			arg3 = null;
		} finally {
			this.release(jedis);
		}

		return arg3;
	}

	public void putex(Object key, Serializable value, int seconds) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString(key);
			jedis.setex(e, seconds, JsonUtils.writer()
					.writeValueAsString(value));
		} catch (Exception arg8) {
			logger.error("设置数据异常：" + arg8.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

	}

	public Set<String> getSet(String key) {
		Jedis jedis = this.getJedis();

		try {
			this.writeAsString(key);
			Set rs = jedis.hkeys(key);
			Set arg4 = rs;
			return arg4;
		} catch (Exception arg8) {
			logger.error("设置数据异常：" + arg8.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

		return null;
	}

	public String getHash(String key, String field) {
		Jedis jedis = this.getJedis();

		try {
			String e = this.writeAsString(key);
			String rs = jedis.hget(e, field);
			String arg5 = rs;
			return arg5;
		} catch (Exception arg9) {
			logger.error("设置数据异常：" + arg9.getMessage());
			this.broken(jedis);
		} finally {
			this.release(jedis);
		}

		return null;
	}

}
  
