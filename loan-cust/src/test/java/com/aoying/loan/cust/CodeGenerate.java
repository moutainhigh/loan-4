package com.aoying.loan.cust;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.alibaba.druid.util.StringUtils;
import com.aoying.loan.cust.codemaker.pojo.CodeMakerCfg;
import com.aoying.loan.cust.codemaker.service.AbsCodeMakerService;

/**
 * @author nick
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CodeGenerate extends AbsCodeMakerService {

    /**
     * @设置 单条sql操作模板
     */
    @Autowired
    @Qualifier("masterDBSqlSessionTemplate")
    private SqlSessionTemplate sqlSessionTemplate;

    @Test
    public void codeGenerate() throws Exception {
        String[] tableNames = {"loanApplicationForLarge"};
        String modlePackage = "com.aoying.loan.cust.loan"; //生产的文件所在包名
        String daoSourceModlePackage = "com.aoying.loan.cust.loan.pojo"; //对应pojo所在包名

        String dbName = "loanCust";
        String projectName = "loan-cust"; //在哪个项目生产文件

        String autherName = "nick";
        String notGenerateFields = "id,createrId,createrName,createTime,modId,modName,modTime,"; //这些字段统一在basePojo中
        notGenerateFields += "telNoEnc,custTelNoEnc,emailEnc,bankCardCodeEnc,bankCardTelNoEnc,idCardCodeEnc,idCardNameEnc";  //加密字段，统一在baseEncodePojo中

        String[] notGenerateTemplates = {};
        for (String tableName : tableNames) {
            if (!StringUtils.isEmpty(tableName)) {
                CodeMakerCfg cfg = new CodeMakerCfg();
                cfg.setDb(dbName);
                cfg.setTableName(tableName);
                cfg.setAutherName(autherName);
                cfg.setModlePackage(modlePackage);
                cfg.setProjectName(projectName);
                cfg.setDaoSourceModlePackage(daoSourceModlePackage);
                cfg.setNotGenerateFields(notGenerateFields);
                cfg.setNotGenerateTemplates(notGenerateTemplates);
                this.generateCode(cfg, sqlSessionTemplate);
            }
        }
    }

}
