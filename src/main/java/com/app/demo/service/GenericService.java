package com.app.demo.service;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.demo.dao.GenericDao;
import com.app.demo.dao.GenericEntity;
import com.app.demo.utils.ServiceEntityEnum;

@Component
public class GenericService {

	@Autowired
	GenericDao genericDao;
	
	public GenericEntity findAll(String serviceName) {
		String entityName = null;
		if(serviceName.equalsIgnoreCase(ServiceEntityEnum.EMPLOYEES.getServiceName())) {
			entityName = ServiceEntityEnum.EMPLOYEES.getEntityName();
		} else if(serviceName.equalsIgnoreCase(ServiceEntityEnum.JOBS.getServiceName())) {
			entityName = ServiceEntityEnum.JOBS.getEntityName();
		}

		HashMap<String, String> tableColumns = genericDao.getEntityMeta(entityName);
		String query = createSelectQuery(entityName, tableColumns);
		return genericDao.findAll(query, tableColumns);
	}
	
	public String createSelectQuery(String entityName, HashMap<String, String> tableColumns) {
		String columns = getColumnList(tableColumns.keySet());
		String query = "SELECT " + columns + " FROM " + entityName;
		return query;
	}
	
	public String getColumnList(Set<String> columns)  {
		return String.join(", ", columns);
	}
}
