/** */
package com.aoying.loan.common.base.pojo;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import com.aoying.loan.common.util.JsonTool;

/**
 * @功能:数据基础类
 * @项目名:dunningCommon
 * @作者:wangjz
 * @日期:2017年8月3日上午10:49:01
 * @说明：<pre></pre>
 */
public class BasePojo implements Serializable {
	/** */
	private static final long serialVersionUID = 1L;
	/** id */
	private Long id;
	/** 创建人id */
	private Long createrId;
	/** 创建人姓名 */
	private String createrName;
	/** 创建时间 */
	private Timestamp createTime;
	/** 修改人id */
	private Long modId;
	/** 修改人姓名 */
	private String modName;
	/** 修改时间 */
	private Timestamp modTime;

	/** 分页：第几页 */
	private Integer pageNum;
	/** 分页：每页显示条数 */
	private Integer pageSize;
	/** dataTabel分页：第几页 */
	private Integer start;
	/** dataTabel分页：每页显示条数 */
	private Integer length;
	/** 分页：查询记录总数 */
	private Long totalRowCount;
	/** 分页：查询记录总数 */
	private Integer totalRows;
	/** 分页：第几页  */
	private Integer currentPage;

	/**
	 * @取得 id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @设置 id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @取得 创建人id
	 */
	public Long getCreaterId() {
		return createrId;
	}

	/**
	 * @设置 创建人id
	 */
	public void setCreaterId(Long createrId) {
		this.createrId = createrId;
	}

	/**
	 * @取得 创建人姓名
	 */
	public String getCreaterName() {
		return createrName;
	}

	/**
	 * @设置 创建人姓名
	 */
	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}

	/**
	 * @取得 创建时间
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * @设置 创建时间
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @取得 修改人id
	 */
	public Long getModId() {
		return modId;
	}

	/**
	 * @设置 修改人id
	 */
	public void setModId(Long modId) {
		this.modId = modId;
	}

	/**
	 * @取得 修改人姓名
	 */
	public String getModName() {
		return modName;
	}

	/**
	 * @设置 修改人姓名
	 */
	public void setModName(String modName) {
		this.modName = modName;
	}

	/**
	 * @取得 修改时间
	 */
	public Timestamp getModTime() {
		return modTime;
	}

	/**
	 * @设置 修改时间
	 */
	public void setModTime(Timestamp modTime) {
		this.modTime = modTime;
	}

	/**
	 * @取得 分页：第几页
	 */
	public Integer getPageNum() {
		return pageNum;
	}

	/**
	 * @设置 分页：第几页
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @取得 分页：每页显示条数
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @设置 分页：每页显示条数
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/** @取得 dataTabel分页：第几页 */
	public Integer getStart() {
		return start;
	}

	/** @设置 dataTabel分页：第几页 */
	public void setStart(Integer start) {
		this.start = start;
		if (this.start != null && this.length != null && this.length > 0) {
			this.pageNum = this.start / this.length + 1;
		}
	}

	/** @取得 dataTabel分页：每页显示条数 */
	public Integer getLength() {
		return length;
	}

	/** @设置 dataTabel分页：每页显示条数 */
	public void setLength(Integer length) {
		this.length = length;
		this.pageSize = length;
		if (this.start != null && this.length != null && this.length > 0) {
			this.pageNum = this.start / this.length + 1;
		}
	}

	/**
	 * @取得 分页：查询记录总数
	 */
	public Long getTotalRowCount() {
		return totalRowCount;
	}

	/**
	 * @设置 分页：查询记录总数
	 */
	public void setTotalRowCount(Long totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	/**
	 * @方法重写
	 */
	@Override
	public String toString() {
		return JsonTool.getString(this);
	}

	/** 获取 分页：查询记录总数 */
	public Integer getTotalRows() {
		return this.totalRows;
	}

	/** 设置 分页：查询记录总数 */
	public void setTotalRows(Integer totalRows) {
		this.totalRows = totalRows;
	}

	/** 获取 分页：第几页  */
	public Integer getCurrentPage() {
		return this.currentPage;
	}

	/** 设置 分页：第几页  */
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public static void main(String[] args) {
		Date date = new Date(1525943119000L);
		System.out.println(date);
	}
}
