/**  
 * File Name:TestGetItem.java  
 * Package Name:com.zhoufb.taobao  
 * Description: (That's the purpose of the file)
 * Date:2018年4月28日下午1:39:20  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:TestGetItem.java  
 * Package Name:com.zhoufb.taobao  
 * Description: That's the purpose of the file
 * Date:2018年4月28日下午1:39:20  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.taobao;  

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkItemGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.request.TbkUatmFavoritesGetRequest;
import com.taobao.api.request.TbkUatmFavoritesItemGetRequest;
import com.taobao.api.request.TimeGetRequest;
import com.taobao.api.request.WirelessShareTpwdQueryRequest;
import com.taobao.api.response.TbkItemGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import com.taobao.api.response.TbkUatmFavoritesGetResponse;
import com.taobao.api.response.TbkUatmFavoritesItemGetResponse;
import com.taobao.api.response.TimeGetResponse;
import com.taobao.api.response.WirelessShareTpwdQueryResponse;

/**  
 * ClassName:TestGetItem <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年4月28日 下午1:39:20 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TestGetItem <br/>  
 * date: 2018年4月28日 下午1:39:20 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TestGetItem {

	/**
	 * @throws ApiException  
	 * @Title: main 
	 * @Description: (That's the purpose of the method) 
	 * @param args
	 * @throws 
	 */
	public static String url="http://gw.api.taobao.com/router/rest";
	public static String appkey="24869789";
	public static String secret="58156a0e160ab602b4fe43926053c495";

	public static void main(String[] args) throws ApiException {
		test5();
	}
	//获取淘宝联盟选品库的宝贝信息
	public static void test7() throws ApiException{
	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
	TbkUatmFavoritesItemGetRequest req = new TbkUatmFavoritesItemGetRequest();
	req.setPlatform(1L);
	req.setPageSize(20L);
	req.setAdzoneId(486208659L);//推广位id
	//req.setUnid("3456");
	req.setFavoritesId(16317593L);//
	req.setPageNo(1L);
	req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick,shop_title,zk_final_price_wap,event_start_time,event_end_time,tk_rate,status,type");
	TbkUatmFavoritesItemGetResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());
	}
	//获取淘宝联盟选品库列表  :枚举出淘宝客在淘宝联盟超级搜索，特色频道中，创建的选品库列表 
	public static void test6() throws ApiException{
	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
	TbkUatmFavoritesGetRequest req = new TbkUatmFavoritesGetRequest();
	req.setPageNo(1L);
	req.setPageSize(20L);
	req.setFields("favorites_title,favorites_id,type");
	req.setType(1L);
	TbkUatmFavoritesGetResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());
	}
	//生成淘口令 taobao.wireless.share.tpwd.create
	public static void test5() throws ApiException{
	TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
	TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
	//req.setUserId("123");
	req.setText("博哥测试专用");
	req.setUrl("https://item.taobao.com/item.htm?spm=a21cx.8050146.313353.10.5f5f65cfyMyrns&id=562257181748");
	//req.setLogo("https://uland.taobao.com/");
	//req.setExt("{}");
	TbkTpwdCreateResponse rsp = client.execute(req);
	System.out.println(rsp.getBody());
	}
	//解析淘口令
	public static void test4() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		WirelessShareTpwdQueryRequest req = new WirelessShareTpwdQueryRequest();
		req.setPasswordContent("【棉绸女童睡衣夏季男童宝宝绵绸儿童空调家居服套装女长袖夏天薄】，复制这条信息￥XERc0tULFpU￥后打开手机淘宝");
		WirelessShareTpwdQueryResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	public static void test3() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkItemConvertRequest req = new TbkItemConvertRequest();
		req.setFields("num_iid,click_url");
		req.setNumIids("11998");
		req.setAdzoneId(123L);
		req.setPlatform(123L);
		req.setUnid("demo");
		req.setDx("1");
		TbkItemConvertResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
	}
	public static void test2() throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "24869789", "58156a0e160ab602b4fe43926053c495");
		TbkItemGetRequest req = new TbkItemGetRequest();
		req.setFields("num_iid,title,pict_url,small_images,reserve_price,zk_final_price,user_type,provcity,item_url,seller_id,volume,nick");
		req.setQ("《远远的阳光房2018-330》原创女装宽松连衣裙开衫防");
		//req.setCat("16,18");
		//req.setItemloc("杭州");
		//req.setSort("tk_rate_des");
		/*	req.setIsTmall(false);
	req.setIsOverseas(false);
	req.setStartPrice(10L);
	req.setEndPrice(10L);
	req.setStartTkRate(123L);
	req.setEndTkRate(123L);
	req.setPlatform(1L);
	req.setPageNo(123L);
	req.setPageSize(20L);*/
		TbkItemGetResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());

	}
	public void test1() throws ApiException{
		DefaultTaobaoClient client = new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", "24869789", "58156a0e160ab602b4fe43926053c495");
		TimeGetRequest request = new TimeGetRequest();
		TimeGetResponse response = client.execute(request);
		if (response.isSuccess()) {
			System.out.println(response.getBody());
		}
	}
}

