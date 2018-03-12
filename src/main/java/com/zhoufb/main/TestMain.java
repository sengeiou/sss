/**  
 * File Name:TestMain.java  
 * Package Name:com.zhoufb.main  
 * Description: (That's the purpose of the file)
 * Date:2017年11月28日上午9:25:48  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:TestMain.java  
 * Package Name:com.zhoufb.main  
 * Description: That's the purpose of the file
 * Date:2017年11月28日上午9:25:48  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.main;  

import com.alibaba.dubbo.container.Main;

/**  
 * ClassName:TestMain <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月28日 上午9:25:48 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class TestMain {

	/** 
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static void main(String[] args) {
		//-Rdevelop
		setArgs(args);
		System.setProperty("dubbo.spring.javaconfig","com.zhoufb.config");

		String[] startArgs = {"javaconfig"};
		Main.main(startArgs);
	}
	public static void setArgs(String[] args){
		for(String arg:args){
			try {
				if (arg.contains("-P")){
					System.setProperty("dubbo.protocol.rest.port", arg.substring(2));
				}else if (arg.contains("-R")){
					System.setProperty("runMode",arg.substring(2));
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}

