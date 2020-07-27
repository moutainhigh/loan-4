package com.aoying.loan.common.util;

import java.io.InputStream;
import com.aliyun.oss.OSSClient;

/**
 * 阿里云OSS工具类
 * @author nick
 */
public class AliOssUtils {
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    private static String accessKeyId = "LTAImcUjzWn1AK6t";
    private static String accessKeySecret = "hG5anhyAZSUj9dSV8jWW3qhqIZa2tF";

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private static String endpoint = "oss-cn-shanghai.aliyuncs.com";
    private static String bucketName = "yx-static-res";

    public static String upload(String objectName, InputStream is) {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient("http://" + endpoint, accessKeyId, accessKeySecret);

        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        ossClient.putObject(bucketName, objectName, is);

        // 关闭OSSClient。
        ossClient.shutdown();

        // 返回访问URL
        return "http://" + bucketName + "." + endpoint + "/" + objectName;
    }
}
