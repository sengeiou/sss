/**  
 * File Name:TestOneComsumer.java  
 * Package Name:com.zhoufb  
 * Description: (That's the purpose of the file)
 * Date:2017年11月21日下午2:17:07  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestOneComsumer.java  
 * Package Name:com.zhoufb  
 * Description: That's the purpose of the file
 * Date:2017年11月21日下午2:17:07  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.testMq;  

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**  
 * ClassName:TestOneComsumer <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月21日 下午2:17:07 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TestOneComsumer <br/>  
 * date: 2017年11月21日 下午2:17:07 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TestOneComsumer {

	/**
	 * @throws JMSException  
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) throws JMSException {

		ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		Connection connection = factory.createConnection();
		connection.start();
		
		Queue queue = new ActiveMQQueue("testQueue");
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		MessageConsumer comsumer = session.createConsumer(queue);

		 //接受消息的方式一
		Message recvMessage = comsumer.receive();
		System.out.println("received:" + ((TextMessage) recvMessage).getText());

	}

}
  
