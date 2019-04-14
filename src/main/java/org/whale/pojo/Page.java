package org.whale.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.whale.utils.StringUtils;


/**
 * @ClassName： Page 
 * @Description： 
 * @author： 皮卡尔稽 
 * @date：2019年2月21日
 */
public class Page implements Serializable {
	private static final long serialVersionUID = -4710867631907261303L;
	private int pageSize = 15;

	private int pageNo = 1;
	
	private long totalNum;

	private Object datas;

	private String sql;

	private String countSql;

	private Map<String, Object> param = new HashMap<String, Object>();

	private List<Object> args = new ArrayList<Object>();

	private List<String> orderColumn = new LinkedList<String>();

	private List<Boolean> orderAsc = new LinkedList<Boolean>();

	public Page() {
	}

	public int getLimitA() {
		return this.pageNo*this.pageSize;
	}

	public int getLimitB() {
		return (this.pageNo - 1) * this.pageSize + 1;
	}

	public int getTotalPages() {
		if (this.totalNum % this.pageSize == 0L) {
			return new Long(String.valueOf(this.totalNum / this.pageSize)).intValue();
		}
		return new Long(String.valueOf(this.totalNum / this.pageSize)).intValue() + 1;
	}

	public boolean isPrevious() {
		return this.pageNo > 1;
	}

	public boolean isNext() {
		return this.pageNo < getTotalPages();
	}

	public void addArg(Object obj) {
		if (obj == null)
			return;
		this.args.add(obj);
	}

	public List<Object> getArgs() {
		 return this.args;
	}
	
	public void put(String key, Object value) {
		this.param.put(key, value);
	}

	public Object getParam(String key) {
		return this.param.get(key);
	}

	public String getParamStr(String key) {
		Object val = getParam(key);
		if (val == null)
			return null;
		return val.toString();
	}

	public Integer getParamInteger(String key) {
		Object val = getParam(key);
		if (val == null)
			return null;
		try {
			return Integer.valueOf(Integer.parseInt(val.toString()));
		} catch (Exception localException) {
		}

		return null;
	}

	public Long getParamLong(String key) {
		Object val = getParam(key);
		if (val == null)
			return null;
		try {
			return Long.valueOf(Long.parseLong(val.toString()));
		} catch (Exception localException) {
		}

		return null;
	}

	public Boolean getParamBoolean(String key) {
		return (Boolean) getParam(key);
	}

	public void addOrderBy(String column, boolean asc) {
		if (StringUtils.isBlank(column))
			return;
		this.orderColumn.add(column);
		this.orderAsc.add(asc ? Boolean.TRUE : Boolean.FALSE);
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public Long getTotalNum() {
		return Long.valueOf(this.totalNum);
	}

	public void setTotalNum(Long totalNum) {
		this.totalNum = totalNum.longValue();
	}

	public String getSql() {
		return this.sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getCountSql() {
		return this.countSql;
	}

	public void setCountSql(String countSql) {
		this.countSql = countSql;
	}

	public Object getDatas() {
		return this.datas;
	}

	public void setDatas(Object datas) {
		this.datas = datas;
	}

	public Map<String, Object> getParam() {
		return this.param;
	}

	public List<String> getOrderColumn() {
		return this.orderColumn;
	}

	public List<Boolean> getOrderAsc() {
		return this.orderAsc;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNo=" + pageNo + ", totalNum=" + totalNum + ", datas=" + datas
				+ ", sql=" + sql + ", countSql=" + countSql + ", param=" + param + ", args=" + args + ", orderColumn="
				+ orderColumn + ", orderAsc=" + orderAsc + "]";
	}
	
}
