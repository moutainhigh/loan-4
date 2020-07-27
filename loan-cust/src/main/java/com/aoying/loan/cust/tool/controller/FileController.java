package com.aoying.loan.cust.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.common.constant.response.exception.CustomMsgException;
import com.aoying.loan.cust.tool.service.FileService;

/**
 * 文件 Controller
 * @author nick
 */
@RestController
@RequestMapping("/file")
public class FileController extends BaseController {
    @Autowired
    private FileService fileService;

    /**
     * @api {post} /file/mgmt/uploadImgPro/v1 MGMT上传图片至服务器
     * @apiGroup file
     *
     * @apiParam {MultipartFile} file 图片文件
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} data 图片URL
     * @apiSuccessExample {json} 无需验证码响应示例:
    {
    "data": "http://res.91loaning.com/loanProduct/xxx.png",
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping(value = "/mgmt/uploadImgPro/v1", method = RequestMethod.POST)
    public ResponseData uploadImg(@RequestParam("file")MultipartFile file) throws CustomMsgException {
        String url = fileService.addFile(file);
        return ResponseData.succ(url);
    }

    /**
     * @api {post} /file/mgmt/uploadImgOssPro/v1/{path} MGMT上传图片至阿里云
     * @apiGroup file
     *
     * @apiParam {String} path android上传路径/file/mgmt/uploadImgOssPro/v1/android，ios上传路径/file/mgmt/uploadImgOssPro/v1/ios
     * @apiParam {MultipartFile} file 图片文件
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} data 图片URL
     * @apiSuccessExample {json} 无需验证码响应示例:
    {
    "data": "http://res.91loaning.com/loanProduct/xxx.png",
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping(value = "/mgmt/uploadImgOssPro/v1/{path}", method = RequestMethod.POST)
    public ResponseData uploadImgOss(@PathVariable("path")String path, @RequestParam("file")MultipartFile file) throws CustomMsgException {
        String url = fileService.addFileOss(path, file);
        return ResponseData.succ(url);
    }
}
