package cn.techouse.ims.test.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import cn.techouse.common.pojo.SystemInfo;
import cn.techouse.ims.TechuseIMSApplicationBoot;
import cn.techouse.ims.configvalue.service.interf.ConfigValueService;
import cn.techouse.ims.core.datatable.DataTable;
import cn.techouse.ims.entity.ConfigValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,classes={TechuseIMSApplicationBoot.class})
public class ConfigValueServiceTest {
	@Autowired
	private ConfigValueService configValueService;
	public void testFindAllSystemInfos(){
		
		List<SystemInfo> systemInfos=configValueService.findAllSystemsInfo();
		System.out.println(Arrays.toString(systemInfos.toArray()));
	}
	
	@Test
	public void testFindAllConfigValues(){
		ConfigValue configValue=new ConfigValue();
		configValue.setConfigCode("%all.system.%");
		configValue.setEnvironmentCode("%System%");
		configValue.setValidFlag("1");
		DataTable<ConfigValue> findAllConfigValues = configValueService.findAllConfigValues(configValue);
		for (ConfigValue c : findAllConfigValues.getData()) {
			System.out.println(c.getEnvironmentCode());
			System.out.println(c.getConfigCode());
			System.out.println(c.getConfigValue());
			System.out.println(c.getValidFlag());
			System.out.println("==================================");
		}
			
	}
}
