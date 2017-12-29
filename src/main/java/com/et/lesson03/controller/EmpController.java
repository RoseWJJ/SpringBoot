package com.et.lesson03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.et.lesson03.entity.Emp;
import com.et.lesson03.entity.Result;
import com.et.lesson03.service.EmpService;
import com.et.lesson03.util.PageTools;
@Controller
public class EmpController {
	@Autowired
	EmpService empServices;
	
	@ResponseBody
	@RequestMapping("/queryEmp")
	public PageTools queryEmp(String sname,Integer page,Integer rows){	
		
		
		return empServices.queryEmp(sname, page, rows);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/Emp/{id}",method={RequestMethod.DELETE})
	public Result deleteEmp(@PathVariable String id) throws Exception {
		
		String [] arr = id.split(",");
	
		Result r = new Result();
		r.setCode(1);
		try {
			for(int i = 0 ; i < arr.length;i++){
				empServices.deleteEmp(arr[i]);
			}
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
	
	@ResponseBody
	@RequestMapping(value="/saveEmp",method={RequestMethod.POST})
	public Result saveEmp(Emp emp) throws Exception {
		Result r = new Result();
		try {
			r.setCode(1);
			empServices.addEmp(emp);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		
		return r;
	}
	@ResponseBody
	@RequestMapping(value="/updateEmp/{id}",method={RequestMethod.PUT})
	public Result updateEmp(@PathVariable Integer id,Emp dept) throws Exception{
		Result r = new Result();
		r.setCode(1);
		try {
	
			empServices.updateEmp(dept);
		} catch (Exception e) {
			r.setCode(0);
			r.setMessage(e);
		}
		return r;
	}
}
