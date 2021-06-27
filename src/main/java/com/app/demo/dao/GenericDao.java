package com.app.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class GenericDao extends GenericRepository{

	public GenericEntity findAll(String query, HashMap<String, String> tableColumns) {
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		
		GenericEntity entity = new GenericEntity();
		
        for (Map row : rows) {
        	HashMap<Object, Object> record = new HashMap<Object, Object>();

        	for(String column : tableColumns.keySet()) {
        		record.put(column, row.get(column));
        		entity.getRows().add(record);
        	}
        }
        return entity;
	}

}
