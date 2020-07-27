package com.aoying.loan.common.util;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.druid.util.StringUtils;

/**
 * 枚举 工具类
 * @author nick
 */
public class EnumUtils {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(EnumUtils.class);

    /**
     * 通过方法名执行枚举方法
     * @param methodName
     * @param obj
     * @param args
     * @param <T>
     * @return
     */
    private static <T> Object getValueByMethodName(String methodName, T obj, Object... args) {
        Method[] methods = obj.getClass().getMethods();
        if (methods.length <= 0) { return null; }

        Method method = null;
        for (Method m : methods) {
            if (m.getName().equalsIgnoreCase(methodName)) {
                method = m;
                break;
            }
        }
        if (method == null) { return null; }

        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            logger.error("枚举执行方法异常", e);
        }
        return null;
    }

    /**
     * 枚举 转 Map
     * @param enumClass
     * @param methodNames
     * @param <T>
     * @return
     */
    public static <T> Map<String, Object> enumToMap(Class<T> enumClass, String... methodNames) {
        Map<String, Object> enumMap = new TreeMap<String, Object>();
        if (!enumClass.isEnum()) { return enumMap; }

        T[] enumArr = enumClass.getEnumConstants();
        if (enumArr == null || enumArr.length <= 0) { return enumMap; }

        String valueMethod = "getVal";
        String descMethod = "getName";
        if (methodNames.length >= 1 && !StringUtils.isEmpty(methodNames[0])) {
            valueMethod = methodNames[0];
        }
        if (methodNames.length >= 2 && !StringUtils.isEmpty(methodNames[1])) {
            descMethod = methodNames[1];
        }

        for (T t : enumArr) {
            Object value = EnumUtils.getValueByMethodName(valueMethod, t);
            if (value == null) { continue; }
            Object desc = EnumUtils.getValueByMethodName(descMethod, t);
            if (desc == null) { continue; }
            enumMap.put(value.toString(), desc);
        }
        return enumMap;
    }

}
