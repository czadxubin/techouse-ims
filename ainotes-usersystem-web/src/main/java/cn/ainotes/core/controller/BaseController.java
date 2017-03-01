package cn.ainotes.core.controller;
import java.io.Serializable;

import cn.ainotes.core.service.facade.BaseService;
/**
 * 
 * @author Controller»ùÀà
 *
 */
public class BaseController<T extends Serializable> {
	private BaseService<T> baseService;
}
