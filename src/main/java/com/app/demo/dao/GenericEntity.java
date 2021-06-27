package com.app.demo.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenericEntity {
	List<HashMap<Object, Object>> rows = new ArrayList<HashMap<Object, Object>>();

	public List<HashMap<Object, Object>> getRows() {
		return rows;
	}

	public void setRows(List<HashMap<Object, Object>> rows) {
		this.rows = rows;
	}

}
