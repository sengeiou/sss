/**  
 * File Name:JsonUtils.java  
 * Package Name:com.zhoufb.util  
 * Description: (That's the purpose of the file)
 * Date:2017年12月1日上午10:00:34  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
*/  
/**  
 * File Name:JsonUtils.java  
 * Package Name:com.zhoufb.util  
 * Description: That's the purpose of the file
 * Date:2017年12月1日上午10:00:34  
 * Copyright (c) 2017, forint.lee@qq.com All Rights Reserved.  
 *  
 */  
  
package com.zhoufb.util;  

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.zhoufb.util.json.SpecialDateDerializer;
import com.zhoufb.util.json.SpecialStringDerializer;
import com.zhoufb.util.json.SpecialStringSerializer;
import com.zhoufb.util.json.SpecialTimestampDerializer;
import com.zhoufb.util.json.SpecialTimestampSerializer;

/**  
 * ClassName:JsonUtils <br/>  
 * Description:That's the purpose of the class
 * Date:     2017年12月1日 上午10:00:34 <br/>  
 * @author   zhoufengbo  
 * @version  V1.0  
 * @see        
 */

public class JsonUtils {

	private static ObjectMapper mapper = new ObjectMapper();
	private static ObjectMapper reader;
	private static ObjectMapper writer;

	public static ObjectMapper mapper() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
				false);
		return mapper;
	}

	public static ObjectMapper reader() {
		if (reader == null) {
			reader = new ObjectMapper();
			reader.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
					false);
			SimpleModule module = new SimpleModule();
			module.addDeserializer(String.class, new SpecialStringDerializer());
			module.addDeserializer(Date.class, new SpecialDateDerializer());
			module.addDeserializer(Timestamp.class,
					new SpecialTimestampDerializer());
			reader.registerModule(module);
		}

		return reader;
	}

	public static ObjectMapper writer() {
		if (writer == null) {
			writer = new ObjectMapper();
			SimpleModule module = new SimpleModule();
			module.addSerializer(String.class, new SpecialStringSerializer());
			module.addSerializer(Timestamp.class,
					new SpecialTimestampSerializer());
			writer.registerModule(module);
		}

		return writer;
	}



}
  
