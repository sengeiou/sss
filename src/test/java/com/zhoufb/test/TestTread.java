/**  
 * File Name:TestTread.java  
 * Package Name:com.zhoufb.test  
 * Description: (That's the purpose of the file)
 * Date:2017年12月21日上午11:49:26  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:TestTread.java  
 * Package Name:com.zhoufb.test  
 * Description: That's the purpose of the file
 * Date:2017年12月21日上午11:49:26  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.test;  

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * ClassName:TestTread <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月21日 上午11:49:26 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TestTread <br/>  
 * date: 2017年12月21日 上午11:49:26 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TestTread {

	/** 
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	static int i=1;

	public static void main(String[] args) {
	/*	ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		cachedThreadPool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("pool i="+i);
				i=2;
			}
		});*/
		Thread a=new Thread(new Runnable() {
			@Override
			public void run() {
				i=3;
			}
		});
		Thread b=new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("b i="+i);
			}
		});

		a.start();
		b.start();
		System.out.println("end i="+i);

	}

}

