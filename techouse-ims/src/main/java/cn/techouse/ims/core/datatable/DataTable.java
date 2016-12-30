package cn.techouse.ims.core.datatable;

import java.util.List;

/**
 * 前端DataTable交互javaBean
 * @author 许宝众
 *
 */
public class DataTable<T> {
	private List<T> data;
	private String draw;//datatable在ajax数据时标识请求 
	private Long recordsTotal;//总记录数
	private Long recordsFiltered;//过滤后的记录数
	private String error;//抛出错误信息提示
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getDraw() {
		return draw;
	}

	public void setDraw(String draw) {
		this.draw = draw;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
