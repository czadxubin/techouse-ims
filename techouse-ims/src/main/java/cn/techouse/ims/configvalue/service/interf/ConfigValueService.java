package cn.techouse.ims.configvalue.service.interf;

import java.util.List;

import cn.techouse.common.pojo.SystemInfo;
import cn.techouse.ims.core.datatable.DataTable;
import cn.techouse.ims.entity.ConfigValue;

/**
 * 处理参数配置相关值
 * @author 许宝众
 *
 */
public interface ConfigValueService {
	
	/**
	 * 查询所有系统名称<br>
	 * 命名规范：[系统代码]|[系统名称]<br>
	 * 如：ims|用户系统
	 * @return
	 */
	List<SystemInfo> findAllSystemsInfo();
	/**
	 * 查询满足条件的configValues,分页返回<br>
	 * 其中环境代码和参数代码如果存在，则为模糊查询
	 * @param configValue
	 * @return
	 */
	DataTable<ConfigValue> findAllConfigValues(ConfigValue configValue);
}
