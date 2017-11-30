/**  
 * File Name:TestTaskConsumer.java  
 * Package Name:com.zhoufb.task  
 * Description: (That's the purpose of the file)
 * Date:2017年11月30日下午5:48:57  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:TestTaskConsumer.java  
 * Package Name:com.zhoufb.task  
 * Description: That's the purpose of the file
 * Date:2017年11月30日下午5:48:57  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.consumer.task;  

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**  
 * ClassName:TestTaskConsumer <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月30日 下午5:48:57 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
@Configuration
@EnableScheduling
@Service("TestTaskConsumer")
public class TestTaskConsumer {
	
	private Logger logger =LoggerFactory.getLogger(TestTaskConsumer.class);
	
	@Scheduled(fixedRate = 500*60) 
	public void reportCurrentTime(){
		System.out.println("sdags");
		logger.info("sdgags");
	}
}

