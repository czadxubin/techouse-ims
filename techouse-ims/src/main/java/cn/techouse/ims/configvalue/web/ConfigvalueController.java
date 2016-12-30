package cn.techouse.ims.configvalue.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.techouse.ims.configvalue.service.interf.ConfigValueService;
import cn.techouse.ims.core.datatable.DataTable;
import cn.techouse.ims.core.datatable.DataTableParam;
import cn.techouse.ims.entity.ConfigValue;

@RestController
@RequestMapping(path="/configvalue",method=RequestMethod.POST)
public class ConfigvalueController {
	@Autowired
	private ConfigValueService configValueService;
	@RequestMapping(path="list")
	public DataTable<ConfigValue> list(ConfigValue configValue,DataTableParam dataTableParam){
		if(StringUtils.isEmpty(configValue.getConfigCode())){
			configValue.setEnvironmentCode("%");
		}
		if(StringUtils.isEmpty(configValue.getConfigCode())){
			configValue.setConfigCode("%");
		}
		if(StringUtils.isEmpty(configValue.getValidFlag())){
			configValue.setValidFlag("%");
		}
		DataTable<ConfigValue> dataTable = configValueService.findAllConfigValues(configValue);
		System.out.println(dataTableParam.getOrderHql());
		return dataTable;	
	}
}
