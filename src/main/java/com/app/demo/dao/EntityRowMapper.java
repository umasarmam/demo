package com.app.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EntityRowMapper implements RowMapper<GenericEntity> {

    @Override
    public GenericEntity mapRow(ResultSet rs, int rowNum) throws SQLException {

    	GenericEntity entity = new GenericEntity();
        
    	return entity;
    }
}
