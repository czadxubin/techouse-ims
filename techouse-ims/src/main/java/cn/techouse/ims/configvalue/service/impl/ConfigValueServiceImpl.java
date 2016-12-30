package cn.techouse.ims.configvalue.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.techouse.common.constants.SystemContants;
import cn.techouse.common.pojo.SystemInfo;
import cn.techouse.ims.configvalue.service.interf.ConfigValueService;
import cn.techouse.ims.core.datatable.DataTable;
import cn.techouse.ims.entity.ConfigValue;
import cn.techouse.ims.repositories.ConfigValueRepository;

@Service
public class ConfigValueServiceImpl implements ConfigValueService{
	@Autowired
	private ConfigValueRepository configValueRepository;
	
	@Override
	public List<SystemInfo> findAllSystemsInfo() {
		List<ConfigValue> configValues = configValueRepository.findAllByEnvironmentCodeAndConfigCodeAndValidFlag(SystemContants.SystemInfo.ENV_FETCH_ALL_SYSTEMS,SystemContants.SystemInfo.KEY_FETCH_ALL_SYSTEMS,SystemContants.DATA_VALID);
		if(configValues==null||configValues.isEmpty()){
			return null;
		}
		
		List<SystemInfo>  systemInfos=new ArrayList<SystemInfo>(configValues.size());
		for (ConfigValue configValue : configValues) {
			String value = configValue.getConfigValue();
			String[] a = value.split("\\|");
			Assert.notEmpty(a,"解析系统名称参数失败");
			Assert.isTrue(a.length==2,"解析系统名称参数失败");
			SystemInfo systemInfo = new SystemInfo();
			systemInfo.setSystemCode(a[0]);
			systemInfo.setSystemName(a[1]);
			systemInfos.add(systemInfo);
		}
		return systemInfos;
	}

	@Override
	public DataTable<ConfigValue> findAllConfigValues(ConfigValue configValue) {
		Page<ConfigValue> p = configValueRepository.findAllByEnvironmentCodeLikeAndConfigCodeLikeAndValidFlagLike("%"+configValue.getEnvironmentCode()+"%", "%"+configValue.getConfigCode()+"%", configValue.getValidFlag(), new PageRequest(0, 10));
		DataTable<ConfigValue> dataTable=new DataTable<ConfigValue>();
		dataTable.setData(p.getContent());
		return dataTable;
	}

}
