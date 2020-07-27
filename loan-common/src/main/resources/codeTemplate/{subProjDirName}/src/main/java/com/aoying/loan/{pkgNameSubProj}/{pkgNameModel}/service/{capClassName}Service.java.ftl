package ${fullPkgModel}.service;

import org.springframework.stereotype.Service;
import ${fullPkgProject}.common.base.service.BaseService;
import ${fullPkgModel}.dao.${capClassName}Dao;
import ${fullPkgDaoModel}.${capClassName}Pojo;
import ${fullPkgModel}.service.iservice.I${capClassName}Service;

/**
 * ${tableComment} Service
 * @author ${autherName}
 */
@Service
public class ${capClassName}Service extends BaseService<${capClassName}Pojo, ${capClassName}Dao> implements I${capClassName}Service {

}
