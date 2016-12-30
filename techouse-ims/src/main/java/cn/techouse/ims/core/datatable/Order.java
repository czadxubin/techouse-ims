package cn.techouse.ims.core.datatable;

/**
 * 为dataTable传递参数定义的javaBean
 * @author 许宝众
 *
 */
public class Order {
	private int column;//排序的列索引 开始为0
	private String dir;//排序的方向：asc desc
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
}
