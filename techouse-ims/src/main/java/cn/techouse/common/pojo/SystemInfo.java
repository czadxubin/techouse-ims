package cn.techouse.common.pojo;

public class SystemInfo {
	private String systemCode;
	private String systemName;
	public String getSystemCode() {
		return systemCode;
	}
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	@Override
	public String toString() {
		return "SystemInfo [systemCode=" + systemCode + ", systemName="
				+ systemName + "]";
	}
	
}
