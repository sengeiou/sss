/**  
 * File Name:TbkItemConvertRequest.java  
 * Package Name:com.zhoufb.taobao  
 * Description: (That's the purpose of the file)
 * Date:2018年4月28日下午3:16:28  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TbkItemConvertRequest.java  
 * Package Name:com.zhoufb.taobao  
 * Description: That's the purpose of the file
 * Date:2018年4月28日下午3:16:28  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.fangli.taobao;  

import java.util.Map;

import com.taobao.api.ApiRuleException;
import com.taobao.api.BaseTaobaoRequest;
import com.taobao.api.internal.util.RequestCheckUtils;
import com.taobao.api.internal.util.TaobaoHashMap;
import com.taobao.api.response.TbkItemGetResponse;

/**  
 * ClassName:TbkItemConvertRequest <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年4月28日 下午3:16:28 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class TbkItemConvertRequest extends BaseTaobaoRequest<TbkItemConvertResponse> {

	private String fields;//需返回的字段列表
	
	private String numIids;//商品ID串，用','分割，从taobao.tbk.item.get接口获取num_iid字段，最大40个
	
	private Long adzoneId;//广告位ID，区分效果位置  列：123
	
	
	//可选
	private Long platform;
	
	private String unid;
	
	private String dx;
	
	
	
	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}



	public String getNumIids() {
		return numIids;
	}

	public void setNumIids(String numIids) {
		this.numIids = numIids;
	}

	public Long getAdzoneId() {
		return adzoneId;
	}

	public void setAdzoneId(Long adzoneId) {
		this.adzoneId = adzoneId;
	}

	public Long getPlatform() {
		return platform;
	}

	public void setPlatform(Long platform) {
		this.platform = platform;
	}

	public String getUnid() {
		return unid;
	}

	public void setUnid(String unid) {
		this.unid = unid;
	}

	public String getDx() {
		return dx;
	}

	public void setDx(String dx) {
		this.dx = dx;
	}

	/**  
	 * TODO  
	 * @see com.taobao.api.TaobaoRequest#check()  
	 */
	@Override
	public void check() throws ApiRuleException {
		  
		RequestCheckUtils.checkNotEmpty(this.fields, "fields");		
		RequestCheckUtils.checkNotEmpty(this.numIids, "numIids");	
		RequestCheckUtils.checkNotEmpty(this.adzoneId, "adzoneId");	
	}

	/**  
	 * TODO  
	 * @see com.taobao.api.TaobaoRequest#getApiMethodName()  
	 */
	@Override
	public String getApiMethodName() {
		  
		return "taobao.tbk.item.convert";
	}

	/**  
	 * TODO  
	 * @see com.taobao.api.TaobaoRequest#getResponseClass()  
	 */
	@Override
	public Class<TbkItemConvertResponse> getResponseClass() {
		  
		return TbkItemConvertResponse.class;
	}

	/**  
	 * TODO  
	 * @see com.taobao.api.TaobaoRequest#getTextParams()  
	 */
	@Override
	public Map<String, String> getTextParams() {
		TaobaoHashMap txtParams = new TaobaoHashMap();
		txtParams.put("fields", this.fields);
		txtParams.put("num_iids", this.numIids );
		txtParams.put("adzone_id", this.adzoneId );
		txtParams.put("platform", this.platform );
		txtParams.put("unid", this.unid );
		txtParams.put("dx", this.dx);
		return txtParams;
	}

}
  
