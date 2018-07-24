/**  
 * File Name:TestLock.java  
 * Package Name:com.zhoufb.util.zkLock  
 * Description: (That's the purpose of the file)
 * Date:2018年7月24日上午10:36:56  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestLock.java  
 * Package Name:com.zhoufb.util.zkLock  
 * Description: That's the purpose of the file
 * Date:2018年7月24日上午10:36:56  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util.zkLock;  
/**  
 * ClassName:TestLock <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年7月24日 上午10:36:56 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TestLock <br/>  
 * date: 2018年7月24日 上午10:36:56 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TestLock {

	/** 
	 * @Title: zk 分布式锁使用 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) {
		ZKDistributedLock lock = null;
		try{
			lock = new ZKDistributedLock("唯一 id ");
			lock.lock();
		}catch(Exception e){
			System.out.println(e.getMessage());
		} finally {
			if (lock != null) {
				lock.unlock();
			}
		}
	}

}
  
