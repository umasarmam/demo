package com.app.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dao.GenericEntity;
import com.app.demo.service.GenericService;

@RestController
public class GenericController {

	@Autowired
	GenericService genericService;

	@GetMapping("/{serviceName}/getData")
	public GenericEntity getData(@PathVariable String serviceName) {
		GenericEntity response = null;
		try {
			response = genericService.findAll(serviceName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
