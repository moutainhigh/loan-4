package com.aoying.loan.cust.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aoying.loan.common.base.controller.BaseController;
import com.aoying.loan.common.base.pojo.ResponseData;
import com.aoying.loan.cust.app.pojo.AppCarouselTextPojo;
import com.aoying.loan.cust.app.service.AppCarouselTextService;

/**
 * 轮播文字 Controller
 * @author nick
 */
@RestController
@RequestMapping("/appCarouselText")
public class AppCarouselTextController extends BaseController {
    @Autowired
    private AppCarouselTextService appCarouselTextService;

    /**
     * @api {post} /appCarouselText/api/getListPub/v1 API获取轮播文字列表
     * @apiGroup app
     *
     * @apiParam {Integer} [pageSize] 每页显示条数，不传默认20条
     */
    @RequestMapping("/api/getListPub/v1")
    public ResponseData getList(AppCarouselTextPojo condition) {
        List<AppCarouselTextPojo> list = appCarouselTextService.getList(condition);
        return ResponseData.succ(list);
    }
}
