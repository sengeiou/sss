package com.zhoufb.fangli.taobao;


import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.WirelessShareTpwdCreateRequest;
import com.taobao.api.request.WirelessShareTpwdCreateRequest.GenPwdIsvParamDto;
import com.taobao.api.request.WirelessShareTpwdQueryRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.WirelessShareTpwdCreateResponse;
import com.taobao.api.response.WirelessShareTpwdQueryResponse;

public class TaoboUtil {
	public static String url="http://gw.api.taobao.com/router/rest";
	public static String urls="https://eco.taobao.com/router/rest";
	public static String appkey="24869789";
	public static String secret="58156a0e160ab602b4fe43926053c495";

	public static Long adzoneId=486208659L;

	/**
	 * 先解析淘口令
	 * @param taokouling
	 * @throws ApiException
	 */
	public static String test1(String taokouling) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		WirelessShareTpwdQueryRequest req = new WirelessShareTpwdQueryRequest();
		req.setPasswordContent(taokouling);
		WirelessShareTpwdQueryResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}

	/**
	 * taobao.tbk.dg.material.optional (通用物料搜索API（导购）)
	 * @throws ApiException
	 */
	public static String test2(String q,Long pageSize,Long pageNo) throws ApiException{
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
		TbkDgMaterialOptionalRequest req = new TbkDgMaterialOptionalRequest();
		req.setStartDsr(10L);
		req.setPageSize(pageSize);
		req.setPageNo(pageNo);
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
		req.setQ(q);
		//req.setHasCoupon(false);
		req.setAdzoneId(adzoneId);
		TbkDgMaterialOptionalResponse rsp = client.execute(req);
		System.out.println(rsp.getBody());
		return rsp.getBody();
	}
	//提供isv生成淘口令接口，isv提交口令内容、logo、url等参数，生成淘口令关键key如：￥SADadW￥，后续进行文案包装组装用于传播
		public static String test3(String logo,String targetUrl,String text) throws ApiException{
			TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
			WirelessShareTpwdCreateRequest req = new WirelessShareTpwdCreateRequest();
			GenPwdIsvParamDto obj1 = new GenPwdIsvParamDto();
			//obj1.setExt("{\"xx\":\"xx\"}");
			obj1.setLogo(logo);
			obj1.setUrl(targetUrl);
			obj1.setText(text);
			//obj1.setUserId(24234234234L);
			req.setTpwdParam(obj1);
			WirelessShareTpwdCreateResponse rsp = client.execute(req);
			System.out.println(rsp.getBody());
			return rsp.getBody();
		}

	public static void main(String[] args) {

	}

}
