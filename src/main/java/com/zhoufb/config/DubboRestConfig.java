/**  
 * File Name:DubboRestConfig.java  
 * Package Name:com.zhoufb.config  
 * Description: (That's the purpose of the file)
 * Date:2017年11月28日上午10:34:46  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:DubboRestConfig.java  
 * Package Name:com.zhoufb.config  
 * Description: That's the purpose of the file
 * Date:2017年11月28日上午10:34:46  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.config;  

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;
import com.zhoufb.config.tool.PropertiesFactory;

/**  
 * ClassName:DubboRestConfig <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月28日 上午10:34:46 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan({"com.zhoufb"})
public class DubboRestConfig {

	  public static final String APPLICATION_NAME;//rest提供者名称
	    public static final String APPLICATION_OWNER;//rest提供者所有者
	    public static final String REGISTRY_ADDRESS;//注册dubbo服务的地址
	    public static final String DUBBO_SERVER;//dubbo使用的协议的服务器端实现类型
	    public static final String REST_FILTER;//拦截器
	    public static final int   REST_TIMEOUT;//超时时间
	    public static final String PROTOCOL_SERIALIZATION;//dubbo协议序列化方式
	    public static final int   PROTOCOL_PORT;//rest提供者的接口,web调用时候使用
	    public static final String PROTOCOL_NAME;//dubbo协议名称

	    public static final String PROTOCOL_EXTENSION = "com.zhoufb.filter.ResponseFilter,com.zhoufb.filter.ResponseFilter";


	    public static final String ANNOTATION_PACKAGE = "com.zhoufb.rest.base,"+
	    		"com.zhoufb.rest.impl,"+
	            "com.zhoufb.consumer";//提供者实现类的包路径，实现类必须添加dubbo的service注解

	
    static {
        Properties properties = PropertiesFactory.createProperties("iesp/declaration","restDubbo");
        
        APPLICATION_NAME = properties.getProperty("dubbo.applicationName");
        APPLICATION_OWNER = properties.getProperty("dubbo.applicationOwner");
        REGISTRY_ADDRESS = properties.getProperty("dubbo.registryAddress");
        DUBBO_SERVER = properties.getProperty("dubbo.dubboServer");
        REST_FILTER = properties.getProperty("dubbo.restFilter");
        REST_TIMEOUT = Integer.parseInt(properties.getProperty("dubbo.restTimeout"));
        PROTOCOL_SERIALIZATION = properties.getProperty("dubbo.protocolSerialization");
        PROTOCOL_PORT = Integer.parseInt(properties.getProperty("dubbo.protocolPort"));
        PROTOCOL_NAME = properties.getProperty("dubbo.protocolName");
        
        System.out.println("\r\n\r\r----->>>>端口号："+PROTOCOL_PORT);
    }
    
    @Bean
    public ApplicationConfig restApplicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName(APPLICATION_NAME);
        applicationConfig.setOwner(APPLICATION_OWNER);
        return applicationConfig;
    }
    @Bean
    public RegistryConfig restRegistryConfig() {
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress(REGISTRY_ADDRESS);
        registryConfig.setServer(DUBBO_SERVER);
        return registryConfig;
    }
    @Bean
    public AnnotationBean restAnnotationBean() {
        AnnotationBean annotationBean = new AnnotationBean();
        annotationBean.setPackage(ANNOTATION_PACKAGE);
        return annotationBean;
    }

    @Bean
    public ConsumerConfig restConsumerConfig() {
        ConsumerConfig consumerConfig = new ConsumerConfig();
        consumerConfig.setFilter(REST_FILTER);
        consumerConfig.setTimeout(REST_TIMEOUT);
        consumerConfig.setCheck(false);
        return consumerConfig;
    }
    @Bean
    public ProtocolConfig restProtocolConfig() {
        ProtocolConfig ProtocolConfig = new ProtocolConfig();
        ProtocolConfig.setSerialization(PROTOCOL_SERIALIZATION);
        ProtocolConfig.setPort(PROTOCOL_PORT);
        ProtocolConfig.setName(PROTOCOL_NAME);
        ProtocolConfig.setExtension(PROTOCOL_EXTENSION);
        ProtocolConfig.setServer(DUBBO_SERVER);
        ProtocolConfig.setKeepAlive(false);
        return ProtocolConfig;
    }

}
  
