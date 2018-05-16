/**  
 * File Name:QuerybatchResult.java  
 * Package Name:com.zhoufb.fangli.jd.jsonBean  
 * Description: (That's the purpose of the file)
 * Date:2018年5月15日上午11:02:14  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:QuerybatchResult.java  
 * Package Name:com.zhoufb.fangli.jd.jsonBean  
 * Description: That's the purpose of the file
 * Date:2018年5月15日上午11:02:14  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.jd.jsonBean;  

import java.util.List;

/**  
 * ClassName:QuerybatchResult <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月15日 上午11:02:14 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class QuerybatchResult {
	public String resultCode;

	public String resultMessage;

	public List<QuerybatchResultBean>urlList;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public List<QuerybatchResultBean> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<QuerybatchResultBean> urlList) {
		this.urlList = urlList;
	}



}

