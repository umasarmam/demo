package com.app.demo.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GenericRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public HashMap<String, String> getEntityMeta(String entity) {
    	HashMap<String, String> columns = new HashMap<String, String>();
    	List<Map<String,Object>> result = jdbcTemplate.queryForList("select COLUMN_NAME, DATA_TYPE from ALL_TAB_COLUMNS where upper(TABLE_NAME)='" + entity.toUpperCase() + "'");
    	for(Map<String,Object> element : result) {
    		columns.put(element.get("COLUMN_NAME").toString(), element.get("DATA_TYPE").toString());
    	}
    	return columns;
    }

}
