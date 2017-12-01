/**  
 * File Name:TestConsumerImpl.java  
 * Package Name:com.zhoufb.consumer.impl  
 * Description: (That's the purpose of the file)
 * Date:2017年11月28日下午1:17:10  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestConsumerImpl.java  
 * Package Name:com.zhoufb.consumer.impl  
 * Description: That's the purpose of the file
 * Date:2017年11月28日下午1:17:10  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.consumer.impl;  

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhoufb.consumer.service.TestConsumer;
import com.zhoufb.service.TestService;

/**  
 * ClassName:TestConsumerImpl <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月28日 下午1:17:10 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TestConsumerImpl <br/>  
 * date: 2017年11月28日 下午1:17:10 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
@Service("test")
public class TestConsumerImpl implements TestConsumer{

	private Logger logger =LoggerFactory.getLogger(TestConsumerImpl.class);
	
	@Autowired
	private TestService testService;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Map<String, Object> test() {
		Map<String, Object> resultMap=new HashMap<String, Object>();
		logger.info("sdfasd","一顿log");
		resultMap.put("zhoufb", testService.selectByPrimaryKey("335ED3AEFE014DE585FC2D244DD6D3C2").getPayName());
		return resultMap;
	}

}
  
