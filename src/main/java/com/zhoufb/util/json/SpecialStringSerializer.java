/**  
 * File Name:SpecialStringSerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:02:24  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:SpecialStringSerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:02:24  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util.json;  
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**  
 * ClassName: SpecialStringSerializer <br/>  
 * date: 2017年12月1日 上午10:02:24 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
public class SpecialStringSerializer extends JsonSerializer<String> {
	public void serialize(String value, JsonGenerator jgen,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {
		if (value != null) {
			jgen.writeString(value.trim());
		}

	}

}
  
