/**  
 * File Name:TestService.java  
 * Package Name:com.zhoufb.service  
 * Description: (That's the purpose of the file)
 * Date:2017年11月28日下午2:04:59  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:TestService.java  
 * Package Name:com.zhoufb.service  
 * Description: That's the purpose of the file
 * Date:2017年11月28日下午2:04:59  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.service;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoufb.dao.ExportPaymentDao;
import com.zhoufb.model.db.ExportPayment;

/**  
 * ClassName:TestService <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月28日 下午2:04:59 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

@Service("testService")
public class TestService {

	@Autowired
	private ExportPaymentDao exportPaymentDao;
	
	public  ExportPayment selectByPrimaryKey(String guid){
		return exportPaymentDao.selectByPrimaryKey(guid);
	};
	
	
}
  
