/**  
 * File Name:TestActiveMq.java  
 * Package Name:com.zhoufb  
 * Description: (That's the purpose of the file)
 * Date:2017年11月21日下午2:58:16  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestActiveMq.java  
 * Package Name:com.zhoufb  
 * Description: That's the purpose of the file
 * Date:2017年11月21日下午2:58:16  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.testMq;  

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**  
 * ClassName:TestActiveMq <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月21日 下午2:58:16 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TestActiveMq <br/>  
 * date: 2017年11月21日 下午2:58:16 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TestActiveMq {

	/**
	 * @throws JMSException  
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) throws JMSException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setPassword("admin");
		factory.setUserName("admin");
		factory.setBrokerURL("tcp://localhost:61616");
		Connection connection = factory.createConnection();
		connection.start();
		
		Queue queue = new ActiveMQQueue("testQueue");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageProducer producer = session.createProducer(queue);
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);//消息持久化
		producer.send(session.createTextMessage("A persistent Message"));

		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//消息不持久化
		producer.send(session.createTextMessage("A non persistent Message"));

		System.out.println("Send messages sucessfully!");

	}

}
  
