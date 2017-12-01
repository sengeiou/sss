/**  
 * File Name:SpecialTimestampSerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:03:32  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:SpecialTimestampSerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:03:32  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util.json;  
/**  
 * ClassName:SpecialTimestampSerializer <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:03:32 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.zhoufb.util.DateUtils;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class SpecialTimestampSerializer extends JsonSerializer<Timestamp> {
	public void serialize(Timestamp value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if (value != null) {
			jgen.writeString(DateUtils.formatDateTime(new Date(value.getTime())));
		}

	}

}
  
