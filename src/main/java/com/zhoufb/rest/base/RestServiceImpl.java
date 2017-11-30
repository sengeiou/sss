/**  
 * File Name:RestServiceImpl.java  
 * Package Name:com.zhoufb.rest.base  
 * Description: (That's the purpose of the file)
 * Date:2017年11月28日下午2:30:31  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:RestServiceImpl.java  
 * Package Name:com.zhoufb.rest.base  
 * Description: That's the purpose of the file
 * Date:2017年11月28日下午2:30:31  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.rest.base;  

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.alibaba.dubbo.config.annotation.Service;

/**  
 * ClassName:RestServiceImpl <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年11月28日 下午2:30:31 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

@Service
@Path("/")
public class RestServiceImpl implements RestService{

    @GET
    @Path("/")
    public void index() {
    }

    @GET
    @Path("/static/{var:.*}")
    public void base() {
    }


}
  
