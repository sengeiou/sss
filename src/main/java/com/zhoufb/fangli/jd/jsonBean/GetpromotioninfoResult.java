/**  
 * File Name:GetpromotioninfoResult.java  
 * Package Name:com.zhoufb.fangli.jd.jsonBean  
 * Description: (That's the purpose of the file)
 * Date:2018年5月15日上午10:47:54  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
/**  
 * File Name:GetpromotioninfoResult.java  
 * Package Name:com.zhoufb.fangli.jd.jsonBean  
 * Description: That's the purpose of the file
 * Date:2018年5月15日上午10:47:54  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  

package com.zhoufb.fangli.jd.jsonBean;  

import java.util.List;

/**  
 * ClassName:GetpromotioninfoResult <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年5月15日 上午10:47:54 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class GetpromotioninfoResult {
	public String message;
	public Boolean sucessed;
	public List<GetpromotioninfoResultBean>result;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getSucessed() {
		return sucessed;
	}
	public void setSucessed(Boolean sucessed) {
		this.sucessed = sucessed;
	}
	public List<GetpromotioninfoResultBean> getResult() {
		return result;
	}
	public void setResult(List<GetpromotioninfoResultBean> result) {
		this.result = result;
	}
	
	


}

