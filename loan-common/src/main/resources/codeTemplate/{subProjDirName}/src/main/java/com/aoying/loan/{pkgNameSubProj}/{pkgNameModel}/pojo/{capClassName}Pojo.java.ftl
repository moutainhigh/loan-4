package ${fullPkgModel}.pojo;

<#if useDate = true >
import java.sql.Date;
</#if>
<#if useTimestamp = true >
import java.sql.Timestamp;
</#if>
import ${fullPkgProject}.common.base.pojo.BasePojo;

/**
 * @apiDefine ${capClassName}Pojo
<#list columnList as col>
	<#if col.ableMakerField = true >
 * @apiParam {${col.fieldType}} [${col.fieldName}] ${col.columnComment}
	</#if>
</#list>
 */
/**
 * ${tableComment} Pojo
 * @author ${autherName}
 */
public class ${capClassName}Pojo extends BasePojo {
	/** 序列化UID */
	private static final long serialVersionUID = 1L;
<#list columnList as col> 
	<#if col.ableMakerField = true >
	/** ${col.columnComment} */
	private ${col.fieldType} ${col.fieldName};
	</#if>
</#list> 

<#list columnList as col> 
	<#if col.ableMakerField = true >
	
	/** @取得  ${col.columnComment} */
	public ${col.fieldType} get${col.capFieldName}(){
		return ${col.fieldName};
	}
	
	/** @设置  ${col.columnComment} */
	public void set${col.capFieldName}(${col.fieldType} ${col.fieldName}){
		this.${col.fieldName} = ${col.fieldName};
	}
	</#if>
</#list> 

}
