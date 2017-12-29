package com.et.lesson02.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.et.lesson02.entity.Emp;
import com.et.lesson02.mapper.EmpMapper;

@RestController
public class DruidController {
	@Autowired
	DataSource  dataSource;
	@Autowired
	EmpMapper mapper;
	
	
	@RequestMapping("/syso")
	public String demo(){
		
		return dataSource.toString();
		
	}
	

	@RequestMapping("/queryAll")
	public List<Emp> queryAll(){
		
		return mapper.queryEmp();
		
	}

	@RequestMapping("/querySingle/{id}")
	public Emp querySingle(@PathVariable int id){
		
		return mapper.queryById(id);
		
	}
}
