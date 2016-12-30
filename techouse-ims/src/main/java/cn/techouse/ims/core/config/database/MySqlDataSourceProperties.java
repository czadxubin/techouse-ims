package cn.techouse.ims.core.config.database;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="mysql.datasource",ignoreUnknownFields=true)
public class MySqlDataSourceProperties {
	private String driverClass;
	private String jdbcUrl;
	private String username;
	private String password;
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
