/**  
 * File Name:RCacheConfig.java  
 * Package Name:com.zhoufb.redis  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:35:43  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:RCacheConfig.java  
 * Package Name:com.zhoufb.redis  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:35:43  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.redis;  

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**  
 * ClassName:RCacheConfig <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:35:43 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: RCacheConfig <br/>  
 * date: 2017年12月1日 上午9:35:43 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
@Component
public class RCacheConfig {

	private static final Logger log = LoggerFactory.getLogger(RCacheConfig.class);
	public static String host;
	public static Integer port;
	public static String password = null;
	public static Integer maxActive;
	public static Integer maxIdle;
	public static Integer mindle;
	public static Integer maxWait;
	public static Integer timeout;
	public static Boolean testOnBorrow;
	public static Boolean testOnReturn;
/*
	private static void loadConfig(String configFile) {
		InputStream input = null;

		try {
			log.info("[loadConfig] load config file" + configFile);
			input = RCacheConfig.class.getResourceAsStream(configFile);
			Properties e = new Properties();
			e.load(input);
			host = e.getProperty("redis.host");
			port = Integer.valueOf(Integer.parseInt(e.getProperty("redis.port")));
			maxActive = Integer.valueOf(Integer.parseInt(e.getProperty("redis.maxActive")));
			maxIdle = Integer.valueOf(Integer.parseInt(e.getProperty("redis.maxIdle")));
			mindle = Integer.valueOf(Integer.parseInt(e.getProperty("redis.minIdle")));
			maxWait = Integer.valueOf(Integer.parseInt(e.getProperty("redis.maxWait")));
			timeout = Integer.valueOf(Integer.parseInt(e.getProperty("redis.timeout")));
			testOnBorrow = Boolean.valueOf(Boolean.parseBoolean(e.getProperty("redis.testOnBorrow")));
			testOnReturn = Boolean.valueOf(Boolean.parseBoolean(e.getProperty("redis.testOnReturn")));
		} catch (Exception arg10) {
			log.error("[loadConfig] load " + configFile + " faild", arg10);
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException arg9) {
					;
				}
			}

		}

	}
*/
	static {
		//loadConfig("/redisConfig.properties");
		host = "zhoufb.com";
		port = 6379;
		maxActive =500;
		maxIdle = 150;
		mindle =100;
		maxWait = 10000;
		timeout = 10000;
		testOnBorrow = true;
		testOnReturn = true;
	}

}

