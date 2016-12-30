package cn.techouse.ims.core.datatable;

import java.util.ArrayList;
import java.util.List;

/**
 * 为dataTable传递参数定义的javaBean
 * @author 许宝众
 *
 */
public class Column {
	private String data;//
	private String name;//
	private Boolean searchable;//是否支持搜索
	private Boolean orderable;//是否支持排序
	private Search search=new Search();//搜索相关的参数
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getSearchable() {
		return searchable;
	}
	public void setSearchable(Boolean searchable) {
		this.searchable = searchable;
	}
	public Boolean getOrderable() {
		return orderable;
	}
	public void setOrderable(Boolean orderable) {
		this.orderable = orderable;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
}
