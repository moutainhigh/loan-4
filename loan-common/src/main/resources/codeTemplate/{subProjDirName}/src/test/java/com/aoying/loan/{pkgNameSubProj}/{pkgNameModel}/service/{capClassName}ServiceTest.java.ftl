package ${fullPkgModel}.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ${fullPkgProject}.common.base.test.BaseTest;
import ${fullPkgDaoModel}.${capClassName}Pojo;
import ${fullPkgModel}.service.iservice.I${capClassName}Service;

/**
 * ${tableComment} Test
 * @author ${autherName}
 */
public class ${capClassName}ServiceTest extends BaseTest{
	@Autowired
	private I${capClassName}Service ${className}Service;
	
	/** 模拟HttpServletReqeust*/
	//private static MockHttpServletRequest request = new MockHttpServletRequest();

	/**
	 * 根据主键或唯一键查找数据
	 */
	@Test
	public void selectUnique() {
		${capClassName}Pojo a = new ${capClassName}Pojo();
		a.setId(1L);
		a = ${className}Service.selectUnique(a);
		logger.info("{}", a);
	}

	/**
	 * 根据条件查询记录
	 */
	@Test
	public void selectList() {
		${capClassName}Pojo a = new ${capClassName}Pojo();
		a.setPageNum(1);
		a.setPageSize(3);
		List<${capClassName}Pojo> list = ${className}Service.selectList(a);
		logger.info("记录总数：{}", a.getTotalRowCount());
		logger.info("{}", list);
		a.setPageNum(2);
		a.setPageSize(3);
		list = ${className}Service.selectList(a);
		logger.info("记录总数：" + a.getTotalRowCount());
		logger.info("{}", list);
	}

	/**
	 * 插入一条数据
	 */
	@Test
	public void insert() {
		// ${capClassName}Pojo a = new ${capClassName}Pojo();
		// a.setCreateTime(new Timestamp(System.currentTimeMillis()));
		// int count = ${className}Service.insert(a);
		// logger.info("count:" + count + ",id:" + a.getId());
	}

	/**
	 * 修改一条数据
	 */
	@Test
	public void update() {
		${capClassName}Pojo a = new ${capClassName}Pojo();
		a.setId(1L);
// 		a.setModTime(new Timestamp(System.currentTimeMillis()));
		${className}Service.update(a);
	}

	/**
	 * 批量插入数据
	 */
	@Test
	public void insertList() {
		List<${capClassName}Pojo> list = new ArrayList<${capClassName}Pojo>();
		for (int i = 1; i <= 10; i++) {
			${capClassName}Pojo a = new ${capClassName}Pojo();
			list.add(a);
		}
// 		${className}Service.insertList(list);
	}

	/**
	 * 批量修改数据
	 */
	@Test
	public void updateList() {
		List<${capClassName}Pojo> list = new ArrayList<${capClassName}Pojo>();
		for (int i = 5; i <= 10; i++) {
			${capClassName}Pojo a = new ${capClassName}Pojo();
			a.setId(i + 0L);
			// a.setModTime(new Timestamp(System.currentTimeMillis()));
			list.add(a);
		}
		${className}Service.updateList(list);
	}

	/**
	 * 批量删除数据
	 */
	@Test
	public void deleteList() {
		List<${capClassName}Pojo> list = new ArrayList<${capClassName}Pojo>();
		for (int i = 8; i <= 10; i++) {
			${capClassName}Pojo a = new ${capClassName}Pojo();
			a.setId(i + 0L);
			list.add(a);
		}
// 		${className}Service.deleteList(list);
	}
}
