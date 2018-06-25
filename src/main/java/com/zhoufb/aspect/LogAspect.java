package com.zhoufb.aspect;



import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;



/**
 * 切面日志(此切面输出rest、provider所以方法的入参、出参、耗时)
 * @author hongyong
 * @date 2017年8月2日 
 */
//@Service("LogAspect")
@Aspect
@Component
//@Order(1) 优先级
public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	private static ThreadLocal<String> requestMethod = new ThreadLocal<String>();//请求方法

	private static ThreadLocal<String> requestParam = new ThreadLocal<String>();//入参

	private static ThreadLocal<Object> outputParam = new ThreadLocal<Object>();//出参

	private static ThreadLocal<Long> startTime = new ThreadLocal<Long>();//开始时间

	private static ThreadLocal<Long> endTime = new ThreadLocal<Long>();//结束时间


    @Pointcut("(execution(* com.zhoufb.rest.impl..*(..)))")
    //@Pointcut("execution(public * * (. .))")
    public void aspect() { 
    	System.out.println("进入aspect");
    }


    /**
     * @Description 方法调用前触发 记录开始时间
     * @param joinPoint
     */
    @Before("aspect()")
    public void doBefore(JoinPoint joinPoint) {
    	startTime.set(System.currentTimeMillis()); // 记录方法开始执行的时间
    }

    /**
     * @Description 方法调用后触发 记录结束时间
     * @param joinPoint
     */
    @After("aspect()")
    public void doAfter(JoinPoint joinPoint) {
    	endTime.set(System.currentTimeMillis()); // 记录方法执行完成的时间
        this.printOptLog();
    }

    /**
     * @Description 环绕触发
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("aspect()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        // * 1.获取request信息 2.根据request获取session 3.从session中取出登录用户信息
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        Object result = null;
//        String signature = pjp.getSignature().toString();// 方法全名（接口+方法名）
//        Class<? extends Object> class1 = pjp.getTarget().getClass();//实现层类名
        requestMethod.set(pjp.getSignature().toString());  
        Object[] paramsArray = pjp.getArgs();
        requestParam.set(arrayToJsonString(paramsArray));
        
        //执行真正的方法，此处不要try catch，否则afterThrow不会执行
		result = pjp.proceed();
		
		outputParam.set(result);
        return result;
    }

    //配置抛出异常后通知,使用在方法aspect()上注册的切入点  
    @AfterThrowing(pointcut="aspect()", throwing="ex")  
    public void afterThrow(JoinPoint joinPoint, Exception ex){  
        logger.info("afterThrow-->{} \t -->{}", joinPoint,ex.getMessage());
        outputParam.set("切面日志..");
    }  
    
    
    /**
     * 输出日志
     */
    private void printOptLog() {
        logger.info("接口方法名:{}",requestMethod.get());
        logger.info("接口入参:{}",requestParam.get());
		logger.info("接口出参:{}",JSON.toJSONString(outputParam.get()));
        logger.info("接口耗时：{}",endTime.get()-startTime.get());
    }

    
    /**
     * 返回入参字符串
     * @param params
     * @return
     */
    private String arrayToJsonString(Object[] params) {
        List<Object> list = Arrays.asList(params);
        return JSON.toJSONString(list);
    }
}