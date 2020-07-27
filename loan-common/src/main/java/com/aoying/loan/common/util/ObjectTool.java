/** */
package com.aoying.loan.common.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

/**
 * @功能:object工具类
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月8日下午4:55:24
 * @说明：<pre></pre>
 */
public class ObjectTool {
	/** 日志 */
	protected static Logger logger = LogManager.getLogger(ObjectTool.class);

	/**
	 * 用反射方法，将map中的值设置给对象对应属性
	 * 
	 * @param obj
	 * @param valMap
	 * @return
	 * @throws Exception
	 */
	public static <T> T setValue(T obj, Map<String, Object> valMap) throws Exception {
		return setValue(obj, valMap, true);
	}

	/**
	 * 用反射方法，将map中的值设置给对象对应属性
	 * 
	 * @param obj
	 * @param valMap
	 * @return
	 * @throws Exception
	 */
	public static <T> T setValue(T obj, Map<String, Object> valMap, boolean skipEmpty) throws Exception {
		Field field = null;
		Class<?> clazz = obj.getClass();
		for (Entry<String, Object> entry : valMap.entrySet()) {
			if (ObjectUtils.isEmpty(obj) && skipEmpty) {
				continue;
			}
			field = ReflectionUtils.findField(clazz, entry.getKey());
			field.setAccessible(true);
			if (field.getType().equals(int.class)) {
				field.set(obj, Integer.valueOf(entry.getValue().toString()).intValue());
			} else if (field.getType().equals(Integer.class)) {
				field.set(obj, Integer.valueOf(entry.getValue().toString()));
			} else if (field.getType().equals(long.class)) {
				field.set(obj, Long.valueOf(entry.getValue().toString()).longValue());
			} else if (field.getType().equals(Long.class)) {
				field.set(obj, Long.valueOf(entry.getValue().toString()));
			} else if (field.getType().equals(float.class)) {
				field.set(obj, Float.valueOf(entry.getValue().toString()).floatValue());
			} else if (field.getType().equals(Float.class)) {
				field.set(obj, Float.valueOf(entry.getValue().toString()));
			} else if (field.getType().equals(double.class)) {
				field.set(obj, Double.valueOf(entry.getValue().toString()).doubleValue());
			} else if (field.getType().equals(Double.class)) {
				field.set(obj, Double.valueOf(entry.getValue().toString()));
			} else {
				field.set(obj, entry.getValue());
			}
		}
		return obj;
	}

	/**
	 * 判断string是否为空或空字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> boolean isEmpty(T obj) {
		if (obj instanceof String) {
			return obj == null || obj.toString().trim().length() < 1;
		} else if (obj instanceof Collection) {
			return obj == null || ((Collection<?>) obj).size() == 0;
		} else {
			return obj == null;
		}
	}

	/**
	 * 判断string是否不为空或空字符串
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> boolean isNotEmpty(T obj) {
		return !isEmpty(obj);
	}

	/**
	 * 如果obj为空，返回trueVal,否则返回自己
	 * 
	 * @param obj
	 * @param trueVal
	 * @return
	 */
	public static <T> T ifObjEmpty(T obj, T trueVal) {
		return isEmpty(obj) ? trueVal : obj;
	}



	/**
	 *
	 * @param obj
	 * @return true if not null
	 */
	public static boolean checkFieldValueNull(Object obj,String... str) {
		try {
			for (Field f : obj.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (f.get(obj) == null || f.get(obj) == "") { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
					//这里可以给空字段初始化，及其他操作
					if (str != null) {
						if ("completeData".equals(str) || "cardId".equals(str)) {
							continue;
						}
					}
					return false;
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}



	public static void main(String[] args) throws Exception {
		// JedisPoolConfig cfg = new JedisPoolConfig();
		// HashMap<String, Object> map = new HashMap<String, Object>();
		// map.put("minIdle", 1);
		// ObjectTool.setValue(cfg, map);
		// System.out.println(JsonTool.getString(cfg));
		//
		// Builder builder = MongoClientOptions.builder();
		// HashMap<String, Object> clientCfg = new HashMap<String, Object>();
		// clientCfg.put("minConnectionsPerHost", 5);
		// clientCfg.put("maxConnectionsPerHost", 10);
		// clientCfg.put("threadsAllowedToBlockForConnectionMultiplier", 10);
		// clientCfg.put("socketKeepAlive", true);
		// ObjectTool.setValue(builder, clientCfg);
		// MongoClientOptions options = builder.build();
		// System.out.println(options.getMinConnectionsPerHost());

		String s = null;
		System.out.println(isEmpty(s));
		s = "";
		System.out.println(isEmpty(s));

		List<String> list = null;
		System.out.println(isEmpty(list));
		list = new ArrayList<String>();
		System.out.println(isEmpty(list));
		list.add(s);
		System.out.println(isEmpty(list));

	}
}
