package com.aoying.loan.cust.tool.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.common.util.AliOssUtils;
import com.aoying.loan.common.util.FileTool;

/**
 * 文件 Service
 * @author nick
 */
@Service
public class FileService {
    /** 日志对象 */
    protected static final Logger logger = LoggerFactory.getLogger(FileService.class);

    private String saveDir = "../res/loanProduct";

    @Value("${sysCfg.fileService.accessDir}")
    private String accessDir;

    public String addFile(MultipartFile multipartFile) throws CustomMsgException {
        String name = multipartFile.getOriginalFilename();
        if (!FileService.checkImg(name)) {
            throw new CustomMsgException("文件类型错误");
        }

        name = FileTool.getFilePrefixByDate(new Date()) + name;
        String savePath = this.saveDir + "/" + name;
        String accessPath = this.accessDir + "/" + name;
        File dir = new File(saveDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(savePath);
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        } catch (IOException e) {
            throw new CustomMsgException("文件上传失败");
        }
        return accessPath;
    }

    public String addFileOss(String path, MultipartFile multipartFile) throws CustomMsgException {
        String name = multipartFile.getOriginalFilename();

        String objectName = path + "/" + name;
        String accessPath = null;
        try {
            accessPath = AliOssUtils.upload(objectName, multipartFile.getInputStream());
        } catch (IOException e) {
            throw new CustomMsgException("文件上传失败");
        }
        return accessPath;
    }

    private static Boolean checkImg(String name) {
        String fileSuffix = name.substring(name.lastIndexOf(".") + 1);
        String[] imgSuffix = {"jpg", "bmp", "gif", "jpeg", "png"};
        for (String suffix : imgSuffix) {
            if (suffix.equalsIgnoreCase(fileSuffix)) {
                return true;
            }
        }
        return false;
    }
}
