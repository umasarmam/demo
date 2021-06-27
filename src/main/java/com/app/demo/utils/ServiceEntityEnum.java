package com.app.demo.utils;

public enum ServiceEntityEnum {
	
	EMPLOYEES("employeeService", "employees"),
	JOBS("jobService", "jobs");
	
	private String serviceName;
	private String entityName;
	
	private ServiceEntityEnum(String serviceName, String entityName) {
		this.serviceName = serviceName;
		this.entityName = entityName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public String getEntityName() {
		return entityName;
	}

}
