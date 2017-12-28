package com.novawind.mourn.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
* Json转换工具类 
* @author Jeremy Xiong
* Date: 2017年8月28日 下午3:12:26
*/
public class JsonUtil {

	private static final ObjectMapper om = new ObjectMapper();
	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	private JsonUtil (){}
	
	/**
	 * 对象转json String
	 * @param t an object to be converted
	 * @return
	 */
	public static <T> String toJson(T t) {
		String res = null;
		try {
			res = om.writeValueAsString(t);
		} catch (JsonProcessingException e) {
			logger.info("对象转json String异常:{}", e.getMessage());
		}
		return res;
	}
	
	/**
	 * json转对象
	 * @param <T> generic java type
	 * @param json String
	 * @param clazz json to be converted with this class which represents a type
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clazz) {
		T res = null;
		try {
			res = om.readValue(json, clazz);
		} catch (IOException e) {
			logger.info("json转对象异常:{}", e.getMessage());
		}
		return res;
	}
	
	public static ObjectMapper getObjectMapper(){
		return om;
	}

}
