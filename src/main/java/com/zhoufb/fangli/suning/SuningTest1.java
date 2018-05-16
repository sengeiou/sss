/**  
 * File Name:SuningTest1.java  
 * Package Name:com.zhoufb.suning  
 * Description: (That's the purpose of the file)
 * Date:2018年5月8日上午9:19:21  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:SuningTest1.java  
 * Package Name:com.zhoufb.suning  
 * Description: That's the purpose of the file
 * Date:2018年5月8日上午9:19:21  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.suning;  

import com.suning.api.DefaultSuningClient;
import com.suning.api.entity.custom.StoregroupQueryRequest;
import com.suning.api.entity.custom.StoregroupQueryResponse;
import com.suning.api.entity.netalliance.HomepagepositionurlQueryRequest;
import com.suning.api.entity.netalliance.HomepagepositionurlQueryResponse;
import com.suning.api.entity.netalliance.StorepromotionurlQueryRequest;
import com.suning.api.entity.netalliance.StorepromotionurlQueryResponse;
import com.suning.api.exception.SuningApiException;

/**  
 * ClassName:SuningTest1 <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月8日 上午9:19:21 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class SuningTest1 {

	public static String appKey="e3bc67c6372a3d2185dfb696abee6ee9";
	public static String appSecret="fd79d866c21a20b2fb2dd764d6d39864";

	public static void main(String[] args) {

		test2();
	}

	public static void test1(){
		HomepagepositionurlQueryRequest request = new HomepagepositionurlQueryRequest();
		//api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
		//request.setCheckParam(true);
		String serverUrl = "https://open.suning.com/api/http/sopRequest";
		DefaultSuningClient client = new DefaultSuningClient(serverUrl, appKey,appSecret, "json");
		try {
			HomepagepositionurlQueryResponse response = client.excute(request);
			System.out.println("返回json/xml格式数据 :" + response.getBody());
		} catch (SuningApiException e) {
			e.printStackTrace();
		}
	}
	public static void test2(){
		StorepromotionurlQueryRequest request = new StorepromotionurlQueryRequest();
		request.setAdBookId("100195");
		request.setCommCode("150020195");
		request.setMertCode("0070057321");
		//api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
		request.setCheckParam(true);
		String serverUrl = "https://open.suning.com/api/http/sopRequest";
		DefaultSuningClient client = new DefaultSuningClient(serverUrl, appKey,appSecret, "json");
		try {
			StorepromotionurlQueryResponse response = client.excute(request);
			System.out.println("返回json/xml格式数据 :" + response.getBody());
		} catch (SuningApiException e) {
			e.printStackTrace();
		}
	}
	
	public static void test3(){
		StoregroupQueryRequest request = new StoregroupQueryRequest();
		request.setGroupCode("1");
		//request.setGroupName("门店组名称");
		request.setPageNo(1);
		request.setPageSize(10);
		//api入参校验逻辑开关，当测试稳定之后建议设置为 false 或者删除该行
		request.setCheckParam(true);
		String serverUrl = "https://open.suning.com/api/http/sopRequest";
		DefaultSuningClient client = new DefaultSuningClient(serverUrl, appKey,appSecret, "json");
		try {
		 StoregroupQueryResponse response = client.excute(request);
		 System.out.println("返回json/xml格式数据 :" + response.getBody());
		} catch (SuningApiException e) {
		 e.printStackTrace();
		}
	}
}

