package cn.techouse.ims.core.datatable;

/**
 * 为dataTable传递参数定义的javaBean
 * @author 许宝众
 *
 */
public class Search {
	private String value;//值
	private Boolean regex;//是否支持正则
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Boolean getRegex() {
		return regex;
	}
	public void setRegex(Boolean regex) {
		this.regex = regex;
	}
}
