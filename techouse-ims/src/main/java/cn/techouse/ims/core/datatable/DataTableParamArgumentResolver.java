package cn.techouse.ims.core.datatable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class DataTableParamArgumentResolver implements HandlerMethodArgumentResolver{

	/** order[0][dir]:asc  **/
	private static final String ORDER_D_DIR = "^order\\[\\d+\\]\\[dir\\]$";
	
	/** order[0][column]:0 **/
	private static final String ORDER_D_COLUMN = "^order\\[\\d+\\]\\[column\\]$";
	
	/** columns[0][search][regex]:false **/
	private static final String COLUMNS_D_SEARCH_REGEX = "^columns\\[\\d+\\]\\[search\\]\\[regex\\]$";
	
	/** columns[0][search][value]: **/
	private static final String COLUMNS_D_SEARCH_VALUE = "^columns\\[\\d+\\]\\[search\\]\\[value\\]$";
	
	/** columns[0][orderable]:true **/
	private static final String COLUMNS_D_ORDERABLE = "^columns\\[\\d+\\]\\[orderable\\]$";
	
	/** columns[0][searchable]:true **/
	private static final String COLUMNS_D_SEARCHABLE = "^columns\\[\\d+\\]\\[searchable\\]$";
	
	/** columns[0][name]: **/
	private static final String COLUMNS_D_NAME = "^columns\\[\\d+\\]\\[name\\]$";
	
	/** columns[0][data]:environmentCode **/
	private static final String COLUMNS_D_DATA = "^columns\\[\\d+\\]\\[data\\]$";
	
	/** search[value]: **/
	private static final String SEARCH_VALUE="^search\\[value\\]$";
	
	/** search[regex]:false **/
	private static final String SEARCH_REGEX="^search\\[regex\\]$";
	
	private static final String START="^start$";
	private static final String LENGTH="^length$";
	private static final String DRAW="^draw$";
	
	
	public static final List<String> resolvedNameRegexList;
	static {
		resolvedNameRegexList=new ArrayList<String>();
		resolvedNameRegexList.add(COLUMNS_D_DATA);
		resolvedNameRegexList.add(COLUMNS_D_NAME);
		resolvedNameRegexList.add(COLUMNS_D_SEARCHABLE);
		resolvedNameRegexList.add(COLUMNS_D_ORDERABLE);
		resolvedNameRegexList.add(COLUMNS_D_SEARCH_VALUE);
		resolvedNameRegexList.add(COLUMNS_D_SEARCH_REGEX);
		
		resolvedNameRegexList.add(ORDER_D_COLUMN);
		resolvedNameRegexList.add(ORDER_D_DIR);
		
		resolvedNameRegexList.add(SEARCH_VALUE);
		resolvedNameRegexList.add(SEARCH_REGEX);
		
		resolvedNameRegexList.add(START);
		resolvedNameRegexList.add(LENGTH);
		resolvedNameRegexList.add(DRAW);
				
	}
	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		Class<?> parameterType = parameter.getParameterType();
		return parameterType!=null?parameterType.equals(DataTableParam.class):false;
	}

	@Override
	public Object resolveArgument(MethodParameter parameter,
			ModelAndViewContainer mavContainer, NativeWebRequest webRequest,
			WebDataBinderFactory binderFactory) throws Exception {
		DataTableParam dataTableParam = new DataTableParam();
		List<Column> columns = dataTableParam.getColumns();
		List<Order> orders = dataTableParam.getOrder();;
		
		Iterator<String> parameterNames = webRequest.getParameterNames();
		if(parameter!=null){
			while (parameterNames.hasNext()) {
				String name=parameterNames.next();
				Object[] res = isNeedResolved(name);
				boolean isNeed = (boolean) res[0];
				if(isNeed){
					String value = webRequest.getParameter(name);
					String neededNameRegex = (String) res[1];
					
					if(neededNameRegex.equals(COLUMNS_D_DATA)){
						getColumn(name,columns).setData(value);
					}else if(neededNameRegex.equals(COLUMNS_D_NAME)){
						getColumn(name,columns).setName(value);
					}else if(neededNameRegex.equals(COLUMNS_D_SEARCHABLE)){
						getColumn(name,columns).setSearchable(Boolean.parseBoolean(value));
					}else if(neededNameRegex.equals(COLUMNS_D_ORDERABLE)){
						getColumn(name,columns).setOrderable(Boolean.parseBoolean(value));
					}else if(neededNameRegex.equals(COLUMNS_D_SEARCH_VALUE)){
						getColumn(name,columns).getSearch().setValue(value);
					}else if(neededNameRegex.equals(COLUMNS_D_SEARCH_REGEX)){
						getColumn(name,columns).getSearch().setRegex(Boolean.parseBoolean(value));
					}else if(neededNameRegex.equals(ORDER_D_COLUMN)){
						getOrder(name, orders).setColumn(Integer.valueOf(value));
					}else if(neededNameRegex.equals(ORDER_D_DIR)){
						getOrder(name, orders).setDir(value);
					}else if(neededNameRegex.equals(SEARCH_VALUE)){
						dataTableParam.getSearch().setValue(value);
					}else if(neededNameRegex.equals(SEARCH_REGEX)){
						dataTableParam.getSearch().setRegex(Boolean.parseBoolean(value));
					}else if(neededNameRegex.equals(START)){
						dataTableParam.setStart(Long.valueOf(value));
					}else if(neededNameRegex.equals(LENGTH)){
						dataTableParam.setLength(Long.valueOf(value));
					}else if(neededNameRegex.equals(DRAW)){
						dataTableParam.setDraw(value);;
					}
				}
			}
		}
		return dataTableParam;
	}
	
	private Column getColumn(String name,List<Column> columns){
		int beginIndex = name.indexOf('[')+1;
		int endIndex = name.indexOf(']');
		Integer index=null;
		Column column=null;
		if(beginIndex>-1&&endIndex>-1){
			index = Integer.valueOf(name.substring(beginIndex,endIndex));
		}
		if(index!=null&&index<columns.size()) {
			column= columns.get(index);
		}
		if(column==null){
			column=new Column();
			columns.add(column);
		}
		return column;
	}
	
	private Order getOrder(String name,List<Order> orders){
		int beginIndex = name.indexOf('[')+1;
		int endIndex = name.indexOf(']');
		Integer index=null;
		Order order=null;
		if(beginIndex>-1&&endIndex>-1){
			index = Integer.valueOf(name.substring(beginIndex,endIndex));
		}
		if(index!=null&&index<orders.size()) {
			order= orders.get(index);
		}
		if(order==null){
			order=new Order();
			orders.add(order);
		}
		return order;
	}
	
	
	/**
	 * 对请求参数的name进行判断，是否需要被解析
	 * @param name
	 * 		
	 * @return  Object[]<br>
	 * 		0	:	布尔值，标识是否为需要解析的参数<br>
	 * 		1	:	resolvedNameRegexList中匹配的regex表达式。
	 * 		
	 */
	public static Object[] isNeedResolved(String name){
		Object[] obj=new Object[2];
		boolean isNeed=false;
		String  neededNameRegex=null;
		for (int i=0;i<resolvedNameRegexList.size();i++) {
			neededNameRegex=resolvedNameRegexList.get(i); 
			if(!StringUtils.isEmpty(name)){
				if(name.matches(neededNameRegex)){
					isNeed=true;
					break;
				}
			}
		}
		obj[0]=isNeed;
		obj[1]=neededNameRegex;
		return obj;
//		return name==null?false:name.matches("^((columns)|(order))\\[\\d+\\](\\[[A-Za-z]+\\])+");
	}
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("11");
		list.get(1);
	}
}
