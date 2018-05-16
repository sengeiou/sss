/**  
 * File Name:TbkItemConvertResponse.java  
 * Package Name:com.zhoufb.taobao  
 * Description: (That's the purpose of the file)
 * Date:2018年4月28日下午3:24:05  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TbkItemConvertResponse.java  
 * Package Name:com.zhoufb.taobao  
 * Description: That's the purpose of the file
 * Date:2018年4月28日下午3:24:05  
 * Copyright (c) 2018, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.fangli.taobao;  

import java.util.List;

import com.taobao.api.TaobaoResponse;
import com.taobao.api.domain.NTbkItem;
import com.taobao.api.internal.mapping.ApiField;
import com.taobao.api.internal.mapping.ApiListField;

/**  
 * ClassName:TbkItemConvertResponse <br/>  
 * Description:That's the purpose of the class
 * Date:     2018年4月28日 下午3:24:05 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: TbkItemConvertResponse <br/>  
 * date: 2018年4月28日 下午3:24:05 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class TbkItemConvertResponse  extends TaobaoResponse{
	/**  
	 * serialVersionUID:That's the purpose of the variable.  
	 */
	private static final long serialVersionUID = 7344123914069514498L;
	
	@ApiListField("results")
	@ApiField("n_tbk_item")
	private List<NTbkItem> results;

	public void setResults(List<NTbkItem> results) {
		this.results = results;
	}

	public List<NTbkItem> getResults() {
		return this.results;
	}
}
  
