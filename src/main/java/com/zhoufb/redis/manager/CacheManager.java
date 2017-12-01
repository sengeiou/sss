/**  
 * File Name:CacheManager.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午9:40:10  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:CacheManager.java  
 * Package Name:com.zhoufb.redis.manager  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午9:40:10  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.redis.manager;  

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * ClassName:CacheManager <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午9:40:10 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: CacheManager <br/>  
 * date: 2017年12月1日 上午9:40:10 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public interface CacheManager {

	void put(Object arg0, Serializable arg1);

	void put(Object arg0, Object arg1);

	void update(Object arg0, Serializable arg1);

	boolean exists(Object arg0);

	Serializable get(Class<? extends Serializable> arg0, Object arg1);

	Object getT(Class arg0, Object arg1);

	void remove(Object arg0);

	List<Serializable> getAll(Class<? extends Serializable> arg0);

	List<Map<String, String>> getAllKey(String arg0);

	String getValue(String arg0);

	List<Serializable> getAll(Class<? extends Serializable> arg0,
			List<Object> arg1);

	void clear();

	void clearAll();

	void destory();

	void putex(Object arg0, Serializable arg1, int arg2);

	Set<String> getSet(String arg0);

	String getHash(String arg0, String arg1);

}
  
