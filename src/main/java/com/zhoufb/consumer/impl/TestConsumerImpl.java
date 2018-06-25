/**  
 * File Name:TestConsumerImpl.java  
 * Package Name:com.zhoufb.consumer.impl  
 * Description: (That's the purpose of the file)
 * Date:2017年11月28日下午1:17:10  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestConsumerImpl.java  
 * Package Name:com.zhoufb.consumer.impl  
 * Description: That's the purpose of the file
 * Date:2017年11月28日下午1:17:10  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.consumer.impl;  

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.taobao.api.ApiException;
import com.zhoufb.consumer.service.TestConsumer;
import com.zhoufb.fangli.jd.JDUtil;
import com.zhoufb.fangli.jd.jsonBean.GetpromotioninfoResult;
import com.zhoufb.fangli.jd.jsonBean.JdResultBean;
import com.zhoufb.fangli.jd.jsonBean.QuerybatchResult;
import com.zhoufb.fangli.taobao.TaoboUtil;
import com.zhoufb.service.TestService;

/**  
 * ClassName:TestConsumerImpl <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月28日 下午1:17:10 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

@Service("test")
public class TestConsumerImpl implements TestConsumer{

	private Logger logger =LoggerFactory.getLogger(TestConsumerImpl.class);
	
	@Autowired
	private TestService testService;
	
	@Transactional(readOnly = false, rollbackFor = Exception.class)
	public Map<String, Object> test() {
		Map<String, Object> resultMap=new HashMap<String, Object>();
		logger.info("sdfasd","一顿log");
		//resultMap.put("zhoufb", testService.selectByPrimaryKey("335ED3AEFE014DE585FC2D244DD6D3C2").getPayName());
		return resultMap;
	}

	/**  
	 * TODO  
	 * @see com.zhoufb.consumer.service.TestConsumer#index()  
	 */
	@Override
	public String index() {
		  
		try {
			return TaoboUtil.test2("复古连衣裙2018春夏新款女装休闲宽松韩版气质圆领中袖丝麻连衣裙", 10L,1L);
		} catch (ApiException e) {
			  
			e.printStackTrace();  
			return "error";
			
		}
	}

	/**  
	 * TODO  
	 */
	@Override
	public String JdIndex(String url) {
		List<JdResultBean>list=new ArrayList<JdResultBean>();
		String[] urlArr=url.split(".html")[0].split("/");
		String sku=urlArr[urlArr.length-1];
		Gson gson=new Gson();
		try {
			JdResultBean bean=new JdResultBean();
			GetpromotioninfoResult getpromotioninfoResult=gson.fromJson(JDUtil.test1(sku), GetpromotioninfoResult.class);
			bean.setGoodsName(getpromotioninfoResult.getResult().get(0).getGoodsName());
			bean.setImgUrl(getpromotioninfoResult.getResult().get(0).getImgUrl());
			bean.setGoodsName(getpromotioninfoResult.getResult().get(0).getGoodsName());
			bean.setUnitPrice(getpromotioninfoResult.getResult().get(0).getUnitPrice());
			
			BigDecimal a=new BigDecimal(getpromotioninfoResult.getResult().get(0).getCommisionRatioPc());
			BigDecimal b=new BigDecimal(getpromotioninfoResult.getResult().get(0).getUnitPrice());
			
			bean.setCommisionRatioPc(a.multiply(b).divide(new BigDecimal(100)).setScale(2,BigDecimal.ROUND_HALF_UP).toString());
			
			QuerybatchResult guerybatchResult=gson.fromJson(JDUtil.test3(sku), QuerybatchResult.class);
			bean.setUrl(guerybatchResult.getUrlList().get(0).getUrl());
			list.add(bean);
			return gson.toJson(list);
		} catch (Exception e) {
			  
			e.printStackTrace();  
			return "error";
			
		}
	}

}
  
