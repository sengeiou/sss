/**  
 * File Name:SpecialTimestampDerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:05:31  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:SpecialTimestampDerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:05:31  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util.json;  
/**  
 * ClassName:SpecialTimestampDerializer <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:05:31 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: SpecialTimestampDerializer <br/>  
 * date: 2017年12月1日 上午10:05:31 <br/>  
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
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class SpecialTimestampDerializer extends JsonDeserializer<Timestamp> {
	public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		if (!StringUtils.isBlank(jp.getText())) {
			try {
				Date e = DateUtils.pownerParseDate(jp.getText().trim());
				return new Timestamp(e.getTime());
			} catch (ParseException arg3) {
				arg3.printStackTrace();
			}
		}

		return null;
	}
}
