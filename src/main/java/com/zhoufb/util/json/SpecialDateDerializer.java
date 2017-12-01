/**  
 * File Name:SpecialDateDerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:06:36  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:SpecialDateDerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:06:36  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util.json;  
/**  
 * ClassName:SpecialDateDerializer <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:06:36 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: SpecialDateDerializer <br/>  
 * date: 2017年12月1日 上午10:06:36 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.zhoufb.util.DateUtils;
import com.zhoufb.util.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

public class SpecialDateDerializer extends JsonDeserializer<Date> {
	public Date deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (!StringUtils.isBlank(jp.getText())) {
			try {
				return DateUtils.pownerParseDate(jp.getText().trim());
			} catch (ParseException arg3) {
				arg3.printStackTrace();
			}
		}

		return null;
	}
}
  
