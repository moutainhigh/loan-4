package ${fullPkgModel}.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import ${fullPkgProject}.common.base.controller.BaseController;
import ${fullPkgDaoModel}.${capClassName}Pojo;
import ${fullPkgModel}.service.iservice.I${capClassName}Service;

/**
 * ${tableComment} Controller
 * @author ${autherName}
 */
@RestController
@RequestMapping("/${className}")
public class ${capClassName}Controller extends BaseController<${capClassName}Pojo> {
    @Autowired
    private I${capClassName}Service ${className}Service;

    /**
     * @api {post} /${className}/api/getPro/v1 API${tableComment}获取单个
     * @apiGroup ${className}
     *
     * @apiSuccess (成功响应) {String} reqResult 请求结果码、结果信息
     * @apiSuccess (成功响应) {Object} data 请求结果数据
     * @apiSuccessExample {json} 成功响应示例:
    {
    "data": {
    },
    "reqResult": {
    "code": 1,
    "msg": "操作成功"
    }
    }
     */
//	@RequestMapping("/api/getPro/v1")
//	public void get(${capClassName}Pojo ${className}, HttpServletRequest request, HttpServletResponse response) {
//
//	}
}
