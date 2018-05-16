 package com.zhoufb.testMq;  

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**  
 * ClassName: TestOne <br/>  
 * date: 2017年11月21日 下午2:07:32 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TestOne {

	/**
	 * @throws JMSException  
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) throws JMSException {/*
		ConnectionFactory factory = new ActiveMQConnectionFactory("vm://localhost");
		Connection connection = factory.createConnection();
		connection.start();

		Queue queue = new ActiveMQQueue("testQueue");
		final Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Message message = session.createTextMessage("Hello JMS!");
		MessageProducer producer = session.createProducer(queue);
		producer.send(message);

		new Thread(() -> {
		    try {
		        producer.send(message);
		    } catch (JMSException e) {
		        e.printStackTrace();
		    }
		}, "theadr-jsm").start();

		//下面接受发送的消息
		System.out.println("Send Message Completed!");
		MessageConsumer comsumer = session.createConsumer(queue);

		 
		 //接受消息的方式一
		Message recvMessage = comsumer.receive();
		System.out.println("received:" + ((TextMessage) recvMessage).getText());

		 //接受消息的方式二(区别一在于,如果有很多消息,在一中需要while(true){//dosomething },这里不需要.推荐使用方式二)
		 comsumer.setMessageListener(new MessageListener() {
		     public void onMessage(Message m) {
		         TextMessage textMsg = (TextMessage) m;
		         try {
		             System.out.println("received:" + textMsg.getText());
		         } catch (JMSException e) {
		             e.printStackTrace();
		         }
		     }
		 });

	*/}

}
  
