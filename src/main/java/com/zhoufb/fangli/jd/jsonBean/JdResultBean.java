/**  
 * File Name:JdResultBean.java  
 * Package Name:com.zhoufb.fangli.jd.jsonBean  
 * Description: (That's the purpose of the file)
 * Date:2018年5月15日上午11:52:10  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:JdResultBean.java  
 * Package Name:com.zhoufb.fangli.jd.jsonBean  
 * Description: That's the purpose of the file
 * Date:2018年5月15日上午11:52:10  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.jd.jsonBean;  
/**  
 * ClassName:JdResultBean <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月15日 上午11:52:10 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class JdResultBean {
	
	public String url;
	
	public String imgUrl;
	public String goodsName;
	public String unitPrice;//商品单价即京东价
	public String commisionRatioPc;//PC佣金比例
	public String materialUrl;//商品落地页

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCommisionRatioPc() {
		return commisionRatioPc;
	}

	public void setCommisionRatioPc(String commisionRatioPc) {
		this.commisionRatioPc = commisionRatioPc;
	}

	public String getMaterialUrl() {
		return materialUrl;
	}

	public void setMaterialUrl(String materialUrl) {
		this.materialUrl = materialUrl;
	}



}

