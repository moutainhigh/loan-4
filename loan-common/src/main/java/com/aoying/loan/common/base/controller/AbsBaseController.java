package com.aoying.loan.common.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.aoying.loan.common.base.pojo.BasePojo;

/**
 * @author nick
 */
public abstract class AbsBaseController<T extends BasePojo> {
	/** 日志对象 */
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

}
