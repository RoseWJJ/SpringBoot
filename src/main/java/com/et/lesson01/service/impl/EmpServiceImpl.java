package com.et.lesson01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.et.lesson01.dao.EmpRepository;
import com.et.lesson01.entity.Emp;
import com.et.lesson01.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	EmpRepository er;

	public int save(Emp emp) {
//		 er.save(emp);
		return 1;
	}

	public Emp query(Integer id) {
	
		Emp emp = er.findOne(id);
		return emp;
	}

	public int delete(Integer id) {
		er.delete(id);
		return 1;
	}
	public int update(Emp emp) {
		jdbc.update("UPDATE emp SET sname='"+emp.getName()+"', deptid="+emp.getDeptid()+" WHERE id = "+emp.getId());
		
		return 1;
	}
}
