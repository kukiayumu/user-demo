package com.song.user.utils;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{

	private List rows;

	private Long total;

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	
}
