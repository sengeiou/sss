/**  
 * File Name:SpecialStringDerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:11:24  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:SpecialStringDerializer.java  
 * Package Name:com.zhoufb.util.json  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:11:24  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util.json;  
/**  
 * ClassName:SpecialStringDerializer <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:11:24 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */
/**  
 * ClassName: SpecialStringDerializer <br/>  
 * date: 2017年12月1日 上午10:11:24 <br/>  
 * @author zhoufengbo  
 * @version v1.0
 */
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;

public class SpecialStringDerializer extends JsonDeserializer<String> {
	public String deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		JsonToken currentToken = jp.getCurrentToken();
		return currentToken == JsonToken.VALUE_STRING
				? jp.getText().trim()
				: jp.getText();
	}
}
  
