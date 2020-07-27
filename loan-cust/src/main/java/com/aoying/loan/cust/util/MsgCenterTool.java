package com.aoying.loan.cust.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

/**
 * 手机号 工具类
 * @author nick
 */
public class MsgCenterTool {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(MsgCenterTool.class);

    private static Map<Operator, String[]> map3 = new HashMap<Operator, String[]>();
    private static Map<Operator, String[]> map4 = new HashMap<Operator, String[]>();

    static {
        // 前3位
        map3.put(Operator.ChinaMobile, new String[]{
                "134", "135", "136", "137", "138", "139", "147", "150", "151", "152",
                "157", "158", "159", "182", "183", "184", "178", "187", "188"});
        map3.put(Operator.ChinaUnicom, new String[]{"130", "131", "132", "145", "155", "156", "176", "185", "186"});
        map3.put(Operator.ChinaTelecom, new String[]{"133", "153", "177", "180", "181", "189"});

        // 前4位
        map4.put(Operator.ChinaMobile, new String[]{"1705"});
        map4.put(Operator.ChinaUnicom, new String[]{"1709"});
        map4.put(Operator.ChinaTelecom, new String[]{"1700"});
    }

    /**
     * 检查手机号
     * @param number
     * @return
     */
    public static String checkPhoneNum(String number) {
        if (number == null || number.isEmpty()) return "手机号为空";

        if (number.length() != 11) return "手机号非11位";

        for (int i = 0; i< number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                return "手机号包含非数字";
            }
        }

        return null;
    }

    /**
     * 根据手机号获取运营商
     * @param number
     * @return
     */
    public static Operator getOperator(String number) {
        // 去除前后的空白
        if (number == null) {
            logger.warn("未知运营商号码 {}", number);
            return Operator.Unknow;
        } else {
            number = number.trim();
        }

        // 去除前缀
        if (number.startsWith("+")) {
            number = number.substring(1);
        }
        if (number.startsWith("86")) {
            number = number.substring(2);
        }

        // 判断是否11位
        if (number.length() != 11) {
            logger.warn("未知运营商号码 {}", number);
            return Operator.Unknow;
        }

        // 判断是否全为数字
        for (int i = 0; i< number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                logger.warn("未知运营商号码 {}", number);
                return Operator.Unknow;
            }
        }

        // 前3位
        String head3 = number.substring(0, 3);
        for (Operator op : map3.keySet()) {
            for (String str : map3.get(op)) {
                if (head3.equals(str)) {
                    return op;
                }
            }
        }

        // 前4位
        String head4 = number.substring(0, 4);
        for (Operator op : map4.keySet()) {
            for (String str : map4.get(op)) {
                if (head4.equals(str)) {
                    return op;
                }
            }
        }

        logger.warn("未知运营商号码 {}", number);
        return Operator.Unknow;
    }

    public enum Operator {
        Unknow(0, "未知运营商"),
        ChinaMobile(1, "中国移动"),
        ChinaUnicom(2, "中国联通"),
        ChinaTelecom(3, "中国电信");

        /** 值 */
        private int val;
        /** 名称 */
        private String name;

        Operator(int val, String name) {
            this.val = val;
            this.name = name;
        }

        /** 获取 值 */
        public int getVal() {
            return this.val;
        }

        /** 获取 名称 */
        public String getName() {
            return this.name;
        }
    }

    /**
     * 用json格式的参数替换字符串中的参数
     * @param template 模板 "hello {username}"
     * @param paramJson json格式的参数 '{"username":"tom"}'
     * @return
     */
    public static String replaceByJson(String template, String paramJson) {
        if (template == null || template.isEmpty() || paramJson == null || paramJson.isEmpty()) return template;

        Map<String, Object> param = JSON.parseObject(paramJson, new TypeReference<Map<String, Object>>(){});
        StringBuilder builder = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < template.length(); i++) {
            if (template.charAt(i) == '{' && !flag) {
                flag = true;
                temp.delete(0, temp.length());
            } else if (template.charAt(i) == '}' && flag) {
                flag = false;
                builder.append(param.get(temp.toString()));
            } else if (flag) {
                temp.append(template.charAt(i));
            } else {
                builder.append(template.charAt(i));
            }
        }
        return builder.toString();
    }

    /**
     * 生成UUID
     * @return UUID字符串
     */
    public static String generateUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
