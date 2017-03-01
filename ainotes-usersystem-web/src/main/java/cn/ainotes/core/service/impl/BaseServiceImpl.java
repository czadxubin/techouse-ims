package cn.ainotes.core.service.impl;

import java.io.Serializable;

import cn.ainotes.core.service.facade.BaseService;
public class BaseServiceImpl<T extends Serializable> implements BaseService<T> {

	@Override
	public void get(Serializable id) {
		
	}
}
