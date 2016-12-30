package cn.techouse.ims.core.config.database;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import cn.techouse.ims.TechuseIMSApplicationBoot;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@ConditionalOnMissingBean(value={DataSource.class})
@ConditionalOnResource(resources={"classpath:mysqlDataSource.properties"})
@Configuration
@PropertySource(encoding="utf-8",value={"classpath:mysqlDataSource.properties"})
public class DataAccessConfiguration {
	@Bean
	public MySqlDataSourceProperties dataSourceProps(){
		return new MySqlDataSourceProperties();
	}
	@Bean(name="mysqlDataSource")
	public ComboPooledDataSource c3p0ConnectionPool() throws Exception{
		MySqlDataSourceProperties dataSourceProps = dataSourceProps();
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(dataSourceProps.getDriverClass());
		dataSource.setJdbcUrl(dataSourceProps.getJdbcUrl());
		dataSource.setUser(dataSourceProps.getUsername());
		dataSource.setPassword(dataSourceProps.getPassword());
		return dataSource;
	}
	
}
