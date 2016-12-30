package cn.techouse.ims.core.datatable;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

public class DataTableParam {
	private String draw;
	private Long start;//0 is the first record
	private Long length;//页大小
	private List<Column> columns=new ArrayList<>();
	private List<Order> order=new ArrayList<>();
	private Search search=new Search();
	public String getDraw() {
		return draw;
	}
	public void setDraw(String draw) {
		this.draw = draw;
	}
	public Long getStart() {
		return start;
	}
	public void setStart(Long start) {
		this.start = start;
	}
	
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public List<Column> getColumns() {
		return columns;
	}
	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	public Search getSearch() {
		return search;
	}
	public void setSearch(Search search) {
		this.search = search;
	}
	/**
	 * 根据前端传值得到排序Hql
	 * @return
	 */
	public String getOrderHql(){
		StringBuffer sb=new StringBuffer(" order by ");
		boolean noChange=true;
		if(order!=null&&order.size()>0){
			for (Order o : order) {
				int index = o.getColumn();
				Column column = columns.get(index);
				if(column.getOrderable()){
					//默认使用前端的data为属性名
					String propertyName=column.getData();
					String name = column.getName();
					//如果指定了name，则使用name
					if(!StringUtils.isEmpty(name)){
						propertyName=name;
					}
					sb.append(" "+propertyName+", ");
					noChange=false;
				}
			}
		}
		if(noChange){
			return "";
		}else{
			String hql = sb.toString();
			return hql.substring(0, hql.lastIndexOf(','));
		}
	}
	
}
