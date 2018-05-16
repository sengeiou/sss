/**  
 * File Name:JDUtil.java  
 * Package Name:com.zhoufb.fangli.jd  
 * Description: (That's the purpose of the file)
 * Date:2018年5月15日上午10:26:24  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:JDUtil.java  
 * Package Name:com.zhoufb.fangli.jd  
 * Description: That's the purpose of the file
 * Date:2018年5月15日上午10:26:24  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.jd;  

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.cps.ServicePromotionBatchGetcodeRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionGetcodeRequest;
import com.jd.open.api.sdk.request.cps.ServicePromotionGoodsInfoRequest;
import com.jd.open.api.sdk.response.cps.ServicePromotionBatchGetcodeResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionGetcodeResponse;
import com.jd.open.api.sdk.response.cps.ServicePromotionGoodsInfoResponse;

/**  
 * ClassName:JDUtil <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月15日 上午10:26:24 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class JDUtil {


	public static String appKey="76028849E3CDE566D0FFA4F17B4EFA1A";
	public static String appSecret="1fb2c8777c8b4d50936592f36bb92723";

	public static String accessToken="324a7325-b95a-4f67-b72e-b84d2d36ae9b";

	//https://gw.api.360buy.com/routerjson
	public static String serverUrl="https://api.jd.com/routerjson";

	public static String unionId="1000614266";

	public static String webId ="1287293011";

	//获取推广商品信息接口
	public static String test1(String skuIds) throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionGoodsInfoRequest request=new ServicePromotionGoodsInfoRequest();

		request.setSkuIds(skuIds );

		ServicePromotionGoodsInfoResponse response=client.execute(request);
		System.out.println(response.getMsg());
		return response.getGetpromotioninfoResult();

	}

	//自定义链接转换
	public static String test2(String materialId) throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);
		ServicePromotionGetcodeRequest request=new ServicePromotionGetcodeRequest();

		request.setPromotionType(7);
		request.setMaterialId(materialId); 
		request.setUnionId( Long.parseLong(unionId) );
		request.setChannel( "WL" );
		request.setWebId( webId);
		request.setAdttype( "6" );

		ServicePromotionGetcodeResponse response=client.execute(request);
		System.out.println(response.getMsg());
		return response.getMsg();
	}
	//批量获取代码接口
	public static String test3(String id) throws JdException{
		JdClient client=new DefaultJdClient(serverUrl,accessToken,appKey,appSecret);

		ServicePromotionBatchGetcodeRequest request=new ServicePromotionBatchGetcodeRequest();

		request.setId( id ); 
		request.setUrl( "https://item.jd.com/"+id+".html" );
		request.setUnionId( Long.parseLong(unionId) );
		request.setChannel( "WL" );
		request.setWebId( webId ); 

		ServicePromotionBatchGetcodeResponse response=client.execute(request);
		System.out.println(response.getQuerybatchResult());
		return response.getQuerybatchResult();
	}
}

