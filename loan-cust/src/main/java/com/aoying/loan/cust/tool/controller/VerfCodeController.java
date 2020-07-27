package com.aoying.loan.cust.tool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.tool.service.VerfCodeService;

/**
 * 验证码 Controller
 * @author nick
 */
@RestController
@RequestMapping("/verfcode")
public class VerfCodeController extends BaseController {
    @Autowired
    private VerfCodeService verfCodeService;

    /**
     * @api {post} /verfcode/api/getClickPicVerfCodePub/v1 API获取点选图片验证码
     * @apiGroup verfcode
     */
    @RequestMapping("/api/getClickPicVerfCodePub/v1")
    public ResponseData getClickPicVerfCode() {
        return new ResponseData<>(null, null);
    }

    /**
     * @api {post} /verfcode/api/getStaticPicVerfCodePub/v1 API获取静态图片验证码
     * @apiGroup verfcode
     *
     * @apiParam {String} codeFlag 图片验证码标记，标记一个唯一的图片验证码
     */
    /**
     * @apiVersion 2019.1.27
     * @api {post} /verfcode/api/getStaticPicVerfCodePub/v1 API获取静态图片验证码
     * @apiGroup verfcode
     *
     * @apiParam {String} [deviceType] 设备类型，根据不同类型返回结果，若无需验证码返回空，若需要验证码返回base64图片，
     * 若不传默认需要验证码，1Android，2IOS，3桌面版H5，4移动版H5，5落地页，10其他
     * @apiParam {String} codeFlag 图片验证码标记，标记一个唯一的图片验证码
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {String} data 贷款报告对象，注意reportJson是String类型
     * @apiSuccessExample {json} 无需验证码响应示例:
    {
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     * @apiSuccessExample {json} 需要验证码响应示例:
    {
    "data": "/9j/4AAQSkZJRgABA...kI//9k=",
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
    @RequestMapping("/api/getStaticPicVerfCodePub/v1")
    public ResponseData getStaticPicVerfCode(Integer deviceType, String codeFlag) {
        String base64 = verfCodeService.getStaticPicVerfCode(deviceType, codeFlag);
        return ResponseData.succ(base64);
    }

    /**
     * @api {post} /verfcode/api/getSmsVerfCodePub/v1 API获取短信验证码
     * @apiGroup verfcode
     *
     * @apiParam {Integer} type 验证码类型，1注册，2登录，3贷款报告查询
     * @apiParam {String} telNo 手机号
     * @apiParam {Boolean} realSend 是否真发短信
     * @apiParam {String} codeFlag 验证码标记，用于识别是哪个图片验证码
     * @apiParam {String} picCode 图片验证码
     */
    /**
     * @apiVersion 2019.1.27
     * @api {post} /verfcode/api/getSmsVerfCodePub/v1 API获取短信验证码
     * @apiGroup verfcode
     *
     * @apiParam {Integer} type 验证码类型，1注册，2登录，3贷款报告查询
     * @apiParam {String} telNo 手机号
     * @apiParam {Boolean} realSend 是否真发短信
     * @apiParam {String} [deviceType] 设备类型，根据不同类型返回结果，若无需验证码返回空，若需要验证码返回base64图片，
     * 若不传默认需要验证码，1Android，2IOS，3桌面版H5，4移动版H5，5落地页，10其他
     * @apiParam {String} codeFlag 验证码标记，用于识别是哪个图片验证码
     * @apiParam {String} picCode 图片验证码
     */
    @RequestMapping("/api/getSmsVerfCodePub/v1")
    public ResponseData getSmsVerfCode(Integer type, String telNo, Boolean realSend,
                                       Integer deviceType, String codeFlag, String picCode) throws Exception {
        String verfCode = verfCodeService.getSmsVerfCode(type, telNo, realSend, deviceType, codeFlag, picCode);
        return ResponseData.succ(realSend?"":verfCode);
    }
}
