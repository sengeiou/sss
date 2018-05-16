/**  
 * File Name:TestTaobaoRob.java  
 * Package Name:com.zhoufb.taobao  
 * Description: (That's the purpose of the file)
 * Date:2018年5月4日上午10:46:30  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestTaobaoRob.java  
 * Package Name:com.zhoufb.taobao  
 * Description: That's the purpose of the file
 * Date:2018年5月4日上午10:46:30  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.fangli.taobao;  

import java.util.ArrayList;
import java.util.List;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkDgNewuserOrderGetRequest;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkScMaterialOptionalRequest;
import com.taobao.api.request.TbkScNewuserOrderGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest;
import com.taobao.api.request.TbkSpreadGetRequest.TbkSpreadRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.request.WirelessShareTpwdCreateRequest;
import com.taobao.api.request.WirelessShareTpwdCreateRequest.GenPwdIsvParamDto;
import com.taobao.api.request.WirelessShareTpwdQueryRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkDgNewuserOrderGetResponse;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkScMaterialOptionalResponse;
import com.taobao.api.response.TbkScNewuserOrderGetResponse;
import com.taobao.api.response.TbkSpreadGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import com.taobao.api.response.WirelessShareTpwdCreateResponse;
import com.taobao.api.response.WirelessShareTpwdQueryResponse;

/**  
 * ClassName:TestTaobaoRob <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月4日 上午10:46:30 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class TestTaobaoRob {
	
	public static String url="http://gw.api.taobao.com/router/rest";
	public static String urls="https://eco.taobao.com/router/rest";
	public static String appkey="24869789";
	public static String secret="58156a0e160ab602b4fe43926053c495";
	
	public static Long adzoneId=486208659L;
	
	public static Long siteId=44684310L;

	public static void main(String[] args) throws ApiException {
		test2();

	}
	
	//先解析淘口令
	public static void test1() throws ApiException{
		String taokouling="￥O9rJ0tDUKqG￥";
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		WirelessShareTpwdQueryRequest req = new WirelessShareTpwdQueryRequest();
		req.setPasswordContent(taokouling);
		WirelessShareTpwdQueryResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
	//taobao.tbk.dg.material.optional (通用物料搜索API（导购）)
	public static void test2() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
		req.setStartDsr(10L);
		req.setPageSize(20L);
		req.setPageNo(1L);
		req.setPlatform(1L);
		//req.setEndTkRate(1234L);
		//req.setStartTkRate(1234L);
		//req.setEndPrice(10L);
		//req.setStartPrice(10L);
		//req.setIsOverseas(false);
		//req.setIsTmall(false);
		//req.setSort("tk_rate_des");
		//req.setItemloc("杭州");
		//req.setCat("16,18");
		req.setQ("复古连衣裙2018春夏新款女装休闲宽松韩版气质圆领中袖丝麻连衣裙");
		//req.setHasCoupon(false);
		req.setAdzoneId(adzoneId);
		TbkDgMaterialOptionalResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		

	}
	
	//taobao.tbk.tpwd.create (淘宝客淘口令) 免费，不能用
	public static void test3() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
		//req.setUserId("123");
		req.setLogo("http://gw.alicdn.com/bao/uploaded/i4/909908153/TB12YLQdv5TBuNjSspmXXaDRVXa_!!2-item_pic.png");
		req.setUrl("https://item.taobao.com/item.htm?ut_sk=1.WFS5buLdU+sDAGBLJW0GLC2Z_21380790_1525656694562.TaoPassword-Weixin.1&id=539736035839&sourceType=item&price=115&origin_price=278&suid=6C8FE668-A561-4AFD-93E2-7FDE9E1D9EB7&un=dbeb45e61e6abca98bcc5a13b9bc225d&share_crt_v=1&spm=a211b4.24869789&visa=13a09278fde22a2e&disablePopup=true&disableSJ=1");
		req.setText("超值活动，惊喜活动多多boge");
		//req.setLogo("https://uland.taobao.com/");
		req.setExt("{}");
		TbkTpwdCreateResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
	//taobao.tbk.spread.get (物料传播方式获取)
	public static void test4() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkSpreadGetRequest req = new TbkSpreadGetRequest();
		List<TbkSpreadRequest> list2 = new ArrayList<TbkSpreadRequest>();
		TbkSpreadRequest obj3 = new TbkSpreadRequest();
		list2.add(obj3);
		obj3.setUrl("https://s.click.taobao.com/t_js?tu=https%3A%2F%2Fs.click.taobao.com%2Ft%3Fe%3Dm%3D2%26s%3DuHUWBbaoHj2w%2Bv2O2yX1MeeEDrYVVa64K7Vc7tFgwiHjf2vlNIV67kt980%2FdyY0HdgpT%2Fnt4ZAgYY8TkJdZOZVL2g0c5Z%2F%2BQOo7qg56OhkJxEZUBFM2evaSklA%2BkNa5n3494U3cW2yXMLMA8Y7DTYvZrDHxHxeRjcSpj5qSCmbA%3D%26pvid%3D10_202.104.136.203_5003_1525414806917%26ut_sk%3D1.utdid_null_1525414824643.TaoPassword-Outside.lianmeng-app%26spm%3Da211b4.24869789%26visa%3D13a09278fde22a2e%26disablePopup%3Dtrue%26disableSJ%3D1%26ref%3Dhttp%253A%252F%252Fwww.json.cn%252F%26et%3D9esorUNqoJVHH4sXDUBivby0aQXHqNo9");
		req.setRequests(list2);
		TbkSpreadGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	
	//收费，可用
	//提供isv生成淘口令接口，isv提交口令内容、logo、url等参数，生成淘口令关键key如：￥SADadW￥，后续进行文案包装组装用于传播
	public static void test5() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		WirelessShareTpwdCreateRequest req = new WirelessShareTpwdCreateRequest();
		GenPwdIsvParamDto obj1 = new GenPwdIsvParamDto();
		//obj1.setExt("{\"xx\":\"xx\"}");
		obj1.setLogo("http://gw.alicdn.com/bao/uploaded/i4/909908153/TB12YLQdv5TBuNjSspmXXaDRVXa_!!2-item_pic.png");
		obj1.setUrl("https://item.taobao.com/item.htm?ut_sk=1.WFS5buLdU+sDAGBLJW0GLC2Z_21380790_1525656694562.TaoPassword-Weixin.1&id=539736035839&sourceType=item&price=115&origin_price=278&suid=6C8FE668-A561-4AFD-93E2-7FDE9E1D9EB7&un=dbeb45e61e6abca98bcc5a13b9bc225d&share_crt_v=1&spm=a211b4.24869789&visa=13a09278fde22a2e&disablePopup=true&disableSJ=1");
		obj1.setText("超值活动，惊喜活动多多boge");
		//obj1.setUserId(131469734L);
		req.setTpwdParam(obj1);
		WirelessShareTpwdCreateResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	//taobao.tbk.dg.newuser.order.get (淘宝客新用户订单API--导购)
	public static void test6() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkDgNewuserOrderGetRequest req = new TbkDgNewuserOrderGetRequest();
		req.setPageSize(20L);
		req.setAdzoneId(adzoneId);
		req.setPageNo(1L);
		//req.setStartRegisterTime(StringUtils.parseDateTime("2018-01-24 00:34:05"));
		//req.setEndRegisterTime(StringUtils.parseDateTime("2018-01-24 00:34:05"));
		TbkDgNewuserOrderGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}

}
  
