/**  
 * File Name:Test2.java  
 * Package Name:com.zhoufb  
 * Description: (That's the purpose of the file)
 * Date:2017年11月21日下午2:36:11  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:Test2.java  
 * Package Name:com.zhoufb  
 * Description: That's the purpose of the file
 * Date:2017年11月21日下午2:36:11  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.testMq;  

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;


/**  
 * ClassName: Test2 <br/>  
 * date: 2017年11月21日 下午2:36:11 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class Test2 {

	/**
	 * @throws JMSException  
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) throws JMSException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		Connection connection = factory.createConnection();
		connection.start();

		Queue queue = new ActiveMQQueue("testQueue");
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageConsumer comsumer = session.createConsumer(queue);
		comsumer.setMessageListener(new MessageListener() {
		    public void onMessage(Message m) {
		        try {
		            System.out.println("Consumer get " + ((TextMessage) m).getText());
		        } catch (JMSException e) {
		            e.printStackTrace();
		        }
		    }
		});

	}

}
  
