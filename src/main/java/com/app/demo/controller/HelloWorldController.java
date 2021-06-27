package com.app.demo.controller;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.demo.dao.GenericRepository;

@RestController
public class HelloWorldController {

  @Autowired
  DataSource dataSource;

  @Autowired
  GenericRepository genericRepository;

  @GetMapping("/hello-world")
  public String sayHello() {
	try {
		this.run();
	} catch (Exception e) {
		e.printStackTrace();
	}
    return "Hello world....!";
  }
  
  public void run(String... args) throws Exception {

      System.out.println("DATASOURCE = " + dataSource);

      System.out.println("Display all customers...");
      HashMap<String, String> columnsData = genericRepository.getEntityMeta("EMPLOYEES");

      System.out.println(columnsData.toString());
      System.out.println("Done!");

  }

}
