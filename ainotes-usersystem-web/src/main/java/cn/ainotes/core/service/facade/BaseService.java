package cn.ainotes.core.service.facade;

import java.io.Serializable;

/**
 * Service基类
 * @author 许宝众
 *	
 * @param <T>
 */
public interface BaseService<T extends Serializable> {
	public void get(Serializable id);
}
