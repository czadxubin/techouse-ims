package cn.ainotes.core.service.facade;

import java.io.Serializable;

/**
 * Service����
 * @author ����
 *	
 * @param <T>
 */
public interface BaseService<T extends Serializable> {
	public void get(Serializable id);
}
