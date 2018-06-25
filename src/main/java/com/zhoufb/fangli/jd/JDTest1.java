/**  
 * File Name:JDTest1.java  
 * Package Name:com.zhoufb.fangli.jd  
 * Description: (That's the purpose of the file)
 * Date:2018年5月8日上午10:42:40  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:JDTest1.java  
 * Package Name:com.zhoufb.fangli.jd  
 * Description: That's the purpose of the file
 * Date:2018年5月8日上午10:42:40  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.jd;  

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.cps.ServicePromotionAppGetcodeRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionBatchGetcodeRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionCouponGetCodeByUnionIdRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionGetcodeRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionGoodsInfoRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionWxsqGetCodeByUnionIdRequest;
import com.jd.open.api.sdk.request.cps.UnionServiceQueryImportOrdersRequest;
import com.jd.open.api.sdk.response.cps.ServicePromotionAppGetcodeResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionBatchGetcodeResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionCouponGetCodeByUnionIdResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionGetcodeResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionGoodsInfoResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionWxsqGetCodeByUnionIdResponse;
import com.jd.open.api.sdk.response.cps.UnionServiceQueryImportOrdersResponse;
import com.zhoufb.fangli.jd.jsonBean.GetpromotioninfoResult;
import com.zhoufb.fangli.jd.jsonBean.QuerybatchResult;

/**  
 * ClassName:JDTest1 <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月8日 上午10:42:40 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class JDTest1 {

	public static String appKey="76028849E3CDE566D0FFA4F17B4EFA1A";
	public static String appSecret="1fb2c8777c8b4d50936592f36bb92723";

	public static String accessToken="324a7325-b95a-4f67-b72e-b84d2d36ae9b";

	//https://gw.api.360buy.com/routerjson
	public static String serverUrl="https://api.jd.com/routerjson";

	public static String unionId="1000614266";

	public static String webId ="1287293011";

	public static void main(String[] args) throws JdException {

		test7();

	}
	//获取推广商品信息接口
	public static void test1() throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionGoodsInfoRequest request=new ServicePromotionGoodsInfoRequest();

		request.setSkuIds("1211737" );

		ServicePromotionGoodsInfoResponse response=client.execute(request);
		System.out.println(response.getGetpromotioninfoResult());

		Gson gson = new Gson();
		GetpromotioninfoResult bean=gson.fromJson(response.getGetpromotioninfoResult(),GetpromotioninfoResult.class);
		System.out.println(bean.getResult().get(0).getGoodsName());

	}
	//自定义链接转换
	public static void test2() throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionGetcodeRequest request=new ServicePromotionGetcodeRequest();

		request.setPromotionType( 7 );
		request.setMaterialId( "1211737" ); 
		request.setUnionId( Long.parseLong(unionId) );
		request.setChannel( "WL" );
		request.setWebId( webId );
		request.setAdttype( "6" );

		ServicePromotionGetcodeResponse response=client.execute(request);
		System.out.println(response.getMsg());
	}
	//  联盟微信手q通过unionId获取推广链接【申请】
	public static void test3() throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionWxsqGetCodeByUnionIdRequest request=new ServicePromotionWxsqGetCodeByUnionIdRequest();

		request.setProCont( 1 ); 
		request.setMaterialIds( "1260800" ); 
		request.setUnionId( Long.parseLong(unionId) ); 

		ServicePromotionWxsqGetCodeByUnionIdResponse response=client.execute(request);
		System.out.println(response.getMsg());
	}

	//jingdong.service.promotion.batch.getcode      批量获取代码接口
	public static void test4() throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionBatchGetcodeRequest request=new ServicePromotionBatchGetcodeRequest();

		request.setId( "1211737" ); 
		request.setUrl( "https://item.jd.com/1211737.html" );
		request.setUnionId( Long.parseLong(unionId) );
		request.setChannel( "WL" );
		request.setWebId( webId ); 
		request.setProtocol( 123 );

		ServicePromotionBatchGetcodeResponse response=client.execute(request);
		System.out.println(response.getQuerybatchResult());
		Gson gson = new Gson();
		QuerybatchResult bean =gson.fromJson(response.getQuerybatchResult(), QuerybatchResult.class);
		System.out.println(bean.getUrlList().get(0).getUrl());
	}

	public  static void test5() throws JdException{

		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionAppGetcodeRequest request=new ServicePromotionAppGetcodeRequest();

		request.setJdurl( "jingdong" );
		request.setAppId( "jingdong" );
		request.setSubUnionId( "jingdong" );
		request.setPositionId( "jingdong" );
		request.setExt( "jingdong" );
		request.setProtocol( 123 );
		request.setPid( "jingdong" );

		ServicePromotionAppGetcodeResponse response=client.execute(request);
		System.out.println(response.getMsg());
	}
	
	//  优惠券,商品二合一转接API-通过unionId获取推广链接【申请】
	public static void test6() throws JdException{
		 JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		 ServicePromotionCouponGetCodeByUnionIdRequest request=new ServicePromotionCouponGetCodeByUnionIdRequest();

		 request.setCouponUrl( "jingdong,yanfa,pop" ); 
		 request.setMaterialIds( "jingdong,yanfa,pop" );
		 request.setUnionId( 123 );
		 request.setPositionId( 123 ); 
		 request.setPid( "jingdong" );

		 ServicePromotionCouponGetCodeByUnionIdResponse response=client.execute(request);
		System.out.println(response.getMsg());
	}
	// 查询引入订单
	public static void test7() throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		UnionServiceQueryImportOrdersRequest request=new UnionServiceQueryImportOrdersRequest();

		request.setUnionId( Long.parseLong(unionId) ); 
		request.setTime( "2018052112" );
		request.setPageIndex( 1 ); 
		request.setPageSize( 12 );

		UnionServiceQueryImportOrdersResponse response=client.execute(request);
		System.out.println(response.getMsg());
	}
}

